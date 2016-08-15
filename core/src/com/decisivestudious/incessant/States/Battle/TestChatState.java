package com.decisivestudious.incessant.States.Battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.decisivestudious.incessant.Managers.SocketManager;
import com.decisivestudious.incessant.States.Menus.MainMenuState;
import com.decisivestudious.incessant.States.State;
import com.decisivestudious.incessant.States.StateManager;
import com.decisivestudious.incessant.UI.Styles;

import java.util.LinkedList;

/**
 * Created by Immortan on 8/1/2016.
 */
public class TestChatState implements State {

    StateManager statemanager;
    Stage stage = new Stage();
    Table table;
    BitmapFont font = new BitmapFont();

    //Name selection
    boolean nameSelection = true;
    String displayName = "";
    Label nameField;

    //Messaging client
    private LinkedList <String> messages = new LinkedList<String>();
    private SocketManager socketManager;
    private String currentMessage="";
    private int maxMessages = 20;
    Label messageArea;

    public TestChatState(StateManager statemanager){
        this.statemanager = statemanager;

        socketManager = statemanager.getSocketManager();
        socketManager.startService(this);

        initializeButtons();
    }

    private void sendMessage() {
        if(currentMessage.length()==0)
            return;
        socketManager.transferString("Message"+currentMessage);
        messages.add(displayName+": "+currentMessage);
        currentMessage = "";
        messageArea.setText(currentMessage);
        if(messages.size()>maxMessages)
            messages.removeFirst();
    }

    private void createTextTable(){
        socketManager.transferString("Entering"+displayName);

        table.clear();
        final Label messageHeader = new Label("Message:",Styles.labelStyle);
        table.add(messageHeader);
        messageArea = new Label("",Styles.labelStyle);
        messageArea.setWidth(1400);
        table.add(messageArea);

        TextButton submitButton = new TextButton("Send", Styles.basicTextButtonStyle);
            submitButton.addListener(new ClickListener(){
                public void clicked(InputEvent event, float x, float y){
                    sendMessage();
                }
        });
        TextButton exit = new TextButton("Exit", Styles.basicTextButtonStyle);
        exit.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                socketManager.endService();
                statemanager.setState(new MainMenuState(statemanager));
            }
        });

        table.row();
        table.add(submitButton);
        table.add(exit);
    }

    private void initializeButtons() {
        table = new Table();

        table.setFillParent(true);
        table.align(Align.center);
        stage.addActor(table);

        Label label = new Label("Enter your display name:",Styles.labelStyle);
        table.add(label);
        nameField = new Label("",Styles.labelStyle);
        nameField.setWidth(500);
        table.add(nameField);
        table.row();

        TextButton.TextButtonStyle textButtonStyle = Styles.basicTextButtonStyle;

        TextButton submitButton = new TextButton("Done",textButtonStyle);
        submitButton.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                if(displayName.length()>2){
                    nameSelection = false;
                    createTextTable();
                }
                else
                    displayName = "Too short!";
            }
        });

        TextButton backbutton = new TextButton("Back",textButtonStyle);
        backbutton.addListener(new ClickListener(){
           public void clicked(InputEvent event, float x, float y){
                statemanager.setState(new MainMenuState(statemanager));
           }
        });
        table.add();
        table.add(submitButton);
        table.add(backbutton);
    }

    public void socketMessage(String string) {
        messages.add(string);
        if(messages.size()>maxMessages)
            messages.removeFirst();
    }

    @Override
    public void update() {
        stage.act();
    }

    @Override
    public void draw(Batch batch) {
        stage.draw();
        batch.begin();
        for(int i=0;i<maxMessages&&i<messages.size();i++){
            font.draw(batch,messages.get(i),40,Gdx.graphics.getHeight()-(i*15+15));
        }
        batch.end();
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

    @Override
    public boolean consoleCommand(String command) {
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        if(nameSelection){
            if(keycode == Input.Keys.BACKSPACE&&displayName.length()>0) {
                displayName = displayName.substring(0,displayName.length()-1);
                nameField.setText(displayName);
            }
        }

        else if(!nameSelection){
            if(keycode == Input.Keys.BACKSPACE&&currentMessage.length()>0) {
                currentMessage = currentMessage.substring(0,currentMessage.length()-1);
                messageArea.setText(currentMessage);
            }
            else if(keycode == Input.Keys.ENTER)
                sendMessage();
        }
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

        if(nameSelection){
            if(Character.isLetterOrDigit(character)&&displayName.length()<26){
                displayName = displayName + character;
                nameField.setText(displayName);
            }
        }
        else if(!nameSelection){
            if((Character.isLetterOrDigit(character)||character==' ')&&displayName.length()<100){
                currentMessage = currentMessage + character;
                messageArea.setText(currentMessage);
            }
        }


        return false;
    }
}
