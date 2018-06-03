package com.ul.game.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.World;
import com.ul.game.model.elements.impl.*;

import java.util.HashMap;

public class TextureFactory {
    static private TextureFactory instance = null;

    private HashMap<Class<?>, iTexturable> textures;

    private TextureFactory(World world){
    	textures = new HashMap<Class<?>, iTexturable>();
		textures.put(
				Intersection.class,
				new TextureUnique("core/assets/dark.png")
		);
		textures.put(
				IntersectionWithSuperPellet.class,
				new TextureSuperPellet(.7f)
		);
		textures.put(
				IntersectionWithPellet.class,
				new TextureUnique("core/assets/pellet.png")
		);
		textures.put(
				Pellet.class,
				new TextureUnique("core/assets/pellet.png")
		);
    	textures.put(
    			Block.class,
				new TextureUnique("core/assets/bloc.png")
		);
		textures.put(
				Dark.class,
				new TextureUnique("core/assets/dark.png")
		);

		textures.put(
				Barriere.class,
				new TextureUnique("core/assets/pellet.png")
		);
		textures.put(
				SuperPellet.class,
				new TextureSuperPellet(.7f)
		);

		//Pacman
    	textures.put(
    			Pacman.class,
				new TexturePacman(world.getPacman(), .3f)
		);

    	//redGhost
    	textures.put(
    			RedGhost.class,
				new TextureRedGhost(world.getRedGhost())
		);
		//pinkGhost
		textures.put(
				PinkGhost.class,
				new TexturePinkGhost(world.getPinkGhost())
		);
		//blueGhost
		textures.put(
				BlueGhost.class,
				new TextureBlueGhost(world.getBlueGhost())
		);
		//yellowGhost
		textures.put(
				YellowGhost.class,
				new TextureYellowGhost(world.getYellowGhost())
		);
    }


	public Texture getTexture(Class<?> c, float delta){
    		return textures.get(c).getTexture(delta);
	}

    static public void reset(World world){
        instance = new TextureFactory(world);
    }

	public static TextureFactory getInstance(World world) {
		if (instance == null) {
			instance = new TextureFactory(world);
		}
		return instance;
	}
}
