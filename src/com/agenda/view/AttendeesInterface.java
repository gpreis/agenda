package com.agenda.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.agenda.helpers.AgendaTaskHelper;
import com.agenda.model.AgendaTask;
import com.agenda.model.User;

public class AttendeesInterface {
	
	public AgendaTask task;
	private Scanner input;
	
	public AttendeesInterface(AgendaTask task){
		this.task = task;
	}
	
	public void manage() {
		int action = -1;
		input = new Scanner(System.in);
		while(action != 0){
			System.out.println("0- Finalizar");
			System.out.println("1- Adicionar");
			System.out.println("2- Listar");
			System.out.println("3- Remover");
			System.out.println("Digite a ação: ");
			
			action = input.nextInt();
			switch(action){
				case 1: AgendaTaskHelper.askAttendees(task.getOwner(), task.getAttendees()); break;
				case 2: UserView.printList(task.getAttendees());
				case 3: removeAttendees(task.getAttendees());
			}
		}
	}
	
	public void removeAttendees(ArrayList<User> users){
		int action = -1;
		input = new Scanner(System.in);
		while(action != 0){
			System.out.println("\n0- Cancelar");
			for(int i = 1; i <= users.size(); i++) System.out.println(i + "- " + users.get(i-1).getNome());
			System.out.println("Digite o usuário a ser removido: ");
			action = input.nextInt();
			if(action > 0 && action <=users.size()) users.remove(action - 1); 
		}
	}
	
	
	

	public AgendaTask getTask() {
		return task;
	}

	public void setTask(AgendaTask task) {
		this.task = task;
	}
	
}
