package com.spaceinvaders.enums;

import com.spaceinvaders.components.FastInvasor;
import com.spaceinvaders.components.InvasorComponent;
import com.spaceinvaders.components.MidInvasor;
import com.spaceinvaders.components.StrongInvasor;
import com.spaceinvaders.model.Invasor;
import com.spaceinvaders.model.Position;

public enum InvasorType {
    StrongInvasor(StrongInvasor.class, 3, 20, 15, 10),
    MidInvasor(MidInvasor.class, 2, 15, 15, 10), 
    FastInvasor(FastInvasor.class, 1, 15, 15, 10);

    private final int points;
    private final Class<? extends InvasorComponent> invasorClass;

    private final int width;
    private final int height;
    private final int speed;

    InvasorType(Class<? extends InvasorComponent> invasorClass, int points, int width, int height, int speed) {
        this.invasorClass = invasorClass;
        this.points = points;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    public int getPoints() {
        return this.points;
    }

    public static InvasorType fromValue(String value) {
        try {
            return InvasorType.valueOf(value); // Não precisa de toUpperCase aqui, já que os nomes estão corretos
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invasor inválido: " + value);
        }
    }

    public InvasorComponent createInvasorArt(int width, int height, int pixelSize) {
        try {
            return invasorClass.getDeclaredConstructor(int.class, int.class, int.class).newInstance(width, height, pixelSize);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Elemento de arte inválido");
        }
    }

    public int getWidth() {
        return this.width;
    }
    public int getHeight() {
        return this.height;
    }

    public int getSpeed() {
        return this.speed;
    }
}
