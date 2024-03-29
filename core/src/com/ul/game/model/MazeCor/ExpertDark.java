package com.ul.game.model.MazeCor;

import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.elements.impl.Dark;
import com.ul.game.model.elements.GameElement;
import com.ul.game.model.World;
import com.ul.game.model.elements.impl.Pellet;
import com.ul.game.model.elements.impl.SuperPellet;

public class ExpertDark extends MazeCOR {
    @Override
    public GameElement buildSpecifique(World w, int ElementType, int x, int y) {
        if (ElementType == 1) return new Pellet(new Vector2(x, y), w);
        if (ElementType == 9) return new SuperPellet(new Vector2(x, y), w);
        if (ElementType == 6) return new Dark(new Vector2(x, y), w);
        return null;
    }
}
