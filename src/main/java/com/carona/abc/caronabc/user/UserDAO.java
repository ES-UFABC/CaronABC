package com.carona.abc.caronabc.user;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "users")
public class UserDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String fullName;

    @Column
    private String initialAddress;

    @Column
    private String finalAddress;

    @Column
    private String email;

    @Column
    private String phoneNumber;

    @Column
    //@DateTimeFormat(pattern = "dd/MM/YYYY HH:mm")
    // TODO: should be treated as Date instead of String
    private String departureTime;

    @Column
    private Ride ride;

    @Column
    private LocalDateTime requestedAt = LocalDateTime.now();
}
