package com.spaceinvaders.model;

import com.spaceinvaders.components.BulletArt;
import com.spaceinvaders.components.ElementArt;

public class Bullet {
	private double speed_y;
	private Position position;
	private BulletArt bulletArt;

	public Bullet(Position position, double speed_y, BulletArt bulletArt) {
		setPosition(position);
		setSpeedY(speed_y);
		setBulletArt(bulletArt);
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public double getSpeedY() {
		return speed_y;
	}

	public void setSpeedY(double speed_y) {
		this.speed_y = speed_y;
	}
	private void setBulletArt(BulletArt element) {
		this.bulletArt = element;
	}
	

}
