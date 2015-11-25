package com.agenda.view;

import java.util.Scanner;

import com.agenda.controllers.UsuarioController;
import com.agenda.model.Usuario;

public class UsuarioInterface {
	Scanner input;
	Usuario usuario;
	
	public UsuarioInterface(Scanner input, Usuario usuario){
		this.input = input;
		this.usuario = usuario;
	}
	
	public void manage(){
		int action = -1;
		while(action != 0){
			System.out.println("\n\nUsuário atual > " + usuario.getNome());
			System.out.println("Ações:");
			System.out.println("1- Adicionar Compromisso");
			System.out.println("2- Listar Compromissos");
			System.out.println("Digitar as ações:");
			action = input.nextInt();
			
			switch(action){
				case 1:
					usuario.getCompromissoController().adicionarCompromisso(input);
					break;
				case 2:
					CompromissoView.printList(usuario.getCompromissoController().getInicio());
					break;
			}
		}
	}
	
	
}
