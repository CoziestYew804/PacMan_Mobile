package com.ul.game.model.elements.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.IA.Flood;
import com.ul.game.model.World;
import com.ul.game.view.TextureFactory;

public class YellowGhost extends Ghost {
    private Vector2 currentDirection;

    public static final float size=16;

    public YellowGhost(Vector2 position, World monde) {
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
    public void move(float DeltaTime) {

        Flood f = new Flood();
        switch(f.getDirection(this.currentDirection, getMonde().getPacman().getDirection()))
        {
            case 0:
                this.setDirection(new Vector2(this.getDirection().x, this.getDirection().y+1));
                break;
            case 1:
                this.setDirection(new Vector2(this.currentDirection.x+1, this.currentDirection.y));
        }


    }

    @Override
    public void start(float deltatime) {
        this.currentDirection.set(UP);
        this.move(deltatime);
        this.currentDirection.set(RIGHT);
        this.move(deltatime);
        this.currentDirection.set(UP);
        this.move(deltatime);
        this.currentDirection.set(UP);
        this.move(deltatime);
        isOut = true;
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
