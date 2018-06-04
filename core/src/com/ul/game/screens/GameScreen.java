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

    /**
     * Ecran de jeu
     * @param game Partie
     */
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

    /**
     * Analyse la position actuelle du pacman et éxécute une méthode en fonction de lélément sur lequel le pacman est
     */
    public void analyzePosition()
    {
        Vector2 currentPosition = this.monde.getPacman().getPosition();

        //Telepoortation
        if(currentPosition.y <= 0)
            this.monde.getPacman().setPosition(new Vector2(this.monde.getPacman().getPosition().x, this.monde.getMaze().getWidth()-1));
        if(currentPosition.y >= this.monde.getMaze().getWidth()-1)
            this.monde.getPacman().setPosition(new Vector2(this.monde.getPacman().getPosition().x, 0));
        //Test pour les pellets
        int x = (int) currentPosition.x;
        int y = (int) currentPosition.y;
        GameElement element = this.monde.getMaze().get(x, y);


        if(element != null)
        {
            //Si l'élément est sur un pellet
            if (element instanceof Pellet){
                this.getMonde().getMaze().eatPellet(y, x);
                score++;
            }
            //Si le pacman est sur une intersection avec pellet
            if (element instanceof IntersectionWithPellet){
                this.getMonde().getMaze().eatPelletIntersection(y, x);
                score++;
            }
            //Si le pacman est sur un super pellet
            if(element instanceof SuperPellet)
            {

                this.monde.getYellowGhost().isAfraid();
                this.monde.getBlueGhost().isAfraid();
                this.monde.getRedGhost().isAfraid();
                this.monde.getPinkGhost().isAfraid();
                this.getMonde().getMaze().eatSuperPellet(y,x);
                score += 3;
            }
            // Si le pacman est sur une intersection
            if(element instanceof IntersectionWithSuperPellet)
            {

                this.monde.getYellowGhost().isAfraid();
                this.monde.getBlueGhost().isAfraid();
                this.monde.getRedGhost().isAfraid();
                this.monde.getPinkGhost().isAfraid();
                this.getMonde().getMaze().eatSuperPelletIntersection(y,x);
                score += 3;
            }

        }


    }
}
