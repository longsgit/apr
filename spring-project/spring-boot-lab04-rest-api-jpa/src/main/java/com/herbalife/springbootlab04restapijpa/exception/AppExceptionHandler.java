package com.herbalife.springbootlab04restapijpa.exception;

import com.herbalife.springbootlab04restapijpa.dto.ErrorInformation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class AppExceptionHandler {

    //private static Logger logger = LoggerFactory.getLogger(AppExceptionHandler.class);

    @ExceptionHandler(TopicFoundException.class)
    public HttpEntity<ErrorInformation> handleTopicFoundException(TopicFoundException ex, WebRequest webRequest) {
        ErrorInformation errorInformation = new ErrorInformation(
                "Topic %s already exists".formatted(ex.getMessage()),
                webRequest.getDescription(false),
                Instant.now().toString());
//        errorInformation.setError("Topic %s already exists".formatted(ex.getMessage()));
//        errorInformation.setPath(webRequest.getDescription(false));
//        errorInformation.setTimestamp(Instant.now().toString());
//        logger.error("Topic {} already exists", ex.getMessage());
        log.error("Topic {} already exists", ex.getMessage());
        return new ResponseEntity<>(errorInformation, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TopicNotFoundException.class)
    public HttpEntity<ErrorInformation> handleTopicNotFoundException(TopicNotFoundException ex, WebRequest webRequest) {
        ErrorInformation errorInformation = new ErrorInformation();
//        errorInformation.error("Topic %s is not found".formatted(ex.getMessage()));
//        errorInformation.path(webRequest.getDescription(false));
//        errorInformation.setTimestamp(Instant.now().toString());
        //logger.error("Topic {} not found", ex.getMessage());
        log.error("Topic {} not found", ex.getMessage());
        return new ResponseEntity<>(errorInformation, HttpStatus.INTERNAL_SERVER_ERROR);
    }
//
//    @ExceptionHandler(ConstraintViolationException.class)
//    public HttpEntity<ErrorInformation> handleConstraintViolationException(ConstraintViolationException ex, WebRequest webRequest) {
//        ErrorInformation errorInformation = new ErrorInformation();
//        String message = ex
//                .getConstraintViolations()
//                .stream()
//                .map(it -> it.getPropertyPath() + ": " + it.getMessage())
//                .collect(Collectors.joining(System.lineSeparator()));
//
//        errorInformation.setError("Invalid data: %s".formatted(message));
//        errorInformation.setPath(webRequest.getDescription(false));
//        errorInformation.setTimestamp(Instant.now().toString());
//        return new ResponseEntity<>(errorInformation, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
