package com.farukkavlak.akbankbootcamphw2.service.entityService;/*
Created by farukkavlak on 19.05.2023
@author: farukkavlak
@date: 19.05.2023
@project: homework-2-farukkavlak
*/

import com.farukkavlak.akbankbootcamphw2.dao.UserDao;
import com.farukkavlak.akbankbootcamphw2.entity.User;
import com.farukkavlak.akbankbootcamphw2.generic.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService extends BaseEntityService<User, UserDao> {
    public UserEntityService(UserDao dao) {
        super(dao);
    }
}
