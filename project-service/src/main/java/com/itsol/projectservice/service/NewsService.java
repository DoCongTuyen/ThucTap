package com.itsol.projectservice.service;

import com.itsol.projectservice.dto.NewsDto;

import java.util.List;

public interface NewsService {
    List<NewsDto> getAllNews();

    void create(NewsDto newsDto);

    NewsDto getNews(long id);
}
