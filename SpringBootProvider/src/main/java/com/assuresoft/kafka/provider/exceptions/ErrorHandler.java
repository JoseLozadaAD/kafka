package com.assuresoft.kafka.provider.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorHandler {
  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<Map<String, String>> handlerNotFoundException(EntityNotFoundException exception) {
    final Map<String, String> error = new HashMap<>();

    error.put("Error", exception.getMessage());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }
}
