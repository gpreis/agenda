package com.agenda.helpers;

import java.util.Scanner;

import com.agenda.model.Birthday;
import com.agenda.model.User;

public class BirthdayHelper extends AgendaTaskHelper{
	
	private static Scanner input;
	
	public static Birthday askBirthday(User owner){
		return new Birthday(owner, askDescription(), askCode(), askDate(), askDuration(),
				askBirthdayPerson(), askAttendees());
	}

	private static User askBirthdayPerson(){
		input = new Scanner(System.in);
		System.out.println("Nome do Aniversariante: ");
		return UserHelper.findByName(input.nextLine());
	}
}
