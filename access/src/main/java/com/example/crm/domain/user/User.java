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
@ToString(exclude = "location", callSuper = true)
@EqualsAndHashCode(exclude = "location", callSuper = true)

@Entity
@Table(name = "users")
public class User extends BaseEntity<Integer> {
    @Column(length = 45)
    protected String firstName;
    @Column(length = 45)
    protected String lastName;
    @Column(length = 45, unique = true)
    protected String username;
    @Column(length = 45)
    protected String password;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "city_id")
    protected City location;

    public User(Integer integer, String firstName, String lastName, String username, String password) {
        super(integer);
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public User(Integer integer, String firstName, String lastName, String username, String password, City location) {
        super(integer);
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.location = location;
    }
}
