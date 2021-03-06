package controllersTests;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controllers.RaceController;
import models.Data;
import models.Horse;
import models.Race;

public class RaceControllerTests {

	Data data = Data.init();
	
	RaceController rCrt = new RaceController();
	
	
	@BeforeEach
	public void initData() {
		data.resetData();
	}
	
	// printAllRace tests
	
	@Test
	public void printAllRaceTestOk() {
		assertTrue(rCrt.printAllRaces().equals("OK"));
	}
	
	// createRace tests
	
	@Test
	public void createRaceTestOk() {
		String name = "Course du mardi";
		assertTrue(rCrt.createRace(name).equals("OK"));
	}
	
	@Test
	public void createRaceTestWithRaceNameAlReadyExist() {
		String name = "Course du mercredi";
		data.getAllRace().add(new Race(name));
		assertTrue(rCrt.createRace(name).equals("Le nom de la course existe d?j?"));
	}
	
	@Test
	public void createRaceTestWithRaceNameEmpty() {
		String name = "";
		assertTrue(rCrt.createRace(name).equals("La cr?ation de la course n'a pas pu ?tre faite"));
	}
	
	@Test
	public void createRaceTestWithRaceNameNull() {
		String name = null;
		assertTrue(rCrt.createRace(name).equals("La cr?ation de la course n'a pas pu ?tre faite"));
	}
	
	// deleteHorseInRace tests
	@Test
	public void deleteHorseInRaceTestOk() {
		String raceName = "Course de Mars v1";
		String horseName = "Bobby";
		Horse h = new Horse(horseName,7);
		data.getAllHorse().add(h);
		Race r = new Race(raceName);
		r.getHorseList().add(h);
		data.getAllRace().add(r);
		assertTrue(rCrt.deleteHorseInRace(raceName, horseName).equals("OK"));
	}
	
	@Test
	public void deleteHorseInRaceTestWithRaceNotExist() {
		String raceName = "Course de Mars v2";
		String horseName = "Babby";
		Horse h = new Horse(horseName,7);
		data.getAllHorse().add(h);
		Race r = new Race(raceName);
		r.getHorseList().add(h);
		assertTrue(rCrt.deleteHorseInRace(raceName, horseName).equals("La course n'existe pas"));
	}
	
	@Test
	public void deleteHorseInRaceTestWithHorseNotExist() {
		String raceName = "Course de Mars v3";
		String horseName = "Bibby";
		Horse h = new Horse(horseName,7);
		Race r = new Race(raceName);
		r.getHorseList().add(h);
		data.getAllRace().add(r);
		assertTrue(rCrt.deleteHorseInRace(raceName, horseName).equals("Le cheval n'existe pas"));
	}
	
	@Test
	public void deleteHorseInRaceTestWithHorseNotExistInRace() {
		String raceName = "Course de Mars v4";
		String horseName = "Bubby";
		Horse h = new Horse(horseName,7);
		data.getAllHorse().add(h);
		Race r = new Race(raceName);
		data.getAllRace().add(r);
		assertTrue(rCrt.deleteHorseInRace(raceName, horseName).equals("Le cheval n'existe pas dans cette course"));
	}
	
	@Test
	public void deleteHorseInRaceTestWithHorseNameNull() {
		String raceName = "Course de Mars v4";
		String horseName = null;
		assertTrue(rCrt.deleteHorseInRace(raceName, horseName).equals("Le cheval n'existe pas"));
	}
	
	@Test
	public void deleteHorseInRaceTestWithHorseNameEmpty() {
		String raceName = "Course de Mars v4";
		String horseName = "";
		assertTrue(rCrt.deleteHorseInRace(raceName, horseName).equals("Le cheval n'existe pas"));
	}
	
	@Test
	public void deleteHorseInRaceTestWithRaceNameNull() {
		String raceName = null;
		String horseName = "Tenor 1";
		Horse h = new Horse(horseName,7);
		data.getAllHorse().add(h);
		assertTrue(rCrt.deleteHorseInRace(raceName, horseName).equals("La course n'existe pas"));
	}
	
	@Test
	public void deleteHorseInRaceTestWithRaceNameEmpty() {
		String raceName = "";
		String horseName = "Tenor 2";
		Horse h = new Horse(horseName,7);
		data.getAllHorse().add(h);
		assertTrue(rCrt.deleteHorseInRace(raceName, horseName).equals("La course n'existe pas"));
	}
	
	// printHorseListInRace tests
	
	@Test
	public void printHorseListInRaceTestOk() {
		String raceName = "Course arc-en-ciel";
		Race r = new Race(raceName);
		data.getAllRace().add(r);
		assertTrue(rCrt.printHorseListInRace(raceName).equals("OK"));	
	}
	
