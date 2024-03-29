package com.ul.game.model.MazeCor;

import com.ul.game.model.elements.GameElement;
import com.ul.game.model.World;

/**
 * Chaine de responsabilité permettant de construire le monde de jeu à partir du labyrinthe à deux dimensions
 */
public abstract class MazeCOR {
    private MazeCOR suivant;



    public void setSuivant(MazeCOR psuivant)
    {
        suivant = psuivant;
    }

    public abstract GameElement buildSpecifique(World w, int ElementType, int x, int y);

    public GameElement build (World w, int ElementType, int x, int y)
    {
        GameElement ge = buildSpecifique(w, ElementType, x, y);

        if(ge != null) return ge;

        if(suivant != null) return suivant.build(w, ElementType, x, y);

        return null;

    }
}
