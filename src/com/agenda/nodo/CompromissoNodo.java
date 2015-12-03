package com.agenda.nodo;

import com.agenda.model.AgendaTask;

public class CompromissoNodo extends Nodo{
	private AgendaTask compromisso;
	
	public CompromissoNodo(){
		super();
	}
	
	public CompromissoNodo(AgendaTask compromisso, CompromissoNodo prox){
		super(prox);
		this.compromisso = compromisso;
	}

	public AgendaTask getCompromisso() {
		return compromisso;
	}

	public void setCompromisso(AgendaTask compromisso) {
		this.compromisso = compromisso;
	}
}