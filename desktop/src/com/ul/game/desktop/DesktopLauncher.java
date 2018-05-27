package com.ul.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ul.game.PacManGdx;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "PacMan";
		config.width = 28 * 16;
		config.height = 31 * 16;
		//config.foregroundFPS = 16;
		
		new LwjglApplication(new PacManGdx(), config);
	}
}
