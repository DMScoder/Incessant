package com.decisivestudious.incessant.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by Immortan on 8/1/2016.
 */
public class Styles {

    public static TextButton.TextButtonStyle basicTextButtonStyle;
    public static Label.LabelStyle labelStyle;
    public static TextButton.TextButtonStyle togglableTextButtonStyle;
    public static TextField.TextFieldStyle textFieldStyle;

    private Texture UI = new Texture(Gdx.files.internal("UI/MainMenuButtons.png"));
    TextureRegion upRegion = new TextureRegion(UI,0,0,200,35);
    TextureRegion downRegion = new TextureRegion(UI,0,35,200,35);
    BitmapFont buttonFont = new BitmapFont();

    public Styles() {
        basicTextButtonStyle = new TextButton.TextButtonStyle();
        basicTextButtonStyle.up = new TextureRegionDrawable(upRegion);
        basicTextButtonStyle.over = new TextureRegionDrawable(downRegion);
        basicTextButtonStyle.font = buttonFont;

        togglableTextButtonStyle = new TextButton.TextButtonStyle();
        togglableTextButtonStyle.up = new TextureRegionDrawable(upRegion);
        togglableTextButtonStyle.checked = new TextureRegionDrawable(downRegion);
        togglableTextButtonStyle.font = buttonFont;

        textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.font = buttonFont;
        textFieldStyle.background = new TextureRegionDrawable(downRegion);
        textFieldStyle.fontColor = Color.BLUE;

        labelStyle = new Label.LabelStyle();
        labelStyle.font = buttonFont;
    }
}
