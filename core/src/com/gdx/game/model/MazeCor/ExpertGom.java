package com.gdx.game.model.MazeCor;

import com.badlogic.gdx.math.Vector2;
import com.gdx.game.model.Block;
import com.gdx.game.model.GameElement;
import com.gdx.game.model.Gom;
import com.gdx.game.model.World;

public class ExpertGom extends MazeCOR{
    public GameElement buildSpecifique(World w, int ElementType, int x, int y) {
        if (ElementType == 0) return new Gom(new Vector2(x, y), w);
        return null;
    }
}
