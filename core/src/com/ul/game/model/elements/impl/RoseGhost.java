package com.ul.game.model.elements.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.World;
import com.ul.game.view.TextureFactory;

import java.util.Random;

public class RoseGhost extends Ghost {
    public static final float size=16;
    private Vector2 currentDirection;
    public RoseGhost(Vector2 position, World monde) {
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

    @Override
    public void move(float delta) {

        int randomNum = 1 + (int)(Math.random() * ((2 - 1) + 1));

        switch (randomNum){
            case 1:
                    randomMove(delta);
            case 2:
                    bestChoiceMove();
            default:
                break;
        }

    }

    public Vector2 getDirection() {
        return currentDirection;
    }

    public void setDirection(Vector2 direction) {

        this.currentDirection.set(direction);
    }


    @Override
    public void changeOrientation() {

    }
}
