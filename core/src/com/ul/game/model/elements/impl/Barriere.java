package com.ul.game.model.elements.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.World;
import com.ul.game.model.elements.GameElement;
import com.ul.game.view.TextureFactory;

public class Barriere extends GameElement {
    public static final float size=48;

    public Barriere(Vector2 position, World monde) {
        super(position, monde);
    }

    @Override
    public float getWidth() {
        return size;
    }

    @Override
    public float getHeight() {
        return size;
    }

    @Override
    public Texture getTexture() {
        return TextureFactory.getInstance().getTexture(this.getClass());
    }
}