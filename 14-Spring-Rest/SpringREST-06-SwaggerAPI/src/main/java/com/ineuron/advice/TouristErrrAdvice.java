package com.ineuron.advice;

import com.ineuron.error.ErrorDetails;
import com.ineuron.exception.TouristNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class TouristErrrAdvice {

    @ExceptionHandler(TouristNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleTouristNotFound(){
        System.out.println("TouristErrorControllerAdvice.handleTourist not found()");
        Throwable tf = null;
        ErrorDetails details = new ErrorDetails(LocalDateTime.now(), tf.getMessage(), "404-NotFound");
        return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleAllProblems(Exception e){
        System.out.println("Handle all problems");
        ErrorDetails details = new ErrorDetails(LocalDateTime.now(), e.getMessage(), "Problem in execution");
        return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
