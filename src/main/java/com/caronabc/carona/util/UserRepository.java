package com.caronabc.carona.util;

import com.caronabc.carona.user.AppUser;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository {
    Optional<AppUser> findByEmail(String email);
}
