package d_kostka_do_gry;

import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class KostkaRPG {
	public static void main(String[] args) {
		// Pobieram dane od gracza

		System.out.println("Jaką kostą rzucasz ?");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		// Wywołuje metodę obliczającą rzut
		rpg(str);
	}

	public static void rpg(String str) {
		// Inicjuje zmienne i dziele wprowadzone dane
		StringTokenizer strTok = new StringTokenizer(str, "D-+");
		int numberOfThrows;
		int k;
		int additonalNumber;
		int result = 0;
		int throwK;
		Random r = new Random();
		// Sprawdzam jaki jest rodzaj rzutu
		if (str.charAt(0) == 'D') {
			k = Integer.parseInt(strTok.nextToken());
			throwK = r.nextInt(k + 1)+ 1;
			// Sprawdzam czy dodajemy lub odejmujemy jakąś wartość od rzutu
			if (strTok.hasMoreTokens()) {
				additonalNumber = Integer.parseInt(strTok.nextToken());
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == '-') {
						result = throwK - additonalNumber;
						break;
					} else if (str.charAt(i) == '+') {
						result = throwK + additonalNumber;
						break;
					}
				}
				System.out.println("wynik: " + result);
			} else {
				result = throwK;
				System.out.println("wynik: " + result);
			}
//			kilka rzutów kością
		} else {
			numberOfThrows = Integer.parseInt(strTok.nextToken());
			k = Integer.parseInt(strTok.nextToken());
			for (int i = 0; i < numberOfThrows; i++) {
				throwK = r.nextInt(k + 1) + 1;
				result += throwK;
			}
			if (strTok.hasMoreTokens()) {
				additonalNumber = Integer.parseInt(strTok.nextToken());
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == '-') {
						result -= additonalNumber;
						break;
					} else if (str.charAt(i) == '+') {
						result += additonalNumber;
						break;
					}
				}
				System.out.println("wynik: " + result);
			} else {
				System.out.println("wynik: " + result);
			}
		}
	}
}
