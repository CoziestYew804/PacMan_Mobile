package com.ul.game;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.ul.game.screens.GameScreen;
import com.ul.game.screens.HomeScreen;

public class PacManGdx extends Game implements ApplicationListener {

	@Override
	public void create() {
		setScreen(new HomeScreen(this));
	}




}
