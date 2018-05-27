package com.ul.game.model.elements.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.COR.*;
import com.ul.game.model.World;
import com.ul.game.view.TextureFactory;

import java.util.List;
import java.util.Random;

import static com.badlogic.gdx.math.MathUtils.random;

public class BlueGhost extends Ghost {
    public static final float size=16;
    RandomMovingCOR movingCOR;
    private Vector2 currentDirection = new Vector2(-1,0);

    public BlueGhost(Vector2 position, World monde) {
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

        movingCOR = new MovingUp();
        RandomMovingCOR down = new MovingDown();
        RandomMovingCOR left = new MovingLeft();
        RandomMovingCOR right = new MovingRight();

        movingCOR.setSuivant(right);
        right.setSuivant(down);
        down.setSuivant(left);

        randomMove(delta);

    }

    public Vector2 getDirection() {
        return currentDirection;
    }

    public void setDirection(Vector2 direction) {

        this.currentDirection.set(direction);
    }


    /*@Override
    public void Move() {



       /* }
        else{
            this.movingCOR.randomMove(this.getMonde(),this);
        }




    }*/

    @Override
    public void changeOrientation() {

    }


}
