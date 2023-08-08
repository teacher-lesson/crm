package com.example.crm.service;

import com.example.crm.domain.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IService<E extends BaseEntity<ID>, ID extends Number> {

    void save(E entity);

    E readById(ID id);

    Page<E> readAll(Pageable pageable);

    void delete(E entity);

    void deleteById(ID id);
}
