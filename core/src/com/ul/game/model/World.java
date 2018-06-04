package com.ul.game.model;

import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.elements.GameElement;
import com.ul.game.model.elements.impl.*;

import java.util.Iterator;


/**
 * Monde de jeu
 */
public class World implements Iterable<GameElement> {
    private Maze _maze;
    private final Pacman _pacman;
    private final BlueGhost _blueGhost;
    private final RedGhost _redGhost;
    private final PinkGhost _pinkGhost;
    private final YellowGhost _yellowGhost;
   // public static Vector2 pacmanStartPos =  new Vector2( (14*16 ), (30-17)*16);

    //Position initiale des éléments déplacables du jeu
    public static Vector2 pacmanStartPos =  new Vector2( 17, 14);
    public static Vector2 redGhostStartingPos = new Vector2(14 , 12 );
    public static Vector2 blueGhostStartingPos = new Vector2(14 , 14 );
    public static Vector2 yellowGhostStartingPos = new Vector2(14 , 15 );
    public static Vector2 pinkGhostStartingPos = new Vector2(14 , 13 );
    private boolean GameOver=false;
    public int points=0;

    public boolean isGameOver() {
        return GameOver;
    }

    public void setGameOver(boolean gameOver) {
        GameOver = gameOver;
    }


    public World()
    {
        this._maze = new Maze(this);
        _pacman = new Pacman(pacmanStartPos, this);
        _blueGhost = new BlueGhost(blueGhostStartingPos,this);
        _redGhost = new RedGhost(redGhostStartingPos,this);
        _yellowGhost = new YellowGhost(yellowGhostStartingPos,this);
        _pinkGhost = new PinkGhost(pinkGhostStartingPos,this);

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
    public BlueGhost getBlueGhost() {
        return _blueGhost;
    }
    public RedGhost getRedGhost() {
        return _redGhost;
    }
    public PinkGhost getPinkGhost() {
        return _pinkGhost;
    }
    public YellowGhost getYellowGhost() {
        return _yellowGhost;
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
