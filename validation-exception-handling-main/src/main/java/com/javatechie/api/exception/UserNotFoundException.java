package com.javatechie.api.exception;

public class UserNotFoundException  extends Exception{
    public UserNotFoundException(String message) {
        super(message);
    }

//    public UserNotFoundException() {
//        super("user is not avaialbe");
//    }
}
