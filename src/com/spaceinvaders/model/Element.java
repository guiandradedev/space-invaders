package com.spaceinvaders.model;

import com.spaceinvaders.components.ElementArt;
import com.spaceinvaders.components.MovableArt;
import com.spaceinvaders.components.PixelArt;

import javafx.scene.layout.Pane;

public abstract class Element {
    private Position position;
	private MovableArt elementArt;

    public Element(Position position, MovableArt elementArt) {
        setPosition(position);
		setElementArt(elementArt);
    }
    	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public PixelArt getPixelArt() {
		return this.elementArt;
	}
	
	public void print(Pane root) {
		elementArt.printArt(this.getPosition());
		root.getChildren().add(this.getPixelArt());
	}
	private void setElementArt(MovableArt element) {
		this.elementArt = element;
	}
}