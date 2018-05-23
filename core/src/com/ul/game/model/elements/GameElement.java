package com.ul.game.model.elements;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.World;

public abstract class GameElement {
    private Vector2 position;
    private World monde;

    protected GameElement(Vector2 position, World monde) {
        this.position = position;
        this.monde=monde;
    }

    public World getMonde(){
        return this.monde;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public abstract float getWidth();

    public abstract float getHeight();

    public abstract Texture getTexture();
}
