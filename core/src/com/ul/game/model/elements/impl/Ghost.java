package com.ul.game.model.elements.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.World;
import com.ul.game.model.elements.GameElement;
import com.ul.game.model.elements.MovableElement;

import java.util.List;
import java.util.Random;

public abstract class Ghost extends MovableElement {
    private Vector2 currentDirection = new Vector2(-5,0);
    int etat=0;
    public Ghost(Vector2 position, World monde) {
        super(position, monde);
    }

    public int getEtat() {
        return this.etat;
    }

    @Override
    public abstract float getWidth();

    @Override
    public abstract float getHeight();


    public abstract void move(float DeltaTime);

    public void randomMove(float delta){

        if(!this.isNextABlock(this.getDirection()) && !this.isNextAGhostDoor(this.getDirection())) {

                this.getPosition().mulAdd(this.getDirection(),delta);
            } else if (this.isAnIntersection()){
                //this.setPosition(this.getThis().getPosition());
                List<Vector2> temp = ((Intersection) this.getThis()).getPossibilities();
                Random rand = new Random();
                //getPosition().mulAdd(this.getDirection(),delta);
                //this.setPosition(this.getNext(this.getDirection()).getPosition());
               // System.out.println("Nombre de choix " + temp.size());
                Vector2 directionAleatoire = temp.get(rand.nextInt(temp.size()));
                //System.out.println("Direction aleatoire " + directionAleatoire);
                this.setDirection(directionAleatoire) ;
                //System.out.println("Changement de direction !!! :" + this.getDirection());
                //System.out.println(this.getPosition());

            }


        }
    public void bestChoiceMove(float delta){

        if(!this.isNextABlock(this.getDirection())&& !this.isNextAGhostDoor(this.getDirection())) {
                //this.getPosition().add(this.getDirection());
            this.getPosition().mulAdd(this.getDirection(),delta);
            //System.out.println("JE CONTINUE This to rouge !!! :" + this.getThis().getClass());
            //System.out.println(" JE CONTINUE Next to rouge !!! :" + this.getNext(this.getDirection()));
            //System.out.println("Je suis a cote d'un bloc ? " + this.isNextABlock(this.getDirection()));
            //System.out.println(this.getDirection()+  "this ou bien "+ this.currentDirection );
            }
            else if(this.isAnIntersection()){
                //this.setPosition(this.getThis().getPosition());
                //((Intersection) this.getNext(currentDirection)).getBestPossibilitieTo(this.getMonde().getPacman());
                //getPosition().add(this.getDirection());
                this.setDirection(((Intersection) this.getThis()).getBestPossibilitieTo(this.getMonde().getPacman()));
                //this.getPosition().add(this.getDirection());
                //System.out.println("Changement de direction rouge !!! :" + this.getDirection());
                //System.out.println("Changement position rouge !!! :" + this.getPosition());
                //System.out.println("This to rouge !!! :" + this.getThis().getClass());
                //System.out.println("Next to rouge !!! :" + this.getNext(this.getDirection()));

            }else{
            //this.setPosition(soustraire(this.getNext(currentDirection).getPosition(),currentDirection));
        }



    }


    public Vector2 getDirection(){
        return this.currentDirection;
    }

    public void setDirection(Vector2 direction){
        this.currentDirection= direction;
    }





}
