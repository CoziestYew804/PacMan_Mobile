package com.gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.gdx.game.model.Maze;
import com.gdx.game.model.Pacman;
import com.gdx.game.screens.GameScreen;

public class PacManGdx extends ApplicationAdapter {
	SpriteBatch batch;
	Texture block;
	Texture pacGomme;
	Texture pacPower;
	Texture dark;
	Maze wut;
	GameScreen gs;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		block = new Texture("core/assets/bloc.png");
		pacGomme = new Texture("core/assets/pellet.png");
		pacPower = new Texture("core/assets/superpellet.png");
		dark = new Texture("core/assets/dark.png");
		//wut = new Maze(block, pacGomme, pacPower, dark);
		wut = new Maze();
		gs = new GameScreen();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		wut.drawMaze(batch);
		batch.begin();
			batch.draw(this.gs.getMonde().getPacman().getTexture(),
						this.gs.getMonde().getPacman().getPosition().x,
						this.gs.getMonde().getPacman().getPosition().y);
		batch.end();


				//Vector2 posPacman = this.gs.getMonde().getPacman().getPosition();

		if(Gdx.input.isTouched())
		{
			this.gs.getMonde().getPacman().changeOrientationPacman(Gdx.input.getX(), Gdx.input.getY());
			//float y = this.gs.getMonde().getPacman().getPosition().y;



			batch.begin();
				batch.draw(
						this.gs.getMonde().getPacman().getTexture(),
						this.gs.getMonde().getPacman().getPosition().x,
						this.gs.getMonde().getPacman().getPosition().y
				);
			batch.end();
			System.out.println("X : " + this.gs.getMonde().getPacman().getPosition().x + " Y : " + + this.gs.getMonde().getPacman().getPosition().y);

			if(this.gs.getMonde().getPacman().getPosition().x == 431 && this.gs.getMonde().getPacman().getPosition().y == 255)
			{
				this.gs.getMonde().getPacman().setPosition(new Vector2(0, this.gs.getMonde().getPacman().getPosition().y));
			}

			if(this.gs.getMonde().getPacman().getPosition().x == 0 && this.gs.getMonde().getPacman().getPosition().y == 255)
			{
				this.gs.getMonde().getPacman().setPosition(new Vector2(431, this.gs.getMonde().getPacman().getPosition().y));
			}
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		block.dispose();
		pacGomme.dispose();
		pacPower.dispose();
		dark.dispose();
	}
}
