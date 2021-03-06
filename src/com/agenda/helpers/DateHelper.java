package com.agenda.helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import com.agenda.exceptions.InvalidDayOfTheWeekException;

public class DateHelper {
	
	private static Scanner input;
	
	public static final String PATTERN_DAY = "dd/MM/yyyy";
	public static final String PATTERN_HOUR = "hh:mm";
	public static final String PATTERN_DATE = PATTERN_DAY + " " + PATTERN_HOUR;
	public static final SimpleDateFormat DATE_BR = new SimpleDateFormat(PATTERN_DATE);
	public static final SimpleDateFormat DAY_BR = new SimpleDateFormat(PATTERN_DATE);
	public static final SimpleDateFormat HOUR_BR = new SimpleDateFormat(PATTERN_DATE);
	
	public static GregorianCalendar askDate(){
		input = new Scanner(System.in);
		GregorianCalendar result = askDay();
		
		result.set(Calendar.HOUR_OF_DAY, AskHelper.askInt("Hora:"));
		result.set(Calendar.MINUTE, AskHelper.askInt("Minuto:"));
		
		return result;
	}
	
	public static GregorianCalendar askDay(){
		input = new Scanner(System.in);
		int day, month, year;
		
		day = AskHelper.askInt("Dia:");
		month = AskHelper.askInt("Mês:") - 1;
		year = AskHelper.askInt("Ano:");
		
		return new GregorianCalendar(year, month, day);
	}
	
	public static String dayOfTheWeek(int i) {
		switch(i){
			case 1: return "DOMINGO";
			case 2: return "SEGUNDA";
			case 3: return "TERÇA";
			case 4: return "QUARTA";
			case 5: return "QUINTA";
			case 6: return "SEXTA";
			case 7: return "SÁBADO";
			default: throw new InvalidDayOfTheWeekException();
		}
	}
}
