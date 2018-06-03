package com.ul.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ul.game.controller.SoundController;
import com.ul.game.model.elements.GameElement;
import com.ul.game.model.World;

public class WorldRenderer {


    private SpriteBatch spriteBatch;
    private TextureFactory texture;
    private World monde;
    private int ppuX, ppuY;
    private float delta = 0.1f;
    private float delta2 = Gdx.graphics.getDeltaTime()*60;
    int k= 0;

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

        if(!this.monde.isGameOver()) {
            this.spriteBatch.begin();
            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            for (GameElement element : this.monde) {

                this.spriteBatch.draw(
                        this.texture.getInstance(this.monde).getTexture(element.getClass(), delta),
                        element.getPosition().y * 16,
                        (30 - element.getPosition().x) * 16,
                        16,
                        16
                );

            }
            this.spriteBatch.draw(
                    this.texture.getInstance(this.monde).getTexture(this.monde.getBlueGhost().getClass(), delta),
                    this.monde.getBlueGhost().getPosition().y * 16,
                    (30 - this.monde.getBlueGhost().getPosition().x) * 16,
                    16,
                    16
            );
            this.spriteBatch.draw(
                    this.texture.getInstance(this.monde).getTexture(this.monde.getRedGhost().getClass(), delta),
                    this.monde.getRedGhost().getPosition().y * 16,
                    (30 - this.monde.getRedGhost().getPosition().x) * 16,
                    16,
                    16
            );
            this.spriteBatch.draw(
                    this.texture.getInstance(this.monde).getTexture(this.monde.getPinkGhost().getClass(), delta),
                    this.monde.getPinkGhost().getPosition().y * 16,
                    (30 - this.monde.getPinkGhost().getPosition().x) * 16,
                    16,
                    16
            );
            this.spriteBatch.draw(
                    this.texture.getInstance(this.monde).getTexture(this.monde.getYellowGhost().getClass(), delta),
                    this.monde.getYellowGhost().getPosition().y * 16,
                    (30 - this.monde.getYellowGhost().getPosition().x) * 16,
                    16,
                    16
            );
            this.spriteBatch.end();

            moveThem(this.delta);

        }

    }

    public void moveThem(float delta){


            this.monde.getPacman().move(delta);
            if(k>0){
                this.monde.getBlueGhost().move(delta);
            }
            if(k>50){
                this.monde.getRedGhost().move(delta);
            }
            if(k>100){
                this.monde.getPinkGhost().move(delta);
            }
            if(k>150){
                this.monde.getYellowGhost().move(delta);
            }
            k++;




    }
}

