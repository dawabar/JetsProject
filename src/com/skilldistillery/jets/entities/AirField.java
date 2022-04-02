package com.skilldistillery.jets.entities;

import java.util.ArrayList;
import java.util.List;

public class AirField {
	private List<Jet> fleet = new ArrayList<>();

	public AirField() {
	}

	public AirField(List<Jet> fleet) {
		super();
		this.fleet = fleet;
	}

	public List<Jet> getFleet() {
		return fleet;
	}

	public void setFleet(List<Jet> fleet) {
		this.fleet = fleet;
	};

	public void displayFleet() {
		for (Jet jet : fleet) {
			Jet tempJet = jet;
			System.out.println("MODEL: " + tempJet.getModel() + "\tSPEED (Mach): " + tempJet.getSpeed()
					+ "\tRANGE (km): " + tempJet.getRange() + "\tPRICE: " + tempJet.getPrice());
		}
		System.out.println();
	}
	
	public void flyAllJets() {
		for (Jet jet : fleet) {
			Jet tempJet = jet;
			if (!tempJet.getFlyMessage().equals("")) {
				System.out.println(tempJet.getModel() + ": " + tempJet.getFlyMessage());
			} else {
				System.out.println(tempJet.getModel() + " is soaring through the skies at Mach " + tempJet.getSpeed());
			}
			
		}
		System.out.println();
	}
}
