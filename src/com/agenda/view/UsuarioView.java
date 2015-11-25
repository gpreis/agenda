package com.agenda.view;

import com.agenda.model.Usuario;
import com.agenda.nodo.UsuarioNodo;

public class UsuarioView {
	public static void print(Usuario usuario){
		System.out.println(usuario.getNome() + " | " + usuario.getCodigo());
	}
	
	public static void printList(UsuarioNodo inicio){
		UsuarioNodo temp = inicio;
		
		System.out.println("Nome | Codigo");
		System.out.println("---------------------");
		
		while(temp != null){
			print(temp.getUsuario());
			temp = (UsuarioNodo) temp.getProx();
		}		
	}
}