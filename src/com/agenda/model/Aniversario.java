package com.agenda.model;

public class Aniversario extends AgendaTask {
	public User aniversariante;
	public String presente;
	public Boolean compreiPresente;

	public Aniversario(String descricao, Integer dia, Integer mes, Integer ano,
			Integer hora, User aniversariante, String presente, Boolean compreiPresente) {
		super(descricao, dia, mes, ano, hora);
		this.aniversariante = aniversariante;
		this.presente = presente;
		this.compreiPresente = compreiPresente;
	}
	
	public void compraDePresenteRealizada(){
		compreiPresente = true;
	}

	public User getAniversariante() {
		return aniversariante;
	}

	public void setAniversariante(User aniversariante) {
		this.aniversariante = aniversariante;
	}

	public String getPresente() {
		return presente;
	}

	public void setPresente(String presente) {
		this.presente = presente;
	}

	public Boolean compreiPresente(){
		return compreiPresente;
	}

}
