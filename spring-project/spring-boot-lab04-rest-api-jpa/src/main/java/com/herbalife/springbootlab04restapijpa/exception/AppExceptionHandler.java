package com.herbalife.springbootlab04restapijpa.exception;

import com.herbalife.springbootlab04restapijpa.dto.ErrorInformation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(TopicFoundException.class)
    public HttpEntity<ErrorInformation> handleTopicFoundException(TopicFoundException ex, WebRequest webRequest) {
        ErrorInformation errorInformation = new ErrorInformation();
        errorInformation.setError(ex.getMessage());
        errorInformation.setPath(webRequest.getDescription(false));
        errorInformation.setTimestamp(Instant.now().toString());
        return new ResponseEntity<>(errorInformation, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
