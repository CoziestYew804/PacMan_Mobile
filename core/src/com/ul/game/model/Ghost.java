package com.ul.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class Ghost extends GameElement {

    public Ghost(Vector2 position, World monde) {
        super(position, monde);
    }

    @Override
    public abstract float getWidth();

    @Override
    public abstract float getHeight();

    @Override
    public abstract Texture getTexture();

    public abstract void Move();
}
