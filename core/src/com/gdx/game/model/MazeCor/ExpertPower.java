package com.gdx.game.model.MazeCor;

import com.badlogic.gdx.math.Vector2;
import com.gdx.game.model.Dark;
import com.gdx.game.model.GameElement;
import com.gdx.game.model.SuperGom;
import com.gdx.game.model.World;

public class ExpertPower extends MazeCOR{

    public GameElement buildSpecifique(World w, int ElementType, int x, int y) {
        if (ElementType == 1) return new SuperGom(new Vector2(x, y), w);
        return null;
    }
}
