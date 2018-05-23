package com.ul.game.model.MazeCor;

import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.*;
import com.ul.game.model.elements.GameElement;
import com.ul.game.model.elements.impl.*;

public class ExpertGhost extends MazeCOR {

    @Override
    public GameElement buildSpecifique(World w, int ElementType, int x, int y) {
        if (ElementType == 5) return new RedGhost(new Vector2(x, y), w);
        else if (ElementType == 6) return new RoseGhost(new Vector2(x, y), w);
        else if (ElementType == 7) return new BlueGhost(new Vector2(x, y), w);
        else if (ElementType == 8) return new YellowGhost(new Vector2(x, y), w);
        return null;
    }
}
