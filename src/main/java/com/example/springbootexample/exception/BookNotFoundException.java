package com.example.springbootexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Sharmila
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Book Not Found")
public class BookNotFoundException extends RuntimeException{

    private static final long serialVersionUID = -3332292346834265371L;

    public BookNotFoundException(String message){
        super(message);
    }
}
