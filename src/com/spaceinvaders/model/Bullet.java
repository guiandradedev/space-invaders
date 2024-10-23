package com.spaceinvaders.model;

import com.spaceinvaders.components.BulletArt;
import com.spaceinvaders.components.ElementArt;
import com.spaceinvaders.components.PlayerArt;

import javafx.scene.layout.Pane;

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
	@Override
	public BulletArt getPixelArt() {
		return (BulletArt)super.getPixelArt();
	}

	@Override
	public void print(Pane root) {
		this.getPixelArt().printArt(this.getPosition());
		root.getChildren().add(this.getPixelArt());
	}
	public void print(Pane root, Character element) {
		this.getPixelArt().printArt(this.getPosition(), element);
		root.getChildren().add(this.getPixelArt());
	}
}
