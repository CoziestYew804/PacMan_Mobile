package com.gdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gdx.game.model.MazeCor.*;
import com.gdx.game.view.TextureFactory;
import com.gdx.game.model.Block;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static sun.misc.Version.println;

public class Maze implements Iterable<GameElement> {
	private MazeCOR _MazeCOR;
	private World _world;
	private int _width;
	private int _height;

	Texture block=TextureFactory.getInstance().getTexture(Block.class);
	Texture pacGomme=TextureFactory.getInstance().getTexture(Gom.class);
	Texture pacPower=TextureFactory.getInstance().getTexture(SuperGom.class);
	Texture dark=TextureFactory.getInstance().getTexture(Dark.class);
	Texture pacman = TextureFactory.getInstance().getTexture(Pacman.class);
	Texture redGhost = TextureFactory.getInstance().getTexture(RedGhost.class);
	Texture roseGhost = TextureFactory.getInstance().getTexture(RoseGhost.class);
	Texture blueGhost = TextureFactory.getInstance().getTexture(BlueGhost.class);
	Texture yellowGhost = TextureFactory.getInstance().getTexture(YellowGhost.class);

	/* 0 : mur, 1 : vide, 2 : intersection, 3 : barriere fantomes */
	private int[][] _laby1 = new int[][] {
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 0},
			{0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
			{0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
			{0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
			{0, 2, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 2, 0},
			{0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0},
			{0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0},
			{0, 1, 1, 1, 1, 1, 2, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 2, 1, 1, 1, 1, 1, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 3, 3, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 0, 0, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0},
			{0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
			{0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
			{0, 1, 1, 1, 0, 0, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 0, 0, 1, 1, 1, 0},
			{0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0},
			{0, 1, 1, 2, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
			{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
	};

	private GameElement[][] _laby2;

	public Maze() {}



	private void init ()
	{
		this._height = _laby1.length;
		this._width  = _laby1[0].length;
		this._laby2 = new GameElement[this._height][this._width];
		System.out.println(this.getWidth() + " " +this.getHeight());

		_MazeCOR = new ExpertBlock();
		MazeCOR dark = new ExpertDark();
		MazeCOR inter = new ExpertIntersection();
		MazeCOR barriere = new ExpertBarriere();
		MazeCOR pacman = new ExpertPacman();

		_MazeCOR.setSuivant(dark);
		dark.setSuivant(inter);
		inter.setSuivant(pacman);
		pacman.setSuivant(barriere);

		int x = 0,y = 0;
		for(int[] t : _laby1) {
			for(int elementType : t) {

				GameElement element = _MazeCOR.build (
						this._world,
						elementType,
						x,
						y);
				this._laby2[x][y] = element;
				y = (++y % this._width);
			}
			x++;
		}
		System.out.println(this.get(14,13));
	}

	public Maze(World w) {
		_world = w;
		this.init();
	}
	public GameElement get(int x, int y) { return this._laby2[y][x]; }

	public int getHeight() { return _height; }

	public int getWidth()  { return _width; }
	/*public Maze(Texture Block, Texture PacGomme, Texture PacPower, Texture Dark, Texture pacman) {
		block = Block;
		pacGomme = PacGomme;
		pacPower = PacPower;
		dark = Dark;
		this.pacman = pacman;
	}*/

	public void drawMaze(SpriteBatch batch){
		//murs
		drawResize(batch, block, 0);
		draw(batch, dark, 1);
		//draw(batch, pacGomme, 2);
		//draw(batch, pacPower, 3);
		draw(batch, pacman, 4);
		draw(batch,redGhost,5);
		draw(batch,roseGhost,6);
		draw(batch,blueGhost,7);
		draw(batch,yellowGhost,8);


	}

	private void draw(SpriteBatch batch, Texture text, int what) {
		batch.begin();
		for(int i = 0; i < 28; i ++) {
			for(int j = 0; j < 31; j++) {
				if(_laby1[j][i] == what)
					batch.draw(text, i * 16, (30-j) * 16);
			}
		}
		batch.end();
	}

	private void drawResize(SpriteBatch batch, Texture text, int what) {
		batch.begin();
		for(int i = 0; i < 28; i ++) {
			for(int j = 0; j < 31; j++) {
				if(_laby1[j][i] == what)
					batch.draw(text, i * 16, (30-j) * 16, 16, 16, 0, 0, 48, 48, false, false);
			}
		}
		batch.end();
	}

	@Override
	public Iterator<GameElement> iterator() {
		return new MazeIterator(this);
	}

	public void loadDemoLevel()
	{

	}
}

class MazeIterator implements Iterator<GameElement> {

	private Maze _maze;
	int _i, _j;

	public MazeIterator(Maze maze) {
		this._maze = maze;
		_i = _j = 0;
	}

	@Override
	public boolean hasNext() {
		return (_i < this._maze.getHeight()) && (_j < this._maze.getWidth());
	}

	@Override
	public GameElement next() {
		if (!this.hasNext()) throw new NoSuchElementException("No more game elements");
		GameElement gameElement;
		do {
			gameElement = this._maze.get(_i, _j);
			_j = (_j + 1) % this._maze.getWidth();
			if (_j == 0)
				_i++;
		} while (gameElement == null
				&& this.hasNext());
		return gameElement;
	}

	@Override
	public void remove() {
		// TODO
	}
}