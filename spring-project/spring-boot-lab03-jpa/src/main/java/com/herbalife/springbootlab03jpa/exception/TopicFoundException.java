package com.herbalife.springbootlab03jpa.exception;

public class TopicFoundException extends RuntimeException {
    public TopicFoundException(String message) {
        super(message);
    }
}
