package com.simul.vision.controllers;

import com.simul.vision.SceneHandler;
import javafx.fxml.FXML;

public class GravityController {

    @FXML
    protected void onExitClick() {
        SceneHandler.changeToMainScene();
    }

    @FXML
    protected void onStopClick() {
        SceneHandler.changeToMainScene();
    }

}
