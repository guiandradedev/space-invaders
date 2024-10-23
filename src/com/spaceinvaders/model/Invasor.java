package com.spaceinvaders.model;

import com.spaceinvaders.components.InvasorComponent;
// import com.spaceinvaders.components.InvasorDeadArt;
import com.spaceinvaders.components.PixelArt;
import com.spaceinvaders.components.PlayerArt;
import com.spaceinvaders.enums.InvasorType;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.scene.layout.Pane;

public class Invasor extends Character{
	private SoundPlayer soundExplode;
	private SoundPlayer soundHit;

	private final InvasorType type;
	public Invasor(Position position, int lives, double speed_x, InvasorType type, InvasorComponent elementArt) {
		super(position, lives, speed_x, elementArt);
		this.type = type;
		soundExplode= new SoundPlayer("src/com/spaceinvaders/assets/sounds/explode.mp3");
		soundHit= new SoundPlayer("src/com/spaceinvaders/assets/sounds/hit.mp3");
	}

	public void move(double x, double y) {
		this.getPosition().setPosition(x,y);
	}
	public void shoot(Character invasor, Pane root) {}
	public void takeDamage(Pane root) {
		soundHit.playSound();
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

	public void changeSprintWhenDie(Pane root) {
		InvasorComponent invasorComponent = this.getPixelArt();
		// root.getChildren().remove(invasorComponent);
	
		// InvasorDeadArt invasorDeadArt = new InvasorDeadArt(
		// 	(int) invasorComponent.getWidth() / invasorComponent.getPixelSize(),
		// 	(int) invasorComponent.getHeight() / invasorComponent.getPixelSize(),
		// 	(int) invasorComponent.getPixelSize()
		// );
		
		
		this.setLives(1);
		/*
		 * Gambiarra aqui
		 * 
		 * O setLives era pra ser private, no entanto ao morrer a animação so vai continuar se ele manter uma vida,
		 * ja q o delay pra remover o alien é maior que o delay do keyframe
		 * pra resolver isso deixei o setLives protected pra aumentar a vida temporariamente e retornar ao 0 quando remover da tela
		 *
		 * */

		this.getPixelArt().killInvasor();

		// setElementArt(invasorDeadArt);
		// print(root);

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				Platform.runLater(() -> {
					setLives(0);
					root.getChildren().remove(invasorComponent);
				});
			}
		}, 500);
	}
	
}
