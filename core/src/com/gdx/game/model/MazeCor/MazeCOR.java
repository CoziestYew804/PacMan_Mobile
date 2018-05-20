package com.gdx.game.model.MazeCor;

import com.gdx.game.model.GameElement;
import com.gdx.game.model.World;

public abstract class MazeCOR {
    private MazeCOR suivant;



    public void setSuivant(MazeCOR psuivant)
    {
        suivant = psuivant;
    }

    public abstract GameElement buildSpecifique(World w, int ElementType, int x, int y);

    public GameElement build (World w, int ElementType, int x, int y)
    {
        System.out.println("Je suis dans la méthode ! ");
        GameElement ge = buildSpecifique(w, ElementType, x, y);

        if(ge != null) return ge;

        if(suivant != null) return suivant.build(w, ElementType, x, y);

        return null;

    }
}
