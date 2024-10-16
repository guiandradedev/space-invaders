package com.spaceinvasors.model;

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
	public double getX(){
		return this.x;
	}
	public double getY(){
		return this.y;
	}
	public void setX(){
		this.x = x;
	}
	public void setY(){
		this.y = y;
	}

}
