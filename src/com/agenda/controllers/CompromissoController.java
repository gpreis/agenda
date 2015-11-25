package com.agenda.controllers;

import java.util.Scanner;

import com.agenda.model.Compromisso;
import com.agenda.nodo.CompromissoNodo;

public class CompromissoController {
	private CompromissoNodo inicio;
	private Integer tamanho;
	
	public CompromissoController(CompromissoNodo inicio){
		this.inicio = inicio;
		tamanho = (inicio != null ? inicio.getTamanho() : 0);
	}
	
	public CompromissoController(){
		this.inicio = null;
		tamanho = 0;
	}
	
	public void adicionarCompromisso(String descricao, Integer dia, Integer mes, Integer ano, Integer hora){
		Compromisso compromisso = new Compromisso(descricao, dia, mes, ano, hora);
		adicionarNodo(compromisso);
	}
	
	public void adicionarCompromisso(Scanner input){
		String descricao;
		int dia, mes, ano, hora;
		
		input.nextLine();
		System.out.println("Descricao do compromisso: ");
		descricao = input.nextLine();
		System.out.println("Dia do compromisso: ");
		dia = input.nextInt();
		System.out.println("Mes do compromisso: ");
		mes = input.nextInt();
		System.out.println("Ano do compromisso: ");
		ano = input.nextInt();
		System.out.println("Hora do compromisso: ");
		hora = input.nextInt();
		
		adicionarCompromisso(descricao, dia, mes, ano, hora);
	}
	
	private void adicionarNodo(Compromisso compromisso){
		CompromissoNodo nodo = inicio;
		inicio = new CompromissoNodo(compromisso, nodo);
		tamanho++;
	}
	
	public CompromissoNodo getInicio(){
		return inicio;
	}
	
	public Integer getTamanho(){
		return tamanho;
	}
	
}