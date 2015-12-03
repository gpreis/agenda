package com.agenda.view;

import java.util.List;
import java.util.Scanner;

import com.agenda.controllers.AgendaTaskController;
import com.agenda.model.AgendaTask;

public class AgendaTaskInterface {

	private Scanner input;
	private AgendaTask task;
	private AgendaTaskController tasks;

	public AgendaTaskInterface(AgendaTask task, AgendaTaskController tasks) {
		this.task = task;
		this.tasks = tasks;
		this.input = new Scanner(System.in);
	}
	
	public void manage() {
		int action = -1;
		while(action != 0){
			System.out.println("\n\nCompromisso atual > " + task.getDescription());
			System.out.println("Ações:");
			System.out.println("0- Voltar");
			System.out.println("1- Detalhes");
			System.out.println("2- Alterar");
			System.out.println("3- Remover");
			System.out.println("Digitar a ação desejada:");
			action = input.nextInt();
			
			switch(action){
				case 1:
					AgendaTaskView.printDetails(task);
					break;
			}
		}
	}
}
