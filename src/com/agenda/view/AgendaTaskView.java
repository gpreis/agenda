package com.agenda.view;

import java.text.SimpleDateFormat;
import java.util.List;

import com.agenda.helpers.DateHelper;
import com.agenda.model.AgendaTask;

public class AgendaTaskView {
	public static final SimpleDateFormat br = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	public static String[] TASK_TYPES = {"GERAL", "ANIVERSARIO", "AULA", "SAUDE"};
	
	public static String basicAgendaTaskInfo(AgendaTask task) {
		return task.getCode() + " | " + task.getDescription() + " | " + formatDate(task);
	}
	
	public static void print(AgendaTask task) {
		System.out.println(basicAgendaTaskInfo(task));
	}
	
	public static void printDetails(AgendaTask task) {
		System.out.println(task.toString());
	}
	
	public static void printList(List<AgendaTask> list) {
		System.out.println("Código | Descrição | Data");
		System.out.println("----------------------------------------");
		
		for(int i = 0; i < list.size(); i++){
			print(list.get(i));
		}
	}
	
	public static void printOnDay(AgendaTask task){
		System.out.println(DateHelper.HOUR_BR.format(task.getDateBegin().getTime()) + " | " + hours(task.getDurationMinutes()) + " | " + task.getDescription());
	}
	
	public static void printTypes() {
		int i = 0;
		for(String kind : TASK_TYPES){
			System.out.println(i++ + "- " + kind);
		}
	}
	
	public static String formatDate(AgendaTask task) {
		if(task.isWeekly()) {
			return DateHelper.dayOfTheWeek(task.getDayOfTheWeek()) + " " + DateHelper.HOUR_BR.format(task.getDateBegin().getTime());
		}
		return DateHelper.dayOfTheWeek(task.getDayOfTheWeek()) + " " + DateHelper.DATE_BR.format(task.getDateBegin().getTime());
	}
	
	public static String hours(int minutes){
		return minutes / 60 + ":" + minutes % 60;
	}
	
}