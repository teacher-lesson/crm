package com.example.crm.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor

@MappedSuperclass
public class BaseEntity<ID extends Number> implements Persistable<ID>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected ID id;

    @Override
    public boolean isNew() {
        return id == null;
    }
}
