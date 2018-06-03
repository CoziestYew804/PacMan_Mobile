package com.ul.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.PacManGdx;
import com.ul.game.controller.SoundController;
import com.ul.game.model.World;
import com.ul.game.model.elements.GameElement;
import com.ul.game.model.elements.MovableElement;
import com.ul.game.model.elements.impl.*;
import com.ul.game.view.TextureFactory;

import java.util.ArrayList;
import java.util.List;

public class HomeScreen implements Screen {

    private SpriteBatch spriteBatch;
    private Game game;
    private Pacman pacman;
    private BlueGhost blue;
    private YellowGhost yellow;
    private RedGhost red;
    private PinkGhost rose;
    private List<MovableElement> elements = new ArrayList<MovableElement>(){};
    private Texture logo;
    private World monde;

    public HomeScreen(Game game){

        this.monde = new World();
         this.game = game;
         this.spriteBatch = new SpriteBatch();
         this.pacman= new Pacman(new Vector2(200,200), this.monde);
         this.monde.getPacman().setDirection(MovableElement.LEFT);
         this.rose= new PinkGhost(new Vector2(350,200), this.monde);
         this.blue= new BlueGhost(new Vector2(250,200), this.monde);
         this.yellow= new YellowGhost(new Vector2(400,200), this.monde);
         this.red= new RedGhost(new Vector2(300,200), this.monde);
         logo = new Texture("core/assets/logo.png");


         this.elements.add(pacman);
         this.elements.add(rose);
         this.elements.add(yellow);
         this.elements.add(blue);
         this.elements.add(red);
        SoundController.getInstance().getBeginningMusic().play();


    }
    @Override
    public void show() {

    }

    @Override
    public void render(float deltaTime) {

        this.spriteBatch.begin();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.spriteBatch.draw(logo,
                80,
                280,
                300,
                200
        );
        for (GameElement element : elements) {
            //System.out.println(element.getClass());

            this.spriteBatch.draw(
                    TextureFactory.getInstance( this.monde).getTexture(element.getClass(), 0.1f),
                    //element.getTexture(),
                    element.getPosition().x ,
                    ( element.getPosition().y) ,
                    20,
                    20
            );

            element.getPosition().add(-1.5f,0);
            if(element.getPosition().x<-500) element.setPosition(new Vector2(500,200));

        }
        this.spriteBatch.end();




        if ((Gdx.input.isTouched()) || (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) ){

            this.spriteBatch.dispose();
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
