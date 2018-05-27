package com.ul.game.COR;

import com.badlogic.gdx.Gdx;
import com.ul.game.model.World;
import com.ul.game.model.elements.GameElement;
import com.ul.game.model.elements.impl.Ghost;

public abstract class RandomMovingCOR {

        private RandomMovingCOR suivant;
        protected boolean moved=false;
        protected static final float SPEED = 2* Gdx.graphics.getDeltaTime();

        public void setSuivant(RandomMovingCOR psuivant)
        {
            suivant = psuivant;
        }

        public abstract void move(World w, Ghost ghost);

        public void randomMove (World w, Ghost ghost)
        {

            move(w, ghost);

            if(!moved) {
                if (suivant != null) suivant.randomMove(w, ghost);
            }


        }
}
