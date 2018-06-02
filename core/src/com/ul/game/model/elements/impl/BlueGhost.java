package com.ul.game.model.elements.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.COR.*;
import com.ul.game.model.World;
import com.ul.game.view.TextureFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.badlogic.gdx.math.MathUtils.random;

public class BlueGhost extends Ghost {
    public static final float size=16;
    private Vector2 currentDirection = new Vector2(-1,0);
    private ArrayList<Vector2> sortir = new ArrayList<Vector2>();
    private int etape=0;
    private boolean isInHouse = true;

    public BlueGhost(Vector2 position, World monde) {
        super(position, monde);
        sortir.add(UP);
        sortir.add(UP);
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

    @Override
    public Texture getTexture() {
        return TextureFactory.getInstance().getTexture(this.getClass());
    }

    public void moveOutOfHouse(){
        this.setDirection(sortir.get(etape));
        this.getPosition().add(this.getDirection());
        System.out.println(this.etape + " je suis a l'etape");
        this.etape+=1;

    }

    @Override
    public void move(float delta) {

        if(isInHouse){
            moveOutOfHouse();
        }
        else{
            randomMove(delta);
        }
        if(etape==3){
            isInHouse=false;
        }


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
