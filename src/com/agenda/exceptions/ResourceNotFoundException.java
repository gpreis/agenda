package com.agenda.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException(){
		super("Resource not found!");
	}
	
	public ResourceNotFoundException(Class<?> klass){
		super(klass.getSimpleName() + " not found!");
	}
}
