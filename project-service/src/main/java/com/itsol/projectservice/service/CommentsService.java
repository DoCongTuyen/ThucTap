package com.itsol.projectservice.service;

import com.itsol.projectservice.dto.CommentsDto;

import java.util.List;

public interface CommentsService {
    List<CommentsDto> getComments();
     void create(CommentsDto commentsDto);
}
