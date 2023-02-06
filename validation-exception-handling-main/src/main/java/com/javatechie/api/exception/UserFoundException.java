package com.javatechie.api.exception;

public class UserFoundException extends Exception {

    public UserFoundException(String message) {
        super(message);
    }


    public UserFoundException(){
        super("user is already regisetered");
    }
}
