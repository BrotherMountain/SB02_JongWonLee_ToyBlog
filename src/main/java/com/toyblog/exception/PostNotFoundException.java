package com.toyblog.exception;

public class PostNotFoundException extends NotFoundException {
    public PostNotFoundException(String message) {
        super(message);
    }
}
