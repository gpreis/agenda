package com.agenda.view;

import java.util.List;
import java.util.Scanner;

import com.agenda.controllers.AgendaTaskController;
import com.agenda.helpers.AgendaTaskHelper;
import com.agenda.helpers.BirthdayHelper;
import com.agenda.helpers.HealthHelper;
import com.agenda.helpers.LessonHelper;
import com.agenda.model.AgendaTask;
import com.agenda.model.Birthday;
import com.agenda.model.Health;
import com.agenda.model.Lesson;

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
			System.out.println("2- Outros Participantes");
			System.out.println("3- Alterar");
			System.out.println("4- Remover");
			System.out.println("Digitar a ação desejada:");
			action = input.nextInt();
			
			switch(action){
				case 1:
					AgendaTaskView.printDetails(task);
					break;
				case 2:
					UserView.printList(task.getAttendees());
					break;
				case 3:
					edit();
					break;
				case 4:
					remove();
					action = 0;
					break;
			}
		}
	}
	
	public void edit(){
		int action = -1;
		while(action != 0){
			AgendaTaskView.printDetails(task);
			System.out.println("\n0- Cancelar");
			for(Integer i : task.fields()) System.out.println(i + "- " + task.fieldName(i));
			System.out.println("Digitar o código do campo a ser editado:");		
			action = input.nextInt();
			set(action);
		}
	}
	
	private void set(int i){
		if(task.getClass() == Birthday.class) BirthdayHelper.set(task, i);
		else if(task.getClass() == Lesson.class) LessonHelper.set(task, i);
		else if(task.getClass() == Health.class) HealthHelper.set(task, i);
		else AgendaTaskHelper.set(task, i);
	}
	
	public void remove(){
		tasks.remove(task);
		AgendaTask.tasks.remove(task);
	}
}
