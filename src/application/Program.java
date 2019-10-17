package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import General.Utility;
import entities.Political;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter file full path: ");
		String pathIn = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(pathIn))) {

			Map<Political, Integer> politicals = new HashMap<>();
			String line = br.readLine();

			while (line != null) {
				String[] fields = line.split(",");
				String politicalParty = fields[0];
				String political = fields[1];
				Integer value = Integer.parseInt(fields[2]);
				Political key = new Political(political, politicalParty);
				if (politicals.containsKey(key)) {
					value += politicals.get(key);
				}
				politicals.put(key, value);
				line = br.readLine();
			}
			showPoliticals(politicals);
			
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
		sc.close();
	}
	public static void showPoliticals(Map<Political, Integer> politicals) {
		
		Map<Political, Integer> politicalsOrderVotes = new TreeMap<>();
		
		for (Political key : politicals.keySet()) {

			String political = key.getPolitical();
			String politicalParty = key.getPoliticalParty();
			Political p = new Political(political, politicalParty);
			
			Integer value = politicals.get(key);
			p.addVotes(value);
			
			politicalsOrderVotes.put(p, value);
			
		}
		System.out.println("Counted votes until moment:");
		System.out.println(Utility.stringFix("", 50, "="));
		System.out.print(Utility.stringFix("Party", 10, " "));
		System.out.print(Utility.stringFix("Political", 30, " "));
		System.out.println(Utility.stringFix("Votes", 10, " "));
		System.out.println(Utility.stringFix("", 50, "="));
		for (Political key : politicalsOrderVotes.keySet()) {
			System.out.print(Utility.stringFix(key.getPoliticalParty(), 10, " "));
			System.out.print(Utility.stringFix(key.getPolitical(), 30, " "));
			System.out.println(Utility.stringFix(""+ politicalsOrderVotes.get(key), 10, " "));
		}
		System.out.println(Utility.stringFix("", 50, "="));
	}
}
