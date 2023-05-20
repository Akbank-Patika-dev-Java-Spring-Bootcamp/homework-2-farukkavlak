package com.farukkavlak.akbankbootcamphw2.controller;/*
Created by farukkavlak on 20.05.2023
@author: farukkavlak
@date: 20.05.2023
@project: homework-2-farukkavlak
*/

import com.farukkavlak.akbankbootcamphw2.dto.CommentDto;
import com.farukkavlak.akbankbootcamphw2.dto.CommentPostRequestDto;
import com.farukkavlak.akbankbootcamphw2.generic.response.RestResponse;
import com.farukkavlak.akbankbootcamphw2.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping()
    public ResponseEntity<RestResponse<CommentDto>> save(@RequestBody CommentPostRequestDto dto) {
        return ResponseEntity.ok(RestResponse.of(commentService.save(dto)));
    }

    //"/user" is added to the end of the path to avoid ambiguity with "/{id}
    @GetMapping("/user/{userId}")
    public ResponseEntity<RestResponse<Collection<CommentDto>>> findAllByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(RestResponse.of(commentService.findAllByUserId(userId)));
    }
    //"/product" is added to the end of the path to avoid ambiguity with "/{id}
    @GetMapping("/product/{productId}")
    public ResponseEntity<RestResponse<Collection<CommentDto>>> findAllByProductId(@PathVariable Long productId) {
        return ResponseEntity.ok(RestResponse.of(commentService.findAllByProductId(productId)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Void>> deleteById(@PathVariable Long id) {
        commentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
