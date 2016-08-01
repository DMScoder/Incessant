package com.decisivestudious.incessant.States.Menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.decisivestudious.incessant.States.State;
import com.decisivestudious.incessant.States.StateManager;

import java.util.Random;

/**
 * Created by Immortan on 7/30/2016.
 */
public class MainMenuState implements State{

    private boolean paused;
    private MainMenuState mainMenuState = this;
    private StateManager stateManager;
    private Stage stage;
    private Texture background;
    private Texture menuTitle = new Texture(Gdx.files.internal("UI/YeOlde.png"));
    private Table table;
    private Texture UI = new Texture(Gdx.files.internal("UI/MainMenuButtons.png"));
    TextureRegion upRegion = new TextureRegion(UI,0,0,200,35);
    TextureRegion downRegion = new TextureRegion(UI,0,35,200,35);
    BitmapFont buttonFont = new BitmapFont();

    public MainMenuState(StateManager stateManager){
        this.stateManager = stateManager;
        createBackground();
        layoutButtons();
    }

    @Override
    public void update() {
        stage.act(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void draw(Batch batch) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.clear();
        stage.dispose();
    }

    @Override
    public Stage getUI() {
        return stage;
    }

    private void createBackground(){
        //Select background
        Random random = new Random();
        int backgroundNumber = random.nextInt(5)+1;
        background = new Texture(Gdx.files.internal("Artwork/background"+backgroundNumber+".jpeg"));

        //Add to stage
        stage = new Stage();
        Actor actor = new Image(background);
        actor.setBounds(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        stage.addActor(actor);
    }

    private void layoutButtons(){
        table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.up = new TextureRegionDrawable(upRegion);
        style.over = new TextureRegionDrawable(downRegion);
        style.font = buttonFont;

        Image image = new Image(menuTitle);
        table.add(image);
        table.row();

        //Quick Battle button
        TextButton button1 = new TextButton("Quick Battle", style);
        button1.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){

            }
        });
        table.add(button1);
        table.row();

        //Army viewer button
        TextButton button2 = new TextButton("Army Viewer", style);
        button2.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){

            }
        });
        table.add(button2);
        table.row();

        //Campaign Button
        TextButton button3 = new TextButton("Campaign", style);
        button3.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){

            }
        });
        table.add(button3);
        table.row();

        //Settings button
        TextButton button4 = new TextButton("Settings", style);
        button4.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                stateManager.addState(new SettingsState(stateManager,mainMenuState));
            }
        });
        table.add(button4);
        table.row();

        //Exit button
        TextButton button5 = new TextButton("Exit", style);
        button5.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                Gdx.app.exit();
            }
        });
        table.add(button5);
    }

    @Override
    public boolean consoleCommand(String command) {
        if(command.equals("pause")){
        }

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
