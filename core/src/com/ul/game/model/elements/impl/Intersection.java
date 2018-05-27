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
            if(!this.isNextABlock(direction)){
                if(!this.isNextAGhostDoor(direction)) {
                    possibilites.add(direction);
                }
            }
        }

        return possibilites;
    }
    public Vector2 getBestPossibilitieTo(GameElement element){
        Vector2 temp =new Vector2(0,0);
        for (Vector2 direction: possibleDirection) {
            if(!this.isNextABlock(direction)){
                    if(element.getPosition().dst(this.getPosition().add(temp)) > element.getPosition().dst(this.getPosition().add(direction))){
                        temp=direction;
                }

            }
        }

        return temp;
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
        return TextureFactory.getInstance().getTexture(Dark.class);
    }
}