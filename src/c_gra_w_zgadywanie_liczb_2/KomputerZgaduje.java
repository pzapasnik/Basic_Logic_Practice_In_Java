package c_gra_w_zgadywanie_liczb_2;

import java.util.Scanner;

public class KomputerZgaduje {
	public static void main(String[] args) {
		game();
	}
	public static void game() {
		System.out.println("Pomyśl liczbę od 1 do 1000 a ja ją zgadnę w max 10 próbach");
		int min = 0;
		int max = 1000;
		for (int i = 1; i <= 10; i++) {
			int guess = ((max - min) / 2) + min;
			System.out.println("Zgaduje: " + guess);
			System.out.println("Odpowiedz: zgadłeś, za dużo, za mało");
			Scanner scan = new Scanner(System.in);
			String str = scan.nextLine();
			if (str.equalsIgnoreCase("za mało")) {
				min = guess;
			} else if (str.equalsIgnoreCase("za dużo")) {
				max = guess;
			} else if (str.equalsIgnoreCase("zgadłeś")) {
			System.out.println("Wygrałem!!!");
			break;
			} else {
				System.out.println("Nie oszukuj!");
			}
		}
	}
}
