package ru.rzn.dzh.easychat.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<RestErrorResponse> handleException(ResourceNotFoundException exception) {

        RestErrorResponse restErrorResponse = new RestErrorResponse();

        restErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        restErrorResponse.setMessage(exception.getMessage());
        restErrorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(restErrorResponse, HttpStatus.NOT_FOUND);
    }
}
