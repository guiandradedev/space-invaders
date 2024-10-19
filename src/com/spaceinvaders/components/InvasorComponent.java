package com.spaceinvaders.components;

import com.spaceinvaders.model.Character;
import com.spaceinvaders.model.Invasor;

public abstract class InvasorComponent extends ElementArt{
    public InvasorComponent(int width, int height, int pixelSize) {
        super(width, height, pixelSize);
    }

    // @Override
    // public Invasor getCharacter(){
    //     return (Invasor)super.getCharacter();
    // }

}
