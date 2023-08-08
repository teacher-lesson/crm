package com.example.crm.core;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

@Component
public class ReferenceMapper {

    @PersistenceContext
    private EntityManager entityManager;

    @ObjectFactory
    public <E> E resolve(Number id, @TargetType Class<E> type) {
        if (id == null)
            return null;

        return entityManager.getReference(type, id);
    }
}
