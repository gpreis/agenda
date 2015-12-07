package com.agenda.helpers;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

import com.agenda.model.AgendaTask;
import com.agenda.model.User;
import com.agenda.view.AgendaTaskView;

public class AgendaTaskHelper {
	
	private static Scanner input;
	
	public static AgendaTask askAnyAgendaTask(User owner){
		int type;
		AgendaTaskView.printTypes();
		type = DateHelper.askInt("Digite o tipo de compromisso:");
		switch(type){
			case 1: return BirthdayHelper.askBirthday(owner); 
			default: return askAgendaTask(owner);
		}
		
	}
	
	public static AgendaTask askAgendaTask(User owner){
		return new AgendaTask(owner, askDescription(), askCode(), askDate(), askDuration(), askWeekly(), askAttendees());
	}
	
	protected static ArrayList<User> askAttendees(){
		ArrayList<User> result = new ArrayList<User>();
		User user;
		input = new Scanner(System.in);
		
		while(DateHelper.askInt("\nAdicionar Participante?\n1- Sim\n0- Não") == 1){
			System.out.println("Nome do Participante: ");
			user = UserHelper.findByName(input.nextLine());
			
			if(result.contains(user)) System.out.println("Usuário já está na lista de participantes!");
			else result.add(user);
		}
		
		return result;
	}
	
	protected static boolean askWeekly(){
		return DateHelper.askInt("É Semanal?\n1- Sim\n0- Não") == 1;
	}
	
	protected static GregorianCalendar askDate(){
		input = new Scanner(System.in);
		System.out.println("Início do compromisso: ");
		return DateHelper.askDate();
	}
	
	protected static String askCode(){
		input = new Scanner(System.in);
		System.out.println("Código alfanumérico do compromisso: ");
		return input.nextLine();
	}
	
	protected static String askDescription(){
		input = new Scanner(System.in);
		System.out.println("Descricao do compromisso: ");
		return input.nextLine();
	}
	
	protected static int askDuration(){
		System.out.println("Duração do compromisso: ");
		return (DateHelper.askInt("Horas:") * 60) + DateHelper.askInt("Minutos:");
	}
}
