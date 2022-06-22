package com.CarRental.Exceptions;

public class ApiStatusCodeException extends RuntimeException{
    private static final String ERROR_MESSAGE = "Api response code is different than 200";

    public ApiStatusCodeException() {
        super(ERROR_MESSAGE);
    }
}
