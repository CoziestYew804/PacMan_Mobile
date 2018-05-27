package com.ul.game.model;

import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.elements.GameElement;
import com.ul.game.model.elements.impl.BlueGhost;
import com.ul.game.model.elements.impl.Ghost;
import com.ul.game.model.elements.impl.Pacman;

import java.util.Iterator;

public class World implements Iterable<GameElement> {
    private Maze _maze;
    private final Pacman _pacman;
    private final BlueGhost _blueGhost;
   // public static Vector2 pacmanStartPos =  new Vector2( (14*16 ), (30-17)*16);
    public static Vector2 pacmanStartPos =  new Vector2( 17, 14);
    public World()
    {
        this._maze = new Maze(this);
        _pacman = new Pacman(pacmanStartPos, this);
        _blueGhost = (BlueGhost) this._maze.get(14,14);

    }

    public int getHeight() {
        return this.getMaze().getHeight();
    }

    public int getWidth() {
        return this.getMaze().getWidth();
    }

    public Maze getMaze() {
        return _maze;
    }

    public Pacman getPacman() {
        return _pacman;
    }
    public Ghost getBlueGhost() {
        return _blueGhost;
    }

    @Override
    public Iterator<GameElement> iterator() {
        return new WorldIterator(this);
    }

}



class WorldIterator implements Iterator<GameElement>
{
    private World _world;
    private Iterator<GameElement> _mazeIterator;
    int _i;

    public WorldIterator(World world) {
        this._world = world;
        this._mazeIterator = this._world.getMaze().iterator();
        this._i = 0; /* 0 = maze, 1 = pacman */
    }

    @Override
    public boolean hasNext() {
        return (this._i < 1);
    }

    @Override
    public GameElement next() {
        if((_i == 0)) {
            if (!this._mazeIterator.hasNext())
                _i = 1; // on passe à Pacman
        }
        else _i++;

        GameElement res;
        switch(this._i) {
            case 0 : return this._mazeIterator.next();
            case 1 : return this._world.getPacman();
            default : return null; /* erreur */
        }
    }

    @Override
    public void remove() {
        // TODO
    }
}
