package com.agenda.view;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.agenda.controllers.AgendaTaskController;
import com.agenda.exceptions.InvalidDayOfTheWeekException;
import com.agenda.exceptions.ResourceDuplicatedException;
import com.agenda.exceptions.ResourceNotFoundException;
import com.agenda.model.AgendaTask;
import com.agenda.model.User;
import com.agenda.model.comparators.HourOfDayTaskComparator;

public class UserInterface {
	private Scanner input;
	private User user;
	private AgendaTaskController tasks;
	
	public UserInterface(User user) {
		this.input = new Scanner(System.in);
		this.user = user;
		this.tasks = new AgendaTaskController(user.getCompromissos(), user);
	}
	
	public void manage() {
		int action = -1;
		while(action != 0){
			System.out.println("\n\nUsuário atual > " + user.getNome());
			System.out.println("Ações:");
			System.out.println("0- Voltar");
			System.out.println("1- Adicionar Compromisso");
			System.out.println("2- Listar Compromissos");
			System.out.println("3- Verificar dia");
			System.out.println("4- Buscar compromisso");
			System.out.println("Digitar a ação desejada:");
			
			try{
				action = input.nextInt();
			} catch(InputMismatchException e) {
				action = -1;
				System.out.println("Informação inválida!");
			}
			switch(action){
				case 1:
					addTask();
					break;
				case 2:
					AgendaTaskView.printList(tasks.getList());
					break;
				case 3: 
					verifyDay();
					break;
				case 4:
					findTask();
			}
		}
	}
	
	private void addTask() {
		try{
			tasks.add();
		} catch (ResourceDuplicatedException e){
			System.out.println("Você não pode ter dois compromissos juntos.");
		} catch (InvalidDayOfTheWeekException e) {
			System.out.println("Dia da Semana inválido!");
		} catch (Exception e) {
			System.out.println("Impossível adicionar o usuário!");
		}
	}
	
	private void verifyDay() {
		Collections.sort(tasks.getList(), new HourOfDayTaskComparator());
		tasks.verifyDay();
	}
	
	private void findTask(){
		try {
			AgendaTask task = tasks.findByCode();
			AgendaTaskView.printDetails(task);
			new AgendaTaskInterface(task, tasks).manage();
		} catch (ResourceNotFoundException e){
			System.out.println(e.getMessage());
		}
	}
	
}
