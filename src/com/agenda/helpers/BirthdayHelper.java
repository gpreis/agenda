package com.agenda.helpers;

import com.agenda.model.Birthday;
import com.agenda.model.User;

public class BirthdayHelper extends AgendaTaskHelper{
	
	public static Birthday askBirthday(User owner){
		return new Birthday(owner, askDescription(), askCode(), askDate(), askDuration(),
				askBirthdayPerson(), askAge(), askAttendees(owner));
	}
	
	private static int askAge(){
		return AskHelper.askInt("Idade do aniversariante: ");
	}

	private static User askBirthdayPerson(){
		startScanner();
		System.out.println("Nome do Aniversariante: ");
		return UserHelper.findByName(input.nextLine());
	}
}
