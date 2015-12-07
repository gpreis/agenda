package com.agenda.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Lesson extends AgendaTask {

	private static final long serialVersionUID = -8996084734030500920L;
	private String place;
	private String subject;

	public Lesson(User owner, String description, String code, GregorianCalendar dateBegin, int durationMinutes,
			boolean weekly, String place, String subject, ArrayList<User> attendees) {
		super(owner, description, code, dateBegin, durationMinutes, weekly, attendees);
		this.place = place;
		this.subject = subject;
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
