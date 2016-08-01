package com.decisivestudious.incessant.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.decisivestudious.incessant.States.Menus.MainMenuState;

/**
 * Created by Immortan on 7/30/2016.
 */
public class SplashState implements State{

    int totalTicks = 250;
    int currentTicks = 0;
    Stage stage = new Stage();
    StateManager stateManager;
    ShapeRenderer shapeRenderer = new ShapeRenderer();
    Texture texture = new Texture(Gdx.files.internal("DecisiveStudios.png"));
    Color color1 = new Color(0,0,0,0);
    Color color2 = new Color(0,0,0,0);
    Color color3 = new Color(0,0,0,0);
    Color color4 = new Color(0,0,0,0);
    MainMenuState mainMenuState;

    public SplashState(StateManager stateManager){
        this.stateManager = stateManager;
        mainMenuState = new MainMenuState(stateManager);
    }

    @Override
    public void update() {
        currentTicks++;
        if(currentTicks>=totalTicks)
            stateManager.setState(mainMenuState);

        color1.add(0.002f,0.003f,0.002f,0);
        color2.add(0.002f,0.002f,0.003f,0);
        color3.add(0.002f,0.002f,0.003f,0);
        color4.add(0.002f,0.003f,0.002f,0);
    }

    @Override
    public void draw(Batch batch) {

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),
                color1,color2,color3,color4);
        shapeRenderer.end();
        batch.begin();
        batch.draw(texture,0,0);
        batch.end();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
        texture.dispose();
    }

    @Override
    public Stage getUI() {
        return stage;
    }

    @Override
    public boolean consoleCommand(String command) {

        if(command.equals("skip")){
            currentTicks = totalTicks;
            return true;
        }

        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        currentTicks = totalTicks;
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        currentTicks = totalTicks;
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }
}
