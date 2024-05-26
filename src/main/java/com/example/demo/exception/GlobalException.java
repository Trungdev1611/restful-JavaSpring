package com.example.demo.exception;

import com.example.demo.reponse.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice //annotation to say this is place to handle exception in app
public class GlobalException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        Response responseError = new Response(0, "error", errors);
        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
    }

    //This is place handle exception NotFound
    @ExceptionHandler(NotFoundEx.class)
    public ResponseEntity<Response> handleNotFoundEx(NotFoundEx ex) {
        Response responseError = new Response(0, ex.getMsg(), null);
        return new ResponseEntity<>(responseError, HttpStatus.NOT_FOUND);
    }
}
