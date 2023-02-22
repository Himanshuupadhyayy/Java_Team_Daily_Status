package com.blogApp.Exception;

import com.blogApp.Payload.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponses> resourseNotFoundException( ResourceNotFoundException ex){
    String message = ex.getMessage();
    ApiResponses apiResponses = new ApiResponses(message, false);
    return new ResponseEntity<ApiResponses>(apiResponses, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String> > handleMethodArgsNotValidException(MethodArgumentNotValidException ex){
    Map<String,String> resp = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error)->{
        String fieldName = ((FieldError)error).getField();
        String message = error.getDefaultMessage();
        resp.put(fieldName,message);
    } );
    return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
    }
}
