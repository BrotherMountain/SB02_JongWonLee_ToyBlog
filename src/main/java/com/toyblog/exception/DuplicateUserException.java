package com.toyblog.exception;

public class DuplicateUserException extends InvalidException {
    public DuplicateUserException(String message) {
        super(message);
    }
}
