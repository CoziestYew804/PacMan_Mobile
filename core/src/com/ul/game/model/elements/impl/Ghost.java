package com.ul.game.model.elements.impl;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.controller.SoundController;
import com.ul.game.model.World;
import com.ul.game.model.elements.GameElement;
import com.ul.game.model.elements.MovableElement;

import java.util.List;
import java.util.Random;

public abstract class Ghost extends MovableElement {
    private Vector2 currentDirection = new Vector2(-5,0);
    int etat=0;
    float timerScared=0;
    boolean isFrightened=false;
    protected boolean changed=false;
    //public  Vector2 StartingPos;
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

    public abstract  Vector2 getStartingPos();

    public abstract void setStartingPos(Vector2 startingPos);

    public void isAfraid() {this.etat = 1;
    this.isFrightened=true;}

    /**
     * Colisions avec le Pacman
     */
    public void resolveCollisionPacman(){
        if(this.getExactPosition().equals(this.getMonde().getPacman().getExactPosition())){
            //Si le fantôme est effrayé
            if(isFrightened){
                this.getMonde().getPacman().eatGhost(this);
                this.etat=2;
                SoundController.getInstance().getEatingGhostSound().play();
            //S'il est normal
            }else{
                this.getMonde().setGameOver(true);
                SoundController.getInstance().getDeadPacmanSound().play();
            }
        }
    }

    public abstract void move(float DeltaTime);

    /**
     * Mouvement aléatoire (concerne le fantôme bleu et le fantôme rose
     * @param delta
     */
    public void randomMove(float delta){
        teleport();
        //Si le fantôme est sur une intersection
        if (this.isAnIntersection()){
            //Si le fantôme n'a pas changé de direction
            if(!changed) {
                this.setPosition(new Vector2((int) this.getPosition().x, (int) this.getPosition().y));
                List<Vector2> temp = ((Intersection) this.getThis()).getPossibilities();
                Random rand = new Random();
                //On choisit une nouvelle dirction
                Vector2 directionAleatoire = temp.get(rand.nextInt(temp.size()));
                this.setDirection(directionAleatoire);
                this.getPosition().mulAdd(this.getDirection(), delta);
                changed=true;
            }

            this.getPosition().mulAdd(this.getDirection(), delta);

        }
        //Si le fantome n'est pas devant un block
        else if (!this.isNextABlock(this.getDirection()) && !this.isNextAGhostDoor(this.getDirection())) {

            this.getPosition().mulAdd(this.getDirection(), delta);
            changed=false;
        }



        }
    public void bestChoiceMove(float delta){
        teleport();
        if(this.isAnIntersection()) {
            if (!changed) {
                this.setPosition(new Vector2((int) this.getPosition().x, (int) this.getPosition().y));
                Vector2 bestChoice = ((Intersection) this.getThis()).getBestPossibilitieTo(this.getMonde().getPacman());
                this.setDirection(bestChoice);
                changed=true;
            }
            this.getPosition().mulAdd(this.getDirection(), delta);
        }else if(!this.isNextABlock(this.getDirection())&& !this.isNextAGhostDoor(this.getDirection())) {

            this.getPosition().mulAdd(this.getDirection(),delta);
            changed=false;

            }



    }

    public void runAway(float delta){
        teleport();
        if(timerScared<=1000){
            if (this.isAnIntersection()) {
                if (!changed) {
                    this.setPosition(new Vector2((int) this.getPosition().x, (int) this.getPosition().y));
                    Vector2 bestChoice = ((Intersection) this.getThis()).getBestPossibilitieToRunAway(this.getMonde().getPacman());
                    this.setDirection(bestChoice);
                    changed = true;
                }
                this.getPosition().mulAdd(this.getDirection(), delta);
            } else if (!this.isNextABlock(this.getDirection()) && !this.isNextAGhostDoor(this.getDirection())) {

                this.getPosition().mulAdd(this.getDirection(), delta);
                changed = false;

            }
        }

        timerScared=timerScared+0.5f;
        if(timerScared>1000){timerScared=0;etat=0;isFrightened=false;this.setPosition(new Vector2((int) this.getPosition().x, (int) this.getPosition().y));}
    }

    public void getBackToHouse(float delta){
        teleport();
        if(this.isAnIntersection()) {
            if (!changed) {
                this.setPosition(new Vector2((int) this.getPosition().x, (int) this.getPosition().y));
                Vector2 bestChoice = ((Intersection) this.getThis()).getBestPossibilitieTo(this.getStartingPos());
                this.setDirection(bestChoice);
                changed=true;
            }
            this.getPosition().mulAdd(this.getDirection(), delta);
        }else if(!this.isNextABlock(this.getDirection())&& !this.isNextAGhostDoor(this.getDirection())) {

            this.getPosition().mulAdd(this.getDirection(),delta);
            changed=false;

        }
    }



    public Vector2 getDirection(){
        return this.currentDirection;
    }

    public void setDirection(Vector2 direction){
        this.currentDirection= direction;
    }

    /**
     * Téléportation
     */
    public void teleport() {
        if (this.getPosition().y <= 0) {
            this.setPosition(new Vector2(this.getExactPosition().x, this.getMonde().getMaze().getWidth() - 1));
        }
        if (this.getPosition().y >= this.getMonde().getMaze().getWidth() - 1) {
            this.setPosition(new Vector2(this.getExactPosition().x, 0));
        }
    }





}
