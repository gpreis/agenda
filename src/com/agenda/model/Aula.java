package com.agenda.model;

public class Aula extends AgendaTask{

	private String diciplina;
	private String professor;
	private double notaAtual;
	public Aula(String descricao, Integer dia, Integer mes, Integer ano,
			Integer hora, String diciplina, String professor, double notaAtual) {
		super(descricao, dia, mes, ano, hora);
		this.diciplina = diciplina;
		this.professor = professor;
		this.notaAtual = notaAtual;
	}
	public String getDiciplina() {
		return diciplina;
	}
	public void setDiciplina(String diciplina) {
		this.diciplina = diciplina;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public double getNotaAtual() {
		return notaAtual;
	}
	public void setNotaAtual(double notaAtual) {
		this.notaAtual = notaAtual;
	}
	
	
	
}
