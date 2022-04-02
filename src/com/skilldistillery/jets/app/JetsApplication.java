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

		ja.readFromFile("jets.txt", aircraft);
		for (Jet jet : aircraft) {
			System.out.println("Model: " + jet.getModel());
			System.out.println("Speed (Mach): " + jet.getSpeed());
			System.out.println("Range (km): " + jet.getRange());
			System.out.println("Price (USD): " + jet.getPrice());
		};

	}

	public void readFromFile(String fn, List<Jet> jetsList) {
		try {
			BufferedReader bufIn = new BufferedReader(new FileReader(fn));
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] split = line.split("\t");
				String aircraftType = split[0];
				String model = split[1];
				double speed = Double.parseDouble(split[2]);
				int range = Integer.parseInt(split[3]);
				long price = (long)Integer.parseInt(split[4]);
				String flyMessage = split[5];
				System.out.println("TYPE: " + split[0] + "\tMODEL: " + split[1] + "\tSPEED: " + split[2]
						+ "\tRANGE: " + split[3] + "\tPRICE: " + split[4] + "\tMESSAGE: " + split[5]);
//				switch (aircraftType) {
//				case "FighterJet":
//					jetsList.add(new FighterJet(model, speed, range, price, flyMessage));
//					break;
//				case "CargoJet":
//					jetsList.add(new CargoJet(model, speed, range, price, flyMessage));
//					break;
//				case "PassengerJet":
//					jetsList.add(new PassengerJet(model, speed, range, price, flyMessage));
//					break;
//				default:
//					jetsList.add(new PassengerJet(model, speed, range, price));
//					break;
//				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
