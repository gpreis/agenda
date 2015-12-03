package com.agenda.model;

public class Saude extends AgendaTask{
	private User medico;
	private Boolean fazerExames;
	private Boolean fizExames;
	private Boolean fazerJejum;
	private String sintomas;

	public Saude(String descricao, Integer dia, Integer mes, Integer ano,
			Integer hora, User medico, Boolean fazerExames,
			Boolean fizExames, Boolean fazerJejum, String sintomas) {
		super(descricao, dia, mes, ano, hora);
		this.medico = medico;
		this.fazerExames = fazerExames;
		this.fizExames = fizExames;
		this.fazerJejum = fazerJejum;
		this.sintomas = sintomas;
	}


	public void examesRealizados(){
		fizExames = true;
	}

	public User getMedico() {
		return medico;
	}

	public void setMedico(User medico) {
		this.medico = medico;
	}

	public Boolean getFazerExames() {
		return fazerExames;
	}

	public void setFazerExames(Boolean fazerExames) {
		this.fazerExames = fazerExames;
	}

	public Boolean getFazerJejum() {
		return fazerJejum;
	}

	public void setFazerJejum(Boolean fazerJejum) {
		this.fazerJejum = fazerJejum;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public Boolean getFizExames() {
		return fizExames;
	}
	
}
