package com.spaceinvaders.model;

import com.spaceinvaders.components.InvasorComponent;
import com.spaceinvaders.components.PlayerArt;
import com.spaceinvaders.enums.InvasorType;

public class Invasor extends Character{

	private final InvasorType type;
	public Invasor(Position position, int lives, double speed_x, InvasorType type, InvasorComponent elementArt) {
		super(position, lives, speed_x, elementArt);
		this.type = type;
	}
	
	public void move(double x, double y) {
		this.getPosition().setPosition(x,y);
	}
	public void shoot(Character invasor) {}
	public void takeDamage() {
		super.takeDamage(); // remove uma vida
	}
	public InvasorType getType() {
		return this.type;
	}
	@Override
	public InvasorComponent getPixelArt() {
		return (InvasorComponent)super.getPixelArt();
	}

	public void animation(int delay) {
		
	}
	public boolean isAlive() {
		return this.getLives() != 0;
	}
}
