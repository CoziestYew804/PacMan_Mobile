package com.ul.game.IA;

import com.badlogic.gdx.math.GridPoint2;
import com.ul.game.model.Maze;
import com.ul.game.model.elements.GameElement;

import java.util.Stack;

public class Wave {
    Wave _father;
    Maze _maze;
    GridPoint2 _origin, _target;

    public Wave(Wave father, Maze maze, GridPoint2 origin, GridPoint2 target)
    {
        this._father = father;
        this._maze = maze;
        this._origin = origin;
        this._target = target;
    }

    public GridPoint2 getPosition(){ return _origin; }
    public Wave getFather(){ return _father; }

    public boolean flood(Stack<Wave> tsunami)
    {
        if(_origin.equals(_target))//->.equals test bien les positions?
            return true;


        //chercher cases vides autour,
        //créer une Wave avec chaques coordonnées de cases trouvée en tant que _origin

        GridPoint2 left = new GridPoint2(_origin.x-1, _origin.y);
        GridPoint2 right = new GridPoint2 (_origin.x+1, _origin.y);
        GridPoint2 up = new GridPoint2 (_origin.x, _origin.y +1);
        GridPoint2 down = new GridPoint2 (_origin.x, _origin.y -1);


        //on vérifie si c'est un chemin ou une intersection ou la porte des fantomes
        if(_maze.getMap(left.x, left.y) == 1 || _maze.getMap(left.x, left.y) == 2 || _maze.getMap(left.x, left.y) == 3)
            tsunami.push(new Wave(null, _maze, left, _target));
        if(_maze.getMap(right.x, right.y) == 1 || _maze.getMap(right.x, right.y) == 2 || _maze.getMap(right.x, right.y) == 3)
            tsunami.push(new Wave(null, _maze, right, _target));
        if(_maze.getMap(up.x, up.y) == 1 || _maze.getMap(up.x, up.y) == 2 || _maze.getMap(up.x, up.y) == 3)
            tsunami.push(new Wave(null, _maze, up, _target));
        if(_maze.getMap(down.x, down.y) == 1 || _maze.getMap(down.x, down.y) == 2 || _maze.getMap(down.x, down.y) == 3)
            tsunami.push(new Wave(null, _maze, down, _target));


        //!\\Les cases vides autour -> ne pas rechercher en dehors du tableau
        //Si ça dépasse la taille, revenir au début (tp de gauche à droite et inversement, ainsi que haut bas)
        if(_origin.x < 0)
            _origin.x = _maze.getWidth()-1;
        if(_origin.x > _maze.getWidth())
            _origin.x = 0;
        if (_origin.y > _maze.getHeight())
            _origin.y = 0;
        if (_origin.y < 0)
            _origin.y = _maze.getHeight()-1;


        return false;


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
