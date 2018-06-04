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

    /**
     * Constructeur de Wave
     * @param father Vague père
     * @param origin Position actuelle
     * @param target Position du Pacman
     * @param maze Labyrinthe du jeu
     */
    public Wave(Wave father, GridPoint2 origin, GridPoint2 target, Maze maze)
    {
        this._father = father;
        this._maze = maze;
        this._origin = origin;
        this._target = target;
    }

    /**
     * Même constructeur mais sans Father
     * @param origin
     * @param target
     * @param maze
     */
    public Wave(GridPoint2 origin, GridPoint2 target, Maze maze)
    {
        this(null, origin, target, maze);
    }


    public GridPoint2 getPosition(){ return _origin; }
    public Wave getFather(){ return _father; }

    /**
     * Méthode qui vérifie si le pacman a été trouvé
     * @param tsunami Liste de vague actuelle et modifiée dans la méthode
     * @return true si le pacman a été trouvé
     */
    public boolean flood(LinkedList<Wave> tsunami)
    {
        //Si le pacman est trouvé
        if(_origin.equals(_target))
            return true;

        //cases autour de la position actuelle
        GridPoint2[] nextPos = {
                new GridPoint2 (_origin.x, _origin.y +1),
                new GridPoint2 (_origin.x+1, _origin.y),
                new GridPoint2 (_origin.x, _origin.y -1),
                new GridPoint2(_origin.x-1, _origin.y)
        };

        //Vérifie si les cases ne sont pas en dehors du tableau
        for(int i = 0; i < 4; i++){
            if(nextPos[i].x < 0)
                nextPos[i].x = _maze.getWidth()-1;
            if(nextPos[i].x > _maze.getWidth()-1)
                nextPos[i].x = 0;
            if (nextPos[i].y > _maze.getHeight()-1)
                nextPos[i].y = 0;
            if (nextPos[i].y < 0)
                nextPos[i].y = _maze.getHeight()-1;


            int type = _maze.getMap(nextPos[i].x, nextPos[i].y);
            //Si le type n'est pas un block
            if(type != 0)
                tsunami.addLast(new Wave(this, nextPos[i], _target, _maze));
        }

        //Pacman non trouvé
        return false;


    }

    //Récupère le premier fils
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
