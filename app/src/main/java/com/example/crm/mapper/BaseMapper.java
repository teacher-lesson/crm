package com.example.crm.mapper;

import com.example.crm.domain.BaseEntity;
import com.example.crm.dto.IEntityDto;

public interface BaseMapper<E extends BaseEntity<ID>, D extends IEntityDto<ID>, ID extends Number> {
    E toEntity(D dto);

    D toDto(E entity);

    E toEntity(ID id);
}
