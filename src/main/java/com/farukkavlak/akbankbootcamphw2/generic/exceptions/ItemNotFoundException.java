package com.farukkavlak.akbankbootcamphw2.generic.exceptions;/*
Created by farukkavlak on 20.05.2023
@author: farukkavlak
@date: 20.05.2023
@project: homework-2-farukkavlak
*/

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends BusinessException {
    public ItemNotFoundException(String message) {
        super(message);
    }
}
