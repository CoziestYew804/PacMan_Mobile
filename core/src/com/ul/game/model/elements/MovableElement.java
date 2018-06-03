package com.ul.game.model.elements;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.World;
import com.ul.game.model.elements.impl.Barriere;
import com.ul.game.model.elements.impl.Block;
import com.ul.game.model.elements.impl.Ghost;
import com.ul.game.model.elements.impl.Intersection;

public abstract class MovableElement extends GameElement{

    public static final Vector2  LEFT =  new Vector2(0,-1);
    public static final Vector2  RIGHT = new Vector2(0,+1);
    public static final Vector2  UP = new Vector2(-1,0);
    public static final Vector2  DOWN = new Vector2(+1,0);



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

    public Vector2 soustraire(Vector2 v, Vector2 v2){
        return new Vector2(v.x-v2.x,v.y-v2.y);
    }

    public abstract void move(float DeltaTime);

    public Vector2 getUP(){
        return UP;
    }

    public Vector2 getDOWN(){
        return DOWN;
    }

    public Vector2 getLEFT(){
        return LEFT;
    }

    public Vector2 getRIGHT(){
        return RIGHT;
    }


    public void changeOrientation(){};



    public boolean isNextAnIntersection (Vector2 currentDirection){

        return this.getNext(currentDirection).getClass()==Intersection.class;
    }

    public boolean isAnIntersection ()
    {
        return this.getThis() instanceof Intersection;
    }





}
