package com.CarRental.Exceptions;

public class ObjectNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
    public String getMessage() {
        return "desired object was not found";
    }
}
