package com.ul.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.view.TextureFactory;

public class RoseGhost extends Ghost {
    public static final float size=16;
    public RoseGhost(Vector2 position, World monde) {
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

    }
}
