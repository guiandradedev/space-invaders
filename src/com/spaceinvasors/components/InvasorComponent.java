package com.spaceinvasors.components;

import com.spaceinvasors.model.Character;
import com.spaceinvasors.model.Invasor;

public abstract class InvasorComponent extends ElementArt{
    public InvasorComponent(int width, int height, int pixelSize, Character character) {
        super(width, height, pixelSize, character);
    }

    @Override
    public Invasor getCharacter(){
        return (Invasor)super.getCharacter();
    }

}
