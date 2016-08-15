package com.decisivestudious.incessant.Managers.Events;

import com.decisivestudious.incessant.States.StateManager;

/**
 * Created by Immortan on 7/30/2016.
 */
public class EventManager {

    private StateManager stateManager;

    public EventManager(StateManager stateManager){
        this.stateManager = stateManager;
    }
}
