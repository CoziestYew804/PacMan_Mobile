package com.ul.game.model.elements.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.IA.Flood;
import com.ul.game.model.World;
import com.ul.game.view.TextureFactory;

import java.util.ArrayList;

/**
 * Fantôme jaune (plus court chemin avec parcours en largeur)
 */
public class YellowGhost extends Ghost {
    private Vector2 currentDirection = new Vector2(-1, 0);
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
    public Vector2 getStartingPos() {
        return null;
    }

    @Override
    public void setStartingPos(Vector2 startingPos) {

    }


    @Override
    public void move(float DeltaTime) {

        if(isInHouse){
            moveOutOfHouse();
        }
        else
        {
            Pacman pac = this.getMonde().getPacman();
            Flood f = new Flood(this.getMonde());
            GridPoint2 currGP = new GridPoint2((int)this.getPosition().x,(int)this.getPosition().y);
            GridPoint2 gpPac = new GridPoint2((int)pac.getPosition().x, (int)pac.getPosition().y);
            //this.setDirection(f.getDirection(currGP, gpPac));

        }

        if(etape==3){
            isInHouse=false;
        }

    }
    public void moveOutOfHouse(){
        this.setDirection(sortir.get(etape));
        this.getPosition().add(this.getDirection());
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
