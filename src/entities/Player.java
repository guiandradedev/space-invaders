package entities;

public class Player extends Character{
	private int points;
	private int hits;

	public Player(Position position, int lives, int speed_x, int points, int hits) {
		super(position, lives, speed_x);
		
		setPoints(points);
		setHits(hits);
	}
	
	public void move() {}
	public void shoot() {}
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
	
}
