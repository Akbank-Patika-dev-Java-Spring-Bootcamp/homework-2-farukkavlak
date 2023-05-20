package com.farukkavlak.akbankbootcamphw2.generic.service;/*
Created by farukkavlak on 19.05.2023
@author: farukkavlak
@date: 19.05.2023
@project: homework-2-farukkavlak
*/
import com.farukkavlak.akbankbootcamphw2.generic.entity.BaseAdditionalFields;
import com.farukkavlak.akbankbootcamphw2.generic.entity.BaseEntity;
import com.farukkavlak.akbankbootcamphw2.generic.enums.ErrorMessage;
import com.farukkavlak.akbankbootcamphw2.generic.exceptions.BusinessException;
import com.farukkavlak.akbankbootcamphw2.generic.exceptions.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.Collection;
@Service
@RequiredArgsConstructor
public abstract class BaseEntityService<E extends BaseEntity, D extends JpaRepository<E,Long>> {

    private final D dao;

    public Collection<E> findAll() {
        try {
            return this.dao.findAll();
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }
    public Optional<E> findById(Long id) {
        return this.dao.findById(id);
    }

    public E findByIdWithControl(Long id) {
        Optional<E> entity = this.dao.findById(id);
        if (!entity.isPresent()) {
            throw new ItemNotFoundException(ErrorMessage.ITEM_NOT_FOUND.getMessage());
        }
        return entity.get();
    }

    public E save(E entity) {
        this.setAdditionalFields(entity);
        try {
            return this.dao.save(entity);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    private void setAdditionalFields(E entity) {
        BaseAdditionalFields baseAdditionalFields = entity.getBaseAdditionalFields();
        if (baseAdditionalFields == null) {
            baseAdditionalFields = new BaseAdditionalFields();
            entity.setBaseAdditionalFields(baseAdditionalFields);
        }

        if (entity.getBaseAdditionalFields().getCreateDate() == null) {
            baseAdditionalFields.setCreateDate(new Date());
        }

        baseAdditionalFields.setUpdateDate(new Date());
    }

    public void delete(E e) {
        this.dao.delete(e);
    }

    public D getDao() {
        return this.dao;
    }

    public boolean existsById(Long id) {
        return this.dao.existsById(id);
    }
}

