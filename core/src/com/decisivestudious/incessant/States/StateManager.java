package com.decisivestudious.incessant.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.decisivestudious.incessant.Managers.EventManager;
import com.decisivestudious.incessant.Managers.SocketManager;
import com.decisivestudious.incessant.States.Menus.MainMenuState;

/**
 * Created by Immortan on 7/30/2016.
 */
public class StateManager implements InputProcessor{

    //Management
    private Batch batch;
    private State currentState;
    private State oldState;
    private SocketManager socketManager = new SocketManager();
    private EventManager eventManager = new EventManager();
    private InputMultiplexer inputMultiplexer = new InputMultiplexer();

    //Console
    private boolean isConsoleOpen;
    private static String consoleString;
    private BitmapFont font;

    public StateManager(Batch batch){
        this.batch = batch;
        initializeConsole();
        setState(new SplashState(this));
    }

    //Replaces current state with new state
    //Disposes old state
    public void setState(State newState){
        if(currentState!=null){
            inputMultiplexer.removeProcessor(currentState.getUI());
            currentState.dispose();
        }
        currentState = newState;
        inputMultiplexer.addProcessor(currentState.getUI());
    }

    //Used to preserve previous state (add on menu)
    public void addState(State newState){
        inputMultiplexer.removeProcessor(currentState.getUI());
        oldState = currentState;
        currentState=newState;
        inputMultiplexer.addProcessor(currentState.getUI());
    }

    public void restoreState() {
        if(oldState!=null){
            inputMultiplexer.removeProcessor(currentState.getUI());
            currentState.dispose();
            currentState = oldState;
            inputMultiplexer.addProcessor(currentState.getUI());
            oldState = null;
        }
    }

    public void update(){
        if(!isConsoleOpen)
            currentState.update();
        currentState.draw(batch);

        if(isConsoleOpen){
            batch.begin();
            font.setColor(Color.RED);
            font.draw(batch,"Console:",200,Gdx.graphics.getHeight()-10);
            font.draw(batch,socketManager.getAnswer(),200,Gdx.graphics.getHeight()-22);
            font.setColor(Color.GREEN);
            font.draw(batch,consoleString,200,Gdx.graphics.getHeight()-34);
            batch.end();
        }
    }

    private void initializeConsole(){
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        inputMultiplexer.addProcessor(this);
        consoleString = "";
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    private void openConsole(){
        consoleString = "";
        Gdx.input.setInputProcessor(this);
        //currentState.consoleCommand("pause");
    }

    private void closeConsole(){
        Gdx.input.setInputProcessor(inputMultiplexer);
        consoleString = "";
        //currentState.consoleCommand("pause");
    }

    public InputMultiplexer getInputMultiplexer(){
        return inputMultiplexer;
    }

    private boolean runGlobalCommandCheck(){
        if(consoleString.equals("exit")){
            Gdx.app.exit();
            return true;
        }
        else if(consoleString.equals("getheight")){
            consoleString = ""+Gdx.graphics.getHeight();
            return true;
        }
        else if(consoleString.equals("getwidth")){
            consoleString = ""+Gdx.graphics.getWidth();
            return true;
        }

        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.GRAVE){
            if(isConsoleOpen){
                closeConsole();
                isConsoleOpen = false;
            }
            else{
                openConsole();
                isConsoleOpen = true;
            }
        }

        else if(isConsoleOpen && keycode == Input.Keys.ENTER)
        {
            if(!runGlobalCommandCheck()){
                currentState.consoleCommand(consoleString);
                consoleString = "";
            }
        }

        else if(isConsoleOpen && keycode == Input.Keys.BACKSPACE){
            if(consoleString.length()>0){
                consoleString = consoleString.substring(0,consoleString.length()-1);
            }
        }

        else if(!isConsoleOpen)
            currentState.keyDown(keycode);

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(!isConsoleOpen)
            currentState.keyUp(keycode);
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        if(isConsoleOpen&&Character.isLetter(character))
            consoleString = consoleString + Character.toLowerCase(character);
        else
            currentState.keyTyped(character);
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(!isConsoleOpen)
            currentState.touchDown(screenX,screenY,pointer,button);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(!isConsoleOpen)
            currentState.touchUp(screenX,screenY,pointer,button);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if(!isConsoleOpen)
            currentState.touchDragged(screenX,screenY,pointer);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        if(!isConsoleOpen)
            currentState.mouseMoved(screenX,screenY);
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        if(!isConsoleOpen)
            currentState.scrolled(amount);
        return false;
    }
}
