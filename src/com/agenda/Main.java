package com.agenda;

import java.io.IOException;
import java.util.ArrayList;

import com.agenda.io.InputData;
import com.agenda.io.OutputData;
import com.agenda.model.User;
import com.agenda.view.MainInterface;

public class Main {

	private final static String PATH_DATA = "/home/gabriel/agendadata";  
	
	public static void main(String[] args) {
		load(); // TODO ask path and put on the menu actions 
		MainInterface mainInterface = new MainInterface();
		mainInterface.mainMenu();
		save(); // TODO ask path and put on the menu actions
	}
	
	private static void save() {
		try {
			new OutputData(PATH_DATA).save();
			System.out.println("Dados salvos com sucesso!");
		} catch (IOException e) {
			System.out.println("Impossível salvar dados!");
		}
	}

	private static void load(){
		try {
			new InputData(PATH_DATA).load();
			System.out.println("Dados carregados com sucesso!");
		} catch (ClassNotFoundException e) {
			System.out.println("Impossível ler arquivo de dados!"); 
		} catch (IOException e) {
			System.out.println("Arquivo de dados não encontrado!");
		}
	}

}
