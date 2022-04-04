package com.carona.abc.caronabc.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name =  "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(nullable = false, length = 1000)
    private String password;

    @Column(name = "FULL_NAME", nullable = false, length = 1000)
    private String fullName;

    @Column(name = "RA", nullable = false, length = 20)
    private String ra;
}
