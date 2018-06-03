package com.ul.game.model.elements.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.World;
import com.ul.game.model.elements.GameElement;
import com.ul.game.model.elements.impl.Dark;
import com.ul.game.view.TextureFactory;

import java.util.*;

public class Intersection extends Dark {
    public static final float size=48;
    List<Vector2> possibleDirection = new ArrayList<Vector2>(){

        {
            add( new Vector2(0,-1));
            add( new Vector2(0,+1));
            add( new Vector2(-1,0));
            add( new Vector2(+1,0));
        }
    };



    public Intersection(Vector2 position, World monde) {
        super(position, monde);
    }

    public List<Vector2> getPossibilities(){
        List<Vector2> possibilites = new ArrayList<Vector2>();
        for (Vector2 direction: possibleDirection) {
            if(!this.isNextABlock(direction)&&!this.isNextAGhostDoor(direction)){
                    possibilites.add(direction);
            }
        }

        return possibilites;
    }
    public Vector2 getBestPossibilitieTo(GameElement element){
        Vector2 temp=new Vector2(0,0);
        Vector2 cible;
        Vector2 maPosition;
        for (Vector2 direction: possibleDirection) {
            if(!this.isNextABlock(direction)&&!this.isNextAGhostDoor(direction)){
               temp=direction;
            }
        }
        for (Vector2 direction: possibleDirection) {
            cible=new Vector2(element.getExactPosition());
            maPosition=new Vector2(this.getExactPosition());
            if(!this.isNextABlock(direction)&&!this.isNextAGhostDoor(direction)&&!this.isNextABlock(temp)&&!this.isNextAGhostDoor(temp)){
                /*    if(cible.dst(maPosition.add(temp)) >= cible.dst(maPosition.add(direction))){
                        temp=direction;
                }*/
                if(getDistance(cible,maPosition.add(temp)) > getDistance(cible,maPosition.add(direction))){
                    temp=direction;
                }

            }
        }

        return temp;
    }

    public Vector2 getBestPossibilitieTo(Vector2 vector){
        Vector2 temp=new Vector2(0,0);
        Vector2 cible;
        Vector2 maPosition;
        for (Vector2 direction: possibleDirection) {
            if(!this.isNextABlock(direction)&&!this.isNextAGhostDoor(direction)){
                temp=direction;
            }
        }
        for (Vector2 direction: possibleDirection) {
            cible=new Vector2(vector);
            maPosition=new Vector2(this.getExactPosition());
            if(!this.isNextABlock(direction)&&!this.isNextAGhostDoor(direction)&&!this.isNextABlock(temp)&&!this.isNextAGhostDoor(temp)){
                /*if(cible.dst(maPosition.add(temp)) >= cible.dst(maPosition.add(direction))){
                    temp=direction;
                }*/
                if(getDistance(cible,maPosition.add(temp)) > getDistance(cible,maPosition.add(direction))){
                    temp=direction;
                }

            }
        }

        return temp;
    }

    public Vector2 getBestPossibilitieToRunAway(GameElement element){
        Vector2 temp=new Vector2(0,0);
        Vector2 cible;
        Vector2 maPosition;
        for (Vector2 direction: possibleDirection) {
            if(!this.isNextABlock(direction)&&!this.isNextAGhostDoor(direction)){
                temp=direction;
            }
        }
        for (Vector2 direction: possibleDirection) {
            cible=new Vector2(element.getExactPosition());
            maPosition=new Vector2(this.getExactPosition());
            if(!this.isNextABlock(direction)&&!this.isNextAGhostDoor(direction)&&!this.isNextABlock(temp)&&!this.isNextAGhostDoor(temp)){
                /*f(cible.dst(maPosition.add(temp)) <= cible.dst(maPosition.add(direction))){
                    temp=direction;
                }*/
                if(getDistance(cible,maPosition.add(temp)) < getDistance(cible,maPosition.add(direction))){
                    temp=direction;
                }
            }
        }

        return temp;
    }

    public double getDistance(Vector2 position1, Vector2 position2) {
        double diffX = position1.x - position2.x;
        double diffY = position1.y - position2.y;
        return Math.sqrt((diffX * diffX) + (diffY * diffY));
    }

    @Override
    public float getWidth() {
        return size;
    }

    @Override
    public float getHeight() {
        return size;
    }

}