package com.ul.game.view;

import com.badlogic.gdx.graphics.Texture;
import com.ul.game.model.elements.impl.Pacman;

import static com.ul.game.model.elements.MovableElement.*;


public class TexturePacman implements iTexturable {
	private Pacman pacman;
	private float deltaT = 0.0f, seuil;
	private int step = 0;

	private Texture[] up, right, down, left;


	public TexturePacman(Pacman pacman, float seuil){
		this.pacman = pacman;
		this.seuil = seuil;

		up = new Texture[]{
				new Texture("core/assets/pacmanUp-2.png"),
				new Texture("core/assets/pacmanUp.png"),
				new Texture("core/assets/pacman-3.png")
		};

		right = new Texture[]{
				new Texture("core/assets/pacmanRight-2.png"),
				new Texture("core/assets/pacmanRight.png"),
				new Texture("core/assets/pacman-3.png")
		};

		down = new Texture[]{
				new Texture("core/assets/pacmanDown-2.png"),
				new Texture("core/assets/pacmanDown.png"),
				new Texture("core/assets/pacman-3.png")
		};

		left = new Texture[]{
				new Texture("core/assets/pacmanLeft-2.png"),
				new Texture("core/assets/pacmanLeft.png"),
				new Texture("core/assets/pacman-3.png")
		};
	}


	@Override
	public Texture getTexture(float delta) {
		this.deltaT += delta;
		if(this.deltaT > this.seuil) {
			this.deltaT = 0.0f;
			this.step++;
			if(this.step > 2) this.step = 0;
		}

System.out.println(pacman.getDirection());
		System.out.println(UP==pacman.getDirection());
		System.out.println(DOWN==pacman.getDirection());
		System.out.println(LEFT==pacman.getDirection());System.out.println(RIGHT==pacman.getDirection());


		if(pacman.getDirection().equals(UP)){
			return up[this.step];
		}
		if(pacman.getDirection().equals(DOWN)){
			return down[this.step];
		}if(pacman.getDirection().equals(LEFT)){
			return left[this.step];
		}if(pacman.getDirection().equals(RIGHT)){
			return right[this.step];
		}

		return down[this.step];

	}
}
