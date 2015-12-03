package com.agenda.nodo;

import com.agenda.model.User;

public class UsuarioNodo extends Nodo{
	private User usuario;
	
	public UsuarioNodo(){
		super();
	}
	
	public UsuarioNodo(User usuario, UsuarioNodo prox){
		super(prox);
		this.usuario = usuario;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
}