	@Test
	public void printHorseListInRaceTestWithRaceNotExist() {
		String raceName = "Course arc-en-ciel";
		Race r = new Race("Course prix de l'arc de triomphe");
		data.getAllRace().add(r);
		assertTrue(rCrt.printHorseListInRace(raceName).equals("Cette course n'existe pas"));	
	}
	
	@Test
	public void printHorseListInRaceTestWithRaceNameIsNull() {
		String raceName = null;
		assertTrue(rCrt.printHorseListInRace(raceName).equals("Cette course n'existe pas"));	
	}
	
	@Test
	public void printHorseListInRaceTestWithRaceNameIsEmpty() {
		String raceName = "";
		assertTrue(rCrt.printHorseListInRace(raceName).equals("Cette course n'existe pas"));	
	}
	
	
	// addHorseInRace tests
	
	@Test
	public void addHorseInRaceTestOk() {
		String horseName = "Tonnerre";
		Horse h = new Horse(horseName,3);
		data.getAllHorse().add(h);
		String raceName = "Course V";
		Race r = new Race(raceName);
		data.getAllRace().add(r);
		assertTrue(rCrt.addHorseInRace(raceName, horseName).equals("OK"));
	}
	
	@Test
	public void addHorseInRaceTestHorseNotExist() {
		String horseName = "Tonnerre";
		Horse h = new Horse("Eclair",3);
		data.getAllHorse().add(h);
		String raceName = "Course V";
		Race r = new Race(raceName);
		data.getAllRace().add(r);
		assertTrue(rCrt.addHorseInRace(raceName, horseName).equals("Ce cheval n'existe pas"));
	}
	
	@Test
	public void addHorseInRaceTestHorseAlreadyExistInRace() {
		String horseName = "Tonnerre";
		Horse h = new Horse(horseName,3);
		data.getAllHorse().add(h);
		String raceName = "Course V";
		Race r = new Race(raceName);
		r.getHorseList().add(h);
		data.getAllRace().add(r);
		assertTrue(rCrt.addHorseInRace(raceName, horseName).equals("Ce cheval existe d?j? dans la course"));
	}
	
	@Test
	public void addHorseInRaceTestRaceNameIsNull() {
		String horseName = "Tonnerre";
		Horse h = new Horse(horseName,3);
		data.getAllHorse().add(h);
		assertTrue(rCrt.addHorseInRace(null, horseName).equals("La course n existe pas"));
	}
	
	@Test
	public void addHorseInRaceTestRaceNameIsEmpty() {
		String horseName = "Tonnerre";
		Horse h = new Horse(horseName,3);
		data.getAllHorse().add(h);
		assertTrue(rCrt.addHorseInRace("", horseName).equals("La course n existe pas"));
	}
	
	@Test
	public void addHorseInRaceTestHorseNameIsEmpty() {
		String horseName = "";
		String raceName = "Course V";
		Race r = new Race(raceName);
		data.getAllRace().add(r);
		assertTrue(rCrt.addHorseInRace(raceName, horseName).equals("Ce cheval n'existe pas"));
	}
	
	@Test
	public void addHorseInRaceTestHorseNameIsNull() {
		String horseName = null;
		String raceName = "Course V";
		Race r = new Race(raceName);
		data.getAllRace().add(r);
		assertTrue(rCrt.addHorseInRace(raceName, horseName).equals("Ce cheval n'existe pas"));
	}
	
	@Test
	public void addHorseInRaceTestWithAdd7thHorseInRace() {
		String horseName = "Tonnerre";
		Horse h = new Horse(horseName,3);
		data.getAllHorse().add(h);
		String raceName = "Course V";
		Race r = new Race(raceName);
		String[] listHorse = new String[] {"Pomme","Banane","Poire","Fraise","Framboise","P?che"};
		for(String name : listHorse) {
			r.getHorseList().add(new Horse(name,5));
		}
		data.getAllRace().add(r);
		assertTrue(rCrt.addHorseInRace(raceName, horseName).equals("La course a d?j? atteint son nombre maximum de chevaux"));
	}
	
	//  deleteRace tests
	
	@Test
	public void deleteRaceTestOkWithinHorseInRace() {
		String nameRace = "Course Prix Rivoli";
		Race r = new Race(nameRace);
		data.getAllRace().add(r);
		assertTrue(rCrt.deleteRace(nameRace).equals("OK"));
	}
	
	@Test
	public void deleteRaceTestOkWithHorseInRace() {
		String nameRace = "Course Prix Rivoli";
		Race r = new Race(nameRace);
		r.getHorseList().add(new Horse("Fille de beaute", 7));
		data.getAllRace().add(r);
		assertTrue(rCrt.deleteRace(nameRace).equals("OK"));
	}
	
