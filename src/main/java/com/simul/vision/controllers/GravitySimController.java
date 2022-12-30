package com.simul.vision.controllers;

import com.simul.vision.SceneHandler;
import com.simul.vision.events.EventHandler;
import com.simul.vision.events.GravitySimEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;

public class GravitySimController implements FxController {

    @FXML
    public Canvas canvas;

    @FXML
    protected void onExitClick() {
        SceneHandler.changeToMainScene();
    }

    @FXML
    protected void onStopClick() {
        EventHandler.getInstance().fireEvent(GravitySimEvent.STOP_EVENT);
    }

}
