package com.ul.game.model.elements.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.World;
import com.ul.game.view.TextureFactory;

import java.util.ArrayList;

public class YellowGhost extends Ghost {
    private Vector2 currentDirection;

    public static final float size=16;
    private ArrayList<Vector2> sortir = new ArrayList<Vector2>();
    private int etape=0;
    private boolean isInHouse = true;

    public YellowGhost(Vector2 position, World monde) {
        super(position, monde);
        sortir.add(UP);
        sortir.add(LEFT);
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
    public void move(float DeltaTime) {

        if(isInHouse){
            moveOutOfHouse();
        }

        if(etape==3){
            isInHouse=false;
        }

    }
    public void moveOutOfHouse(){
        this.setDirection(sortir.get(etape));
        this.getPosition().add(this.getDirection());
        System.out.println(this.etape + " je suis a l'etape");
        this.etape+=1;

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
