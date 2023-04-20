package com.herbalife.springbootlab04restapijpa.exception;

public class TopicFoundException extends RuntimeException {
    public TopicFoundException(String message) {
        super(message);
    }
}
