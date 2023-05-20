package com.farukkavlak.akbankbootcamphw2.controller;/*
Created by farukkavlak on 20.05.2023
@author: farukkavlak
@date: 20.05.2023
@project: homework-2-farukkavlak
*/

import com.farukkavlak.akbankbootcamphw2.dto.UserDeleteRequestDto;
import com.farukkavlak.akbankbootcamphw2.dto.UserDto;
import com.farukkavlak.akbankbootcamphw2.dto.UserPostRequestDto;
import com.farukkavlak.akbankbootcamphw2.dto.UserPutRequestDto;
import com.farukkavlak.akbankbootcamphw2.generic.response.RestResponse;
import com.farukkavlak.akbankbootcamphw2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping()
    public ResponseEntity<RestResponse<Collection<UserDto>>> findAll() {
        return ResponseEntity.ok(RestResponse.of(userService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<UserDto>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(RestResponse.of(userService.findById(id)));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<RestResponse<UserDto>> findByUsername(@PathVariable String username) {
        return ResponseEntity.ok(RestResponse.of(userService.findByUsername(username)));
    }

    @PostMapping()
    public ResponseEntity<RestResponse<UserDto>> save(@RequestBody UserPostRequestDto dto) {
        return ResponseEntity.ok(RestResponse.of(userService.save(dto)));
    }

    @DeleteMapping()
    public ResponseEntity<RestResponse<Void>> delete(@RequestBody UserDeleteRequestDto dto) {
        userService.delete(dto);
        return ResponseEntity.ok(RestResponse.empty());
    }

    @PutMapping()
    public ResponseEntity<RestResponse<UserDto>> update(@RequestBody UserPutRequestDto dto) {
        return ResponseEntity.ok(RestResponse.of(userService.update(dto)));
    }
}
