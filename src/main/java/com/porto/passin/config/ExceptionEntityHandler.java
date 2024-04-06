package com.porto.passin.config;

import com.porto.passin.exceptions.EventNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionEntityHandler {

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity handlerEvenNotFound(EventNotFoundException eventNotFoundException){
        return ResponseEntity.notFound().build();
    }
}
