package com.farukkavlak.akbankbootcamphw2.controller;/*
Created by farukkavlak on 20.05.2023
@author: farukkavlak
@date: 20.05.2023
@project: homework-2-farukkavlak
*/

import com.farukkavlak.akbankbootcamphw2.dto.ProductDto;
import com.farukkavlak.akbankbootcamphw2.dto.ProductPatchRequestDto;
import com.farukkavlak.akbankbootcamphw2.dto.ProductPostRequestDto;
import com.farukkavlak.akbankbootcamphw2.generic.response.RestResponse;
import com.farukkavlak.akbankbootcamphw2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping()
    public ResponseEntity<RestResponse<ProductDto>> save(@RequestBody ProductPostRequestDto dto) {
        return ResponseEntity.ok(RestResponse.of(productService.save(dto)));
    }

    @GetMapping()
    public ResponseEntity<RestResponse<Collection<ProductDto>>> findAll() {
        return ResponseEntity.ok(RestResponse.of(productService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<ProductDto>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(RestResponse.of(productService.findById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Void>> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

    @PatchMapping()
    public ResponseEntity<RestResponse<ProductDto>> update(@RequestBody ProductPatchRequestDto dto) {
        return ResponseEntity.ok(RestResponse.of(productService.update(dto)));
    }
}
