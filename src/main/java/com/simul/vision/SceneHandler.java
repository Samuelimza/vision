package com.simul.vision;

import com.simul.vision.controllers.FxController;
import com.simul.vision.controllers.GravitySimController;
import com.simul.vision.simulations.GravitySimulation;
import com.simul.vision.utils.FileUtils;
import com.simul.vision.utils.StoredResources;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class SceneHandler {

    public static FxController loadScene(String sceneSceneFx) {
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
        FxController controller = loadScene(StoredResources.GRAVITY_VIEW_FX);
        if (!(controller instanceof GravitySimController gravitySimController)) {
            return;
        }

        GravitySimulation simulation = new GravitySimulation(gravitySimController);
        simulation.run();
    }

}
