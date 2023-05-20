package com.farukkavlak.akbankbootcamphw2.dao;/*
Created by farukkavlak on 19.05.2023
@author: farukkavlak
@date: 19.05.2023
@project: homework-2-farukkavlak
*/

import com.farukkavlak.akbankbootcamphw2.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CommentDao extends JpaRepository<Comment, Long> {
    Collection<Comment> findAllByProductId(Long id);

    Collection<Comment> findAllByUserId(Long id);
}
