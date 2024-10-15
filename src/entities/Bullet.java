package entities;

public class Bullet {
	private double speed_y;
	private Position position;
	// adicionar imagem do tiro

	public Bullet(Position position, double speed_y) {
		setPosition(position);
		setSpeedY(speed_y);
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

}
