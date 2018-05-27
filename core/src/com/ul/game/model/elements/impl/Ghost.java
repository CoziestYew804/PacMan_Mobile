package com.ul.game.model.elements.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.World;
import com.ul.game.model.elements.GameElement;
import com.ul.game.model.elements.MovableElement;

public abstract class Ghost extends MovableElement {

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
