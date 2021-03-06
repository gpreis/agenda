package com.agenda.helpers;

import com.agenda.model.AgendaTask;
import com.agenda.model.Health;
import com.agenda.model.Health;
import com.agenda.model.User;

public class HealthHelper extends AgendaTaskHelper {
	
	public static Health askHealth(User owner){
		return new Health(owner, askDescription(), askCode(), askDate(), askDuration(), askWeekly(),
				askDoctorSpecialization(), askDoctorName(), askCoveredByPlan(), askReason(),
				askAttendees(owner));
	}
	
	public static String askDoctorSpecialization(){
		return AskHelper.askString("Especialização do médico:");
	}
	
	public static String askDoctorName(){
		return AskHelper.askString("Nome do médico:");
	}
	
	public static boolean askCoveredByPlan(){
		return AskHelper.askBoolean("Consulta coberta pelo plano?");
	}
	
	public static String askReason(){
		return AskHelper.askString("Motivo da ida ao médico:");
	}
	
	public static void set(AgendaTask task, int field){
		switch(field){
			case Health.COVERED_BY_PLAN: task.set(field, askCoveredByPlan()); break;
			case Health.DOCTOR_NAME: task.set(field, askDoctorName()); break;
			case Health.DOCTOR_SPECIALIZATION: task.set(field, askDoctorSpecialization()); break;
			case Health.REASON: task.set(field, askReason()); break;
			default: AgendaTaskHelper.set(task, field); 
		}
	}
	
}
