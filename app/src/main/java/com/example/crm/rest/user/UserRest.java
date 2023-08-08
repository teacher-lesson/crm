package com.example.crm.rest.user;

import com.example.crm.domain.user.User;
import com.example.crm.dto.user.UserDto;
import com.example.crm.mapper.user.UserMapper;
import com.example.crm.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UserRest {

    private final UserService service;
    private final UserMapper mapper;

    @Autowired
    public UserRest(UserService service, UserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody UserDto dto) {
        User entity = mapper.toEntity(dto);
        service.save(entity);
    }


    @GetMapping("/{id}")
    public UserDto read(@PathVariable int id) {
        User entity = service.readById(id);
        return mapper.toDto(entity);
    }


    @GetMapping
    public List<UserDto> readAll(@RequestParam int page, @RequestParam int size) {
        return service.readAll(PageRequest.of(page, size)).stream().map(mapper::toDto).toList();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody UserDto dto) {
        User entity = mapper.toEntity(dto);
        service.save(entity);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteById(id);
    }

}
