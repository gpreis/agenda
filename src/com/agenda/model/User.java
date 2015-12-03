package com.agenda.model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Comparable<User>, Serializable{

	private static final long serialVersionUID = 9106319402808364968L;
	private String nome;
	private String codigo;
	private ArrayList<AgendaTask> compromissos;
	public static ArrayList<User> users = new ArrayList<User>();

	public User(String nome, String codigo) {
		this.nome = nome;
		this.codigo = codigo;
		this.compromissos = new ArrayList<AgendaTask>();
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

	public ArrayList<AgendaTask> getCompromissos() {
		return compromissos;
	}	
	
	public String toString(){
		return nome + " – " + codigo;
	}

	@Override
	public int compareTo(User user) {
		return getNome().compareTo(user.getNome());
	}
	
	public boolean equals(Object o) {
		User user = (User) o;
		return getNome().equals(user.getNome());
	}
	
}
