package com.ul.game.IA;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.World;
import com.ul.game.model.elements.GameElement;

import java.util.Stack;

public class Inondation {
    World world;

    public Inondation(Vector2 origine, Vector2 cible) {
        Stack<Wave> tsunami = new Stack<Wave>();
        boolean destroyed[][] = new boolean[world.getMaze().getHeight()]
                [world.getMaze().getWidth()];

    }
}
