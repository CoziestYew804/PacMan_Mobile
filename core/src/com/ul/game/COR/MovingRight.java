package com.ul.game.COR;

import com.ul.game.model.World;
import com.ul.game.model.elements.impl.Block;
import com.ul.game.model.elements.impl.Ghost;

public class MovingRight extends RandomMovingCOR {


    @Override
    public void move(World w, Ghost ghost) {
        if (ghost.getNext(0, 1 * SPEED + 1).getClass() != Block.class) {
            System.out.println("Le ghost va à droite");
            ghost.getPosition().add(0, 1 * SPEED);
            this.moved = true;
        }
        else {
        }

    }
}
