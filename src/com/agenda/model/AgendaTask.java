package com.agenda.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.agenda.view.AgendaTaskView;

public class AgendaTask implements Serializable{

	public static ArrayList<AgendaTask> tasks = new ArrayList<AgendaTask>();
	private User owner;
	private ArrayList<User> attendees;
	private static final long serialVersionUID = 6871893678399877125L;
	private String description;
	private String code;
	private GregorianCalendar dateBegin;
	private int durationMinutes;
	private boolean weekly;
	
	public AgendaTask(User owner, String description, String code, GregorianCalendar dateBegin, int durationMinutes, boolean weekly) {
		this.owner = owner;
		this.description = description;
		this.code = code;
		this.dateBegin = dateBegin;
		this.durationMinutes = durationMinutes;
		this.weekly = weekly;
		this.attendees = new ArrayList<User>();
	}

	public AgendaTask(User owner, String description, String code, GregorianCalendar dateBegin, int durationMinutes, boolean weekly, ArrayList<User> attendees) {
		this.owner = owner;
		this.description = description;
		this.code = code;
		this.dateBegin = dateBegin;
		this.durationMinutes = durationMinutes;
		this.weekly = weekly;
		this.attendees = attendees;
	}
	
	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public ArrayList<User> getAttendees() {
		return attendees;
	}

	public void setAttendees(ArrayList<User> attendees) {
		this.attendees = attendees;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public GregorianCalendar getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(GregorianCalendar dateBegin) {
		this.dateBegin = dateBegin;
	}

	public int getDurationMinutes() {
		return durationMinutes;
	}

	public void setDurationMinutes(int durationMinutes) {
		this.durationMinutes = durationMinutes;
	}

	public boolean isWeekly() {
		return weekly;
	}

	public Integer getDayOfTheWeek() {
		return getDateBegin().get(Calendar.DAY_OF_WEEK);
	}
	
	
	public boolean equals(Object o) {
		AgendaTask task = (AgendaTask) o;
		return this.getCode().equals(task.getCode());
	}
	
	public String toString(){
		String weekly = " | " + (isWeekly() ? "Semanal" : "Não semanal");
		return AgendaTaskView.basicAgendaTaskInfo(this).concat(weekly);
	}
	
	public boolean isTheSameDay(GregorianCalendar c){
		if(this.getDateBegin().get(Calendar.YEAR) != c.get(Calendar.YEAR)) return false;
		else if(this.getDateBegin().get(Calendar.MONTH) != c.get(Calendar.MONTH)) return false;
		else if(this.getDateBegin().get(Calendar.DAY_OF_MONTH) != c.get(Calendar.DAY_OF_MONTH)) return false;
		return true;
	}
	
	public boolean isOnThatDay(GregorianCalendar c){
		if(getDayOfTheWeek() != c.get(Calendar.DAY_OF_WEEK)) return false;
		else if(isWeekly()) return true;
		else if(isTheSameDay(c)) return true;
		return false;
	}

	
}
