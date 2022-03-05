package views;

import controllers.HorseController;
import controllers.RaceController;
import models.Racetrack;
import utils.Util;

public class Menu {
	
	HorseController hController = new HorseController();
	RaceController rController = new RaceController();

	public void bonjour() {
		System.out.println("Administrateur de l hippodrome : " + Racetrack.initRacetrack().getNameRacetrack());
		System.out.println("Bienvenue dans votre application de gestion");
	}

	public void choix() {
		System.out.println("-----------------------------------------------------");
		System.out.println("Que voulez vous faire ?");
		System.out.println("1 Afficher la liste des courses");
		System.out.println("2 Afficher la liste de tous les chevaux");
		System.out.println("3 Afficher la liste des chevaux d une course");
		System.out.println("4 Creer une nouvelle course");
		System.out.println("5 Creer un nouvel cheval");
		System.out.println("6 Supprimer une course");
		System.out.println("7 Supprimer un cheval");
		System.out.println("8 Ajouter des chevaux a une course");
		/*
		 * TODO 
		 * 1) Afficher la liste de tous les chevaux 
		 * 2) 2 proposition : 
		 * 		a) Ajouter cheval 
		 * 		b) Retour menu principale
		 */
		System.out.println("9 Lancement d une course et affichage de son resultat");
		System.out.println("10 Afficher les dix dernieres courses lancees");
		System.out.println("-----------------------------------------------------");

		switch (Util.saisieString()) {
		case "1":
			partMenuPrintAllRaces();
			waitBeforeComebackMenu();
			break;
		case "2":
			partMenuPrintAllHorses();
			waitBeforeComebackMenu();
			break;
		case "3":
			partMenuPrintHorseListInRace();
			waitBeforeComebackMenu();
			break;
		case "4":
			partMenuCreateRace();
			waitBeforeComebackMenu();
			break;
		case "5":
			partMenuCreateHorse();
			waitBeforeComebackMenu();
			break;
		case "6":
			System.out.println("N est pas encore implente");
			break;
		case "7":
			partMenuDeleteHorse();
			waitBeforeComebackMenu();
			break;
		case "8":
			System.out.println("N est pas encore implente");
			break;
		case "9":
			System.out.println("N est pas encore implente");
			break;
		case "10":
			System.out.println("N est pas encore implente");
			break;
		default:
			System.out.println("Cette option n existe pas");
			break;
		}
	}
	
	private void waitBeforeComebackMenu() {
		System.out.println("-----------------------------------------------------");
		System.out.println("Pour retourner au menu principal :");
		System.out.println("Appuyer sur 0");
		System.out.println("-----------------------------------------------------");
		if(Util.saisieString() == "0")
		{
			int x = 0;
		}
	}
	
	private void partMenuPrintAllRaces() {
		System.out.println("Voici la liste des courses :");
		System.out.println("-----------------------------------------------------");
		rController.printAllRaces();
	}
	
	private void partMenuPrintAllHorses() {
		System.out.println("Voici la liste des chevaux :");
		System.out.println("-----------------------------------------------------");
		hController.getAllHorses();
	}
	
	private void partMenuPrintHorseListInRace() {
		System.out.println("Pour voir les chevaux d une course vous devez :");
		System.out.println("Donner le nom de la course :");
		System.out.println("-----------------------------------------------------");
		System.out.println("Le nom de la course :");
		String raceName = Util.saisieString();
		System.out.println("-----------------------------------------------------");
		String msgPrintHorseListInRace = rController.printHorseListInRace(raceName);
		if(!msgPrintHorseListInRace.equals("OK"))
			System.out.println(msgPrintHorseListInRace);
	}
	
	private void partMenuCreateRace() {
		System.out.println("Pour creer une nouvelle course vous devez :");
		System.out.println("Lui donner un nom");
		System.out.println("-----------------------------------------------------");
		System.out.println("Le nom de la course :");
		String raceName = Util.saisieString();
		System.out.println("-----------------------------------------------------");
		String msgCreateRace = rController.createRace(raceName);
		if(!msgCreateRace.equals("OK"))
			System.out.println(msgCreateRace);
		else
			System.out.println("La course a bien ete cree");
	}
	
	private void partMenuCreateHorse() {
		System.out.println("Pour creer un nouveau cheval vous devez :");
		System.out.println("- Lui donner un nom");
		System.out.println("- Donner son age");
		System.out.println("-----------------------------------------------------");
		System.out.println("Le nom du cheval :");
		String horseName = Util.saisieString();
		System.out.println("-----------------------------------------------------");
		System.out.println("L age du cheval :");
		int horseAge = Util.saisieInt();
		System.out.println("-----------------------------------------------------");
		String msgCreateHorse = hController.createHorse(horseName, horseAge);
		if(!msgCreateHorse.equals("OK"))
			System.out.println(msgCreateHorse);
		else
			System.out.println("Le cheval a bien ete cree");
	}
	
	private void partMenuDeleteHorse() {
		partMenuPrintAllHorses();
		System.out.println("-----------------------------------------------------");
		System.out.println("Quel cheval voulez-vous supprimer ?");
		String nameHorseToDelete = Util.saisieString();
		System.out.println("-----------------------------------------------------");
		String msgDeleteHorse = hController.deleteHorse(nameHorseToDelete);
		if(!msgDeleteHorse.equals("OK"))
			System.out.println(msgDeleteHorse);
		else
			System.out.println("Le cheval a bien ete supprime");
	}
}
