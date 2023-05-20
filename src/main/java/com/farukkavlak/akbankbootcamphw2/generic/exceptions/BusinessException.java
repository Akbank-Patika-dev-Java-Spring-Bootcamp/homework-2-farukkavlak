package com.farukkavlak.akbankbootcamphw2.generic.exceptions;/*
Created by farukkavlak on 20.05.2023
@author: farukkavlak
@date: 20.05.2023
@project: homework-2-farukkavlak
*/

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@RequiredArgsConstructor
public class BusinessException extends RuntimeException {
    private final String message;
}
