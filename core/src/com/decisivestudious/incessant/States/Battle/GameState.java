package com.decisivestudious.incessant.States.Battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.decisivestudious.incessant.States.State;
import com.decisivestudious.incessant.States.StateManager;

/**
 * Created by Immortan on 7/30/2016.
 */
public class GameState implements State {

    private Stage stage;
    private StateManager stateManager;
    private Texture texture = new Texture(Gdx.files.internal("World/Incessant_Tile_Base.png"));
    private OrthographicCamera camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
    private Viewport viewport = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),camera);

    public GameState(StateManager stateManager){
        this.stateManager = stateManager;
        stage = new Stage();
        stage.setViewport(viewport);
    }

    @Override
    public void update() {
        stage.act();
        camera.update();
    }

    @Override
    public void draw(Batch batch) {
        Gdx.gl.glClearColor(34f/256f,139f/256f,34f/256f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        for(int i=0;i<50;i++){
            for(int j=0;j<50;j++){
                batch.draw(texture,i*128,j*64);
            }
        }
        batch.end();
        //stage.draw();
    }

    @Override
    public void dispose() {
        stage.clear();
        stage.dispose();
    }

    @Override
    public void socketMessage(String string) {

    }

    @Override
    public Stage getUI() {
        return stage;
    }

    @Override
    public boolean consoleCommand(String command) {
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
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
