package com.spaceinvasors.model;

public abstract class Character {
	private Position position;
	private int lives;
	private double speed_x;
	// adicionar imagem do personagem

	public Character(Position position, int lives, double speed_x) {
		setPosition(position);
		setSpeedX(speed_x);
		setLives(lives);
	}
	
	public abstract void move(double x, double y);
	public abstract void shoot();
	public abstract void takeDamage();
	
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

}
