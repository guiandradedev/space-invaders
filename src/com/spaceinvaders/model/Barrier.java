package com.spaceinvaders.model;

import com.spaceinvaders.components.BarrierArt;

import javafx.scene.layout.Pane;

public class Barrier extends Element{
    public Barrier(Position position, BarrierArt barrierArt) {
		super(position, barrierArt);
	}

	@Override
	public BarrierArt getPixelArt() {
		return (BarrierArt)super.getPixelArt();
	}

	public void takeDamage(Intersection intersection) {
		this.getPixelArt().repaint(intersection);
	}
}
