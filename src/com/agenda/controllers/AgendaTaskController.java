package com.agenda.controllers;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import com.agenda.exceptions.ResourceNotFoundException;
import com.agenda.model.AgendaTask;
import com.agenda.model.User;
import com.agenda.view.AgendaTaskView;

public class AgendaTaskController extends BaseController<AgendaTask> {

	private Scanner input;
	
	public AgendaTaskController(ArrayList<AgendaTask> tasks){
		super(tasks);
	}
	
	@Override
	public void add() {
		AgendaTask task;
		String description;
		Integer year, month, day, hour, period;
		input = new Scanner(System.in);
		
		System.out.println("Descricao do compromisso: ");
		description = input.nextLine();
		System.out.println("Hora do compromisso: ");
		hour = input.nextInt();
		
		System.out.println("O compromisso é semanal?");
		System.out.println("0- Não");
		System.out.println("1- Sim");
		period = input.nextInt();
		
		if(period == 0){
			System.out.println("Dia do compromisso: ");
			day = input.nextInt();
			System.out.println("Mes do compromisso: ");
			month = input.nextInt();
			System.out.println("Ano do compromisso: ");
			year = input.nextInt();
			task = new AgendaTask(description, year, month, day, hour);
		}else{
			System.out.println("Dia da Semana: ");
			for(int i = 1; i < 8; i++){
				System.out.println(i + "- " + AgendaTaskView.dayOfTheWeek(i));
			}
			day = input.nextInt();
			task = new AgendaTask(description, day, hour);
		}
		
		add(task);
	}
	
	public void verifyDay() {
		Integer year, month, day;
		List<AgendaTask> tasks = getList();
		AgendaTask task;
		GregorianCalendar c;
		AgendaTask[] dayTasks = new AgendaTask[24];
		
		input = new Scanner(System.in);
		
		System.out.println("Dia: ");
		day = input.nextInt();
		System.out.println("Mes: ");
		month = input.nextInt();
		System.out.println("Ano: ");
		year = input.nextInt();
		
		c = new GregorianCalendar(year, month -1, day);
		
		for(int i = 0; i < tasks.size(); i++){
			task = tasks.get(i);
			if(task.isOnThatDay(c)){
				dayTasks[task.getHour()] = task;
			}
		}
		
		System.out.println("Hora | Descrição do Compromisso");
		System.out.println("------------------------------------------");
		for(int i = 0; i < 24; i++){
			if(dayTasks[i] != null)	System.out.println(i + " | " + dayTasks[i].getDescription());
		}
	}
	
	public AgendaTask findByDateAndHour(int year, int month, int day, int hour){
		AgendaTask task = new AgendaTask("", year, month, day, hour);
		
		if(getList().contains(task)){
			return getList().get(getList().indexOf(task));
		}
		
		throw new ResourceNotFoundException(User.class);
	}
	
	public AgendaTask findByDateAndHour(){
		Integer year, month, day, hour;
		
		input = new Scanner(System.in);
		
		System.out.println("Informe o/um dia e hora que ocorre a ação: ");
		System.out.println("Dia: ");
		day = input.nextInt();
		System.out.println("Mes: ");
		month = input.nextInt();
		System.out.println("Ano: ");
		year = input.nextInt();
		System.out.println("Hora: ");
		hour = input.nextInt();
		
		return findByDateAndHour(year, month, day, hour);
	}
	
}
