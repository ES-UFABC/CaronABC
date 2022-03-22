package com.caronabc.carona.user;

import com.caronabc.carona.util.CredentialsUtilRepository;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@NoArgsConstructor
@EqualsAndHashCode
public abstract class AppUser implements UserDetails {

    private CredentialsUtilRepository credentialsUtilRepository;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(credentialsUtilRepository.getName());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return credentialsUtilRepository.getPassword();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !credentialsUtilRepository.getAccountLocked();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return credentialsUtilRepository.getAccountEnabled();
    }
}
