package com.ul.game.IA;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.World;
import com.ul.game.model.elements.GameElement;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Classe Flood permettant la recherche du plus court chemin
 */
public class Flood {

    protected World world;

    /**
     * Constructeur de Flood
     * @param world : Monde du jeu
     */
    public Flood(World world)
    {
        this.world = world;
    }

    /**
     * Méthode permettant de définir la direction à prendre pourle fantôme
     * @param origine : Position actuelle du fantôme
     * @param target : Position du pacman
     * @return Direction à emprunter par le fantôme
     */
    public Vector2 getDirection(Vector2 origine, Vector2 target) {

        //Initialisation de la liste de vagues
        LinkedList<Wave> tsunami = new LinkedList<Wave>();

        //Tableau à deux dimensions de booleens de la même taille que le labyrinthe
        boolean destroyed[][] = new boolean[world.getMaze().getWidth()][world.getMaze().getHeight()];

        //Conversion en GridPoint2 de origine et target
        GridPoint2 pos = new GridPoint2((int)origine.x, (int)origine.y);
        GridPoint2 cible = new GridPoint2((int)target.x, (int)target.y);

        //Ajout de la vague dans la liste
        tsunami.add(new Wave(pos, cible,world.getMaze()));

        boolean stop = false;
        Wave last;

        do{
            //On récupère une vague dans la liste
            last = tsunami.pollFirst();

            //Si la liste est vide -> exception
            if(last == null ) {
                throw new NullPointerException("Problème dans le labyrinthe");
            }

            //Si la position de la vague n'est pas marquée, on la marque
            if(!destroyed[last.getPosition().x][last.getPosition().y]){
                stop = last.flood(tsunami);
                destroyed[last.getPosition().x][last.getPosition().y] = true;
            }
        }while(!stop);

        Vector2 nextDir = null;

        //Récupération de la position du premier fils
        GridPoint2 tmp = last.getFirstSon().getPosition();
        Vector2 nextPos = new Vector2(tmp.x, tmp.y);

        //En fonction des coodonnées, on choisit la direction du fantôme
        if(nextPos.y > origine.y) nextDir = new Vector2(0, +1);
        else if (nextPos.y < origine.y) nextDir = new Vector2(0, -1);
        else
        {

            if(nextPos.x > origine.x)
                nextDir = new Vector2(+1, 0);
            else if(nextPos.x < origine.x)
                nextDir = new Vector2(-1, 0);

                //n'est censé jamais arriver
            else nextDir = new Vector2(0,0);

        }

        //On retourne cette direction
        return nextDir;

    }
}
