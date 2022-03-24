package com.caronabc.carona.util;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "CARONA_CREDENTIALS")
public class CredentialsUtil {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credentialsGenerator")
    @SequenceGenerator(name = "credentialsGenerator", sequenceName = "CARONA_CREDENTIALS_SEQUENCE")
    @Column(name = "ID")
    private long id;

    @Column(name = "RA")
    private long ra;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private RoleUtil role;

    @Column(name = "ACCOUNT_LOCKED")
    private Boolean accountLocked;

    @Column(name = "ACCOUNT_ENABLED")
    private Boolean accountEnabled;
}