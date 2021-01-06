package com.codespring.newscms.domain.exceptions;

import lombok.Getter;

public class UserNotFoundException extends RuntimeException {

    @Getter
    private final String id;

    public UserNotFoundException(String id) {
        super("Could not find user " + id);
        this.id = id;
    }
}
