package com.agenda.view;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

import com.agenda.exceptions.InvalidDayOfTheWeekException;
import com.agenda.model.AgendaTask;

public class AgendaTaskView {
	public static final SimpleDateFormat br = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	public static String basicAgendaTaskInfo(AgendaTask task){
		return task.getDescription() + " | " + formatDate(task);
	}
	
	public static void print(AgendaTask task){
		System.out.println(basicAgendaTaskInfo(task));
	}
	
	public static void printDetails(AgendaTask task){
		System.out.println(task.toString());
	}
	
	public static void printList(List<AgendaTask> list){
		System.out.println("Descrição | Data");
		System.out.println("----------------------------------------");
		
		for(int i = 0; i < list.size(); i++){
			print(list.get(i));
		}
	}
	
	public static String dayOfTheWeek(int i){
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
	
	public static String formatDate(AgendaTask task){
		if(task.isWeekly()){
			return dayOfTheWeek(task.getDayOfTheWeek()) + " " + task.getHour() + ":00";
		}else{
			
		}
		return dayOfTheWeek(task.getDayOfTheWeek()) + " " +
				task.getDay() + "/" + 
				task.getMonth() + "/" + 
				task.getYear() + " " + 
				task.getHour() + ":00";
	}
}