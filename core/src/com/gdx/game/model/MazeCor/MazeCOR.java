package com.gdx.game.model.MazeCor;

import com.gdx.game.model.GameElement;
import com.gdx.game.model.World;

public abstract class MazeCOR {
    private MazeCOR suivant;


    public MazeCOR getCOR()
    {
        MazeCOR expertBlock = new ExpertBlock();
        MazeCOR expertDark = new ExpertDark();
        MazeCOR expertIntersection = new ExpertIntersection();
        MazeCOR expertBarriere = new ExpertBarriere();
        MazeCOR expertPacman = new ExpertPacman();

        expertBlock.setSuivant(expertDark);
        expertDark.setSuivant(expertIntersection);
        expertIntersection.setSuivant(expertBarriere);
        expertBarriere.setSuivant(expertPacman);
        expertPacman.setSuivant(null);

        return expertBlock;
    }
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
