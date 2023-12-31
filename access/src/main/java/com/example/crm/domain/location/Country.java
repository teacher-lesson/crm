package com.example.crm.domain.location;


import com.example.crm.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collections;
import java.util.Set;

@Data
@NoArgsConstructor
@ToString(exclude = "cities")
@EqualsAndHashCode(exclude = "cities")

@Entity
@Table(name = "countries")
public class Country extends BaseEntity<Integer> {
    @Column(length = 45, unique = true)
    protected String name;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    protected Set<City> cities = Collections.emptySet();

    public Country(Integer id, String name) {
        super(id);
        this.name = name;
    }
}
