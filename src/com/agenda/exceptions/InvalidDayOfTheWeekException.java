package com.agenda.exceptions;

public class InvalidDayOfTheWeekException extends RuntimeException{
	
	public InvalidDayOfTheWeekException(){
		super("Dia da semana inválido!");
	}
}
