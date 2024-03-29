package com.ul.game.view;

import com.badlogic.gdx.graphics.Texture;

public class TextureSuperPellet implements iTexturable {
	private float deltaT = 0.0f, seuil;
	private int step = 0;

	private Texture[] textures;


	public TextureSuperPellet(float seuil){
		this.seuil = seuil;

		textures = new Texture[]{
				new Texture("core/assets/superpellet-2.png"),
				new Texture("core/assets/superpellet.png")
		};
	}


	@Override
	public Texture getTexture(float delta) {
		this.deltaT += delta;
		if(this.deltaT > this.seuil) {
			this.deltaT = 0.0f;
			this.step++;
			if(this.step > 1) this.step = 0;
		}

		return textures[this.step];
	}
}
