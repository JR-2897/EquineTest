package utils;

import java.util.Random;
import java.util.Scanner;

public class Util {
	
	public static String saisieString() {
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	
	public static int saisieInt() {
		try {
			Scanner sc = new Scanner(System.in);
			return sc.nextInt();
		}catch(Exception ex) {
			return -1;
		}
	}
	
	public static int randomInt(int min,int max) {
		Random r = new Random();
		int t = r.nextInt(max-min);
		return t + min;
	}

}
