package com.itsol.projectservice.rest;

import com.itsol.projectservice.dto.NewsDto;
import com.itsol.projectservice.service.Impl.NewsServiceImpl;
import com.itsol.projectservice.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("")
    ResponseEntity<List<NewsDto>> getAll() {
        List<NewsDto> data = newsService.getAllNews();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping("/add")
    ResponseEntity<Void> create(@RequestBody NewsDto newsDto) {
        newsService.create(newsDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find-one/{id}")
    ResponseEntity<NewsDto> getNews(@PathVariable long id) {
        NewsDto newsDto = newsService.getNews(id);
        if (newsDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(newsDto, HttpStatus.OK);
        }
    }
}
