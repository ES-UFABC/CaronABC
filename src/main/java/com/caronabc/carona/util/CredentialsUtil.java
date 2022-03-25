package com.caronabc.carona.util;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "CARONA_CREDENTIALS")
public class CredentialsUtil implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credentialsGenerator")
    @SequenceGenerator(name = "credentialsGenerator", sequenceName = "CARONA_CREDENTIALS_SEQUENCE")
    @Column(name = "ID")
    private long id;

    @Column(name = "RA")
    private long ra;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private RoleUtil role;

    @Column(name = "ACCOUNT_LOCKED")
    private Boolean accountLocked;

    @Column(name = "ACCOUNT_ENABLED")
    private Boolean accountEnabled;

    public CredentialsUtil(long ra, String name, String email, String password, RoleUtil role) {
        this.ra = ra;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());

        return Collections.singletonList(authority);
    }

    public String getName() {
        return name;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() {
        return !accountLocked;
    }

    @Override
    public boolean isEnabled() {
        return accountEnabled;
    }
}