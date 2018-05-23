package com.ul.game.model.MazeCor;

import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.GameElement;
import com.ul.game.model.Gom;
import com.ul.game.model.World;

public class ExpertGom extends MazeCOR{
    public GameElement buildSpecifique(World w, int ElementType, int x, int y) {
        if (ElementType == 0) return new Gom(new Vector2(x, y), w);
        return null;
    }
}
