package com.itsol.projectservice.service.Impl;

import com.itsol.projectservice.domain.Comments;
import com.itsol.projectservice.dto.CommentsDto;
import com.itsol.projectservice.repository.CommentsRepository;
import com.itsol.projectservice.service.CommentsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CommentsDto> getComments() {
        List<Comments> list = commentsRepository.findAll();
        return list.stream().map(comments ->
                modelMapper.map(comments, CommentsDto.class)).collect(Collectors.toList());
    }

    @Override
    public void create(CommentsDto commentsDto) {
        Comments comments =modelMapper.map(commentsDto,Comments.class);
        commentsRepository.save(comments);
    }
}
