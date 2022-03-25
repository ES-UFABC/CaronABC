package com.caronabc.carona.repository;

import com.caronabc.carona.util.CredentialsUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface CredentialsRepository extends JpaRepository<CredentialsUtil,Long> {

    Optional<CredentialsUtil> findByEmail(String email);

    @Transactional
    @Modifying
    @Query(value = "UPDATE CARONA_CREDENTIALS a " + "SET a.ACCOUNT_ENABLED = TRUE WHERE a.EMAIL = ?1", nativeQuery=true)
    int enableAppUser(String email);
}
