package com.farukkavlak.akbankbootcamphw2.dto;/*
Created by farukkavlak on 19.05.2023
@author: farukkavlak
@date: 19.05.2023
@project: homework-2-farukkavlak
*/

import com.farukkavlak.akbankbootcamphw2.generic.enums.UserTypeEnum;
import lombok.Data;

@Data
public class UserPutRequestDto {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private UserTypeEnum userType;
}
