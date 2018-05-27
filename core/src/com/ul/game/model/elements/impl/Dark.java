package com.ul.game.model.elements.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.World;
import com.ul.game.model.elements.GameElement;
import com.ul.game.view.TextureFactory;

public class Dark extends GameElement {
    public static final float size=48;
    private boolean hasGom = true;

    public Dark(Vector2 position, World monde) {
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

        if(hasGom){return TextureFactory.getInstance().getTexture(Gom.class);}
        return TextureFactory.getInstance().getTexture(this.getClass());
    }

    public boolean hasGom() {
        return hasGom;
    }

    public void setHasGom(boolean hasGom) {
        this.hasGom = hasGom;
    }
}
