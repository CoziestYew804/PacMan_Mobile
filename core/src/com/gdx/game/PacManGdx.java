package com.gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.gdx.game.model.Maze;
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
		Vector2 posPacman = this.gs.getMonde().getPacman().getPosition();

		if(Gdx.input.isTouched())
		{
			if(Gdx.input.getX() >= 150 && Gdx.input.getX() <= 350)
			{
				if(Gdx.input.getY() >= 0 && Gdx.input.getY() <= 225)
				{
					System.out.println("Le pacman va vers le haut !");
					this.gs.getMonde().getPacman().setPosition(new Vector2(
							posPacman.x,
							posPacman.y+35));
				}

				else if (Gdx.input.getY() > 225 && Gdx.input.getY() <= 500)
				{
					System.out.println("Le pacman va vers le bas");
					this.gs.getMonde().getPacman().setPosition(new Vector2(
							posPacman.x,
							posPacman.y-35));


					if(posPacman.y < 0)
					{
						this.gs.getMonde().getPacman().setPosition(new Vector2(
								posPacman.x,
								0));
					}
				}
			}

			else if(Gdx.input.getX() >=0 && Gdx.input.getX() < 150)
			{
				System.out.println("Le pacman va vers la gauche");
				this.gs.getMonde().getPacman().setPosition(new Vector2(
						posPacman.x-35,
						posPacman.y));


				if(posPacman.x < 0)
				{
					this.gs.getMonde().getPacman().setPosition(new Vector2(0,posPacman.y));
				}
			}

			else
			{
				System.out.println("Le pacman va à droite");

				this.gs.getMonde().getPacman().setPosition(new Vector2(
						posPacman.x+35,
						posPacman.y));

				if(posPacman.x > 500)
				{
					this.gs.getMonde().getPacman().setPosition(new Vector2(500, posPacman.y));
				}
			}


			System.out.println("X : "+ this.gs.getMonde().getPacman().getPosition().x+
								" ; Y : "+ this.gs.getMonde().getPacman().getPosition().y);



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
