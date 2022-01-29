package com.github.anderson.soapstudies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Map<String, Object>> handleException(Exception ex) {
    Map<String, Object> response = new HashMap<>();
    response.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
    response.put("message", ex.getMessage());
    return ResponseEntity.internalServerError().body(response);
  }

}
