package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter file full path: ");
		String pathIn = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(pathIn))) {

			//Set<> set = new HashSet<>();
			String line = br.readLine();

			while (line != null) {
				String[] fields = line.split(",");
				String politic = fields[0];
				Integer votes = Integer.parseInt( fields[1]);
				System.out.println("Politic : " + politic + " | Votes : " + votes);
				
				//set.add();
				line = br.readLine();
			}
			//System.out.println("Total users: " + set.size());
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
		sc.close();
	}

}
