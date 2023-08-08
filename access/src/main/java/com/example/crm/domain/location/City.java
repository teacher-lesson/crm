package com.example.crm.domain.location;


import com.example.crm.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(exclude = "country")
@EqualsAndHashCode(exclude = "country")

@Entity
@Table(name = "cities")
public class City extends BaseEntity<Long> {
    @Column(length = 45, unique = true)
    protected String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id")
    protected Country country;

    public City(Long id, String name, Country country) {
        super(id);
        this.name = name;
        this.country = country;
    }
}
