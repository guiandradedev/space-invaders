package com.spaceinvaders.model;

public class Position {
	private double x;
	private double y;
	
	public Position(double x, double y) {
		setPosition(x, y);
	}

	public void setPosition(double x,double y){
		setX(x);
		setY(y);
	}
	public double getX(){
		return this.x;
	}
	public double getY(){
		return this.y;
	}
	public void setX(double x){
		this.x = x;
	}
	public void setY(double y){
		this.y = y;
	}

}
