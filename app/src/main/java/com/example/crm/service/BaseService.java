package com.example.crm.service;

import com.example.crm.dao.BaseRepository;
import com.example.crm.domain.BaseEntity;

import java.util.List;

public abstract class BaseService<E extends BaseEntity<ID>, ID extends Number> implements IService<E, ID> {

    protected abstract BaseRepository<E, ID> getRepository();

    @Override
    public void save(E entity) {
        getRepository().save(entity);
    }

    @Override
    public E readById(ID id) {
        return getRepository().findById(id).orElse(null);
    }

    @Override
    public List<E> readAll() {
        return getRepository().findAll();
    }

    @Override
    public void delete(E entity) {
        getRepository().delete(entity);
    }

    @Override
    public void deleteById(ID id) {
        getRepository().deleteById(id);
    }
}
