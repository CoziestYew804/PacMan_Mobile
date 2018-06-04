package com.ul.game.model.MazeCor;

import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.elements.GameElement;
import com.ul.game.model.World;
import com.ul.game.model.elements.impl.Intersection;
import com.ul.game.model.elements.impl.IntersectionWithPellet;
import com.ul.game.model.elements.impl.IntersectionWithSuperPellet;

public class ExpertIntersection extends MazeCOR{
    @Override
    public GameElement buildSpecifique(World w, int ElementType, int x, int y) {
        if (ElementType == 2) {return new IntersectionWithPellet(new Vector2(x, y), w);}
        if (ElementType == 5) {return new IntersectionWithSuperPellet(new Vector2(x, y), w);}

        return null;
    }
}
