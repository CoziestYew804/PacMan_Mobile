package com.ul.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ul.game.model.elements.GameElement;
import com.ul.game.model.World;

public class WorldRenderer {


    private SpriteBatch spriteBatch;
    private World monde;
    private int ppuX, ppuY;

    public int getPpuX() {
        return ppuX;
    }

    public void setPpuX(int ppuX) {
        this.ppuX = ppuX;
    }

    public int getPpuY() {
        return ppuY;
    }

    public void setPpuY(int ppuY) {
        this.ppuY = ppuY;
    }

    public WorldRenderer(World monde) {
        this.monde = monde;
        this.spriteBatch = new SpriteBatch();
    }

    public void render(float delta) {
        this.spriteBatch.begin();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        for (GameElement element : this.monde) {
            System.out.println(element.getClass());
            this.spriteBatch.draw(
                    TextureFactory.getInstance().getTexture(element.getClass()),
                    element.getPosition().y * 16,
                    (30-element.getPosition().x) * 16,
                    16,
                    16
            );

        }
        this.spriteBatch.end();
        if(Gdx.input.isTouched())
        {
            this.monde.getPacman().changeOrientationPacman(Gdx.input.getX(), Gdx.input.getY());
            //float y = this.gs.getMonde().getPacman().getPosition().y;

        }
        }
    }
