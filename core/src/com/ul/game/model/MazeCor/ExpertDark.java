package com.ul.game.model.MazeCor;

import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.elements.impl.Dark;
import com.ul.game.model.elements.GameElement;
import com.ul.game.model.World;

public class ExpertDark extends MazeCOR {
    @Override
    public GameElement buildSpecifique(World w, int ElementType, int x, int y) {
        if (ElementType == 1) return new Dark(new Vector2(x, y), w);
        return null;
    }
}
