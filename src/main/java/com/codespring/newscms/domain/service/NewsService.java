package com.codespring.newscms.domain.service;

import com.codespring.newscms.domain.exceptions.NewsNotFoundException;
import com.codespring.newscms.domain.models.News;
import com.codespring.newscms.domain.repositories.NewsRepository;
import com.codespring.newscms.domain.vo.NewsRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class NewsService {

    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

//    public News findOne(String id) {
//        final Optional<News> news = newsRepository.findById(id);
//        if (news.isPresent()) {
//            return news.get();
//        } else {
//            throw new NewsNotFoundException(id);
//        }
//    }

    public List<News> findAll() {
        return newsRepository.findAll();
    }

//    public News create(NewsRequest newsRequest) {
//        return newsRepository.save(News());
//    }
}
