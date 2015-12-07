package com.agenda.helpers;

import java.util.Scanner;

public class AskHelper {
	
	private static Scanner scanner;
	
	public static int askInt(String message){
		startScanner();
		System.out.println(message);
		return scanner.nextInt();
	}
	
	public static String askString(String message){
		startScanner();
		System.out.println(message);
		return scanner.nextLine();
	}
	
	public static boolean askBoolean(String message){
		return AskHelper.askInt(message + "\n0- Não\n1- Sim") == 1;
	}
	
	private static void startScanner(){
		scanner = new Scanner(System.in);
	}

}
