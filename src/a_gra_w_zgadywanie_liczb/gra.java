package a_gra_w_zgadywanie_liczb;

import java.util.Random;
import java.util.Scanner;

public class gra {
	public static void main(String[] args) {
		game();
	}

	static void game() {
		Random r = new Random();
		int randomNumber = r.nextInt(101);
		int number = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Zgadnij liczbę");

		while (randomNumber != number) {
			while (!scan.hasNextInt()) {
				scan.next();
				System.out.println("To nie jest liczba");
			}
			number = scan.nextInt();
			if (number > randomNumber) {
				System.out.println("Podana liczba jest za duża");
			} else if (number < randomNumber) {
				System.out.println("Podana liczba jest za mała");
			} else {
				System.out.println("Brawo trafiłeś");
			}
		}
	}

}
