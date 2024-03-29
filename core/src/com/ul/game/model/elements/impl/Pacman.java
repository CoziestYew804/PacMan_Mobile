package com.ul.game.model.elements.impl;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.controller.SoundController;
import com.ul.game.model.World;
import com.ul.game.model.elements.MovableElement;

/**
 * Le pacman, célèbre héros que l'on ne présente plus !
 */
public class Pacman extends MovableElement {
    public static final float size=16;
    private float x=-1;
    private float y=-1;
    private Vector2 currentDirection = new Vector2(-1,0);

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


    public void eat(){
        SoundController.getInstance().getEatingPelletSound().play();
    }



    @Override
    /**
     * Déplacement du pacman en prenant compte du deltatime
     */
    public void move(float delta) {
        //Si la touche LEFT a été préssée
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {
            //Si le pacman n'est pas devant un block ou la maison des fantomes
            if (!this.isNextABlock(LEFT)&&!this.isNextAGhostDoor(LEFT)){
                if(isAnIntersection()){
                    this.setPosition(new Vector2((int)this.getPosition().x,(int)this.getPosition().y));
                }
                this.setDirection(LEFT);
            }
        }
        //Si la touche RIGHT a été préssée
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            if(!this.isNextABlock(RIGHT)&&!this.isNextAGhostDoor(RIGHT)){
                if(isAnIntersection()){
                    this.setPosition(new Vector2((int)this.getPosition().x,(int)this.getPosition().y));
                }

                this.setDirection(RIGHT);
            }
        }

        //Si la touche DOWN a été préssée
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            if(!this.isNextABlock(DOWN)&&!this.isNextAGhostDoor(DOWN)){
                if(isAnIntersection()){
                    this.setPosition(new Vector2((int)this.getPosition().x,(int)this.getPosition().y));
                }
                this.setDirection(DOWN);
            }
        }

        //Si la touche UP a été préssée
        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            if(!this.isNextABlock(UP)&&!this.isNextAGhostDoor(UP)){
                if(isAnIntersection()){
                    this.setPosition(new Vector2((int)this.getPosition().x,(int)this.getPosition().y));
                }
                this.setDirection(UP);
            }
        }
        //Si l'écran a été touché
        if (Gdx.input.isTouched()) {

            this.changeOrientation(Gdx.input.getX(), Gdx.input.getY());
        }

            if (!this.isNextABlock(currentDirection) && !this.isNextAGhostDoor(currentDirection)) {
                this.getPosition().mulAdd(currentDirection, delta);

            } else if (this.isNextABlock(currentDirection)) {
                this.setPosition(soustraire(this.getNext(currentDirection).getPosition(), currentDirection));

            }
            eat();
        }



    public void eatGhost(Ghost ghost){

        this.getMonde().points=+500;

    }

    /**
     * Change la direction du pacman quand l'écran est touché
     * @param x Coordonnée x de la touche
     * @param y Coordonnée y de la touche
     */
    public void changeOrientation(int x, int y) {

            if (x >= 150 && x <= 350) {

                if (y >= 0 && y <= 225) {

                    if(!this.isNextABlock(UP)&&!this.isNextAGhostDoor(UP)){
                        if(isAnIntersection()){
                            this.setPosition(new Vector2((int)this.getPosition().x,(int)this.getPosition().y));
                        }
                        this.setDirection(UP);
                    }
                } else if (y > 225 && y <= 500) {

                    if(!this.isNextABlock(DOWN)&&!this.isNextAGhostDoor(DOWN)){
                        if(isAnIntersection()){
                            this.setPosition(new Vector2((int)this.getPosition().x,(int)this.getPosition().y));
                        }
                        this.setDirection(DOWN);
                    }
                }
            }
            else if (x >= 0 && x < 150) {

                     if (!this.isNextABlock(LEFT)&&!this.isNextAGhostDoor(LEFT)){
                         if(isAnIntersection()){
                             this.setPosition(new Vector2((int)this.getPosition().x,(int)this.getPosition().y));
                         }
                         this.setDirection(LEFT);
                     }

            } else {

                     if(!this.isNextABlock(RIGHT)&&!this.isNextAGhostDoor(RIGHT)){
                         if(isAnIntersection()){
                             this.setPosition(new Vector2((int)this.getPosition().x,(int)this.getPosition().y));
                         }

                         this.setDirection(RIGHT);
                     }
            }
        }



}
