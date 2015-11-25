package com.agenda.nodo;

public class Nodo {
	private Nodo prox;
	
	public Nodo(Nodo prox){
		this.prox = prox;
	}
	
	public Nodo(){
		this.prox = null;
	}
	
	public Nodo getProx(){
		return prox;
	}
	
	public void setProx(Nodo prox){
		this.prox = prox;
	}
	
	public int getTamanho(){
		int size = 0;
		Nodo prox = this.prox;
		while(prox != null){
			prox = prox.getProx();
			size++;
		}
		return size;
	}
	
}
