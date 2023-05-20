package com.farukkavlak.akbankbootcamphw2.dto;/*
Created by farukkavlak on 19.05.2023
@author: farukkavlak
@date: 19.05.2023
@project: homework-2-farukkavlak
*/

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductPatchRequestDto {
    private Long id;
    private BigDecimal price;
}
