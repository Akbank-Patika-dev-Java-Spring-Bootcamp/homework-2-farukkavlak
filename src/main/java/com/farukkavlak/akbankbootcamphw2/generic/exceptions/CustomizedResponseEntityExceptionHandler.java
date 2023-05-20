package com.farukkavlak.akbankbootcamphw2.generic.exceptions;/*
Created by farukkavlak on 20.05.2023
@author: farukkavlak
@date: 20.05.2023
@project: homework-2-farukkavlak
*/

import com.farukkavlak.akbankbootcamphw2.generic.response.ExceptionResponse;
import com.farukkavlak.akbankbootcamphw2.generic.response.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
@RequiredArgsConstructor
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        Date errorDate = new Date();
        String message = ex.getMessage();
        String details = request.getDescription(false);
        return getResponseEntity(errorDate, message, details, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler
    public final ResponseEntity<Object> handleBusinessExceptions(BusinessException ex, WebRequest request) {
        Date errorDate = new Date();
        String message = ex.getMessage();
        String details = request.getDescription(false);
        return getResponseEntity(errorDate, message, details, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Object> getResponseEntity(Date errorDate, String message, String details, HttpStatus httpStatus) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(errorDate, message, details);
        RestResponse<ExceptionResponse> restResponse = RestResponse.error(exceptionResponse);
        restResponse.setMessages(message);

        return new ResponseEntity<>(restResponse, httpStatus);
    }
}
