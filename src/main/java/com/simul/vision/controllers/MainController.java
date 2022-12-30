package com.simul.vision.controllers;

import com.simul.vision.SceneHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onGravitySimClick() {
        SceneHandler.changeToGravityScene();
    }

}