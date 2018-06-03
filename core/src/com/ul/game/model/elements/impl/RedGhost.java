package com.ul.game.model.elements.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.ul.game.model.World;
import com.ul.game.view.TextureFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RedGhost extends Ghost {
    public static final float size=16;
    private boolean isInHouse=true;
    private ArrayList<Vector2> sortir = new ArrayList<Vector2>();
    private Vector2 currentDirection;
    private int etape=0;

    public RedGhost(Vector2 position, World monde) {
        super(position, monde);
        sortir.add(UP);
        sortir.add(RIGHT);
        sortir.add(UP);
    }
    @Override
    public float getWidth() {
        return size;
    }

    @Override
    public float getHeight() {
        return size;
    }


    public void moveOutOfHouse(){
            this.setDirection(sortir.get(etape));
            this.getPosition().add(this.getDirection());
            this.etape+=1;

    }

    @Override
    public void move(float delta) {
        
        if(isInHouse){
            moveOutOfHouse();
            if(etape==3){
                isInHouse=false;
            }
        }
        else if(etat==0){
            bestChoiceMove(delta);
        }else if(etat==1){
            runAway(delta);
        }
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

    /*public Vector2 getDirection() {
        return this.currentDirection;
    }

    public void setDirection(Vector2 direction) {

        this.currentDirection = direction;
    }*/


    @Override
    public void changeOrientation() {

    }
}
