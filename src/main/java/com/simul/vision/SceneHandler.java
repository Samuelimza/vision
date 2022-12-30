package com.simul.vision;

import com.simul.vision.controllers.GravityController;
import com.simul.vision.simulations.gravitysim.GravitySimulation;
import com.simul.vision.utils.FileUtils;
import com.simul.vision.utils.StoredResources;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class SceneHandler {

    public static <T> T loadScene(String sceneSceneFx) {
        FXMLLoader fxmlLoader = new FXMLLoader(FileUtils.getResourceUrl(sceneSceneFx));
        try {
            Parent parent = fxmlLoader.load();
            MainApp.getInstance().getScene().setRoot(parent);

            return fxmlLoader.getController();
        } catch (IOException e) {
            System.out.println("Could not load scene: " + sceneSceneFx);
            e.printStackTrace();
        }

        return null;
    }

    public static void changeToMainScene() {
        loadScene(StoredResources.MAIN_VIEW_FX);
    }

    public static void changeToGravityScene() {
        GravityController controller = loadScene(StoredResources.GRAVITY_VIEW_FX);
        if (controller == null) {
            return;
        }

        GravitySimulation simulation = new GravitySimulation(controller);
        simulation.run();
    }

}
