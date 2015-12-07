package com.agenda.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import com.agenda.exceptions.ResourceNotFoundException;
import com.agenda.helpers.AgendaTaskHelper;
import com.agenda.helpers.DateHelper;
import com.agenda.model.AgendaTask;
import com.agenda.model.User;
import com.agenda.view.AgendaTaskView;

public class AgendaTaskController extends BaseController<AgendaTask> {

	private Scanner input;
	private User owner;
	
	public AgendaTaskController(ArrayList<AgendaTask> tasks, User owner){
		super(tasks);
		this.owner 	= owner; 
	}
	
	public User getOwner() {
		return owner;
	}

	@Override
	public void add() {
		AgendaTask task;
		task = AgendaTaskHelper.askAnyAgendaTask(owner);
		add(task);
		AgendaTask.tasks.add(task);
	}
	
	public void verifyDay() {
		List<AgendaTask> tasks = getList();
		GregorianCalendar c;
		input = new Scanner(System.in);

		c = DateHelper.askDay();
		
		System.out.println("Hora | Duração | Descrição do Compromisso");
		System.out.println("------------------------------------------");
		for(AgendaTask task : tasks){
			if(task.isOnThatDay(c)){
				AgendaTaskView.printOnDay(task);
			}
		}
	}
	
	public AgendaTask findByCode(String code){
		AgendaTask task = new AgendaTask(owner, null, code, null, 0, false);
		
		if(getList().contains(task)){
			return getList().get(getList().indexOf(task));
		}
		
		throw new ResourceNotFoundException(User.class);
	}
	
	public AgendaTask findByCode(){
		String code;
		input = new Scanner(System.in);
		
		System.out.println("Informe o código do compromisso: ");
		code = input.nextLine();
		
		return findByCode(code);
	}

	public ArrayList<AgendaTask> getOthersTasks() {
		ArrayList<AgendaTask> result = new ArrayList<AgendaTask>();
		for(AgendaTask task : AgendaTask.tasks) {
			if(task.getAttendees() != null && task.getAttendees().contains(owner)) result.add(task);
		}
		return result;
	}
	
}
