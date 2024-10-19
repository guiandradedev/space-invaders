package com.spaceinvasors.model;

public class Invasor extends Character{

	private boolean hit = false;
	private final String type;
	public Invasor(Position position, int lives, double speed_x, String type) {
		super(position, lives, speed_x);
		this.type = type;
	}
	
	public void move(double x, double y) {
		this.getPosition().setPosition(x,y);
	}
	public void shoot(Character invasor) {}
	public void takeDamage() {}
	public boolean isHitted() {
		return this.hit;
	}
	public void setHitted() {
		this.hit = true;
	}

}
