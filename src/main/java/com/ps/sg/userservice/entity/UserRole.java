package com.ps.sg.userservice.entity;

import lombok.*;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class UserRole {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Roles role;

    @OneToOne
    @JoinColumn(name = "user_name",nullable = false)
    private User user;

}
