package com.farukkavlak.akbankbootcamphw2.service.entityService;/*
Created by farukkavlak on 19.05.2023
@author: farukkavlak
@date: 19.05.2023
@project: homework-2-farukkavlak
*/

import com.farukkavlak.akbankbootcamphw2.dao.ProductDao;
import com.farukkavlak.akbankbootcamphw2.entity.Product;
import com.farukkavlak.akbankbootcamphw2.generic.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class ProductEntityService extends BaseEntityService<Product, ProductDao> {
    public ProductEntityService(ProductDao dao) {
        super(dao);
    }
}
