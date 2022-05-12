package com.carona.abc.caronabc.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class UserDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    private String initialAddress;
    private String finalAddress;
    private String email;
    private String phoneNumber;
    private boolean active = true;
    private LocalDateTime requestedAt = LocalDateTime.now();
}
