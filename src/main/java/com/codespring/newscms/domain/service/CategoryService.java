package com.codespring.newscms.domain.service;

import com.codespring.newscms.domain.models.Category;
import com.codespring.newscms.domain.repositories.CategoryRepository;
import com.codespring.newscms.domain.vo.CategoryRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Mono<Category> update(String id, CategoryRequest request) {
        return this.categoryRepository.findById(id).flatMap(cat -> {
            cat.setName(request.getName());
            return categoryRepository.save(cat);
        });
    }

    public Mono<Category> create(CategoryRequest request) {
        final Category category = new Category();
        category.setId(UUID.randomUUID().toString());
        category.setName(request.getName());
        return categoryRepository.save(category);
    }

    public void delete(String id) {
        findOne(id).flatMap(category -> {
                System.out.println("Found category $category");
                return categoryRepository.delete(category);
            }).doOnError(Throwable::printStackTrace);
//        categoryRepository.deleteById(id);
    }

    public Flux<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Mono<Category> findOne(String id) {
        return categoryRepository.findById(id);
    }

}
