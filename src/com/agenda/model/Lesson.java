package com.agenda.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

public class Lesson extends AgendaTask {

	private static final long serialVersionUID = -8996084734030500920L;
	private String place;
	private String subject;
	
	public static final int PLACE = 101;
	public static final int SUBJECT = 102;

	public Lesson(User owner, String description, String code, GregorianCalendar dateBegin, int durationMinutes,
			boolean weekly, String place, String subject, ArrayList<User> attendees) {
		super(owner, description, code, dateBegin, durationMinutes, weekly, attendees);
		this.place = place;
		this.subject = subject;
	}

	public ArrayList<Integer> fields(){
		ArrayList<Integer> result = super.fields();
		result.add(PLACE);
		result.add(SUBJECT);
		return result;
	}
	
	public String fieldName(int field) {
		switch (field) {
			case PLACE: return "Local";
			case SUBJECT: return "Disciplina";
			default: return super.fieldName(field);
		}
	}
	
	public void set(int field, Object o){
		switch(field) {
			case PLACE: setPlace((String) o);
			case SUBJECT: setSubject((String) o);
			default: super.set(field, o);
		}
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String toString(){
		return super.toString() + " | Disciplina: " + subject + " | Local: " + place;
	}

}
