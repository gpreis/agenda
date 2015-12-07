package com.agenda.helpers;

import com.agenda.model.AgendaTask;
import com.agenda.model.Lesson;
import com.agenda.model.User;

public class LessonHelper extends AgendaTaskHelper{
	
	public static Lesson askLesson(User owner){
		return new Lesson(owner, askDescription(), askCode(), askDate(), askDuration(), askWeekly(),
				askPlace(), askSubject(), askAttendees(owner));
	}
	
	public static String askPlace(){
		return AskHelper.askString("Local da Aula: ");
	}
	
	public static String askSubject(){
		return AskHelper.askString("Disciplina: ");
	}
	
	public static void set(AgendaTask task, int field){
		switch(field){
			case Lesson.PLACE: task.set(field, askPlace()); break;
			case Lesson.SUBJECT: task.set(field, askSubject()); break;
			default: AgendaTaskHelper.set(task, field); 
		}
	}
	
}
