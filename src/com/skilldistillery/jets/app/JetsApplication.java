package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.CargoJet;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.PassengerJet;

public class JetsApplication {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		JetsApplication ja = new JetsApplication();

		List<Jet> aircraft = new ArrayList<>();
		AirField airfield = new AirField();

		ja.readFromFile("jets.txt", aircraft, airfield);

		ja.menu(sc, airfield);
//		for (Jet jet : airfield.getFleet()) {
//			System.out.println("AFLT Model: " + jet.getModel());
//			System.out.println("AFLT Speed (Mach): " + jet.getSpeed());
//			System.out.println("AFLT Range (km): " + jet.getRange());
//			System.out.println("AFLT Price (USD): " + jet.getPrice());
//		}

	}

	public void readFromFile(String fn, List<Jet> jetsList, AirField airfield) {
		try {
			BufferedReader bufIn = new BufferedReader(new FileReader(fn));
			String line;
			ArrayList<Jet> tempArray = new ArrayList<>();
			while ((line = bufIn.readLine()) != null) {
				String[] split = line.split("\t");
				String aircraftType = split[0];
				String model = split[1];
				double speed = Double.parseDouble(split[2]);
				int range = Integer.parseInt(split[3]);
				long price = (long) Integer.parseInt(split[4]);
				String flyMessage = split[5];
				Jet tempJet;

				switch (aircraftType) {
				case "FighterJet":
					tempJet = new FighterJet(model, speed, range, price, flyMessage);
					tempArray.add(tempJet);
					break;
				case "CargoJet":
					tempJet = new CargoJet(model, speed, range, price, flyMessage);
					tempArray.add(tempJet);
					break;
				case "PassengerJet":
					tempJet = new PassengerJet(model, speed, range, price, flyMessage);
					tempArray.add(tempJet);
					break;
				default:
					tempJet = new PassengerJet(model, speed, range, price);
					tempArray.add(tempJet);
					break;
				}
			}

			for (Jet jet : tempArray) {
				jetsList.add(jet);
			}

			airfield.setFleet(tempArray);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void menu(Scanner sc, AirField airfield) {
		boolean dalshe = true;
		while (dalshe) {
			System.out.println("############# JETS APP #############");
			System.out.println("####    choose an option 1-9    ####");
			System.out.println("###                              ###");
			System.out.println("## 1. List Fleet                  ##");
			System.out.println("## 2. Fly All Jets                ##");
			System.out.println("## 3. View Fastest Jet            ##");
			System.out.println("## 4. View Jet With Longest Range ##");
			System.out.println("## 5. Load All Cargo Jets         ##");
			System.out.println("## 6. Dogfight!!!                 ##");
			System.out.println("## 7. Add A Jet To The Fleet      ##");
			System.out.println("## 8. Remove A Jet From The Fleet ##");
			System.out.println("## 9. Quit                        ##");
			System.out.println("###                              ###");
			System.out.println("####                            ####");
			System.out.println("####################################");
			System.out.println();
			try {
				int choice = sc.nextInt();
				if (choice > 0 && choice < 10) {
					switch (choice) {
					case 1:
						airfield.displayFleet();
						break;
					case 2:
						airfield.flyAllJets();
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						break;
					case 6:
						break;
					case 7:
						break;
					case 8:
						break;
					case 9:
						break;

					}
				}
				else {
					System.err.println("Choice must be a number 1-9");
					continue;
				}
			} catch (Exception e) {
				System.err.println("Choice must be a number 1-9");
				continue;
			}
		}
	}

}
