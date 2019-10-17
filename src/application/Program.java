package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
			
			for (Political key : politicals.keySet()) {
				System.out.println("Political Party : " + key.getPoliticalParty() + " | Political : " + key.getPolitical() + " | Votes : " + politicals.get(key));
			}
			
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
		sc.close();
	}

}
