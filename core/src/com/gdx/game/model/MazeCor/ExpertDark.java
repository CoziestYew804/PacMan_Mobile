package com.gdx.game.model.MazeCor;

import com.badlogic.gdx.math.Vector2;
import com.gdx.game.model.Block;
import com.gdx.game.model.Dark;
import com.gdx.game.model.GameElement;
import com.gdx.game.model.World;

public class ExpertDark extends MazeCOR {
    @Override
    public GameElement buildSpecifique(World w, int ElementType, int x, int y) {
        if (ElementType == 1) return new Dark(new Vector2(x, y), w);
        return null;
    }
}
