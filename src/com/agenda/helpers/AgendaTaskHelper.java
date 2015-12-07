package com.agenda.helpers;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

import com.agenda.exceptions.ResourceNotFoundException;
import com.agenda.model.AgendaTask;
import com.agenda.model.User;
import com.agenda.view.AgendaTaskView;

public class AgendaTaskHelper {
	
	protected static Scanner input;
	
	protected static void startScanner(){
		startScanner();
	}
	
	public static AgendaTask askAnyAgendaTask(User owner){
		int type;
		AgendaTaskView.printTypes();
		type = AskHelper.askInt("Digite o tipo de compromisso:");
		switch(type){
			case 1: return BirthdayHelper.askBirthday(owner);
			case 2: return LessonHelper.askLesson(owner);
			case 3: return HealthHelper.askHealth(owner);
			default: return askAgendaTask(owner);
		}
		
	}
	
	public static AgendaTask askAgendaTask(User owner){
		return new AgendaTask(owner, askDescription(), askCode(), askDate(), askDuration(), askWeekly(), askAttendees(owner));
	}
	
	protected static ArrayList<User> askAttendees(User owner){
		ArrayList<User> result = new ArrayList<User>();
		User user;
		startScanner();
		
		while(AskHelper.askInt("\nAdicionar Participante?\n1- Sim\n0- Não") == 1){
			try {
				System.out.println("Nome do Participante: ");	
				user = UserHelper.findByName(input.nextLine());
				
				if(result.contains(user)) System.out.println("Usuário já está na lista de participantes!");
				else if(user.equals(owner)) System.out.println("Usuário é dono do compromisso!");
				else result.add(user);
			} catch(ResourceNotFoundException e) {
				System.out.println("Usuário não encontrado!");
			}
		}
		
		return result;
	}
	
	protected static boolean askWeekly(){
		return AskHelper.askBoolean("É semanal?");
	}
	
	protected static GregorianCalendar askDate(){
		startScanner();
		System.out.println("Início do compromisso: ");
		return DateHelper.askDate();
	}
	
	protected static String askCode(){
		startScanner();
		System.out.println("Código alfanumérico do compromisso: ");
		return input.nextLine();
	}
	
	protected static String askDescription(){
		startScanner();
		System.out.println("Descricao do compromisso: ");
		return input.nextLine();
	}
	
	protected static int askDuration(){
		System.out.println("Duração do compromisso: ");
		return (AskHelper.askInt("Horas:") * 60) + AskHelper.askInt("Minutos:");
	}
}
