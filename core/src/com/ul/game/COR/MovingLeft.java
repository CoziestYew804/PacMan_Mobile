package com.ul.game.COR;

import com.ul.game.model.World;
import com.ul.game.model.elements.impl.Block;
import com.ul.game.model.elements.impl.Ghost;

public class MovingLeft extends RandomMovingCOR {
    @Override
    public void move(World w, Ghost ghost) {
        System.out.println("j'essaie gauche");
        if(ghost.getNext(0,-1*SPEED).getClass() != Block.class){

            System.out.println("Le ghost va vers la gauche");
            ghost.getPosition().add(0, -1*SPEED);
            this.moved=true;
        }
    }
}
