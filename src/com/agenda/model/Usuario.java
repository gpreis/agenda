package com.agenda.model;

import com.agenda.controllers.CompromissoController;
import com.agenda.nodo.CompromissoNodo;

public class Usuario {
	private String nome;
	private String codigo;
	private CompromissoController compromissoController;

	public Usuario(String nome, String codigo) {
		this.nome = nome;
		this.codigo = codigo;
		this.compromissoController = new CompromissoController();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public CompromissoController getCompromissoController() {
		return compromissoController;
	}

	public void setCompromissoController(CompromissoController compromissoController) {
		this.compromissoController = compromissoController;
	}
}
