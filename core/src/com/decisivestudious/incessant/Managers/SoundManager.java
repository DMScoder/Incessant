package com.decisivestudious.incessant.Managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

/**
 * Created by Immortan on 7/30/2016.
 */
public class SoundManager {

    public Music[] menuMusic = {Gdx.audio.newMusic(Gdx.files.internal("Audio/SovietMarch.mp3")),
            Gdx.audio.newMusic(Gdx.files.internal("Audio/Templars.mp3")),
            Gdx.audio.newMusic(Gdx.files.internal("Audio/WarcraftTheme.mp3"))};

    Music currentMusic = null;

    public SoundManager(){

    }

    public void playMusic(int number){
        if(currentMusic!=null)
            currentMusic.stop();
        currentMusic = menuMusic[number];
        currentMusic.play();
    }
}
