package com.ps.sg.userservice.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    private String userName;

    private String firstName;

    private String lastName;

    private String password;

    private boolean enabled;

    private boolean accountExpired;

    private String email;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserRole role;
}
