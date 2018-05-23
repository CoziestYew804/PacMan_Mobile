package com.ul.game.model.elements.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.World;
import com.ul.game.model.elements.GameElement;
import com.ul.game.view.TextureFactory;

public class Pacman extends GameElement {
    public static final float size=16;
    private static final int SPEED = 16;
    private Vector2 velocity;
    //public static final Vector2 StartPosition = new Vector2(14 , 17);

    public Pacman(Vector2 position, World monde) {

        super(position, monde);
        velocity = new Vector2(0, 0);
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
        return TextureFactory.getInstance().getTexture(this.getClass());
    }

    /**
     * Met à jour l'affichage du déplacement du pacman
     * @param dt deltatime
     * @param directory orientation du pacman : 1 = gauche, 2 = droite, 3 = haut, 4 = bas
     */
    public void update(float dt, int directory)
    {
        velocity.add(0, SPEED);
        velocity.scl(dt);
        switch(directory)
        {
            case 1:
                this.getPosition().add(-velocity.x,0);
                break;
            case 2:
                this.getPosition().add(velocity.x,0);
                break;
            case 3:
                this.getPosition().add(0,-velocity.y);
                break;
            case 4:
                this.getPosition().add(0,velocity.y);
                break;

        }
        velocity.scl(1/dt);

    }
    
    public void changeOrientationPacman(int x, int y)
    {

        if(x >= 150 && x <= 350)
        {
            if(y >= 0 && y <= 225)
            {

                System.out.println("Le pacman va vers le haut !");
                if(this.getMonde().getMaze().get((int)this.getPosition().x-1,(int)this.getPosition().y).getClass() != Block.class) {
                    System.out.println("je bouge!");
                    this.getPosition().add(-1,0);
                }
            }

            else if (y > 225 && y <= 500)
            {
                System.out.println("Le pacman va vers le bas");
                if(this.getMonde().getMaze().get((int)this.getPosition().x+1,(int)this.getPosition().y).getClass() != Block.class) {

                    this.getPosition().add(1,0);
                }
            }
        }

        else if(x >=0 && x < 150)
        {
            System.out.println("Le pacman va vers la gauche");
            if(this.getMonde().getMaze().get((int)this.getPosition().x,(int)this.getPosition().y-1).getClass() != Block.class) {
                    System.out.println("je bouge!");
                    this.getPosition().add(0, -1);
            }
            if(x < 0)
            {
                this.setPosition(new Vector2(0,this.getPosition().y));
            }
        }

        else
        {
            System.out.println("Le pacman va à droite");
            if(this.getMonde().getMaze().get((int)this.getPosition().x,(int)this.getPosition().y+1).getClass() != Block.class) {
                this.getPosition().add(0,1);
            }
            if(x > 500)
            {
                this.setPosition(new Vector2(500, this.getPosition().y));
            }
        }

        if(this.getPosition().y < 0)
        {
            this.setPosition(new Vector2(this.getPosition().x, 0));
        }

        if(this.getPosition().y > 480)
        {
            this.setPosition(new Vector2(this.getPosition().x, 480));
        }

        if(this.getPosition().x < 0)
        {
            this.setPosition(new Vector2(0, this.getPosition().y));
        }

        if(this.getPosition().x > 431)
        {
            this.setPosition(new Vector2(431, this.getPosition().y));
        }


    }
}
