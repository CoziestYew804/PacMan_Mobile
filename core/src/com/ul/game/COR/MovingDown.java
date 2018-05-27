package com.ul.game.COR;

import com.ul.game.model.World;
import com.ul.game.model.elements.impl.Block;
import com.ul.game.model.elements.impl.Ghost;

public class MovingDown extends RandomMovingCOR {
    @Override
    public void move(World w, Ghost ghost) {
        System.out.println("j'essaie bas");
        if(ghost.getNext(ghost.getDOWN()).getClass() != Block.class){
            System.out.println("Le ghost va vers le bas");
            ghost.getPosition().add(ghost.getDOWN());
            this.moved=true;
        }
        /*else {
            System.out.println("j'essaie");
            if(ghost.getPosition()!=ghost.getNext(1*SPEED+1,0).getPosition()) {
                ghost.getPosition().set(ghost.getNext(1 * SPEED + 1, 0).getPosition());
                ghost.getPosition().add(-1, 0);
                this.moved = true;
            }
        }*/
    }
}
