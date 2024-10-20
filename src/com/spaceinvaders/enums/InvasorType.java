package com.spaceinvaders.enums;

import com.spaceinvaders.components.FastInvasor;
import com.spaceinvaders.components.InvasorComponent;
import com.spaceinvaders.components.MidInvasor;
import com.spaceinvaders.components.StrongInvasor;

public enum InvasorType {
    StrongInvasor(StrongInvasor.class, 3, 3, 1),
    MidInvasor(MidInvasor.class, 2, 3, 2), 
    FastInvasor(FastInvasor.class, 1, 3, 2);

    private final int points;
    private final Class<? extends InvasorComponent> invasorClass;

    private final int speed;
    private final int lines;

    InvasorType(Class<? extends InvasorComponent> invasorClass, int points, int speed, int lines) {
        this.invasorClass = invasorClass;
        this.points = points;
        this.speed = speed;
        this.lines = lines;
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

    public int getSpeed() {
        return this.speed;
    }
    public int getLines() {
        return this.lines;
    }
}
