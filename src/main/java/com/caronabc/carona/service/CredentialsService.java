package com.caronabc.carona.service;

import com.caronabc.carona.repository.CredentialsRepository;
import com.caronabc.carona.util.CredentialsUtil;
import com.caronabc.carona.util.TokenUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CredentialsService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    private final CredentialsRepository credentialsRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final TokenService tokenService;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return credentialsRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String signUpUser(CredentialsUtil credentialsUtil) {
        boolean userExists = credentialsRepository
                .findByEmail(credentialsUtil.getEmail())
                .isPresent();

        if (userExists) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.

            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(credentialsUtil.getPassword());

        credentialsUtil.setPassword(encodedPassword);

        credentialsRepository.save(credentialsUtil);

        String token = UUID.randomUUID().toString();

        TokenUtil tokenUtil = new TokenUtil(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                credentialsUtil
        );

        tokenService.saveConfirmationToken(
                tokenUtil);

//        TODO: SEND EMAIL

        return token;
    }

    public int enableAppUser(String email) {
        return credentialsRepository.enableAppUser(email);
    }

}