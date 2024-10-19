package com.spaceinvaders.model;

import com.spaceinvaders.components.ElementArt;

import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public abstract class Character extends Element{
	private int lives;
	private double speed_x;

	public Character(Position position, int lives, double speed_x, ElementArt elementArt) {
		super(position, elementArt);
		setSpeedX(speed_x);
		setLives(lives);
	}
	
	public abstract void move(double x, double y);
	public abstract void shoot(Character invasor);
	public abstract void takeDamage();

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		// alterar pra remover vidas
		this.lives = lives;
	}

	public double getSpeedX() {
		return speed_x;
	}

	public void setSpeedX(double speed_x) {
		this.speed_x = speed_x;
	}

}
