package com.caronabc.carona.service;

import com.caronabc.carona.repository.TokenRepository;
import com.caronabc.carona.util.TokenUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TokenService {

    private final TokenRepository tokenRepository;

    public void saveConfirmationToken(TokenUtil token) {
        tokenRepository.save(token);
    }

    public Optional<TokenUtil> getToken(String token) {
        return tokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return tokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }

}
