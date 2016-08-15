package com.decisivestudious.incessant.States.Battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.decisivestudious.incessant.States.Menus.ArmyCreatorState;
import com.decisivestudious.incessant.States.Menus.MainMenuState;
import com.decisivestudious.incessant.States.State;
import com.decisivestudious.incessant.States.StateManager;
import com.decisivestudious.incessant.UI.Styles;

import java.util.Random;

/**
 * Created by Immortan on 8/15/2016.
 */
public class BattleSelectionState implements State {

    private StateManager stateManager;
    private Stage stage;
    private Table root;

    //Deck options
    private Table deckSelector;
    private Texture RomeIcon = new Texture(Gdx.files.internal("UI/RomeIcon.jpg"));
    private Texture JapanIcon = new Texture(Gdx.files.internal("UI/JapanIcon.jpg"));
    private Texture MedievalIcon = new Texture(Gdx.files.internal("UI/MedievalIcon.jpg"));

    //Battle options
    private Table options;
    TextButton smallSize;
    TextButton mediumSize;
    TextButton epicSize;

    public BattleSelectionState(StateManager stateManager){
        this.stateManager = stateManager;
        layoutButtons();
    }

    private void layoutButtons() {
        //Create stage and root table
        stage = new Stage();
        root = new Table();
        root.setFillParent(true);
        root.setDebug(true);
        stage.addActor(root);

        //Create sub tables
        options = new Table();
        deckSelector = new Table();

        options.align(Align.left);
        deckSelector.align(Align.right);

        root.add(options);
        root.add(deckSelector);

        TextButton.TextButtonStyle textStyle = Styles.basicTextButtonStyle;
        TextButton.TextButtonStyle toggleStyle = Styles.togglableTextButtonStyle;
        Label.LabelStyle labelStyle = Styles.labelStyle;


        /**Battle options*/
        Label battleOptionTitle = new Label("Battle Options",labelStyle);
        options.add(battleOptionTitle).colspan(3);
        options.row();

        Label battleSize = new Label("Battle Size",labelStyle);
        options.add(battleSize).colspan(3);
        options.row();

        smallSize = new TextButton("Savage Skirmish (1500)",toggleStyle);
        smallSize.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                smallSize.setChecked(true);
                mediumSize.setChecked(false);
                epicSize.setChecked(false);
            }
        });
        mediumSize = new TextButton("Decisive Engagement (10000)",toggleStyle);
        mediumSize.setChecked(true);
        mediumSize.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                smallSize.setChecked(false);
                mediumSize.setChecked(true);
                epicSize.setChecked(false);
            }
        });
        epicSize = new TextButton("Epic Clash (30000)",toggleStyle);
        epicSize.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                smallSize.setChecked(false);
                mediumSize.setChecked(false);
                epicSize.setChecked(true);
            }
        });

        options.add(smallSize).pad(10);
        options.add(mediumSize).pad(10);
        options.add(epicSize).pad(10);

        options.row();

        TextButton search = new TextButton("Search", textStyle);
        search.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){

            }
        });

        TextButton back = new TextButton("Back", textStyle);
        back.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                stateManager.setState(new MainMenuState(stateManager));
            }
        });

        options.add(search).spaceTop(300);
        options.add(back).spaceTop(300).spaceLeft(400);

        /**Deck selector options*/
        Label deckSelectorTitle = new Label("Select Army",labelStyle);
        deckSelector.add(deckSelectorTitle);
        deckSelector.row();

        Table scrollTable = populateScrollTable();

        ScrollPane scrollPane = new ScrollPane(scrollTable);
        deckSelector.add(scrollPane).height(500);
        deckSelector.row();

        TextButton addArmy = new TextButton("Add Army",textStyle);
        addArmy.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                stateManager.setState(new ArmyCreatorState(stateManager));
            }
        });

        deckSelector.add(addArmy);
    }

    private Table populateScrollTable() {
        Table scrollTable = new Table();
        Random random = new Random();

        for(int i=0;i<100;i++){
            int faction = random.nextInt(3);

            Image image = null;
            if(faction==0){
                image = new Image(RomeIcon);
            }
            else if(faction==1)
                image = new Image(JapanIcon);

            else
                image = new Image(MedievalIcon);

            scrollTable.add(image).size(30,30);

            scrollTable.add(new Label("Text"+i,Styles.labelStyle));
            scrollTable.row();
        }

        return scrollTable;
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
