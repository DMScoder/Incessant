package com.decisivestudious.incessant.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by Immortan on 8/1/2016.
 */
public class Styles {

    public static TextButton.TextButtonStyle basicTextButtonStyle;
    public static Label.LabelStyle labelStyle;

    private Texture UI = new Texture(Gdx.files.internal("UI/MainMenuButtons.png"));
    TextureRegion upRegion = new TextureRegion(UI,0,0,200,35);
    TextureRegion downRegion = new TextureRegion(UI,0,35,200,35);
    BitmapFont buttonFont = new BitmapFont();

    public Styles() {
        basicTextButtonStyle = new TextButton.TextButtonStyle();
        basicTextButtonStyle.up = new TextureRegionDrawable(upRegion);
        basicTextButtonStyle.down = new TextureRegionDrawable(downRegion);
        basicTextButtonStyle.font = buttonFont;

        labelStyle = new Label.LabelStyle();
        labelStyle.font = buttonFont;
    }
}
