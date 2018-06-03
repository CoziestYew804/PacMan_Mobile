package com.ul.game.IA;

import com.badlogic.gdx.math.GridPoint2;
import com.ul.game.model.Maze;
import com.ul.game.model.elements.GameElement;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Wave {
    Wave _father;
    Maze _maze;
    GridPoint2 _origin, _target;

    public Wave(Wave father, GridPoint2 origin, GridPoint2 target, Maze maze)
    {
        this._father = father;
        this._maze = maze;
        this._origin = origin;
        this._target = target;
    }

    public Wave(GridPoint2 origin, GridPoint2 target, Maze maze)
    {
        this(null, origin, target, maze);
    }

    public GridPoint2 getPosition(){ return _origin; }
    public Wave getFather(){ return _father; }

    public boolean flood(LinkedList<Wave> tsunami)
    {
        if(_origin.equals(_target))//->.equals test bien les positions?
            return true;

        //!\\Les cases vides autour -> ne pas rechercher en dehors du tableau
        //Si ça dépasse la taille, revenir au début (tp de gauche à droite et inversement, ainsi que haut bas)
        System.out.println( "la merde " + _origin.x +"    "+ _origin.y);
        if(_origin.x <= 0)
        {
            _origin.x = _maze.getWidth()-1;
            System.out.println("Nouvelle valeur de X auparavant négative :" + _origin.x);
        }


        if(_origin.x > _maze.getWidth()-1)
        {
            _origin.x = 1;
            System.out.println("Nouvelle valeur de X auparavant trop élevée :" + _origin.x);
        }


        if (_origin.y > _maze.getHeight()-1)
        {
            _origin.y = 1;
            System.out.println("Nouvelle valeur de Y auparavant trop élevée :" + _origin.y);

        }


        if (_origin.y <= 0)
        {
            _origin.y = _maze.getHeight()-1;
            System.out.println("Nouvelle valeur de Y auparavant négative :" + _origin.y);
        }



        GridPoint2 up = new GridPoint2 (_origin.x, _origin.y +1);
        GridPoint2 right = new GridPoint2 (_origin.x+1, _origin.y);
        GridPoint2 down = new GridPoint2 (_origin.x, _origin.y -1);
        GridPoint2 left = new GridPoint2(_origin.x-1, _origin.y);

        System.out.println( "la merde  left " + left.x +"    "+ left.y);

        //on vérifie si c'est un chemin ou une intersection ou la porte des fantomes
        if(_maze.getMap(left.x, left.y) != 0)
            tsunami.addLast(new Wave(left, _target, _maze));
        if(_maze.getMap(right.x, right.y) != 0)
            tsunami.addLast(new Wave(right, _target, _maze ));
        if(_maze.getMap(up.x, up.y) != 0)
            tsunami.addLast(new Wave(up, _target, _maze ));
        if(_maze.getMap(down.x, down.y) != 0)
            tsunami.addLast(new Wave(down, _target, _maze));

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
