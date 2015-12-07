package com.agenda.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import com.agenda.helpers.BooleanHelper;

public class Health extends AgendaTask {

	private static final long serialVersionUID = 4656327614666752464L;
	private boolean coveredByPlan;
	private String doctorSpecialization;
	private String doctorName;
	private String reason;
	
	public static final int COVERED_BY_PLAN = 101;
	public static final int DOCTOR_SPECIALIZATION = 102;
	public static final int DOCTOR_NAME = 103;
	public static final int REASON = 104;

	public Health(User owner, String description, String code, GregorianCalendar dateBegin, int durationMinutes,
			boolean weekly, String doctorSpecialization, String doctorName, 
			boolean coveredByPlan, String reason, ArrayList<User> attendees) {
		super(owner, description, code, dateBegin, durationMinutes, weekly, attendees);
		this.coveredByPlan = coveredByPlan;
		this.doctorSpecialization = doctorSpecialization;
		this.doctorName = doctorName;
		this.reason = reason;
	}
	
	public ArrayList<Integer> fields(){
		ArrayList<Integer> result = super.fields();
		result.add(COVERED_BY_PLAN);
		result.add(DOCTOR_SPECIALIZATION);
		result.add(DOCTOR_NAME);
		result.add(REASON);
		return result;
	}
	
	public String fieldName(int field) {
		switch (field) {
			case COVERED_BY_PLAN: return "Coberto pelo plano?";
			case DOCTOR_SPECIALIZATION: return "Especialização do médico";
			case DOCTOR_NAME: return "Nome do médico";
			case REASON: return "Motivos";
			default: return super.fieldName(field);
		}
	}
	
	public void set(int field, Object o){
		switch(field) {
			case COVERED_BY_PLAN: setCoveredByPlan((Boolean) o);
			case DOCTOR_SPECIALIZATION: setDoctorSpecialization((String) o);
			case DOCTOR_NAME: setDoctorName((String) o);
			case REASON: setReason((String) o);
			default: super.set(field, o);
		}
	}
	
	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public boolean isCoveredByPlan() {
		return coveredByPlan;
	}

	public void setCoveredByPlan(boolean coveredByPlan) {
		this.coveredByPlan = coveredByPlan;
	}

	public String getDoctorSpecialization() {
		return doctorSpecialization;
	}

	public void setDoctorSpecialization(String doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String toString(){
		return super.toString() + " | " + doctorSpecialization + " " + doctorName + " | Coberto pelo Plano: " + BooleanHelper.booleanToBr(coveredByPlan) + " | Motivo: " + reason;
	}
}
