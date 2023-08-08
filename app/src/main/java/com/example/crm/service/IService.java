package com.example.crm.service;

import com.example.crm.domain.BaseEntity;

import java.util.List;

public interface IService<E extends BaseEntity<ID>, ID extends Number> {

    void save(E entity);

    E readById(ID id);

    List<E> readAll();

    void delete(E entity);

    void deleteById(ID id);
}
