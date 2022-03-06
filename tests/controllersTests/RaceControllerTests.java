package controllersTests;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Array;
import java.util.List;

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
		assertTrue(rCrt.createRace(name).equals("Le nom de la course existe déjà"));
	}
	
	@Test
	public void createRaceTestWithRaceNameEmpty() {
		String name = "";
		assertTrue(rCrt.createRace(name).equals("La création de la course n'a pas pu être faite"));
	}
	
	@Test
	public void createRaceTestWithRaceNameNull() {
		String name = null;
		assertTrue(rCrt.createRace(name).equals("La création de la course n'a pas pu être faite"));
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
		Race r = new Race("Course V");
		assertTrue(rCrt.addHorseInRace(r, horseName).equals("OK"));
	}
	
	@Test
	public void addHorseInRaceTestHorseNotExist() {
		String horseName = "Tonnerre";
		Horse h = new Horse("Eclair",3);
		data.getAllHorse().add(h);
		Race r = new Race("Course V");
		assertTrue(rCrt.addHorseInRace(r, horseName).equals("Ce cheval n'existe pas"));
	}
	
	@Test
	public void addHorseInRaceTestHorseAlreadyExistInRace() {
		String horseName = "Tonnerre";
		Horse h = new Horse(horseName,3);
		data.getAllHorse().add(h);
		Race r = new Race("Course V");
		r.getHorseList().add(h);
		assertTrue(rCrt.addHorseInRace(r, horseName).equals("Ce cheval existe déjà dans la course"));
	}
	
	@Test
	public void addHorseInRaceTestRaceIsNull() {
		String horseName = "Tonnerre";
		Horse h = new Horse(horseName,3);
		data.getAllHorse().add(h);
		assertTrue(rCrt.addHorseInRace(null, horseName).equals("La course n'est pas bonne"));
	}
	
	@Test
	public void addHorseInRaceTestHorseNameIsEmpty() {
		String horseName = "";
		Race r = new Race("Course V");
		assertTrue(rCrt.addHorseInRace(r, horseName).equals("Ce cheval n'existe pas"));
	}
	
	@Test
	public void addHorseInRaceTestHorseNameIsNull() {
		String horseName = null;
		Race r = new Race("Course V");
		assertTrue(rCrt.addHorseInRace(r, horseName).equals("Ce cheval n'existe pas"));
	}
	
	@Test
	public void addHorseInRaceTestWithAdd7thHorseInRace() {
		String horseName = "Tonnerre";
		Horse h = new Horse(horseName,3);
		data.getAllHorse().add(h);
		Race r = new Race("Course V");
		String[] listHorse = new String[] {"Pomme","Banane","Poire","Fraise","Framboise","Pêche"};
		for(String name : listHorse) {
			r.getHorseList().add(new Horse(name,5));
		}
		assertTrue(rCrt.addHorseInRace(r, horseName).equals("La course a déjà atteint son nombre maximum de chevaux"));
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
	
}
