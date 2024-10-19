package com.spaceinvasors.model;

public class Player extends Character{
	private int points;
	private int hits;
	private boolean isShooting = false;

	public Player(Position position, int lives, double speed_x, int points, int hits) {
		super(position, lives, speed_x);
		
		setPoints(points);
		setHits(hits);
	}
	
	public void move(double x, double y) {
		this.getPosition().setPosition(x,y);
	}
	public void shoot(Character character) {
		if(character instanceof Invasor) {
			Invasor invasor = (Invasor) character; // Fazendo o casting

			invasor.setHitted();
			addPoints(invasor.getType().getPoints());
		} else {
			throw new IllegalArgumentException("Parametro inválido");
		}
	}
	public void takeDamage() {}

	public int getPoints() {
		return points;
	}
	private void setPoints(int points) {
		this.points = points;
	}

	public int getHits() {
		return hits;
	}

	private void setHits(int hits) {
		this.hits = hits;
	}

	public void addPoints(int points) {
		setPoints(this.getPoints() + points);
	}
	public void addHits(int hits) {
		setHits(this.getHits() + hits);
	}
	public void addHit() {
		setHits(this.getHits() + 1);
	}
	
}
