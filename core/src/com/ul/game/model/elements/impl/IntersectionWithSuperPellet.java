package com.ul.game.model.elements.impl;

import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.World;

public class IntersectionWithSuperPellet extends Intersection {
    public boolean hasSuperGom= true;
    public IntersectionWithSuperPellet(Vector2 position, World monde) {
        super(position, monde);
    }
    public boolean getHasSuperPellet(){
        if(hasSuperGom){
            return true;
        }
        return false;
    }
    public void setHasSuperGom(boolean hasGom) {
        this.hasSuperGom = hasGom;
    }
}
