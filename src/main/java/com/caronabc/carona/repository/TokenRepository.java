package com.caronabc.carona.repository;

import com.caronabc.carona.util.TokenUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@Transactional
public interface TokenRepository extends JpaRepository<TokenUtil,Long> {
    Optional<TokenUtil> findByToken(String token);

    @Transactional
    @Modifying
    @Query(value = "UPDATE CARONA_TOKEN c " + "SET c.CONFIRMED_AT = ?2 " + "WHERE c.TOKEN = ?1", nativeQuery=true)
    int updateConfirmedAt(String token, LocalDateTime confirmedAt);
}
