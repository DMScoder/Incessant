package com.decisivestudious.incessant.States.Battle.DeckStructure;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Immortan on 8/18/2016.
 */
public interface Card {

    Texture getTexture();
    String getName();
    String getFaction();
    String getCardType();
}
