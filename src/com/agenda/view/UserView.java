package com.agenda.view;

import java.util.List;

import com.agenda.model.User;

public class UserView {
	public static void print(User usuario){
		System.out.println(usuario.getNome() + " | " + usuario.getCodigo());
	}
	
	public static void printList(List<User> list){
		System.out.println("Nome | Codigo");
		System.out.println("---------------------");
		
		for(User user : list){
			print(user);
		}
	}
	
}