package com.ul.game.model.MazeCor;

import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.GameElement;
import com.ul.game.model.Pacman;
import com.ul.game.model.World;

public class ExpertPacman extends MazeCOR {

    public GameElement buildSpecifique(World w, int ElementType, int x, int y) {
        if (ElementType == 4) return new Pacman(new Vector2(x, y), w);
        return null;
    }
}
