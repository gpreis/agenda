package com.agenda.helpers;

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
	
}
