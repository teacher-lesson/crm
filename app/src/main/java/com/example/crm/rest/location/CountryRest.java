package com.example.crm.rest.location;

import com.example.crm.domain.location.Country;
import com.example.crm.dto.location.CountryDto;
import com.example.crm.service.location.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<CountryDto> readAll() {
        return service.readAll().stream().map(
                x -> new CountryDto(x.getId(), x.getName())
        ).collect(Collectors.toList());
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
