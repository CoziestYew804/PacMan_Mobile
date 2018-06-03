package com.ul.game;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.ul.game.screens.GameScreen;
import com.ul.game.screens.HomeScreen;

public class PacManGdx extends Game implements ApplicationListener {

	@Override
	public void create() {
		setScreen(new HomeScreen(this));
	}



	/*SpriteBatch batch;
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
						this.gs.getMonde().getPacman().getPosition().x*16,
					(30-this.gs.getMonde().getPacman().getPosition().y)*16);
		batch.end();


				//Vector2 posPacman = this.gs.getMonde().getPacman().getPosition();

		if(Gdx.input.isTouched())
		{
			this.gs.getMonde().getPacman().changeOrientationPacman(Gdx.input.getX(), Gdx.input.getY());
			//float y = this.gs.getMonde().getPacman().getPosition().y;



			batch.begin();
			batch.draw(this.gs.getMonde().getPacman().getTexture(),
					this.gs.getMonde().getPacman().getPosition().x*16,
					(30-this.gs.getMonde().getPacman().getPosition().y)*16);
			batch.end();
		}
	}


	@Override
	public void dispose () {
		batch.dispose();
		block.dispose();
		pacGomme.dispose();
		pacPower.dispose();
		dark.dispose();
	}*/
}
