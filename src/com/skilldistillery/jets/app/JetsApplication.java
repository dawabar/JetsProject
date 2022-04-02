package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import com.skilldistillery.jets.entities.*;

public class JetsApplication {

	public static void main(String[] args) {

		JetsApplication ja = new JetsApplication();

		List<Jet> aircraft = new ArrayList<>();
		AirField airfield = new AirField();
		
		ja.readFromFile("jets.txt", aircraft, airfield);

		for (Jet jet : airfield.getFleet()) {
			System.out.println("AFLT Model: " + jet.getModel());
			System.out.println("AFLT Speed (Mach): " + jet.getSpeed());
			System.out.println("AFLT Range (km): " + jet.getRange());
			System.out.println("AFLT Price (USD): " + jet.getPrice());
		}
		
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
//				TODO: Remove the below test line
//				System.out.println("TYPE: " + split[0] + "\tMODEL: " + split[1] + "\tSPEED: " + split[2]
//						+ "\tRANGE: " + split[3] + "\tPRICE: " + split[4] + "\tMESSAGE: " + split[5]);
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

}
