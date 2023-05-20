package com.farukkavlak.akbankbootcamphw2.generic.entity;/*
Created by farukkavlak on 19.05.2023
@author: farukkavlak
@date: 19.05.2023
@project: homework-2-farukkavlak
*/

import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements BaseModel, Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    @Embedded
    private BaseAdditionalFields baseAdditionalFields;
}