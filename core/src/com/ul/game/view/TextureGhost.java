package com.ul.game.view;

import com.badlogic.gdx.graphics.Texture;
import com.ul.game.model.elements.impl.Ghost;

public class TextureGhost implements iTexturable{


	private Ghost ghost;

	private Texture[] textures;


	public TextureGhost(Ghost ghost, String textureAlive){
		this.ghost = ghost;
		textures = new Texture[]{
				new Texture(textureAlive),
                new Texture("core/assets/ghostEscaping.png"),
				new Texture("core/assets/ghostDead.png")

		};

	}

	public Texture getTexture(float delta) {
		return textures[ghost.getEtat()];
	}
}
