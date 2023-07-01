package com.inventory.management.controller;

import com.inventory.management.exception.ServerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InventoryManagementAdviseController {

    @ExceptionHandler(ServerException.class)
    public ResponseEntity ServerException(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("server error");
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity exception(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("server error");
    }

}
