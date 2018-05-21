package com.gdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.gdx.game.view.TextureFactory;

public class Pacman extends GameElement{
    public static final float size=16;

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

    @Override
    public Texture getTexture() {
        return TextureFactory.getInstance().getTexture(this.getClass());
    }

    public void update(float dt)
    {

    }
    
    public void changeOrientationPacman(int x, int y)
    {
        if(x >= 150 && x <= 350)
        {
            if(y >= 0 && y <= 225)
            {
                System.out.println("Le pacman va vers le haut !");
                this.setPosition(new Vector2(this.getPosition().x, this.getPosition().y+1));
            }

            else if (y > 225 && y <= 500)
            {
                System.out.println("Le pacman va vers le bas");
                this.setPosition(new Vector2(this.getPosition().x, this.getPosition().y-1));
            }
        }

        else if(x >=0 && x < 150)
        {
            System.out.println("Le pacman va vers la gauche");
            this.setPosition(new Vector2(this.getPosition().x-1, this.getPosition().y));


            if(x < 0)
            {
                this.setPosition(new Vector2(0,this.getPosition().y));
            }
        }

        else
        {
            System.out.println("Le pacman va à droite");

            this.setPosition(new Vector2(this.getPosition().x+1, this.getPosition().y));

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
