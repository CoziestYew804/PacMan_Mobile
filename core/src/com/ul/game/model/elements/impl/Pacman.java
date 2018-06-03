package com.ul.game.model.elements.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.World;
import com.ul.game.model.elements.GameElement;
import com.ul.game.model.elements.MovableElement;
import com.ul.game.view.TextureFactory;
import com.ul.game.view.TexturePacman;

public class Pacman extends MovableElement {
    public static final float size=16;
    //private static final float SPEED = 2* Gdx.graphics.getDeltaTime();
    private static final float SPEED = 2 * Gdx.graphics.getDeltaTime();

    // c'est temporaire
    //private Vector2 direction;
    private float x=-1;
    private float y=-1;
    private Vector2 currentDirection = new Vector2(-1,0);
    private Vector2 newDirection =new Vector2(-1,0);
    //private TexturePacman texturePacman =new TexturePacman(this);
    // faudra enlever le x et y je penserais a comment faire
    //private Vector2 velocity;
    //public static final Vector2 StartPosition = new Vector2(14 , 17);

    public Pacman(Vector2 position, World monde) {

        super(position, monde);
    }

    @Override
    public float getWidth() {
        return size;
    }

    @Override
    public float getHeight() {
        return size;
    }

    public Vector2 getDirection() {
        return currentDirection;
    }

    public void setDirection(Vector2 direction) {

        this.currentDirection.set(direction);
    }

    /*public GameElement getNext (float x , float y){

        return this.getMonde().getMaze().get((int)(this.getPosition().x+x),(int)(this.getPosition().y+y));
    }*/



    public void eat(){
        if(getThis() instanceof Pellet)
            if(((Pellet)(getThis())).hasGom()) ((Dark)(getThis())).setHasGom(false);
    }



    @Override
    public void move(float delta) {
        if(Gdx.input.isTouched()) {

            changeOrientation(Gdx.input.getX(),Gdx.input.getY());
        }

        if(!this.isNextABlock(currentDirection)&&!this.isNextAGhostDoor(currentDirection)) {
            this.getPosition().mulAdd(currentDirection,delta);
        }
        else if(this.isNextABlock(currentDirection)){
                this.setPosition(soustraire(this.getNext(currentDirection).getPosition(), currentDirection));


        }
        eat();
    }

    /**
     * Met à jour l'affichage du déplacement du pacman
     * @param dt deltatime
     */
    public void update(float dt)
    {


    }

    public void changeOrientation(int x, int y) {
        /*if (Gdx.input.isTouched()) {

            int x=Gdx.input.getX();
            int y=Gdx.input.getY();

            float next = SPEED c;

            if (x >= 150 && x <= 350) {
                if (y >= 0 && y <= 225) {

                    System.out.println("Le pacman va vers le haut !");


                    if (this.getMonde().getMaze().get((int) (this.getPosition().x - 0.5), (int) this.getPosition().y).getClass() != Block.class) {
                        System.out.println("je bouge!");
                        this.getPosition().add(-0.5f, 0);
                        this.getPosition().add(-0.5f, 0);
                    }

                } else if (y > 225 && y <= 500) {
                    System.out.println("Le pacman va vers le bas");
                    if (this.getMonde().getMaze().get((int) (this.getPosition().x + next + 1), (int) this.getPosition().y).getClass() != Block.class) {

                        this.getPosition().add(next, 0);
                        this.getPosition().add(1 - next, 0);
                    }
                }
            } else if (x >= 0 && x < 150) {
                System.out.println("Le pacman va vers la gauche");
                if (this.getMonde().getMaze().get((int) this.getPosition().x, (int) (this.getPosition().y - next)).getClass() != Block.class) {
                    System.out.println("je bouge!");
                    this.getPosition().add(0, -next);
                    this.getPosition().add(0, -(1 - next));
                }
                if (x < 0) {
                    this.setPosition(new Vector2(0, this.getPosition().y));
                }
            } else {
                System.out.println("Le pacman va à droite");
                if (this.getMonde().getMaze().get((int) this.getPosition().x, (int) (this.getPosition().y + next + 1)).getClass() != Block.class) {
                    this.getPosition().add(0, next);
                    this.getPosition().add(0, 1 - next);
                }
                if (x > 500) {
                    this.setPosition(new Vector2(500, this.getPosition().y));
                }
            }

            if (this.getPosition().y < 0) {
                this.setPosition(new Vector2(this.getPosition().x, 0));
            }

            if (this.getPosition().y > 480) {
                this.setPosition(new Vector2(this.getPosition().x, 480));
            }

            if (this.getPosition().x < 0) {
                this.setPosition(new Vector2(0, this.getPosition().y));
            }

            if (this.getPosition().x > 431) {
                this.setPosition(new Vector2(431, this.getPosition().y));
            }


        }*/


        /*if(Gdx.input.justTouched()) {
            this.x = Gdx.input.getX();
            this.y = Gdx.input.getY();
        }
            if (x >= 150 && x <= 350) {

                if (y >= 0 && y <= 225) {

                    if(this.getNext(-1*SPEED,0).getClass() != Block.class){
                        System.out.println("Le pacman va vers le haut !");
                        this.getPosition().add(-1*SPEED, 0);
                    }

                } else if (y > 225 && y <= 500) {

                    if(this.getNext(1*SPEED+1,0).getClass() != Block.class){
                        System.out.println("Le pacman va vers le bas");
                        this.getPosition().add(1*SPEED, 0);
                    }
                    else {
                        this.getPosition().set(this.getNext(1*SPEED+1,0).getPosition());
                        this.getPosition().add(-1,0);
                    }
                }
            }
            else if (x >= 0 && x < 150) {


                     if(this.getNext(0,-1*SPEED).getClass() != Block.class){
                        System.out.println("Le pacman va vers la gauche");
                        this.getPosition().add(0, -1*SPEED);
                     }

            } else {

                     if(this.getNext(0,1*SPEED+1).getClass() != Block.class){
                         System.out.println("Le pacman va à droite");
                         this.getPosition().add(0, 1*SPEED);

                     }
                     else {
                         this.getPosition().set(this.getNext(0,1*SPEED+1).getPosition());
                         this.getPosition().add(0,-1);
                     }
            }
        }*/

        //System.out.println(currentDirection);




            if (x >= 150 && x <= 350) {

                if (y >= 0 && y <= 225) {

                    if(!this.isNextABlock(UP)){
                        this.setDirection(UP);
                        //this.newDirection=UP;
                    }
                } else if (y > 225 && y <= 500) {

                    if(!this.isNextABlock(DOWN)){
                        this.setDirection(DOWN);
                        //this.newDirection=DOWN;
                    }
                }
            }
            else if (x >= 0 && x < 150) {

                     if (!this.isNextABlock(LEFT)){
                         this.setDirection(LEFT);
                         //this.newDirection=LEFT;
                     }

            } else {

                     if(!this.isNextABlock(RIGHT)){
                         this.setDirection(RIGHT);
                         //this.newDirection=RIGHT;
                     }
            }
/*
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            if(!this.isNextABlock(UP)){
                this.setDirection(UP);
            }
        }

        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
        {
            if(!this.isNextABlock(DOWN)){
                this.setDirection(DOWN);
            }
        }

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {
            if(!this.isNextABlock(LEFT)){
                this.setDirection(LEFT);
            }
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        {
            if(!this.isNextABlock(RIGHT)){
                this.setDirection(RIGHT);
            }
        }*/
        }



}
