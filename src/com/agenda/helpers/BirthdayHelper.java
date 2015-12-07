package com.agenda.helpers;

import java.util.ArrayList;

import com.agenda.model.AgendaTask;
import com.agenda.model.Birthday;
import com.agenda.model.User;

public class BirthdayHelper extends AgendaTaskHelper{
	
	private static User birthdayPerson; 
	
	public static Birthday askBirthday(User owner){
		return new Birthday(owner, askDescription(), askCode(), askDate(), askDuration(),
				askBirthdayPerson(), askAge(), askAttendees(owner));
	}
	
	protected static ArrayList<User> askAttendees(User owner){
		ArrayList<User> users = new ArrayList<User>();
		users.add(birthdayPerson);
		return askAttendees(owner, users);
	}
	
	private static int askAge(){
		return AskHelper.askInt("Idade do aniversariante: ");
	}

	private static User askBirthdayPerson(){
		startScanner();
		System.out.println("Nome do Aniversariante: ");
		birthdayPerson = UserHelper.findByName(input.nextLine());
		return birthdayPerson;
	}
	
	public static void set(AgendaTask task, int field){
		switch(field){
			case Birthday.BIRTHDAY_PERSON: task.set(field, askBirthdayPerson()); break;
			case Birthday.AGE: task.set(field, askAge()); break;
			default: AgendaTaskHelper.set(task, field); 
		}
	}
}
