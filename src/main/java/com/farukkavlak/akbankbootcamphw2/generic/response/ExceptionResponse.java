package com.farukkavlak.akbankbootcamphw2.generic.response;/*
Created by farukkavlak on 20.05.2023
@author: farukkavlak
@date: 20.05.2023
@project: homework-2-farukkavlak
*/

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ExceptionResponse {
    private Date errorDate;
    private String message;
    private String details;
}
