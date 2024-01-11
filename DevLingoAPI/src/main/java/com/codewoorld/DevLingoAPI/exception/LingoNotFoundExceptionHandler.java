package com.codewoorld.DevLingoAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LingoNotFoundExceptionHandler {
    @ExceptionHandler(value = {LingoNotFoundException.class})
  public ResponseEntity<Object> handleException(LingoNotFoundException e) {
      LingoException exception = new LingoException(
          e.getMessage(),
              e.getCause(),
              HttpStatus.NOT_FOUND

      );
      return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
  }
}
