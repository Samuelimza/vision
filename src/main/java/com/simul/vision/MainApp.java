package com.simul.vision;

import com.simul.vision.utils.FileUtils;
import com.simul.vision.utils.StoredResources;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainApp extends Application {

    public static MainApp instance;

    private Stage stage;
    private Scene scene;

    public static MainApp getInstance() {
        if (instance == null) {
            new Thread(Application::launch).start();
        }

        while (instance == null) {
            try {
                Thread.sleep(100);
            } catch (Exception ignored) {
            }
        }

        return instance;
    }

    public MainApp() {
        instance = this;
    }

    public Stage getStage() {
        return stage;
    }

    public Scene getScene() {
        return scene;
    }

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        this.scene = constructMainScene();

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    private Scene constructMainScene() throws IOException {
        URL url = FileUtils.getResourceUrl(StoredResources.MAIN_VIEW_FX);
        FXMLLoader fxmlLoader = new FXMLLoader(url);

        Scene scene = new Scene(fxmlLoader.load(), 640, 360);
        return scene;
    }

    public static void main(String[] args) {
        MainApp.getInstance();
    }

}