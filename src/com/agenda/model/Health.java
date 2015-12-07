package com.agenda.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import com.agenda.helpers.BooleanHelper;

public class Health extends AgendaTask {

	private static final long serialVersionUID = 4656327614666752464L;
	private boolean coveredByPlan;
	private String doctorSpecialization;
	private String doctorName;
	private String reason;

	public Health(User owner, String description, String code, GregorianCalendar dateBegin, int durationMinutes,
			boolean weekly, String doctorSpecialization, String doctorName, 
			boolean coveredByPlan, String reason, ArrayList<User> attendees) {
		super(owner, description, code, dateBegin, durationMinutes, weekly, attendees);
		this.coveredByPlan = coveredByPlan;
		this.doctorSpecialization = doctorSpecialization;
		this.doctorName = doctorName;
		this.reason = reason;
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
