package com.agenda.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.agenda.exceptions.InvalidDayOfTheWeekException;
import com.agenda.view.AgendaTaskView;

public class AgendaTask implements Serializable{

	private static final long serialVersionUID = 6871893678399877125L;
	private String description;
	private Integer year;
	private Integer month;
	private Integer day;
	private Integer hour;
	private Integer dayOfTheWeek;
	private boolean weekly;
	
	public AgendaTask(String description, Integer year, Integer month, Integer day, Integer hour) {
		this.description = description;
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.weekly = false;
	}
	
	public AgendaTask(String description, Integer dayOfTheWeek, Integer hour) {
		if(dayOfTheWeek > 7) throw new InvalidDayOfTheWeekException();
		this.description = description;
		this.dayOfTheWeek = dayOfTheWeek;
		this.hour = hour;
		this.weekly = true;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isWeekly() {
		return weekly;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	public Integer getDayOfTheWeek() {
		if(weekly) return dayOfTheWeek;
		return new GregorianCalendar(year, month - 1, day).get(Calendar.DAY_OF_WEEK);
		
	}

	public void setDayOfTheWeek(Integer dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}
	
	public boolean isTheSameDay(GregorianCalendar c){
		if(year != c.get(Calendar.YEAR)) return false;
		else if((month - 1) != c.get(Calendar.MONTH)) return false;
		else if(day != c.get(Calendar.DAY_OF_MONTH)) return false;
		return true;
	}

	public boolean isOnThatDay(GregorianCalendar c){
		if(getDayOfTheWeek() != c.get(c.DAY_OF_WEEK)) return false;
		else if(isWeekly()) return true;
		else if(isTheSameDay(c)) return true;
		return false;
	}
	
	public boolean equals(Object o) {
		AgendaTask task = (AgendaTask) o;
		if(isWeekly() || task.isWeekly()) return getDayOfTheWeek().equals(task.getDayOfTheWeek()) && getHour().equals(task.getHour());
		else return getHour().equals(task.getHour()) && getDay().equals(task.getDay()) && getMonth().equals(task.getMonth()) && getYear().equals(task.getYear());
	}
	
	public String toString(){
		String weekly = " | " + (isWeekly() ? "Semanal" : "Não semanal");
		return AgendaTaskView.basicAgendaTaskInfo(this).concat(weekly);
	}
	
}
