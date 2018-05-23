package com.ul.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.view.TextureFactory;

import static com.badlogic.gdx.math.MathUtils.random;

public class BlueGhost extends Ghost {
    public static final float size=16;

    public BlueGhost(Vector2 position, World monde) {
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

    @Override
    public void Move() {
        int temp = random.nextInt(4 - 1 + 1) + 1;
        switch(temp){
            case  1:
                this.setPosition(new Vector2(
                        this.getPosition().x,
                        this.getPosition().y+1));
                        break;
            case  2:
                this.setPosition(new Vector2(
                        this.getPosition().x,
                        this.getPosition().y-1));
                break;
            case  3:
                this.setPosition(new Vector2(
                        this.getPosition().x+1,
                        this.getPosition().y));
                break;
            case  4:
                this.setPosition(new Vector2(
                        this.getPosition().x-1,
                        this.getPosition().y));
                break;
        }


    }


}
