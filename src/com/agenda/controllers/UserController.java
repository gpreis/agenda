package com.agenda.controllers;

import java.util.Scanner;

import com.agenda.exceptions.ResourceNotFoundException;
import com.agenda.helpers.UserHelper;
import com.agenda.model.User;

public class UserController extends BaseController<User>{

	private Scanner input;
	
	public UserController() {
		super(User.users);
	}

	@Override
	public void add() {
		String nome, codigo;
		input = new Scanner(System.in);
		
		System.out.println("Nome do usuario: ");
		nome = input.nextLine();
		System.out.println("Codigo do usuario: ");
		codigo = input.nextLine();
		
		User user = new User(nome, codigo);
		add(user);
	}
	
	public User findByName(){
		String nome;
		input = new Scanner(System.in);
		
		System.out.println("Nome do usuario: ");
		nome = input.nextLine();
		
		return UserHelper.findByName(nome);
	}

}