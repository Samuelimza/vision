package com.simul.vision;

import com.simul.vision.utils.FileUtils;
import com.simul.vision.utils.StoredResources;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class SceneHandler {

    public static Parent loadScene(String sceneSceneFx) {
        FXMLLoader fxmlLoader = new FXMLLoader(FileUtils.getResourceUrl(sceneSceneFx));
        try {
            return fxmlLoader.load();
        } catch (IOException e) {
            System.out.println("Could not load scene: " + sceneSceneFx);
            e.printStackTrace();
        }

        return null;
    }

    public static void changeToMainScene() {
        Parent parent = loadScene(StoredResources.MAIN_VIEW_FX);
        if (parent == null) {
            return;
        }

        MainApp.getInstance().getScene().setRoot(parent);
    }

    public static void changeToGravityScene() {
        Parent parent = loadScene(StoredResources.GRAVITY_VIEW_FX);
        if (parent == null) {
            return;
        }

        MainApp.getInstance().getScene().setRoot(parent);
    }

}
