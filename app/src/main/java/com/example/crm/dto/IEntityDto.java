package com.example.crm.dto;

public interface IEntityDto<ID extends Number> extends IDto {
    ID id();
}
