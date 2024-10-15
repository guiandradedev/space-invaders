package entities;

public class Position {
	private double x;
	private double y;
	
	public Position(double x, double y) {
		setPosition(x, y);
	}

	public void setPosition(double x,double y){
		this.x = x;
		this.y = y;
	}

}
