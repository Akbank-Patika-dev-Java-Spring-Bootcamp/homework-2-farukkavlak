package com.farukkavlak.akbankbootcamphw2.entity;/*
Created by farukkavlak on 19.05.2023
@author: farukkavlak
@date: 19.05.2023
@project: homework-2-farukkavlak
*/

import com.farukkavlak.akbankbootcamphw2.generic.entity.BaseEntity;
import com.farukkavlak.akbankbootcamphw2.generic.enums.UserTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "USERS")
public class User extends BaseEntity {
    @Id
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "user_id_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true,name = "USERNAME",length = 50,nullable = false)
    private String username;
    @Column(name = "PASSWORD",length = 200,nullable = false)
    private String password;
    @Email(message = "Email should be valid")
    @Column(unique = true,name = "EMAIL",length = 100,nullable = false)
    private String email;
    @Column(unique = true,name = "PHONE",length = 20,nullable = false)
    private String phone;
    @Column(name = "USER_TYPE")
    private UserTypeEnum userType;
}
