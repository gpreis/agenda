package com.agenda.helpers;

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
	
}
