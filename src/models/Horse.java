package models;

public class Horse {
	
	String nameHorse;
	int age;
	int victoryNb;
	
	public Horse(String nameHorse, int age) {
		this.nameHorse = nameHorse;
		this.age = age;
		victoryNb = 0;
	}
	
	public String getNameHorse() {
		return nameHorse;
	}
	public void setNameHorse(String nameHorse) {
		this.nameHorse = nameHorse;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getVictoryNb() {
		return victoryNb;
	}
	public void setVictoryNb(int victoryNb) {
		this.victoryNb = victoryNb;
	}
	
}
