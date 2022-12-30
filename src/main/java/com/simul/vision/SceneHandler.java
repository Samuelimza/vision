package com.simul.vision;

import com.simul.vision.controllers.FxController;
import com.simul.vision.controllers.GravitySimController;
import com.simul.vision.simulations.GravitySimulation;
import com.simul.vision.utils.FileUtils;
import com.simul.vision.utils.ListUtils;
import com.simul.vision.utils.StoredResources;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SceneHandler {

    private static List<RunnableTask> runningTasks = new ArrayList<>();

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
        if(ListUtils.isValid(runningTasks)) {
            for (RunnableTask task : runningTasks) {
                task.stop();
            }
        }
        loadScene(StoredResources.MAIN_VIEW_FX);
    }

    public static void changeToGravityScene() {
        FxController controller = loadScene(StoredResources.GRAVITY_VIEW_FX);
        if (!(controller instanceof GravitySimController gravitySimController)) {
            return;
        }

        GravitySimulation simulation = new GravitySimulation(gravitySimController);
        simulation.start();

        runningTasks.add(simulation);
    }

}
