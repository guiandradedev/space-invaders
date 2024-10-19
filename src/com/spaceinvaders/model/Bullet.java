package com.spaceinvaders.model;

import com.spaceinvaders.components.BulletArt;
import com.spaceinvaders.components.ElementArt;

public class Bullet extends Element{
	private double speed_y;
	private BulletArt bulletArt;

	public Bullet(Position position, double speed_y, BulletArt bulletArt) {
		super(position, bulletArt);
		setSpeedY(speed_y);
		setBulletArt(bulletArt);
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
