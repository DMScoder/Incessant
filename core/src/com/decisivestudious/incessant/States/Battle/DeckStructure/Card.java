package com.decisivestudious.incessant.States.Battle.DeckStructure;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

/**
 * Created by Immortan on 8/18/2016.
 */
public abstract class Card extends ImageButton{

    public Card(Drawable imageUp, Drawable imageDown){
        super(imageUp,imageDown);
    }

    public String getCardName(){
        return "The name was not overridden";
    }

    public String getFaction(){
        return "The faction was not overridden";
    }

    public String cardType(){
        return "The cardType was not overridden";
    }
}
