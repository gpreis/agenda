package com.agenda.model;

public class Ferias extends AgendaTask {

	private int diaFinal, mesFinal, anoFinal;

	public Ferias(String descricao, Integer dia, Integer mes, Integer ano,
			Integer hora, int diaFinal, int mesFinal, int anoFinal) {
		super(descricao, dia, mes, ano, hora);
		this.diaFinal = diaFinal;
		this.mesFinal = mesFinal;
		this.anoFinal = anoFinal;
	}

	public int getDiaFinal() {
		return diaFinal;
	}

	public void setDiaFinal(int diaFinal) {
		this.diaFinal = diaFinal;
	}

	public int getMesFinal() {
		return mesFinal;
	}

	public void setMesFinal(int mesFinal) {
		this.mesFinal = mesFinal;
	}

	public int getAnoFinal() {
		return anoFinal;
	}

	public void setAnoFinal(int anoFinal) {
		this.anoFinal = anoFinal;
	}
	
	
}
