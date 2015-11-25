package com.agenda.view;

import java.util.Scanner;

import com.agenda.controllers.UsuarioController;
import com.agenda.model.Usuario;

public class MainInterface {
	private Scanner input;
	private UsuarioController usCon;
	
	public MainInterface(){
		input = new Scanner(System.in);
		usCon = new UsuarioController();
	}
	
	public void mainMenu(){
		int action = -1;
		while(action != 0){
			
			System.out.println("\n\nMenu Principal:");
			System.out.println("1- Criar Usuário");
			System.out.println("2- Listar Usuários");
			System.out.println("3- Gerenciar Usuário");
			System.out.println("Digite a acione: ");
			action = input.nextInt();
			
			switch (action) {
			case 1:
				usCon.adicionarUsuario(input);
				break;
			case 2:
				UsuarioView.printList(usCon.getInicio());
				break;
			case 3:
				Usuario usuario = usCon.procurarNome(input);
				if(usuario != null) new UsuarioInterface(input, usuario).manage();
				break;
			}
		}
	}
	
}
