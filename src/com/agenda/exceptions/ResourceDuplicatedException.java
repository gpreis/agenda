package com.agenda.exceptions;

public class ResourceDuplicatedException extends RuntimeException {

	public ResourceDuplicatedException(){
		super("Resource duplicated!");
	}
		
	public ResourceDuplicatedException(Class<?> klass){
		super(klass.getSimpleName() + " duplicated!");
	}
		

}
