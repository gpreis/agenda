package com.agenda.nodo;

import com.agenda.model.Compromisso;

public class CompromissoNodo extends Nodo{
	private Compromisso compromisso;
	
	public CompromissoNodo(){
		super();
	}
	
	public CompromissoNodo(Compromisso compromisso, CompromissoNodo prox){
		super(prox);
		this.compromisso = compromisso;
	}

	public Compromisso getCompromisso() {
		return compromisso;
	}

	public void setCompromisso(Compromisso compromisso) {
		this.compromisso = compromisso;
	}
}