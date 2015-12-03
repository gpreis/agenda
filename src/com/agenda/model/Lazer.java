package com.agenda.model;

public class Lazer extends AgendaTask{
       
	private String atividade;
	private boolean separeiApetrechos;
	
	public Lazer(String descricao, Integer dia, Integer mes, Integer ano,
			Integer hora, String atividade, boolean separeiApetrechos) {
		super(descricao, dia, mes, ano, hora);
		this.atividade = atividade;
		this.separeiApetrechos = separeiApetrechos;
	}
	public String getAtividade() {
		return atividade;
	}
	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}
	public boolean isSepareiApetrechos() {
		return separeiApetrechos;
	}
	public void SepareiApetrechosOrganizados() {
		this.separeiApetrechos = true;
	}
	
	
}
