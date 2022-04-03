package com.skilldistillery.jets.entities;

public class CargoJet extends Jet implements CargoCarrier {

	private String model;
	private double speed;
	private int range;
	private long price;
	private double capacity;
	private String flyMessage = "";

	public CargoJet() {
		super();
	}

	public CargoJet(String model, double speed, int range, long price, double capacity, String flyMessage) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
		this.capacity = capacity;
		this.flyMessage = flyMessage;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getFlyMessage() {
		return flyMessage;
	}

	public void setFlyMessage(String flyMessage) {
		this.flyMessage = flyMessage;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public void loadCargo() {
		System.out.println("The " + this.getModel() + " loads its frieght to its full " + this.getCapacity() + " cubic meters.  Time to deliver the goods!");
	}

}
