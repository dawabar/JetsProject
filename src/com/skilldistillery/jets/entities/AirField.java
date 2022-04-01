package com.skilldistillery.jets.entities;

public class AirField {
	private List<Jet> fleet = ArrayList<>();
	
	public AirField() {}

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
	
	
}
