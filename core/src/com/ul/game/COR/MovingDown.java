package com.ul.game.COR;

import com.ul.game.model.World;
import com.ul.game.model.elements.impl.Block;
import com.ul.game.model.elements.impl.Ghost;

public class MovingDown extends RandomMovingCOR {
    @Override
    public void move(World w, Ghost ghost) {
        if(ghost.getNext(1*SPEED+1,0).getClass() != Block.class){
            System.out.println("Le ghost va vers le bas");
            ghost.getPosition().add(1*SPEED, 0);
            this.moved=true;
        }
    }
}