	@Test
	public void deleteRaceTestWithRaceNull() {
		assertTrue(rCrt.deleteRace("Course Prix Toto").equals("La course que vous avez donne n existe pas"));
	}
	
	@Test
	public void deleteRaceTestWithNameRaceNull() {
		assertTrue(rCrt.deleteRace(null).equals("Vous n avez pas donne le nom de la course"));
	}
	
	@Test
	public void deleteRaceTestWithNameRaceEmpty() {
		assertTrue(rCrt.deleteRace("").equals("Vous n avez pas donne le nom de la course"));
	}
	
	@Test
	public void deleteRaceTestWithHorseWinner() {
		String nameRace = "Course Prix Rivoli";
		Race r = new Race(nameRace);
		r.setWinner(new Horse("Fille de beaute", 7));
		data.getAllRace().add(r);
		assertTrue(rCrt.deleteRace(nameRace).equals("Suppresion impossible car la course a un gagnant"));

	}
	
	// showInfoRace tests
	
	@Test
	public void showInfoRaceOK() {
		String nameRace = "Course Prix La Somme";
		rCrt.createRace(nameRace);
		
		assertTrue(rCrt.showInfoRace(nameRace).equals("OK"));
	}
	
	@Test
	public void showInfoRaceKO() {
		String nameRace = "Course Prix Clemenceau";
		assertTrue(rCrt.showInfoRace(nameRace).equals("Cette course n existe pas"));
	}
	
	// launchRaceAndPrintResult tests
	
	@Test
	public void launchRaceAndPrintResultTestOk() {
		String raceName = "Course V";
		Race r = new Race(raceName);
		String[] listHorse = new String[] {"Pomme","Banane","Poire","Fraise","Framboise","P?che"};
		for(String name : listHorse) {
			r.getHorseList().add(new Horse(name,5));
		}
		data.getAllRace().add(r);
		assertTrue(rCrt.launchRaceAndPrintResult(raceName).equals("OK"));
	}
	
	@Test
	public void launchRaceAndPrintResultTestWithRaceNameIsEmpty() {
		assertTrue(rCrt.launchRaceAndPrintResult("").equals("La course n'existe pas"));
	}
	
	@Test
	public void launchRaceAndPrintResultTestWithRaceNameIsNull() {
		assertTrue(rCrt.launchRaceAndPrintResult(null).equals("La course n'existe pas"));
	}
	
	@Test
	public void launchRaceAndPrintResultTestWithRaceNotExist() {
		String raceName = "Course V";
		Race r = new Race(raceName);
		String[] listHorse = new String[] {"Pomme","Banane","Poire","Fraise","Framboise","P?che"};
		for(String name : listHorse) {
			r.getHorseList().add(new Horse(name,5));
		}
		assertTrue(rCrt.launchRaceAndPrintResult(raceName).equals("La course n'existe pas"));
	}
	
	@Test
	public void launchRaceAndPrintResultTestWithOnlyFiveHorses() {
		String raceName = "Course V";
		Race r = new Race(raceName);
		String[] listHorse = new String[] {"Pomme","Banane","Fraise","Framboise","P?che"};
		for(String name : listHorse) {
			r.getHorseList().add(new Horse(name,5));
		}
		data.getAllRace().add(r);
		assertTrue(rCrt.launchRaceAndPrintResult(raceName).equals("Il faut 6 chevaux pour lancer la course. Il y en a que "+ r.getHorseList().size()));
	}
	
	@Test
	public void launchRaceAndPrintResultTestWithRaceHasAlreadyLaunched() {
		String raceName = "Course V";
		Race r = new Race(raceName);
		String[] listHorse = new String[] {"Pomme","Banane","Poire","Fraise","Framboise","P?che"};
		for(String name : listHorse) {
			r.getHorseList().add(new Horse(name,5));
		}
		r.setWinner(new Horse("Pomme",5));
		data.getAllRace().add(r);
		assertTrue(rCrt.launchRaceAndPrintResult(raceName).equals("La course a d?j? ?t? lanc?, elle ne peut pas ?tre relanc?"));
	}
	
	// printLast10RacesLaunched tests
	
	@Test
	public void printLast10RacesLaunchedTestOk() {
		String raceName = "Course V";
		Race r = new Race(raceName);
		r.setWinner(new Horse("Pomme",5));
		r.setRaceDate(LocalDate.now());
		data.getAllRace().add(r);
		assertTrue(rCrt.printLast10RacesLaunched().equals("OK"));
	}
	
	@Test
	public void printLast10RacesLaunchedTestWithNeitherRaceLaunched() {
		assertTrue(rCrt.printLast10RacesLaunched().equals("OK"));
	}
}
