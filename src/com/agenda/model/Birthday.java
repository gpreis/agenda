package com.agenda.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Birthday extends AgendaTask {

	private static final long serialVersionUID = 6836946217565614059L;
	private User birthdayPerson;
	private int age;
	
	public Birthday(User owner, String description, String code, 
			GregorianCalendar dateBegin, int durationMinutes, 
			User birthdayPerson, int age, ArrayList<User> attendees) {
		super(owner, description, code, dateBegin, durationMinutes, false, attendees);
		this.birthdayPerson = birthdayPerson;
		this.age = age;
	}

	public User getBirthdayPerson() {
		return birthdayPerson;
	}

	public void setBirthdayPerson(User birthdayPerson) {
		this.birthdayPerson = birthdayPerson;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString(){
		return super.toString() + " | " + birthdayPerson.getNome() + " completará " + age + " anos!";
	}
	
}
