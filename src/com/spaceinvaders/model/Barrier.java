package com.spaceinvaders.model;

import com.spaceinvaders.components.BarrierArt;

import javafx.scene.layout.Pane;

public class Barrier extends Element{
	private SoundPlayer sound;

    public Barrier(Position position, BarrierArt barrierArt) {
		super(position, barrierArt);
		sound = new SoundPlayer("/sounds/explode.mp3");
	}

	@Override
	public BarrierArt getPixelArt() {
		return (BarrierArt)super.getPixelArt();
	}

	public void playSound(){
		sound.playSound();
	}

	public void takeDamage(Intersection intersection) {
		this.playSound();
		this.getPixelArt().repaint(intersection);
	}
}
