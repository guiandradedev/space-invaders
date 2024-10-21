package com.spaceinvaders.components.barriers;

import com.spaceinvaders.components.StaticArt;
import com.spaceinvaders.model.Position;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public abstract class BarrierArt extends StaticArt{
    public BarrierArt(int width, int height, int pixelSize) {
        super(width, height, pixelSize);
    }

    private Color[][] pixels = new Color[24][24];

    public void print(Position position, Pane root) {
        this.setLayoutX(position.getX());
        this.setLayoutY(position.getY());

        root.getChildren().add(this);
    }
}
