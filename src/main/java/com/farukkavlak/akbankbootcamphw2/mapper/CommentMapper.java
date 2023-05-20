package com.farukkavlak.akbankbootcamphw2.mapper;/*
Created by farukkavlak on 19.05.2023
@author: farukkavlak
@date: 19.05.2023
@project: homework-2-farukkavlak
*/

import com.farukkavlak.akbankbootcamphw2.dto.CommentDto;
import com.farukkavlak.akbankbootcamphw2.dto.CommentPostRequestDto;
import com.farukkavlak.akbankbootcamphw2.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.Collection;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    Comment convertToComment(CommentPostRequestDto dto);

    CommentDto convertToCommentDto(Comment comment);

    Collection<CommentDto> convertToCommentDtoList(Collection<Comment> comments);
}
