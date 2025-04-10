package com.spaceinvaders.model;

public class Intersection {
    private final Position min;
    private final Position max;

    public Intersection(Position min, Position max) {
        this.min = min;
        this.max = max;
    }

    public boolean hasIntersection(){
        return this.getMin().getX() < this.getMax().getX() && this.getMin().getY() < this.getMax().getY();
    }

    public Position getMin() {
        return this.min;
    }
    public Position getMax() {
        return this.max;
    }
    public double getMidPointX(){
        return (this.min.getX() + this.max.getX())/2;
    }
    public double getMidPointY(){
        return (this.min.getY() + this.max.getY())/2;
    }
}
