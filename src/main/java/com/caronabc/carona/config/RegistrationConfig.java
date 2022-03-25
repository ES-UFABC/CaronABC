package com.caronabc.carona.config;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationConfig {
    private final Long ra;
    private final String name;
    private final String email;
    private final String password;
}
