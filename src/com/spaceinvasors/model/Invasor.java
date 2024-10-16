package com.spaceinvasors.model;

public class Invasor extends Character{

	public Invasor(Position position, int lives, int speed_x) {
		super(position, lives, speed_x);
	}
	
	public void move(double x, double y) {
		this.getPosition().setPosition(x,y);
	}
	public void shoot() {}
	public void takeDamage() {}

}
