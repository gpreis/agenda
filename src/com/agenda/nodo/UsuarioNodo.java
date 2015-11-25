package com.agenda.nodo;

import com.agenda.model.Usuario;

public class UsuarioNodo extends Nodo{
	private Usuario usuario;
	
	public UsuarioNodo(){
		super();
	}
	
	public UsuarioNodo(Usuario usuario, UsuarioNodo prox){
		super(prox);
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}