package com.ul.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ul.game.PacManGdx;
import com.ul.game.model.elements.GameElement;
import com.ul.game.model.elements.impl.*;
import com.ul.game.view.TextureFactory;

public class HomeScreen implements Screen {

    private SpriteBatch spriteBatch;
    private PacManGdx game;

    public HomeScreen(PacManGdx game){

         this.game = game;
         this.spriteBatch = new SpriteBatch();
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float deltaTime) {

        this.spriteBatch.begin();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            this.spriteBatch.draw(
                    TextureFactory.getInstance().getTexture(Pacman.class),
                    200,
                    200
            );
        this.spriteBatch.draw(
                TextureFactory.getInstance().getTexture(BlueGhost.class),
                350,
                200
        );
        this.spriteBatch.draw(
                TextureFactory.getInstance().getTexture(RedGhost.class),
                250,
                200
        );
        this.spriteBatch.draw(
                TextureFactory.getInstance().getTexture(YellowGhost.class),
                300,
                200
        );
        this.spriteBatch.draw(
                TextureFactory.getInstance().getTexture(RoseGhost.class),
                400,
                200
        );
        this.spriteBatch.end();







        if (Gdx.input.isTouched()) {

            GameScreen screen = new GameScreen(game);
            game.setScreen(screen);
            //float y = this.gs.getMonde().getPacman().getPosition().y;

        }
    }



    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
