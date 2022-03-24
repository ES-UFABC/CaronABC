package com.caronabc.carona.util;

import org.springframework.stereotype.Repository;

@Repository
public interface CredentialsUtilRepository {
    long getId();
    long getRa();
    String getUsername();
    String getEmail();
    String getPassword();
    String getName();
    RoleUtil getRole();
    Boolean getAccountLocked();
    Boolean getAccountEnabled();
}
