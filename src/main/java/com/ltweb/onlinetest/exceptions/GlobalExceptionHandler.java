package com.ltweb.onlinetest.exceptions;

import java.util.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler  {
        @ExceptionHandler(ResourceNotFoundException.class) 
        public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                                WebRequest webRequest){
                ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
                        webRequest.getDescription(false));
                return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(DataAccessException.class)
        public ResponseEntity<ErrorDetails> handleDataAccessException(DataAccessException exception,
                                                                                WebRequest webRequest){
                ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
                        webRequest.getDescription(false));
                return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        @ExceptionHandler({ AuthenticationException.class,AccessDeniedException.class })
        public ResponseEntity<ErrorDetails> handleAuthenticationException(Exception exception, WebRequest webRequest) {

            ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
            webRequest.getDescription(false));
            return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }
        @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception,
                                                                WebRequest webRequest){
                ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
                        webRequest.getDescription(false));
                return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
        }
}
