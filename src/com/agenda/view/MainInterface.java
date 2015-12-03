package com.agenda.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.agenda.controllers.UserController;
import com.agenda.exceptions.ResourceDuplicatedException;
import com.agenda.exceptions.ResourceNotFoundException;
import com.agenda.model.User;

public class MainInterface {
	private Scanner input;
	private UserController usCon;
	
	public MainInterface(){
		input = new Scanner(System.in);
		usCon = new UserController();
	}
	
	public void mainMenu(){
		int action = -1;
		while(action != 0){
			
			System.out.println("\n\nMenu Principal:");
			System.out.println("0- Sair");
			System.out.println("1- Criar Usuário");
			System.out.println("2- Listar Usuários");
			System.out.println("3- Selecionar Usuário");
			System.out.println("Digite a acione: ");
			
			try{
				action = input.nextInt();
			} catch(InputMismatchException e) {
				action = -1;
				System.out.println("Informação inválida!");
			}
			
			switch (action) {
			case 1:
				addUser();
				break;
			case 2:
				UserView.printList(usCon.getList());
				break;
			case 3:
				selectUser();
				break;
			}
		}
	}
	
	private void addUser(){
		try {
			usCon.add();
		} catch (ResourceDuplicatedException e) {
			System.out.println("Usuário com este nome já cadastrado!"); 
		}
	}
	
	private void selectUser(){
		try{
			User user = usCon.findByName();
			new UserInterface(user).manage();
		}catch(ResourceNotFoundException e){
			System.out.println("Usuário não encontrado!");
		}
	}
	
}
