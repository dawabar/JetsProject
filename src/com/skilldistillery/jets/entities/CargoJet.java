package com.skilldistillery.jets.entities;

public class CargoJet extends Jet {

	private String model;
	private double speed;
	private int range;
	private long price;
	private String flyMessage;

	public CargoJet() {
		super();
	}

	public CargoJet(String model, double speed, int range, long price, String flyMessage) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
		this.flyMessage = flyMessage;
	}

	public String getFlyMessage() {
		return flyMessage;
	}

	public void setFlyMessage(String flyMessage) {
		this.flyMessage = flyMessage;
	}

	
}
