package com.farukkavlak.akbankbootcamphw2.mapper;/*
Created by farukkavlak on 19.05.2023
@author: farukkavlak
@date: 19.05.2023
@project: homework-2-farukkavlak
*/

import com.farukkavlak.akbankbootcamphw2.dto.ProductDto;
import com.farukkavlak.akbankbootcamphw2.dto.ProductPatchRequestDto;
import com.farukkavlak.akbankbootcamphw2.dto.ProductPostRequestDto;
import com.farukkavlak.akbankbootcamphw2.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.Collection;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto convertToProductDto(Product product);

    Product convertToProduct(ProductPostRequestDto productPostRequestDto);


    Collection<ProductDto> convertToProductDtoList(Collection<Product> products);
}
