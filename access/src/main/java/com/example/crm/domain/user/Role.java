package com.example.crm.domain.user;


import com.example.crm.domain.BaseEntity;
import com.example.crm.domain.location.City;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor

@Entity
@Table(name = "roles")
public class Role extends BaseEntity<Integer> {
    @Column(length = 45)
    protected String name;
}
