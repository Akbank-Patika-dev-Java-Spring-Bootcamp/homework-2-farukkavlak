package com.farukkavlak.akbankbootcamphw2.entity;/*
Created by farukkavlak on 19.05.2023
@author: farukkavlak
@date: 19.05.2023
@project: homework-2-farukkavlak
*/

import com.farukkavlak.akbankbootcamphw2.generic.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "COMMENT")
public class Comment extends BaseEntity {
    @Id
    @SequenceGenerator(name = "comment_id_seq", sequenceName = "comment_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "comment_id_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "COMMENT_TEXT",length = 1000,nullable = false)
    private String commentText;
    @Column(name = "USER_ID",nullable = false)
    private Long userId;
    @Column(name = "PRODUCT_ID",nullable = false)
    private Long productId;

}
