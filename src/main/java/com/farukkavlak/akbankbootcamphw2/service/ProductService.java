package com.farukkavlak.akbankbootcamphw2.service;/*
Created by farukkavlak on 19.05.2023
@author: farukkavlak
@date: 19.05.2023
@project: homework-2-farukkavlak
*/

import com.farukkavlak.akbankbootcamphw2.dto.ProductDto;
import com.farukkavlak.akbankbootcamphw2.dto.ProductPatchRequestDto;
import com.farukkavlak.akbankbootcamphw2.dto.ProductPostRequestDto;
import com.farukkavlak.akbankbootcamphw2.entity.Product;
import com.farukkavlak.akbankbootcamphw2.generic.enums.ErrorMessage;
import com.farukkavlak.akbankbootcamphw2.generic.exceptions.BusinessException;
import com.farukkavlak.akbankbootcamphw2.mapper.ProductMapper;
import com.farukkavlak.akbankbootcamphw2.service.entityService.ProductEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductEntityService productEntityService;


    public ProductDto save(ProductPostRequestDto dto) {
        nullCheck(dto);
        Product product = ProductMapper.INSTANCE.convertToProduct(dto);
        productEntityService.save(product);
        return ProductMapper.INSTANCE.convertToProductDto(product);
    }

    public Collection<ProductDto> findAll() {
        Collection<Product> products = productEntityService.findAll();
        return ProductMapper.INSTANCE.convertToProductDtoList(products);
    }

    public ProductDto findById(Long id) {
        Product product = productEntityService.findByIdWithControl(id);
        return ProductMapper.INSTANCE.convertToProductDto(product);
    }

    public void delete(Long id) {
        Product product = productEntityService.findByIdWithControl(id);
        productEntityService.delete(product);
    }

    public ProductDto update(ProductPatchRequestDto dto) {
        nullCheck(dto);
        Long id = dto.getId();
        boolean isExist = productEntityService.existsById(id);
        if (!isExist) {
            throw new BusinessException(ErrorMessage.PRODUCT_NOT_FOUND.getMessage());
        }
        Product product = productEntityService.findByIdWithControl(id);
        product.setPrice(dto.getPrice());

        return ProductMapper.INSTANCE.convertToProductDto(productEntityService.save(product));
    }

    //Generic null check method for parameters
    private static <T> void nullCheck(T object) {
        if (object == null) {
            throw new BusinessException(ErrorMessage.PARAMETER_CANNOT_BE_NULL.getMessage());
        }
    }
}
