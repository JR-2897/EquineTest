package controllers;

import views.Menu;

public class Main {

	public static void main(String[] args) {
		Menu menu= new Menu();
		menu.bonjour();
		
		while(true) {
			menu.choix();
		}
	}

}
