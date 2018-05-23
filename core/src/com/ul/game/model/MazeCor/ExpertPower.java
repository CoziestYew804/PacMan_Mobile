package com.ul.game.model.MazeCor;

import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.elements.GameElement;
import com.ul.game.model.elements.impl.SuperGom;
import com.ul.game.model.World;

public class ExpertPower extends MazeCOR{

    public GameElement buildSpecifique(World w, int ElementType, int x, int y) {
        if (ElementType == 1) return new SuperGom(new Vector2(x, y), w);
        return null;
    }
}
