package com.agenda.view;

import com.agenda.model.Compromisso;
import com.agenda.nodo.CompromissoNodo;

public class CompromissoView {
	public static void print(Compromisso compromisso){
		System.out.println(compromisso.getDescrição() + " | " + compromisso.getDia() + "/" + compromisso.getMes() + "/" +
				compromisso.getAno() + " " + compromisso.getHora() + ":00");
	}
	
	public static void printList(CompromissoNodo inicio){
		CompromissoNodo temp = inicio;
		
		System.out.println("Descrição | Data Hora ");
		System.out.println("---------------------");
		
		while(temp != null){
			print(temp.getCompromisso());
			temp = (CompromissoNodo) temp.getProx();
		}
	}

}