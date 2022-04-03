package com.skilldistillery.jets.entities;

public class FighterJet extends Jet {
	
	private String model;
	private double speed;
	private int range;
	private long price;
	private String flyMessage = "";
	
	public FighterJet() {
		super();
	}

	public FighterJet(String model, double speed, int range, long price, String flyMessage) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
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
	
	public void fight() {
		String[] actions = {" dives from the clouds to fire on its enemy.", " locks on its target to fire its missiles.", " hits the brakes as the enemy flies right by.", " barrel rolls to dodge enemy fire.", " fires its main guns to attack!", " climbs to the skies to hide above the clouds.", " pulls a high-G turn to evade attack.", " destroys an enemy fighter to notch another victory!"};
		int action = (int)(Math.random() * actions.length);
		System.out.println("The " + this.model + actions[action]);
	}
	
}
