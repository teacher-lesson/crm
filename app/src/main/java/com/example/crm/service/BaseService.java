package com.example.crm.service;

import com.example.crm.dao.BaseRepository;
import com.example.crm.domain.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
    public Page<E> readAll(Pageable pageable) {
        return getRepository().findAll(pageable);
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
