package com.example.shop.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

   @ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity<StandardError> resurceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resouce not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError er = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(er);
   }

   @ExceptionHandler(DataBaseException.class)
   public ResponseEntity<StandardError> dataBaseException(DataBaseException e, HttpServletRequest request) {
       String error = "Data base error ";
       HttpStatus status = HttpStatus.BAD_REQUEST;
       StandardError er = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
       return ResponseEntity.status(status).body(er);
   }
}
