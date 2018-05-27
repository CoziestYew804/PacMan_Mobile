package com.ul.game.COR;

import com.ul.game.model.World;
import com.ul.game.model.elements.GameElement;
import com.ul.game.model.elements.impl.Block;
import com.ul.game.model.elements.impl.Ghost;

public class MovingUp extends RandomMovingCOR {

    @Override
    public void move(World w, Ghost ghost) {

        if (ghost.getNext(ghost.getUP()).getClass() != Block.class) {

            System.out.println("Le ghost va vers le haut !");
            ghost.getPosition().add(ghost.getUP());
            this.moved=true;
        }
    }
}
