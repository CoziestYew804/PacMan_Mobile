package com.ul.game.model.elements;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.World;
import com.ul.game.model.elements.impl.Barriere;
import com.ul.game.model.elements.impl.Block;

/**
 * Element du jeu
 */
public abstract class GameElement {
    private Vector2 position;
    private World monde;

    protected GameElement(Vector2 position, World monde) {
        this.position = position;
        this.monde=monde;
    }

    public World getMonde(){
        return this.monde;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getExactPosition() {return new Vector2((int)this.position.x,(int)this.position.y);}

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public abstract float getWidth();

    public abstract float getHeight();


    public GameElement getThis (){

        return this.getMonde().getMaze().get((int)(this.getPosition().x),(int)(this.getPosition().y));
    }


    public GameElement getNext (Vector2 currentDirection){

        return this.getMonde().getMaze().get((int)(this.getPosition().x+currentDirection.x),(int)(this.getPosition().y+currentDirection.y));
    }

    /**
     * Vérifie si l'élement est devant un block
     * @param currentDirection Direction de l'élément
     * @return Si l'element est devant un block
     */
    public boolean isNextABlock (Vector2 currentDirection){

        return this.getNext(currentDirection) instanceof Block;
    }

    /**
     * Vérifie si l'élement est devant la porte des fantômes
     * @param currentDirection Direction de l'élément
     * @return Si l'element est devant la porte des fantomes
     */
    public boolean isNextAGhostDoor (Vector2 currentDirection){

        return this.getNext(currentDirection) instanceof Barriere;
    }


}
