package com.decisivestudious.incessant.States.Menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.decisivestudious.incessant.States.State;
import com.decisivestudious.incessant.States.StateManager;

/**
 * Created by Immortan on 7/31/2016.
 */
public class SettingsState implements State{

    MainMenuState mainMenuState;
    StateManager stateManager;
    Stage stage = new Stage();
    Table table = new Table();
    ShapeRenderer shapeRenderer = new ShapeRenderer();
    Texture UI = new Texture(Gdx.files.internal("UI/MainMenuButtons.png"));
    TextureRegion upRegion = new TextureRegion(UI,0,0,200,35);
    TextureRegion downRegion = new TextureRegion(UI,0,35,200,35);
    BitmapFont buttonFont = new BitmapFont();

    public SettingsState(StateManager stateManager, MainMenuState mainMenuState){
        this.stateManager=stateManager;
        this.mainMenuState=mainMenuState;
        initializeLayout();
    }

    private void initializeLayout() {
        stage.addActor(table);
        table.setSize(800,600);
        table.center();
        table.setFillParent(true);

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.up = new TextureRegionDrawable(upRegion);
        style.over = new TextureRegionDrawable(downRegion);
        style.font = buttonFont;

        TextButton button1 = new TextButton("Settings go here", style);
        button1.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                stateManager.restoreState();
            }
        });
        table.add(button1);

        TextButton button2 = new TextButton("Back", style);
        button2.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                stateManager.restoreState();
            }
        });
        table.add(button2);
        //table.setWidth(Gdx.graphics.getWidth()/3);
        //table.setHeight(Gdx.graphics.getHeight()/3);
    }

    @Override
    public void update() {
        stage.act(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void draw(Batch batch) {
        mainMenuState.draw(batch);
        /*shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(table.getX(),table.getY(),table.getWidth(),table.getHeight());
        shapeRenderer.end();*/
        stage.draw();
    }

    @Override
    public void dispose() {
        UI.dispose();
        stage.clear();
        stage.dispose();
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
