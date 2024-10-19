package com.spaceinvaders.model;

import com.spaceinvaders.components.ElementArt;

import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public abstract class Character {
	private Position position;
	private int lives;
	private double speed_x;
	private ElementArt elementArt;

	public Character(Position position, int lives, double speed_x, ElementArt elementArt) {
		setPosition(position);
		setSpeedX(speed_x);
		setLives(lives);
		setElementArt(elementArt);
	}
	
	public abstract void move(double x, double y);
	public abstract void shoot(Character invasor);
	public abstract void takeDamage();

	public void print(Pane root) {
		elementArt.printArt(this.getPosition());
        root.getChildren().add(this.getElementArt());
	}

	private void setElementArt(ElementArt element) {
		this.elementArt = element;
	}
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

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

	public ElementArt getElementArt() {
		return this.elementArt;
	}

}
