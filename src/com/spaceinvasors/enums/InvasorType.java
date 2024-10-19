package com.spaceinvasors.enums;

public enum InvasorType {
    StrongInvasor(3),
    MidInvasor(2), 
    FastInvasor(1);

    private final int points;

    InvasorType(int points) {
        this.points = points;
    }

    public int getPoints() {
        return this.points;
    }

    public static InvasorType fromValue(String value) {
        try {
            return InvasorType.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invader errado: " + value);
        }
        // invasorType.getSimpleName()
    }
}