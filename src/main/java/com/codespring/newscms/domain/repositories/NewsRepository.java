package com.codespring.newscms.domain.repositories;

import com.codespring.newscms.domain.models.News;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

//@Repository
@Service
public class NewsRepository extends AbstractRepository<News> { //JpaRepository<News, String> {
//    List<News> findByNameIgnoreCaseStartingWith(String query);
}
