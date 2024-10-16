package com.spaceinvasors.components;

import com.spaceinvasors.model.Character;

public abstract class InvasorComponent extends PixelArt{
    public InvasorComponent(int width, int height, int pixelSize, Character character) {
        super(width, height, pixelSize, character);
    }

}
