package com.ul.game.IA;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.World;
import com.ul.game.model.elements.GameElement;

import java.util.Stack;

public class Flood {
    World world;

    public int getDirection(Vector2 origine, Vector2 target) {
        Stack<Wave> tsunami = new Stack<Wave>();
        boolean destroyed[][] = new boolean[world.getMaze().getHeight()-1]
                                            [world.getMaze().getWidth()-1];
        GridPoint2 pos = new GridPoint2((int)origine.x, (int)origine.y);
        GridPoint2 cible = new GridPoint2((int)target.x, (int)target.y);

        tsunami.add(new Wave(null,world.getMaze(),pos, cible));

        boolean stop = false;
        Wave last;

        do{
            if(tsunami.size() == 0)
                throw new NullPointerException("Target not in same maze");
            last = tsunami.pop();
            if(!destroyed[last.getPosition().x][last.getPosition().y]){
                stop = stop || last.flood(tsunami);
                destroyed[last.getPosition().x][last.getPosition().y] = true;
            }
        }while(!stop);

        int nextDir = 0;

        GridPoint2 tmp = last.getFirstSon().getPosition();
        Vector2 nextPos = new Vector2(tmp.x, tmp.y);

        if(nextPos.y > origine.y)
            nextDir = 0;
        if(nextPos.x > origine.x)
            nextDir = 1;

        return nextDir;

    }
}
