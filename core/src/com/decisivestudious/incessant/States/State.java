package com.decisivestudious.incessant.States;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by Immortan on 7/30/2016.
 */
public interface State {
    void update();
    void draw(Batch batch);
    void dispose();
    Stage getUI();
    boolean consoleCommand(String command);
    boolean keyDown(int keycode);
    boolean keyUp(int keycode);
    boolean touchDown(int screenX, int screenY, int pointer, int button);
    boolean touchUp(int screenX, int screenY, int pointer, int button);
    boolean touchDragged(int screenX, int screenY, int pointer);
    boolean mouseMoved(int screenX, int screenY);
    boolean scrolled(int amount);
    boolean keyTyped(char character);
}
