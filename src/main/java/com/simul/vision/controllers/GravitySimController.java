package com.simul.vision.controllers;

import com.simul.vision.SceneHandler;
import com.simul.vision.events.EventHandler;
import com.simul.vision.events.GravitySimEvent;
import javafx.fxml.FXML;

public class GravitySimController implements FxController {

    @FXML
    protected void onExitClick() {
        SceneHandler.changeToMainScene();
    }

    @FXML
    protected void onStopClick() {
        EventHandler.getInstance().fireEvent(GravitySimEvent.STOP_EVENT);
    }

}
