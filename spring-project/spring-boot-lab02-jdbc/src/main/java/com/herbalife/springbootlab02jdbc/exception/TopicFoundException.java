package com.herbalife.springbootlab02jdbc.exception;

public class TopicFoundException extends RuntimeException {
    public TopicFoundException(String message) {
        super(message);
    }
}
