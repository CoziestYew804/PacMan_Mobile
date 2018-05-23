package com.ul.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ul.game.PacManGdx;
import com.ul.game.model.World;
import com.ul.game.view.WorldRenderer;

public class GameScreen implements Screen {
    private World monde;
    private WorldRenderer renderer;
    private SpriteBatch batch;

    public GameScreen(PacManGdx game) {

        monde = new World();
        renderer = new WorldRenderer(monde);


    }

    public World getMonde() {
        return monde;
    }

    @Override
    public void show() {

        batch = new SpriteBatch();

    }

    @Override
    public void render(float delta) {
        this.renderer.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        this.renderer.setPpuX((int)(width/(float)this.monde.getWidth()));
        this.renderer.setPpuY((int)(height/(float)this.monde.getHeight()));
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
