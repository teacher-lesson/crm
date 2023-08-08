package com.example.crm.rest.location;

import com.example.crm.domain.location.Country;
import com.example.crm.dto.location.CityDto;
import com.example.crm.dto.location.CountryDto;
import com.example.crm.dto.location.CountryFullDto;
import com.example.crm.service.location.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/countries/")
public class CountryRest {

    private final CountryService service;

    @Autowired
    public CountryRest(CountryService service) {
        this.service = service;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody CountryDto dto) {
        Country country = new Country(null, dto.name());
        service.save(country);
    }

    @GetMapping("/{id}")
    public CountryDto read(@PathVariable int id) {
        Country country = service.readById(id);

        return new CountryDto(country.getId(), country.getName());
    }

    @GetMapping
    public Page<CountryDto> readAll(@RequestParam int page, @RequestParam int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<Country> countries = service.readAll(pageable);
        return new PageImpl<>(
                countries.map(
                        x -> new CountryDto(x.getId(), x.getName())
                ).toList(),
                pageable,
                countries.getTotalElements()
        );
    }

    @GetMapping("/{id}/full")
    public CountryFullDto fullRead(@PathVariable int id) {
        Country country = service.readById(id);

        return new CountryFullDto(country.getId(), country.getName(),
                country.getCities().stream().map(x -> new CityDto(x.getId(), x.getName(), id)).collect(Collectors.toSet())
        );
    }

    @GetMapping("/full")
    public List<CountryFullDto> fullReadAll(@RequestParam int page, @RequestParam int size) {
        return service.readAll(PageRequest.of(page, size)).stream().map(
                x -> new CountryFullDto(x.getId(), x.getName(), x.getCities().stream().map(c -> new CityDto(c.getId(), c.getName(), x.getId())).collect(Collectors.toSet()))
        ).collect(Collectors.toList());
    }

    @GetMapping("/search")
    public CountryFullDto fullReadByName(@RequestParam String name) {
        Country country = service.readByName(name);

        return new CountryFullDto(country.getId(), country.getName(),
                country.getCities().stream().map(x -> new CityDto(x.getId(), x.getName(), country.getId())).collect(Collectors.toSet())
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody CountryDto dto) {
        Country country = new Country(dto.id(), dto.name());
        service.save(country);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteById(id);
    }
}
