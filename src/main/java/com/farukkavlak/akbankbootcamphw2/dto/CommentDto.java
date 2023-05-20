package com.farukkavlak.akbankbootcamphw2.dto;/*
Created by farukkavlak on 19.05.2023
@author: farukkavlak
@date: 19.05.2023
@project: homework-2-farukkavlak
*/

import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private String commentText;
    private Long userId;
    private Long productId;
}
