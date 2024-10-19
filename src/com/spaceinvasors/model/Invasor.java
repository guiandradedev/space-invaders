package com.spaceinvasors.model;

import com.spaceinvasors.enums.InvasorType;

public class Invasor extends Character{

	private boolean hit = false;
	private final InvasorType type;
	public Invasor(Position position, int lives, double speed_x, InvasorType type) {
		super(position, lives, speed_x);
		this.type = type;
	}
	
	public void move(double x, double y) {
		this.getPosition().setPosition(x,y);
	}
	public void shoot(Character invasor) {}
	public void takeDamage() {
		this.setHitted();
	}
	public boolean isHitted() {
		return this.hit;
	}
	public void setHitted() {
		this.hit = true;
	}
	public InvasorType getType() {
		return this.type;
	}

}
