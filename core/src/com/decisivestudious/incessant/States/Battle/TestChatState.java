package com.decisivestudious.incessant.States.Battle;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.decisivestudious.incessant.States.State;
import com.decisivestudious.incessant.States.StateManager;
import com.decisivestudious.incessant.UI.Styles;

/**
 * Created by Immortan on 8/1/2016.
 */
public class TestChatState implements State {

    StateManager statemanager;
    Stage stage = new Stage();
    Table table;
    String displayName = null;
    Label nameField;

    public TestChatState(StateManager statemanager){
        this.statemanager = statemanager;
        initializeButtons();
    }

    private void initializeButtons() {
        table = new Table();

        table.setFillParent(true);
        stage.addActor(table);

        Label label = new Label("Enter your display name:",Styles.labelStyle);
        table.add(label);
        table.row();

        nameField = new Label("",Styles.labelStyle);
        nameField.setWidth(500);

        TextButton.TextButtonStyle textButtonStyle = Styles.basicTextButtonStyle;

        TextButton submitButton = new TextButton("Done",textButtonStyle);
        submitButton.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){

            }
        });

        TextButton backbutton = new TextButton("Back",textButtonStyle);
        backbutton.addListener(new ClickListener(){
           public void clicked(InputEvent event, float x, float y){

           }
        });
        table.add();
        table.add(submitButton);
        table.add(backbutton);
    }

    @Override
    public void update() {
        nameField.setText(displayName);
    }

    @Override
    public void draw(Batch batch) {

    }

    @Override
    public void dispose() {

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
