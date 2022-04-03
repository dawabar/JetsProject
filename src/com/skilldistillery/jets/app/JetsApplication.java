package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
		
		String importFile = "jets.txt"; 
		ja.readFromFile(importFile, aircraft, airfield);

		ja.menu(sc, airfield, importFile);
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
				long price = (long) Double.parseDouble(split[4]);
				double capacity = Double.parseDouble(split[5]);
				String flyMessage = split[6];
				Jet tempJet;

				switch (aircraftType) {
				case "FighterJet":
					tempJet = new FighterJet(model, speed, range, price, flyMessage);
					tempArray.add(tempJet);
					break;
				case "CargoJet":
					tempJet = new CargoJet(model, speed, range, price, capacity, flyMessage);
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
			bufIn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void menu(Scanner sc, AirField airfield, String importFile) {
		boolean further = true;
		while (further) {
			System.out.println("############# JETS APP #############");
			System.out.println("####    choose an option 1-9    ####");
			System.out.println("###                              ###");
			System.out.println("## 1. List Fleet                  ##");
			System.out.println("## 2. Fly All Jets                ##");
			System.out.println("## 3. Fly Specific Jet            ##");
			System.out.println("## 4. View Fastest Jet            ##");
			System.out.println("## 5. View Jet With Longest Range ##");
			System.out.println("## 6. Load All Cargo Jets         ##");
			System.out.println("## 7. Dogfight!!!                 ##");
			System.out.println("## 8. Add A Jet To The Fleet      ##");
			System.out.println("## 9. Remove A Jet From The Fleet ##");
			System.out.println("## 10. Quit                       ##");
//			System.out.println("## 10. Export fleet to file       ##");
//			System.out.println("## 11. Quit                       ##");
			System.out.println("###                              ###");
			System.out.println("####                            ####");
			System.out.println("####################################");
			System.out.println();
			try {
				int choice = sc.nextInt();
				sc.nextLine();
//				if (choice > 0 && choice < 12) {
				if (choice > 0 && choice < 11) {
					switch (choice) {
					case 1:
						airfield.displayFleet();
						break;
					case 2:
						airfield.flyAllJets();
						break;
					case 3:
						flySpecificJet(sc, airfield);
						break;
					case 4:
						airfield.getFastestJet(airfield.getFleet());
						break;
					case 5:
						airfield.getLongestRange(airfield.getFleet());
						break;
					case 6:
						airfield.loadCargoJets(airfield);
						break;
					case 7:
						airfield.dogfight(airfield);
						break;
					case 8:
						addJetMenu(sc, airfield);
						break;
					case 9:
						removeJet(sc, airfield);
						break;
//					case 10:
//						saveToFile(sc, airfield, importFile);
//					case 11:
//						System.out.println("Thank you for using this app.  Goodbye.");
//						further = false;
//						break;
					case 10:
						System.out.println("Thank you for using this app.  Goodbye.");
						further = false;
						break;
					}
				} else {
					System.err.println("Choice must be a number 1-9");
					continue;
				}
			} catch (Exception e) {
				System.err.println("Choice must be a number 1-9");
				continue;
			}
		}
	}

	public void addJetMenu(Scanner sc, AirField airfield) {
		boolean further = true;
		while (further) {
			System.out.println("What kind of jet do you want to add? (1-4)");
			System.out.println("1. Fighter Jet");
			System.out.println("2. Cargo Jet");
			System.out.println("3. Passenger Jet");
			System.out.println("4. Generic Jet");
			int choice = sc.nextInt();
			try {
				if (choice > 0 && choice < 5) {
					switch (choice) {
					case 1:
						addFighter(sc, airfield);
						further = false;
						break;
					case 2:
						addCargo(sc, airfield);
						further = false;
						break;
					case 3:
						addPassenger(sc, airfield);
						further = false;
						break;
					case 4:
						addGeneric(sc, airfield);
						further = false;
						break;
					}
				} else {
					System.err.println("Number must be 1-4. Choose one of these options.");
					continue;
				}

			} catch (Exception e) {
				System.err.println(e);
			}
		}
		System.out.println();

	}

	public void addFighter(Scanner sc, AirField airfield) {
//		String model, double speed, int range, long price, String flyMessage
		System.out.print("MODEL: ");
		String modelTemp = sc.next().trim();
		sc.nextLine();
		System.out.print("SPEED (Mach): ");
		double speedTemp = sc.nextDouble();
		sc.nextLine();
		System.out.print("RANGE (km): ");
		int rangeTemp = sc.nextInt();
		sc.nextLine();
		System.out.print("PRICE: ");
		long priceTemp = sc.nextLong();
		sc.nextLine();
		System.out.print("Message to display when the jet is flying: ");
		String flyMessageTemp = sc.nextLine();
		FighterJet tempFighter = new FighterJet(modelTemp, speedTemp, rangeTemp, priceTemp, flyMessageTemp);
		airfield.getFleet().add(tempFighter);
	}

	public void addCargo(Scanner sc, AirField airfield) {
//		String model, double speed, int range, long price, double capacity, String flyMessage
		System.out.print("MODEL: ");
		String modelTemp = sc.next().trim();
		sc.nextLine();
		System.out.print("SPEED (Mach): ");
		double speedTemp = sc.nextDouble();
		sc.nextLine();
		System.out.print("RANGE (km): ");
		int rangeTemp = sc.nextInt();
		sc.nextLine();
		System.out.print("PRICE (USD): ");
		long priceTemp = sc.nextLong();
		sc.nextLine();
		System.out.print("CAPACITY (cubic meters): ");
		double capacityTemp = sc.nextDouble();
		sc.nextLine();
		System.out.print("Message to display when the jet is flying: ");
		String flyMessageTemp = sc.nextLine();
		CargoJet tempCargo = new CargoJet(modelTemp, speedTemp, rangeTemp, priceTemp, capacityTemp, flyMessageTemp);
		airfield.getFleet().add(tempCargo);
	}

	public void addPassenger(Scanner sc, AirField airfield) {
//		String model, double speed, int range, long price, String flyMessage
		System.out.println("MODEL: ");
		String modelTemp = sc.next().trim();
		sc.nextLine();
		System.out.print("SPEED (Mach): ");
		double speedTemp = sc.nextDouble();
		sc.nextLine();
		System.out.print("RANGE (km): ");
		int rangeTemp = sc.nextInt();
		sc.nextLine();
		System.out.print("PRICE (USD): ");
		long priceTemp = sc.nextLong();
		sc.nextLine();
		System.out.print("Message to display when the jet is flying: ");
		String flyMessageTemp = sc.nextLine();
		PassengerJet tempPassenger = new PassengerJet(modelTemp, speedTemp, rangeTemp, priceTemp, flyMessageTemp);
		airfield.getFleet().add(tempPassenger);
	}

	public void addGeneric(Scanner sc, AirField airfield) {
//		String model, double speed, int range, long price
		System.out.print("MODEL: ");
		String modelTemp = sc.next().trim();
		sc.nextLine();
		System.out.print("SPEED (Mach): ");
		double speedTemp = sc.nextDouble();
		sc.nextLine();
		System.out.print("RANGE (km): ");
		int rangeTemp = sc.nextInt();
		sc.nextLine();
		System.out.print("PRICE (USD): ");
		long priceTemp = sc.nextLong();
		sc.nextLine();
		PassengerJet tempGeneric = new PassengerJet(modelTemp, speedTemp, rangeTemp, priceTemp);
		airfield.getFleet().add(tempGeneric);
	}

	public void removeJet(Scanner sc, AirField airfield) {
		airfield.displayFleet();
		System.out.print("Choose a number for which jet you want to remove: ");
		try {
			boolean further = true;
			while (further) {
				int removal = sc.nextInt();
				if (removal > 0 && removal < airfield.getFleet().size()) {
					airfield.getFleet().remove(removal - 1);
					further = false;
				} else {
					System.out.println("Choice must be one of the numbers in the list.");
					continue;
				}
			}
		} catch (Exception e) {
			System.err.println(e);
		}

	}

	private void flySpecificJet(Scanner sc, AirField airfield) {
		airfield.displayFleet();
		System.out.print("Choose which jet you want to fly: ");
		int flyJet = sc.nextInt();
		sc.nextLine();
		try {
			boolean further = true;
			while (further) {
				if (flyJet > 0 && flyJet < airfield.getFleet().size()) {
					further = false;
					airfield.flyJet(flyJet - 1);
				} else {
					System.out.println("Choice must be one of the numbers in the list.");
					continue;
				}
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

//	public void saveToFile(Scanner sc, AirField airfield, String importFile) {
//		System.out.println("You can export the current fleet to a text file.");
//		System.out.print("Enter a new name for the exported file: ");
//		String fnInput = sc.next();
//		sc.nextLine();
//		String fileArray[] = fnInput.split(".");
//		String filename = "" + fileArray[0].toString() + ".txt";
//		boolean further = true;
//		while (further) {
//			if (!filename.equals(importFile)) {
//				further = false;
//				break;
//			}
//			else {
//				System.out.println("Export filename must be different from jets.txt");
//				continue;
//			}
//			
//		}
//		System.out.println("Exporting to " + filename);
//		FileWriter writer;
//		try {
//			writer = new FileWriter(filename);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
////		for (Jet jet : airfield.getFleet()) {
////			try {
////				writer.write(jet.getModel().toString() + "\t" + jet.getSpeed() + "\t" + jet.getRange() + "\t" + jet.getPrice() + "\t" + jet.getFlyMessage());
////			} catch (IOException e) {
////				e.printStackTrace();
////			}
////		}
//		try {
//		    FileOutputStream fos = new FileOutputStream(filename);
//		    ObjectOutputStream oos = new ObjectOutputStream(fos);   
//		    oos.writeObject(airfield.getFleet()); // write MenuArray to ObjectOutputStream
//		    oos.close(); 
//		} catch(Exception ex) {
//		    ex.printStackTrace();
//		}
////		writer.close();
//		System.out.println("File writing complete");
//		System.out.println();
//		
//	}
	
}
