package com.itsol.projectservice.service.Impl;

import com.itsol.projectservice.domain.News;
import com.itsol.projectservice.dto.NewsDto;
import com.itsol.projectservice.repository.NewsRepository;
import com.itsol.projectservice.service.NewsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private ModelMapper modelMapper;//truyen data giữa 2 object

    @Override
    public List<NewsDto> getAllNews() {
        List<News> list = newsRepository.findAll();
        modelMapper = new ModelMapper();
        return list.stream().map(news ->
                modelMapper.map(news, NewsDto.class)).collect(Collectors.toList());

    }

    @Override
    public void create(NewsDto newsDto) {
        News news=modelMapper.map(newsDto,News.class);
        newsRepository.save(news);
    }

    @Override
    public NewsDto getNews(long id) {
        Optional<News> newsOptional = newsRepository.findById(id);// it kiem tra null, tranh exception nullpoint exception
        return newsOptional
                .map(news -> modelMapper.map(news,NewsDto.class))
                .orElse(null);
    }
}
