package com.ul.game.model.MazeCor;

import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.elements.GameElement;
import com.ul.game.model.World;
import com.ul.game.model.elements.impl.Intersection;

public class ExpertIntersection extends MazeCOR{
    @Override
    public GameElement buildSpecifique(World w, int ElementType, int x, int y) {
        if (ElementType == 2) {return new Intersection(new Vector2(x, y), w);}

        return null;
    }
}
