package com.farukkavlak.akbankbootcamphw2.service;/*
Created by farukkavlak on 19.05.2023
@author: farukkavlak
@date: 19.05.2023
@project: homework-2-farukkavlak
*/

import com.farukkavlak.akbankbootcamphw2.dao.UserDao;
import com.farukkavlak.akbankbootcamphw2.dto.UserDeleteRequestDto;
import com.farukkavlak.akbankbootcamphw2.dto.UserDto;
import com.farukkavlak.akbankbootcamphw2.dto.UserPostRequestDto;
import com.farukkavlak.akbankbootcamphw2.dto.UserPutRequestDto;
import com.farukkavlak.akbankbootcamphw2.entity.User;
import com.farukkavlak.akbankbootcamphw2.generic.enums.ErrorMessage;
import com.farukkavlak.akbankbootcamphw2.generic.exceptions.BusinessException;
import com.farukkavlak.akbankbootcamphw2.generic.exceptions.ItemNotFoundException;
import com.farukkavlak.akbankbootcamphw2.mapper.UserMapper;
import com.farukkavlak.akbankbootcamphw2.service.entityService.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserEntityService userEntityService;
    private final UserDao userDao;

    public UserDto save(UserPostRequestDto dto) {
        nullCheck(dto);
        passwordStrengthCheck(dto.getPassword());
        User user = UserMapper.INSTANCE.convertToUser(dto);
        userEntityService.save(user);
        return UserMapper.INSTANCE.convertToUserDto(user);
    }

    public UserDto findById(Long id) {
        User user = userEntityService.findByIdWithControl(id);
        return UserMapper.INSTANCE.convertToUserDto(user);
    }

    public UserDto findByUsername(String username) {
        Optional<User> user = userDao.findByUsername(username);
        if(!user.isPresent()){
            throw new ItemNotFoundException(ErrorMessage.USER_NOT_FOUND.getMessage());
        }
        return UserMapper.INSTANCE.convertToUserDto(user.get());
    }

    public Collection<UserDto> findAll() {
        Collection<User> users = userEntityService.findAll();
        return UserMapper.INSTANCE.convertToUserDtoList(users);
    }
    public void delete(UserDeleteRequestDto dto) {
        nullCheck(dto);
        Optional<User> user = userDao.findByUsername(dto.getUsername());
        if (!user.isPresent()) {
            throw new ItemNotFoundException(ErrorMessage.USER_NOT_FOUND.getMessage());
        }
        if (user.get().getPhone().equals(dto.getPhone())) {
            String formattedErrorMessage = String.format(ErrorMessage.PHONE_USERNAME_DOES_NOT_MATCH.getMessage(), dto.getUsername(), dto.getPhone());
            throw new BusinessException(formattedErrorMessage);
        }
        userEntityService.delete(user.get());
    }

    public UserDto update(UserPutRequestDto dto) {
        nullCheck(dto);
        passwordStrengthCheck(dto.getPassword());

        Long id = dto.getId();
        Optional<User> optionalUser = userDao.findById(id);
        if (!optionalUser.isPresent()) {
            throw new ItemNotFoundException(ErrorMessage.USER_NOT_FOUND.getMessage());
        }
        User user = UserMapper.INSTANCE.convertToUser(dto);
        userEntityService.save(user);
        return UserMapper.INSTANCE.convertToUserDto(user);
    }


    //Generic null check method for parameters
    private static <T> void nullCheck(T object) {
        if (object == null) {
            throw new BusinessException(ErrorMessage.PARAMETER_CANNOT_BE_NULL.getMessage());
        }
    }
    //To check password is strong enough
    private void passwordStrengthCheck(String password) {
        if (!(isContainSymbol(password) && isContainNumber(password) && isContainUpperCase(password) && isContainLowerCase(password))) {
            throw new BusinessException(ErrorMessage.PASSWORD_IS_NOT_STRONG_ENOUGH.getMessage());
        }
    }
    //Use regex to determine if password contains symbols
    private boolean isContainSymbol(String password) {
        Pattern special = Pattern.compile ("[!@#$%&*()_.+=|<>?{}\\[\\]~-]");
        Matcher hasSpecial = special.matcher(password);
        return hasSpecial.find();
    }
    //Use regex to determine if password contains number
    private boolean isContainNumber(String password) {
        Pattern digit = Pattern.compile("[0-9]");
        Matcher hasDigit = digit.matcher(password);
        return hasDigit.find();
    }
    //Use regex to determine if password contains upper case
    private boolean isContainUpperCase(String password) {
        for(int letterNo=0;letterNo<password.length();letterNo++){
            if(password.charAt(letterNo)>=65&&password.charAt(letterNo)<=90){
                return true;
            }
        }
        return false;
    }
    //Use regex to determine if password contains lower case
    private boolean isContainLowerCase(String password) {
        for(int letterNo=0;letterNo<password.length();letterNo++){
            if(password.charAt(letterNo)>=97&&password.charAt(letterNo)<=122){
                return true;
            }
        }
        return false;
    }
}
