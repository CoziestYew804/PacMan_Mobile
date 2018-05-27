package com.ul.game.model.elements;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.World;

public abstract class MovableElement extends GameElement{

    public static final int  LEFT = 1;
    public static final int  RIGHT = 2;
    public static final int  UP = 3;
    public static final int  DOWN = 4;

    

    public int currentDirection;

    //protected MovableElement(Vector2 position, World monde, int currentDirection) {
    protected MovableElement(Vector2 position, World monde) {
        super(position, monde);
        //this.currentDirection = currentDirection;
    }

    @Override
    public float getWidth() {
        return 0;
    }

    @Override
    public float getHeight() {
        return 0;
    }

    @Override
    public Texture getTexture() {
        return null;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(int direction) {
        if(this.getPosition().x % 1 == 0 && this.getPosition().y % 1 == 0)
        {
            this.currentDirection = direction;
        }

    }
    public GameElement getNext (float x , float y){

        return this.getMonde().getMaze().get((int)(this.getPosition().x+x),(int)(this.getPosition().y+y));
    }
}
