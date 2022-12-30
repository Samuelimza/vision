package com.simul.vision.controllers;

import com.simul.vision.SceneHandler;
import com.simul.vision.event.EventHandler;
import com.simul.vision.simulations.gravitysim.GravitySimEvent;
import javafx.fxml.FXML;

public class GravityController {

    @FXML
    protected void onExitClick() {
        SceneHandler.changeToMainScene();
    }

    @FXML
    protected void onStopClick() {
        EventHandler.getInstance().fireEvent(GravitySimEvent.STOP_EVENT);
    }

}
