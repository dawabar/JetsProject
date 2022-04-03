package com.skilldistillery.jets.entities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

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
			int jetLoc = fleet.indexOf(tempJet);
			System.out.println(jetLoc + 1 + ". MODEL: " + tempJet.getModel() + "\tSPEED (Mach): " + tempJet.getSpeed()
					+ "\tRANGE (km): " + tempJet.getRange() + "\tPRICE: " + tempJet.getPrice());
		}
		System.out.println();
	}

	public void flyAllJets() {
		System.out.println("It's a busy day at the airport!");
		System.out.println("All of the jets are on the runway, ready to take off!");
		System.out.println();
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

	public void getFastestJet(List<Jet> fleet) {
		int longestRangeIndex = 0;
		ListIterator<Jet> li = fleet.listIterator();
		while (li.hasNext()) {
			if (li.next().getSpeed() > fleet.get(longestRangeIndex).getSpeed()) {
				longestRangeIndex = li.nextIndex();
			}
		}
		System.out.println("Fastest Jet: " + fleet.get(longestRangeIndex).getModel() + "\tSPEED (Mach): "
				+ fleet.get(longestRangeIndex).getSpeed());
		System.out.println();
	}

	public void getLongestRange(List<Jet> fleet) {
		int longestRangeIndex = 0;
		ListIterator<Jet> li = fleet.listIterator();
		while (li.hasNext()) {
			if (li.next().getRange() > fleet.get(longestRangeIndex).getRange()) {
				longestRangeIndex = li.nextIndex();
			}
		}
		System.out.println("Longest Range: " + fleet.get(longestRangeIndex).getModel() + "\tRANGE (km): "
				+ fleet.get(longestRangeIndex).getRange());
		System.out.println();
	}

	public void loadCargoJets(AirField airfield) {
		System.out.println("Air freight is the fastest method of intermodal logistics transportation!");
		System.out.println("It's a busy and important day for the cargo carriers at the airport!");
		System.out.println();
		Jet cargoClass = new CargoJet();
		List<Jet> tempList = new LinkedList<Jet>(airfield.getFleet());
		for (Jet jet : tempList) {
			if (jet.getClass().equals(cargoClass.getClass())) {
				((CargoJet) jet).loadCargo();
			} else {
				continue;
			}
		}
		System.out.println();
	}

	public void dogfight(AirField airfield) {
		System.out.println("Oh no! Air combat has started, and the fighter jets scramble to dominate the skies!");
		System.out.println("Against a backdrop of cumulonimbus clouds and a blue sky, the fighters engage each other.");
		System.out.println();
		Jet fighterClass = new FighterJet();
		List<Jet> tempList = new LinkedList<Jet>(airfield.getFleet());
		for (Jet jet : tempList) {
			if (jet.getClass().equals(fighterClass.getClass())) {
				((FighterJet) jet).fight();
			} else {
				continue;
			}
		}
		System.out.println();
	}

	public void flyJet(int jetChoice) {
		Jet tempJet = getFleet().get(jetChoice);
		if (!tempJet.getFlyMessage().equals("")) {
			System.out.println(tempJet.getModel() + ": " + tempJet.getFlyMessage());
		} else {
			System.out.println(tempJet.getModel() + " is soaring through the skies at Mach " + tempJet.getSpeed());
		}
		System.out.println();
	}

}
