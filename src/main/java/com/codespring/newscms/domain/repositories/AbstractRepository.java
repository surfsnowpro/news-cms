package com.codespring.newscms.domain.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AbstractRepository<T> {
    private final List<T> elements = new ArrayList<>();

    public T findOne(String id) {
        final Optional<T> item = elements.stream().filter(e -> e.equals(id)).findFirst();
        return item.orElse(null);
    }

    public List<T> findAll() {
        return elements;
    }

    public T save(T item) {
        elements.add(item);
        return item;
    }

    public void delete(T item) {
        elements.remove(item);
    }
}
