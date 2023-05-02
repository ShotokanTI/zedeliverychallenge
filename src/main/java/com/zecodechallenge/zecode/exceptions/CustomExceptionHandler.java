package com.zecodechallenge.zecode.exceptions;

import org.postgresql.util.PSQLException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(PartnerNotFoundById.class)
    public ResponseEntity<CustomErrorResponse> handlePartnerNotFoundException(PartnerNotFoundById ex) {
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage("Partner not found with id " + ex.getId().toString());
        errorResponse.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PSQLException.class)
    public ResponseEntity<CustomErrorResponse> handlePSQLException(PSQLException ex){
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(IndexOutOfBoundsException .class)
    public ResponseEntity<CustomErrorResponse> IndexOutOfBoundsException(IndexOutOfBoundsException  ex){
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setMessage("Error: Please check if the exact point was created");
        errorResponse.setOriginExceptionMessage(ex.getMessage());
        errorResponse.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<CustomErrorResponse> IndexOutOfBoundsException(DataIntegrityViolationException  ex){
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setMessage("Error: empty fields needs to fill");
        errorResponse.setOriginExceptionMessage(ex.getMessage());
        errorResponse.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PartnerCoordinatesLessThanFourException.class)
    @ResponseBody
    public final ResponseEntity<CustomErrorResponse> handleCustomException(PartnerCoordinatesLessThanFourException ex){
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage("Less than four coordinates,please create more markers");
        errorResponse.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
