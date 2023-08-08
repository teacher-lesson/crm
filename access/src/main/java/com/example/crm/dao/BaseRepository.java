package com.example.crm.dao;

import com.example.crm.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<E extends BaseEntity<ID>, ID extends Number> extends JpaRepository<E, ID> {
}
