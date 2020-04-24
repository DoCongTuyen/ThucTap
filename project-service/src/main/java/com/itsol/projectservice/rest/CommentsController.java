package com.itsol.projectservice.rest;

import com.itsol.projectservice.dto.CommentsDto;
import com.itsol.projectservice.service.Impl.CommentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CommentsServiceImpl commentsService;

    @GetMapping("")
    ResponseEntity<List<CommentsDto>> getList(){
        List<CommentsDto> list =commentsService.getComments();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<Void> createComments(@RequestBody CommentsDto commentsDto){
        commentsService.create(commentsDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
