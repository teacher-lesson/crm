package com.example.crm.domain.location;


import com.example.crm.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
@Table(name = "countries")
public class Country extends BaseEntity<Integer> {
    @Column(length = 45, unique = true)
    protected String name;

    public Country(Integer id, String name) {
        super(id);
        this.name = name;
    }
}
