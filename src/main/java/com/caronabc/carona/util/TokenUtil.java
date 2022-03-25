package com.caronabc.carona.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class TokenUtil {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credentialsGenerator")
    @SequenceGenerator(name = "credentialsGenerator", sequenceName = "CARONA_CREDENTIALS_SEQUENCE")
    @Column(name = "ID")
    private Long id;

    @Column(name = "TOKEN")
    private String token;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "EXPIRES_AT")
    private LocalDateTime expiresAt;

    @Column(name = "CONFIRMED_AT")
    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(name = "CARONA_CREDENTIALS_ID")
    private CredentialsUtil credentialsUtil;

    public TokenUtil(String token,
                     LocalDateTime createdAt,
                     LocalDateTime expiresAt,
                     CredentialsUtil credentialsUtil) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.credentialsUtil = credentialsUtil;
    }
}