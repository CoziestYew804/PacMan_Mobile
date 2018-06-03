package com.ul.game.model.elements.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.World;
import com.ul.game.view.TextureFactory;

import java.util.ArrayList;
import java.util.Random;

public class PinkGhost extends Ghost {
    public static final float size=16;
    private Vector2 currentDirection = new Vector2(-1,0);
    private ArrayList<Vector2> sortir = new ArrayList<Vector2>();
    private int etape=0;
    private boolean isInHouse = true;
    public PinkGhost(Vector2 position, World monde) {
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
            int randomNum = 1 + (int)(Math.random() * ((2 - 1) + 1));
            if(randomNum==1) randomMove(delta);
            if(randomNum==2) bestChoiceMove(delta);
        }else if(etat==1){
            runAway(delta);
        }



    }



    @Override
    public void changeOrientation() {

    }
}
