package com.spaceinvaders.model;

import com.spaceinvaders.components.InvasorComponent;
import com.spaceinvaders.components.InvasorDeadArt;
import com.spaceinvaders.components.PixelArt;
import com.spaceinvaders.components.PlayerArt;
import com.spaceinvaders.enums.InvasorType;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.scene.layout.Pane;

public class Invasor extends Character{

	private final InvasorType type;
	public Invasor(Position position, int lives, double speed_x, InvasorType type, InvasorComponent elementArt) {
		super(position, lives, speed_x, elementArt);
		this.type = type;
	}

	public void move(double x, double y) {
		this.getPosition().setPosition(x,y);
	}
	public void shoot(Character invasor, Pane root) {}
	public void takeDamage(Pane root) {
		super.takeDamage(root); // remove uma vida
	}
	public InvasorType getType() {
		return this.type;
	}
	@Override
	public InvasorComponent getPixelArt() {
		return (InvasorComponent)super.getPixelArt();
	}

	public void animation(int delay) {
		
	}
	public boolean isAlive() {
		return this.getLives() != 0;
	}

	public void changeSprintWhenDie(Pane root){
		InvasorComponent invasorComponent = this.getPixelArt();
		root.getChildren().remove(invasorComponent);

		InvasorDeadArt invasorDeadArt = new InvasorDeadArt((int)invasorComponent.getWidth() / invasorComponent.getPixelSize(), (int)invasorComponent.getHeight() / invasorComponent.getPixelSize(), (int)invasorComponent.getPixelSize());
		invasorDeadArt.print(getPosition(), root);
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				Platform.runLater(() -> {
					root.getChildren().remove(invasorDeadArt);
				});
			}
		}, 500);
	}
}
