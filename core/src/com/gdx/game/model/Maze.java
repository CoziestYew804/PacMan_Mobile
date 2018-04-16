package com.gdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gdx.game.view.TextureFactory;
import java.util.Iterator;

public class Maze implements Iterable<GameElement> {
	private World _world;
	private final int _width;
	private final int _height;

	Texture block=TextureFactory.getInstance().getTextureBloc();
	Texture pacGomme=TextureFactory.getInstance().getTexturePacGom();
	Texture pacPower=TextureFactory.getInstance().getTexturePacPower();
	Texture dark=TextureFactory.getInstance().getTextureDark();
	Texture pacman = TextureFactory.getInstance().getTexturePacman();

	/* 0 : mur, 1 : vide, 2 : intersection, 3 : barriere fantomes */
	private int[][] _laby1 = new int[][] {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,2,2,2,2,2,2,2,2,2,2,2,2,0,0,2,2,2,2,2,2,2,2,2,2,2,2,0},
			{0,2,0,0,0,0,2,0,0,0,0,0,2,0,0,2,0,0,0,0,0,2,0,0,0,0,2,0},
			{0,3,0,0,0,0,2,0,0,0,0,0,2,0,0,2,0,0,0,0,0,2,0,0,0,0,3,0},
			{0,2,0,0,0,0,2,0,0,0,0,0,2,0,0,2,0,0,0,0,0,2,0,0,0,0,2,0},
			{0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
			{0,2,0,0,0,0,2,0,0,2,0,0,0,0,0,0,0,0,2,0,0,2,0,0,0,0,2,0},
			{0,2,0,0,0,0,2,0,0,2,0,0,0,0,0,0,0,0,2,0,0,2,0,0,0,0,2,0},
			{0,2,2,2,2,2,2,0,0,2,2,2,2,0,0,2,2,2,2,0,0,2,2,2,2,2,2,0},
			{0,0,0,0,0,0,2,0,0,0,0,0,2,0,0,2,0,0,0,0,0,2,0,0,0,0,0,0},
			{0,0,0,0,0,0,2,0,0,0,0,0,2,0,0,2,0,0,0,0,0,2,0,0,0,0,0,0},
			{0,0,0,0,0,0,2,0,0,2,2,2,2,2,2,2,2,2,2,0,0,2,0,0,0,0,0,0},
			{0,0,0,0,0,0,2,0,0,2,0,0,0,1,1,0,0,0,2,0,0,2,0,0,0,0,0,0},
			{0,0,0,0,0,0,2,0,0,2,0,1,1,1,1,1,1,0,2,0,0,2,0,0,0,0,0,0},
			{2,2,2,2,2,2,2,2,2,2,0,1,1,1,1,1,1,0,2,2,2,2,2,2,2,2,2,2},
			{0,0,0,0,0,0,2,0,0,2,0,0,0,0,0,0,0,0,2,0,0,2,0,0,0,0,0,0},
			{0,0,0,0,0,0,2,0,0,2,0,0,0,0,0,0,0,0,2,0,0,2,0,0,0,0,0,0},
			{0,0,0,0,0,0,2,0,0,2,2,2,2,2,4,2,2,2,2,0,0,2,0,0,0,0,0,0},
			{0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0},
			{0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0},
			{0,2,2,2,2,2,2,2,2,2,2,2,2,0,0,2,2,2,2,2,2,2,2,2,2,2,2,0},
			{0,2,0,0,0,0,2,0,0,0,0,0,2,0,0,2,0,0,0,0,0,2,0,0,0,0,2,0},
			{0,2,0,0,0,0,2,0,0,0,0,0,2,0,0,2,0,0,0,0,0,2,0,0,0,0,2,0},
			{0,3,2,2,0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,0,2,2,3,0},
			{0,0,0,2,0,0,2,0,0,2,0,0,0,0,0,0,0,0,2,0,0,2,0,0,2,0,0,0},
			{0,0,0,2,0,0,2,0,0,2,0,0,0,0,0,0,0,0,2,0,0,2,0,0,2,0,0,0},
			{0,2,2,2,2,2,2,0,0,2,2,2,2,0,0,2,2,2,2,0,0,2,2,2,2,2,2,0},
			{0,2,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,2,0},
			{0,2,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,2,0},
			{0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	};
	private GameElement[][] _laby2;

	public Maze() {}

	public Maze(World w) {
		_world = w;
		this.init();
	}

	private void init ()
	{
		this._height = _laby1.length;
		this._width  = _laby1[0].length;
		this._laby2 = new GameElement[this._height][this._width];

		int x = 0,y = 0;
		for(int[] t : _laby1) {
			for(int elementType : t) {
				GameElement element = MazeCOR.getCOR ().build (
						this._world,
						elementType,
						x,
						y);
				this._laby2[x][y] = element;
				y = (++y % this._width);
			}
			x++;
		}
	}

	public GameElement get(int x, int y) { return this._laby2[x][y]; }

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
		draw(batch, pacGomme, 2);
		draw(batch, pacPower, 3);
		draw(batch, pacman, 4);

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