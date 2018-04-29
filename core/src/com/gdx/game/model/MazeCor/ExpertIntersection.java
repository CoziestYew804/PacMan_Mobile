package com.gdx.game.model.MazeCor;

import com.badlogic.gdx.math.Vector2;
import com.gdx.game.model.GameElement;
import com.gdx.game.model.Gom;
import com.gdx.game.model.World;
import com.gdx.game.model.Intersection;

public class ExpertIntersection extends MazeCOR{
    @Override
    public GameElement buildSpecifique(World w, int ElementType, int x, int y) {
        if (ElementType == 2) return new Intersection(new Vector2(x, y), w);
        return null;
    }
}
