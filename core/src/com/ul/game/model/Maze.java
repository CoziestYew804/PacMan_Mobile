package com.ul.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.ul.game.model.elements.GameElement;
import com.ul.game.model.elements.impl.*;
import com.ul.game.model.MazeCor.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Maze implements Iterable<GameElement>
{
	private MazeCOR _MazeCOR;
	private World _world;
	private int _width;
	private int _height;

	/* 0 : mur, 1 : vide, 2 : intersection, 3 : barriere fantomes */
	private int[][] _laby1 = new int[][]{
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 0, 0, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 0},
			{0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
			{0, 9, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 9, 0},
			{0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
			{0, 2, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 2, 0},
			{0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0},
			{0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0},
			{0, 2, 1, 1, 1, 1, 2, 0, 0, 1, 1, 1, 2, 0, 0, 2, 1, 1, 2, 0, 0, 2, 1, 1, 1, 1, 2, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 2, 1, 1, 2, 2, 2, 2, 1, 1, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 3, 3, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 2, 1, 1, 1, 1, 2, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 2, 1, 1, 2, 1, 1, 1, 1, 2, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 2, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 2, 0},
			{0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
			{0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
			{0, 9, 1, 2, 0, 0, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 0, 0, 2, 1, 9, 0},
			{0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0},
			{0, 2, 1, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2, 1, 2, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
			{0, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}

	};

	private GameElement[][] _laby2;


	public Maze() {
	}


	private void init() {
		this._height = _laby1.length;
		this._width = _laby1[0].length;
		this._laby2 = new GameElement[this._height][this._width];
		System.out.println(this.getWidth() + " " + this.getHeight());

		_MazeCOR = new ExpertBlock();
		MazeCOR dark = new ExpertDark();
		MazeCOR inter = new ExpertIntersection();
		MazeCOR barriere = new ExpertBarriere();
		MazeCOR pacman = new ExpertPacman();
		MazeCOR ghost = new ExpertGhost();

		_MazeCOR.setSuivant(dark);
		dark.setSuivant(inter);
		inter.setSuivant(pacman);
		pacman.setSuivant(barriere);
		barriere.setSuivant(ghost);

		int x = 0, y = 0;
		for (int[] t : _laby1) {
			for (int elementType : t) {

				GameElement element = _MazeCOR.build(
						this._world,
						elementType,
						x,
						y);
				this._laby2[x][y] = element;
				y = (++y % this._width);
			}
			x++;
		}
		//System.out.println(this.get(14, 13));
	}

	public Maze(World w) {
		_world = w;
		this.init();
	}

	public GameElement get(int x, int y) {
		return this._laby2[x][y];
	}

	public int getHeight() {
		return _height;
	}

	public int getWidth() {
		return _width;
	}

	public int getMap(int i, int j) { return this._laby1[j][i];}

	public void eatPellet(int x, int y) {
		if(_laby2[y][x] instanceof Pellet)
			_laby2[y][x] = null;
	}



	@Override
	public Iterator<GameElement> iterator() {
		return new MazeIterator(this);
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

}

class MazeIterator implements Iterator<GameElement>
{
	private Maze _maze;
	int _i, _j;

	public MazeIterator(Maze maze) { this._maze = maze; _i = _j = 0; }

	@Override
	public boolean hasNext() { return (_i < this._maze.getHeight()) && (_j < this._maze.getWidth()); }

	@Override
	public GameElement next() {
		if(!this.hasNext()) throw new NoSuchElementException("No more game elements");
		GameElement gameElement;
		do {
			gameElement = this._maze.get(_i,_j);
			_j = (_j + 1) % this._maze.getWidth();
			if(_j == 0)
				_i++;
		} while(gameElement == null
				&& this.hasNext());
		return gameElement;
	}

	/**
	 * Removes from the underlying collection the last element returned
	 * by this iterator (optional operation).  This method can be called
	 * only once per call to {@link #next}.  The behavior of an iterator
	 * is unspecified if the underlying collection is modified while the
	 * iteration is in progress in any way other than by calling this
	 * method.
	 *
	 * @throws UnsupportedOperationException if the {@code remove}
	 *                                       operation is not supported by this iterator
	 * @throws IllegalStateException         if the {@code next} method has not
	 *                                       yet been called, or the {@code remove} method has already
	 *                                       been called after the last call to the {@code next}
	 *                                       method
	 * @implSpec The default implementation throws an instance of
	 * {@link UnsupportedOperationException} and performs no other action.
	 */
	public void remove() {

	}
}