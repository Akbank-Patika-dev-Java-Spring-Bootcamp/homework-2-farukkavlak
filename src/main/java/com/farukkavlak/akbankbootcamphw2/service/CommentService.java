package com.farukkavlak.akbankbootcamphw2.service;/*
Created by farukkavlak on 19.05.2023
@author: farukkavlak
@date: 19.05.2023
@project: homework-2-farukkavlak
*/

import com.farukkavlak.akbankbootcamphw2.dao.CommentDao;
import com.farukkavlak.akbankbootcamphw2.dto.CommentDto;
import com.farukkavlak.akbankbootcamphw2.dto.CommentPostRequestDto;
import com.farukkavlak.akbankbootcamphw2.entity.Comment;
import com.farukkavlak.akbankbootcamphw2.entity.Product;
import com.farukkavlak.akbankbootcamphw2.entity.User;
import com.farukkavlak.akbankbootcamphw2.generic.enums.ErrorMessage;
import com.farukkavlak.akbankbootcamphw2.generic.exceptions.BusinessException;
import com.farukkavlak.akbankbootcamphw2.generic.exceptions.ItemNotFoundException;
import com.farukkavlak.akbankbootcamphw2.mapper.CommentMapper;
import com.farukkavlak.akbankbootcamphw2.service.entityService.CommentEntityService;
import com.farukkavlak.akbankbootcamphw2.service.entityService.ProductEntityService;
import com.farukkavlak.akbankbootcamphw2.service.entityService.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentEntityService commentEntityService;
    private final ProductEntityService productEntityService;
    private final UserEntityService userEntityService;
    private final CommentDao commentDao;

    public CommentDto save(CommentPostRequestDto dto) {
        nullCheck(dto);
        Comment comment = CommentMapper.INSTANCE.convertToComment(dto);
        commentEntityService.save(comment);
        return CommentMapper.INSTANCE.convertToCommentDto(comment);
    }
    public void delete(Long id) {
        Comment comment = commentEntityService.findByIdWithControl(id);
        commentEntityService.delete(comment);
    }

    public Collection<CommentDto> findAllByProductId(Long id) {
        Optional<Product> product = productEntityService.findById(id);
        if (!product.isPresent()) {
            throw new BusinessException(ErrorMessage.PRODUCT_NOT_FOUND.getMessage());
        }
        Collection<Comment> comments = commentDao.findAllByProductId(id);
        if (comments.isEmpty()) {
            String formattedErrorMessage = String.format(ErrorMessage.PRODUCT_HAS_NO_COMMENTS.getMessage(), product.get().getName());
            throw new ItemNotFoundException(formattedErrorMessage);
        }
        return CommentMapper.INSTANCE.convertToCommentDtoList(comments);
    }

    public Collection<CommentDto> findAllByUserId(Long id) {
        Optional<User> user = userEntityService.findById(id);
        if (!user.isPresent()) {
            throw new BusinessException(ErrorMessage.USER_NOT_FOUND.getMessage());
        }
        Collection<Comment> comments = commentDao.findAllByUserId(id);
        if (comments.isEmpty()) {
            String formattedErrorMessage = String.format(ErrorMessage.USER_HAS_NO_COMMENTS.getMessage(), user.get().getUsername());
            throw new ItemNotFoundException(formattedErrorMessage);
        }
        return CommentMapper.INSTANCE.convertToCommentDtoList(comments);
    }

    //Generic null check method for parameters
    private static <T> void nullCheck(T object) {
        if (object == null) {
            throw new BusinessException(ErrorMessage.PARAMETER_CANNOT_BE_NULL.getMessage());
        }
    }
}
