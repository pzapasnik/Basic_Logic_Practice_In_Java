package b_Symulator_LOTTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		lotto();
	}

	static void lotto() {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> numbers = new ArrayList<>();
		int number = 0;
		while (numbers.size() != 6) {
			System.out.println("Podaj kolejno 6 liczb z zakresu od 1 do 49");
			while (!scan.hasNextInt()) {
				scan.next();
				System.out.println("Podaj liczbę");
			}
			number = scan.nextInt();
			if ((number < 1) || (number > 49)) {
				System.out.println("Liczba jest z innego zakresu");
			} else if (numbers.contains(number)) {
				System.out.println("Tą Liczbę już podałeś");
			} else {
				numbers.add(number);
			}
		}
		System.out.println(Arrays.toString(numbers.toArray()));
		int[] numbersArray = new int[6];
		for (int i = 0; i < numbers.size(); i++) {
			numbersArray[i] = numbers.get(i);
		}
		Arrays.sort(numbersArray);
		System.out.println(Arrays.toString(numbersArray));
		int k = 1;
		Integer[] arr = new Integer[49];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = k;
			k++;
		}
		Collections.shuffle(Arrays.asList(arr));
		Integer[] randomNumbers = new Integer[6];
		for (int i = 0; i < randomNumbers.length; i++) {
			randomNumbers[i] = arr[i];
		}
		System.out.println(Arrays.toString(randomNumbers));
		int score = 0;
		for (int i = 0; i < randomNumbers.length; i++) {
			for (int j = 0; j < numbersArray.length; j++) {
				if (randomNumbers[i] == numbersArray[j]) {
					score++;
				}
			}
		}
		if (score > 2) {
			System.out.println("Brawo wygrałeś trafiłeś: " + score + " liczy");
		} else {
			System.out.println("Niestety nie trafiłeś, spróbuj ponownie");
		}
	}

}
