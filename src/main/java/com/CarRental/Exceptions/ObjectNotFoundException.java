package com.CarRental.Exceptions;

public class ObjectNotFoundException extends RuntimeException{
	public static final String ERROR_MESSAGE = "Desired object was not found";

	public ObjectNotFoundException() {
		super(ERROR_MESSAGE);
	}
}
