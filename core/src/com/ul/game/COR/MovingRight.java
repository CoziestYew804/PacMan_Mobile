package com.ul.game.COR;

import com.ul.game.model.World;
import com.ul.game.model.elements.impl.Block;
import com.ul.game.model.elements.impl.Ghost;

public class MovingRight extends RandomMovingCOR {


    @Override
    public void move(World w, Ghost ghost) {
        System.out.println("j'essaie droite");
        if (ghost.getNext(ghost.getRIGHT()).getClass() != Block.class) {
            System.out.println("Le ghost va à droite");
            ghost.getPosition().add(ghost.getRIGHT());
            this.moved = true;
        }
        /*else {
            if(ghost.getPosition()!=ghost.getNext(0, 1 * SPEED + 1).getPosition()) {
                System.out.println("j'essaie je change coord au block droite");
                ghost.getPosition().set(ghost.getNext(0, 1 * SPEED + 1).getPosition());
                ghost.getPosition().add(0, -1);
                this.moved = true;
            }
        }*/

    }
}
