package e_wyszukiwarka_najpopularniejszych_słów;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WyszukiwarkaSłów {
	public static void main(String[] args) {
		write();
	}
	public static void writeToFile() {
		Scanner scan = new Scanner(System.in);
		Path path = Paths.get("popular_words.txt");
		ArrayList<String> out = new ArrayList<>();
		String str = "";
		
		System.out.println("Podaj słowa które chcesz sprawdzić");
		System.out.println("Wpisz quit jeśli skończyłeś");
		
		while (! str.equalsIgnoreCase("quit")) {
			str = scan.next();
			if (str.equals("quit")) {
				break;
			} else {
				out.add(str);
				System.out.println(out);
			}
		}
		try {
			Files.write(path, out);
		} catch (IOException e) {
			System.out.println("Błąd zapisu pliku");
		}
	}
	public static void write() {
		ArrayList<String> str = new ArrayList<>();
		Connection connect = Jsoup.connect("http://wolnosc24.pl/");
		try {
			Document document = connect.get();
			Elements links = document.select("span.title");
			for (Element elem : links) {
				StringTokenizer elTok = new StringTokenizer(elem.text());
				for (int i = 0; i < elTok.countTokens(); i++) {
					str.add(elTok.nextToken());
				}
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
}
