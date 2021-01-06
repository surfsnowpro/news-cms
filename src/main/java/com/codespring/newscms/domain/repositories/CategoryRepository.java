package com.codespring.newscms.domain.repositories;

import com.codespring.newscms.domain.models.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {
}
