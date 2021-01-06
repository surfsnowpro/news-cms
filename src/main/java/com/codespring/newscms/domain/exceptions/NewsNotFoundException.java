package com.codespring.newscms.domain.exceptions;

public class NewsNotFoundException extends RuntimeException {

    public NewsNotFoundException(String id) {
        super("Could not find news entry " + id);
    }
}
