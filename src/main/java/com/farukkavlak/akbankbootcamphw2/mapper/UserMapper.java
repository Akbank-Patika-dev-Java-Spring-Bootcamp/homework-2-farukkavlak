package com.farukkavlak.akbankbootcamphw2.mapper;/*
Created by farukkavlak on 19.05.2023
@author: farukkavlak
@date: 19.05.2023
@project: homework-2-farukkavlak
*/

import com.farukkavlak.akbankbootcamphw2.dto.UserDto;
import com.farukkavlak.akbankbootcamphw2.dto.UserPostRequestDto;
import com.farukkavlak.akbankbootcamphw2.dto.UserPutRequestDto;
import com.farukkavlak.akbankbootcamphw2.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.Collection;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto convertToUserDto(User user);

    User convertToUser(UserPostRequestDto userPostRequestDto);

    User convertToUser(UserPutRequestDto userPutRequestDto);

    Collection<UserDto> convertToUserDtoList(Collection<User> users);
}
