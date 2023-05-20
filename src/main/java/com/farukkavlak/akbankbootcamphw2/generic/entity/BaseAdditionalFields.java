package com.farukkavlak.akbankbootcamphw2.generic.entity;/*
Created by farukkavlak on 19.05.2023
@author: farukkavlak
@date: 19.05.2023
@project: homework-2-farukkavlak
*/

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Embeddable
public class BaseAdditionalFields {
    @Column(
            name = "CREATED_AT",
            updatable = false
    )
    @CreatedDate
    private Date createDate;
    @Column(
            name = "UPDATED_AT"
    )
    @LastModifiedDate
    private Date updateDate;

    public BaseAdditionalFields() {
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setCreateDate(final Date createDate) {
        this.createDate = createDate;
    }

    public void setUpdateDate(final Date updateDate) {
        this.updateDate = updateDate;
    }
}
