package com.ul.game.IA;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.World;
import com.ul.game.model.elements.GameElement;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Flood {

    protected World world;

    public Flood(World world)
    {
        this.world = world;
    }

    public Vector2 getDirection(GridPoint2 origine, GridPoint2 target) {

        LinkedList<Wave> tsunami = new LinkedList<Wave>();

        boolean destroyed[][] = new boolean[world.getMaze().getWidth()][world.getMaze().getHeight()];

        System.out.println(world.getMaze().getHeight());

        //GridPoint2 pos = new GridPoint2((int)origine.x, (int)origine.y);
        //GridPoint2 cible = new GridPoint2((int)target.x, (int)target.y);

        tsunami.add(new Wave(origine, target,world.getMaze()));

        boolean stop = false;
        Wave last;

        do{

            last = tsunami.pollFirst();

            if(last == null)
                throw new NullPointerException("Target not in same maze");


            System.out.println(
                            "X : " + last.getPosition().x +
                            " Y : " + last.getPosition().y +
                            " Etat : " +
                            destroyed[last.getPosition().x][last.getPosition().y]);
            if(!destroyed[last.getPosition().x][last.getPosition().y]){
                stop = stop || last.flood(tsunami);
                destroyed[last.getPosition().x][last.getPosition().y] = true;
            }
        }while(!stop);

        Vector2 nextDir = null;

        GridPoint2 tmp = last.getFirstSon().getPosition();
        Vector2 nextPos = new Vector2(tmp.x, tmp.y);

        if(nextPos.y > origine.y) nextDir = new Vector2(0, +1);
        else if (nextPos.y < origine.y) nextDir = new Vector2(0, -1);
        else
        {

            if(nextPos.x > origine.x)
                nextDir = new Vector2(+1, 0);
            else if(nextPos.x < origine.x)
                nextDir = new Vector2(-1, 0);

                //n'est censé jamais arriver
            else nextDir = new Vector2(0,0);

        }

        return nextDir;

    }
}
