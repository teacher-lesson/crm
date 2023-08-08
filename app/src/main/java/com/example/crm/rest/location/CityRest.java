package com.example.crm.rest.location;

import com.example.crm.domain.location.City;
import com.example.crm.dto.location.CityDto;
import com.example.crm.service.location.CityService;
import com.example.crm.service.location.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cities/")
public class CityRest {

    private final CityService service;
    private final CountryService countryService;

    @Autowired
    public CityRest(CityService service, CountryService countryService) {
        this.service = service;
        this.countryService = countryService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody CityDto dto) {
        City city = createEntity(null, dto);
        service.save(city);
    }


    @GetMapping("/{id}")
    public CityDto read(@PathVariable long id) {
        City city = service.readById(id);
        return createDto(city);
    }


    @GetMapping
    public List<CityDto> readAll(@RequestParam int page, @RequestParam int size) {
        return service.readAll(PageRequest.of(page, size)).stream().map(CityRest::createDto).collect(Collectors.toList());
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody CityDto dto) {
        City city = createEntity(dto.id(), dto);
        service.save(city);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.deleteById(id);
    }

    private static CityDto createDto(City city) {
        return new CityDto(city.getId(), city.getName(), city.getCountry().getId());
    }

    private City createEntity(Long id, CityDto dto) {
        return new City(id, dto.name(), countryService.readById(dto.countyId()));
    }
}
