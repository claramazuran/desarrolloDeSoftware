package com.example.demoapp.presentation.advice;

import com.example.demoapp.domain.dtos.ErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

//PROGRAMACION ORIENTADA A ASPECTOS
//CLASE QUE MANEJA ERRORES
@ControllerAdvice
public class AdviceController {
    private static final Logger logger = LoggerFactory.getLogger(AdviceController.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorDto> handleEmptyInput(Exception e){
        String errorMsg = e.getClass() + " : " + e.getMessage();
        logger.error(errorMsg);
        return ResponseEntity.internalServerError()
                .body(ErrorDto.builder()
                        .errorMsg(e.getMessage())
                        .errorClass(e.getClass().getSimpleName())
                        .build());
    }
}