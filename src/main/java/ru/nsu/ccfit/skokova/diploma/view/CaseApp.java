package ru.nsu.ccfit.skokova.diploma.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Objects;

public class CaseApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("Case data");
            primaryStage.setResizable(false);

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass()
                    .getClassLoader()
                    .getResource("symptom_scene.fxml")));
            Scene scene = new Scene(root, 200, 400);
            primaryStage.setScene(scene);

            primaryStage.show();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
