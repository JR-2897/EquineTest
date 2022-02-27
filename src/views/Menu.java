package views;

import models.Racetrack;
import utils.Util;

public class Menu {

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
			System.out.println("N est pas encore implente");
			break;
		case "2":
			System.out.println("N est pas encore implente");
			break;
		case "3":
			System.out.println("N est pas encore implente");
			break;
		case "4":
			System.out.println("N est pas encore implente");
			break;
		case "5":
			System.out.println("N est pas encore implente");
			break;
		case "6":
			System.out.println("N est pas encore implente");
			break;
		case "7":
			System.out.println("N est pas encore implente");
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
}
