package com.ul.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.PacManGdx;
import com.ul.game.model.elements.GameElement;
import com.ul.game.view.TextureFactory;
import com.badlogic.gdx.Game;

public class GameOverScreen implements Screen {
    private Texture gameOverLogo;
    private SpriteBatch spriteBatch;
    private Game game;
    private GameScreen gs;

    public GameOverScreen(Game game, GameScreen gs){
        this.gs = gs;
        gameOverLogo = new Texture("core/assets/gameover_04.jpg");
        spriteBatch= new SpriteBatch();
        this.game=game;

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        this.spriteBatch.begin();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        BitmapFont font = new BitmapFont();
        font.draw(this.spriteBatch, "Score: " + this.gs.getScore(), 80, 100);
        this.spriteBatch.draw(gameOverLogo,
                70,
                110,
                300,
                300
        );
        this.spriteBatch.end();


        if (Gdx.input.isTouched()) {
            //game.setScreen(new HomeScreen(game));
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
