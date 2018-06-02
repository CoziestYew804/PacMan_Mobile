package com.ul.game.model.elements.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.World;
import com.ul.game.view.TextureFactory;

import java.util.List;
import java.util.Random;

public class RedGhost extends Ghost {
    public static final float size=16;
    private Vector2 currentDirection = new Vector2(-1,0);

    public RedGhost(Vector2 position, World monde) {
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

        bestChoiceMove();
        /*if(!this.isNextABlock(currentDirection)) {
            if (!this.isNextAnIntersection(currentDirection)) {
                getPosition().add(currentDirection);
            } else {
                //((Intersection) this.getNext(currentDirection)).getBestPossibilitieTo(this.getMonde().getPacman());
                getPosition().add(currentDirection);
                this.setDirection(((Intersection)(this.getNext(currentDirection))).getBestPossibilitieTo(this.getMonde().getPacman()));
                System.out.println("Changement de direction !!! :" + currentDirection);

            }


        }*/

    }

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
