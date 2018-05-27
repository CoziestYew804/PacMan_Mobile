package com.ul.game.model.elements.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.World;
import com.ul.game.model.elements.GameElement;
import com.ul.game.model.elements.MovableElement;

import java.util.List;
import java.util.Random;

public abstract class Ghost extends MovableElement {
    private Vector2 currentDirection = new Vector2(-1,0);

    public Ghost(Vector2 position, World monde) {
        super(position, monde);
    }

    @Override
    public abstract float getWidth();

    @Override
    public abstract float getHeight();

    @Override
    public abstract Texture getTexture();

    public abstract void move(float DeltaTime);

    public void randomMove(float delta){

        if(!this.isNextABlock(this.getDirection())) {
            if (!this.isNextAnIntersection(this.getDirection())) {
                getPosition().mulAdd(this.getDirection(),delta);
            } else {
                List<Vector2> temp = ((Intersection) this.getNext(this.getDirection())).getPossibilities();
                Random rand = new Random();
                //getPosition().mulAdd(this.getDirection(),delta);
                this.setPosition(this.getNext(this.getDirection()).getPosition());
                System.out.println("Nombre de choix " + temp.size());
                Vector2 directionAleatoire = temp.get(rand.nextInt(temp.size()));
                System.out.println("Direction aleatoire " + directionAleatoire);
                this.setDirection(directionAleatoire) ;
                System.out.println("Changement de direction !!! :" + this.getDirection());

            }


        }
    }

    public void bestChoiceMove(){

        if(!this.isNextABlock(this.getDirection())) {
            if (!this.isNextAnIntersection(this.getDirection())) {
                getPosition().add(this.getDirection());
            } else {
                //((Intersection) this.getNext(currentDirection)).getBestPossibilitieTo(this.getMonde().getPacman());
                getPosition().add(this.getDirection());
                this.setDirection(((Intersection)(this.getNext(this.getDirection()))).getBestPossibilitieTo(this.getMonde().getPacman()));
                System.out.println("Changement de direction !!! :" + this.getDirection());

            }


        }
    }

    public abstract Vector2 getDirection();

    public abstract void setDirection(Vector2 direction);


}
