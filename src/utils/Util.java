package utils;

import java.util.Random;
import java.util.Scanner;

public class Util {
	
	public static String saisieString() {
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	
	public static int saisieInt() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	public static int randomInt(int min,int max) {
		Random r = new Random();
		int t = r.nextInt(max-min);
		return t + min;
	}

}
