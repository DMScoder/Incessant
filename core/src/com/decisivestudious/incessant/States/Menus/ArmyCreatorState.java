package com.decisivestudious.incessant.States.Menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.decisivestudious.incessant.States.State;
import com.decisivestudious.incessant.States.StateManager;

/**
 * Created by Immortan on 7/31/2016.
 */
public class ArmyCreatorState implements State {

    private StateManager stateManager;
    private Stage stage;

    public ArmyCreatorState(StateManager stateManager){
        this.stateManager = stateManager;
        initializeLayout();
    }

    private void initializeLayout(){
        stage = new Stage();
        Table root = new Table();
        root.setFillParent(true);
        stage.addActor(root);
        initializeTacticsSelection(root);
        initializeUnitSelection(root);
        initializeSelectedUnits(root);
        initializeEquipment(root);
    }

    private void initializeEquipment(Table root) {

    }

    private void initializeSelectedUnits(Table root) {
    }

    private void initializeUnitSelection(Table root) {
    }

    private void initializeTacticsSelection(Table root) {
    }

    @Override
    public void update() {
        stage.act();
    }

    @Override
    public void draw(Batch batch) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
    }

    @Override
    public void dispose() {

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
