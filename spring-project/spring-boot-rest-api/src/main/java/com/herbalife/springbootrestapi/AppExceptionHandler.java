package com.herbalife.springbootrestapi;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.Instant;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public HttpEntity<ErrorInformation> handleDivideByZero(ArithmeticException ex, WebRequest webRequest) {
        ErrorInformation errorInformation = new ErrorInformation();
        errorInformation.setError(ex.getMessage());
        errorInformation.setTimestamp(Instant.now().toString());
        errorInformation.setPath(webRequest.getDescription(false));
        return new ResponseEntity<>(errorInformation, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public HttpEntity<String> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex, WebRequest webRequest) {
        String message = "Error: " + ex.getMessage();
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }


//    @ExceptionHandler(ArithmeticException.class)
//    public String handleDivideByZero(ArithmeticException ex, WebRequest webRequest) {
//        String message = "Error: " + ex.getMessage();
//        return message;
//    }
}
