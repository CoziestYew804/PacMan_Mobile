package com.gdx.game.model;

import com.badlogic.gdx.math.Vector2;
import java.util.Iterator;

public class World implements Iterable<GameElement> {
    private Maze _maze;
    private Pacman _pacman;
    private Ghost _blueGhost;

    public World()
    {
        //this._blueGhost = new BlueGhost(new Vector2(1, 1), this);
        this._maze = new Maze(this);
        //this._pacman = (Pacman) this.getMaze().get(14,17);
        //this._pacman.setPosition( new Vector2( (14*16 ), (30-17)*16));

    }

    public int getHeight() {
        return this.getHeight();
    }

    public int getWidth() {
        return this.getWidth();
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
