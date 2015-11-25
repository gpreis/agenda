package com.agenda.controllers;

import java.util.Scanner;

import com.agenda.model.Compromisso;
import com.agenda.model.Usuario;
import com.agenda.nodo.UsuarioNodo;

public class UsuarioController {
	private UsuarioNodo inicio;
	private Integer tamanho;
	
	public UsuarioController(UsuarioNodo inicio){
		this.inicio = inicio;
		tamanho = inicio.getTamanho();
	}
	
	public UsuarioController(){
		this.inicio = null;
		tamanho = 0;
	}
	
	public void adicionarUsuario(String nome, String codigo){
		Usuario usuario = new Usuario(nome, codigo);
		adicionarNodo(usuario);
	}
	
	public void adicionarUsuario(Scanner input){
		String nome, codigo;
		
		input.nextLine();
		System.out.println("Nome do usuario: ");
		nome = input.nextLine();
		System.out.println("Codigo do usuario: ");
		codigo = input.nextLine();
		
		adicionarUsuario(nome, codigo);
	}
	
	private void adicionarNodo(Usuario usuario){
		UsuarioNodo nodo = inicio;
		inicio = new UsuarioNodo(usuario, nodo);
		tamanho++;
	}
	
	public UsuarioNodo getInicio(){
		return inicio;
	}
	
	public Integer getTamanho(){
		return tamanho;
	}

	public Usuario procurarNome(String nome) {
		UsuarioNodo nodo = inicio;
		while(nodo != null && !nodo.getUsuario().getNome().equals(nome)){
			nodo = (UsuarioNodo) nodo.getProx();
		}
		if(nodo == null) return null;
		return nodo.getUsuario();
	}

	public Usuario procurarNome(Scanner input) {
		String nome;
		
		input.nextLine();
		System.out.println("Nome do usuario: ");
		nome = input.nextLine();
		
		return procurarNome(nome);
	}
	
}