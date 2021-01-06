package com.codespring.newscms.domain.exceptions;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(String id) {
        super("Could not find category " + id);
    }
}
