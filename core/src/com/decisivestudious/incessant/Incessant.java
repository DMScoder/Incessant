package com.decisivestudious.incessant;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.decisivestudious.incessant.States.StateManager;

public class Incessant extends ApplicationAdapter {
	SpriteBatch batch;
	StateManager stateManager;

	@Override
	public void create () {
		batch = new SpriteBatch();
		stateManager = new StateManager(batch);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateManager.update();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
