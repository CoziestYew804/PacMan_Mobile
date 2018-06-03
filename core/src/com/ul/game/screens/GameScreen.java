package com.ul.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.PacManGdx;
import com.ul.game.model.World;
import com.ul.game.model.elements.GameElement;
import com.ul.game.model.elements.impl.*;
import com.ul.game.view.TextureFactory;
import com.ul.game.view.WorldRenderer;

public class GameScreen implements Screen {
    private World monde;
    private WorldRenderer renderer;
    private SpriteBatch batch;
    private int score=0;
    private Game game;

    public GameScreen(Game game) {

        this.game = game;
        monde = new World();
        renderer = new WorldRenderer(monde);
        TextureFactory.reset(this.monde);


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
        this.analyzePosition();
        if(this.monde.isGameOver()){
            this.game.setScreen(new GameOverScreen(this.game, this));
        }
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

    public int getScore()
    {
        return score;
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public void analyzePosition()
    {
        Vector2 currentPosition = this.monde.getPacman().getPosition();
        System.out.println(currentPosition.y);

        if(currentPosition.y <= 0)
            this.monde.getPacman().setPosition(new Vector2(this.monde.getPacman().getPosition().x, this.monde.getMaze().getWidth()-1));
        if(currentPosition.y >= this.monde.getMaze().getWidth()-1)
            this.monde.getPacman().setPosition(new Vector2(this.monde.getPacman().getPosition().x, 0));
        //Test pour les pellets
        int x = (int) currentPosition.x;
        int y = (int) currentPosition.y;
        GameElement element = this.monde.getMaze().get(x, y);

        if(this.monde.getPacman().isNextAGhost(this.monde.getPacman().getDirection()))
        {
            System.out.println("WESH");
        }




        if(element != null)
        {
            if (element instanceof Pellet){
                //this.getMonde().getMaze().eatPellet(y, x);
                score++;
            }

            if(element instanceof SuperPellet)
            {

                this.monde.getYellowGhost().isAfraid();
                this.monde.getBlueGhost().isAfraid();
                this.monde.getRedGhost().isAfraid();
                this.monde.getPinkGhost().isAfraid();
                score += 3;
            }

            if(element instanceof Intersection)
            {

            }
        }


    }
}
