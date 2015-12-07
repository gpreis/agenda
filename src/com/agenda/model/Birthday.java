package com.agenda.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

public class Birthday extends AgendaTask {

	private static final long serialVersionUID = 6836946217565614059L;
	private User birthdayPerson;
	private int age;
	
	public static final int BIRTHDAY_PERSON = 101;
	public static final int AGE = 102;
	
	public Birthday(User owner, String description, String code, 
			GregorianCalendar dateBegin, int durationMinutes, 
			User birthdayPerson, int age, ArrayList<User> attendees) {
		super(owner, description, code, dateBegin, durationMinutes, false, attendees);
		this.birthdayPerson = birthdayPerson;
		this.age = age;
	}
	
	public ArrayList<Integer> fields(){
		ArrayList<Integer> result = super.fields();
		result.add(BIRTHDAY_PERSON);
		result.add(AGE);
		return result;
	}
	
	public String fieldName(int field) {
		switch (field) {
			case BIRTHDAY_PERSON: return "Aniversariante";
			case AGE: return "Idade";
			default: return super.fieldName(field);
		}
	}
	
	public void set(int field, Object o){
		switch(field) {
			case BIRTHDAY_PERSON: setBirthdayPerson((User) o); break;
			case AGE: setAge((Integer) o); break;
			default: super.set(field, o);
		}
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
