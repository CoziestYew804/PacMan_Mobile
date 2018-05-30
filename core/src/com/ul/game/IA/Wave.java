package com.ul.game.IA;

import com.ul.game.model.Maze;
import com.ul.game.model.elements.GameElement;

import java.util.Stack;

public class Wave {
    Wave _father;
    Maze _maze;
    GameElement _origin, _target;

    public Wave(Wave father, Maze maze, GameElement origin, GameElement target)
    {
        this._father = father;
        this._maze = maze;
        this._origin = origin;
        this._target = target;
    }

    public GameElement getPosition(){ return _origin; }
    public Wave getFather(){ return _father; }

    public boolean flood(Stack<Wave> tsunami)
    {
        return (_origin.equals(_target));

    }

    public Wave getFirstSon()
    {
        Wave son = this;
        while(_father != null)
        {
            son = _father;
            _father= _father.getFather();
        }
        return son;
    }
}
