package com.ul.game.model.MazeCor;

import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.elements.GameElement;
import com.ul.game.model.World;
import com.ul.game.model.elements.impl.Barriere;

public class ExpertBarriere extends MazeCOR{
    @Override
    public GameElement buildSpecifique(World w, int ElementType, int x, int y) {
        if (ElementType == 3) return new Barriere(new Vector2(x, y), w);
        return null;
    }
}
