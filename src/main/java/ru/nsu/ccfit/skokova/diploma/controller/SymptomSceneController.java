package ru.nsu.ccfit.skokova.diploma.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SymptomSceneController {
    public VBox box;
    public TextArea input;
    public Button submit;

    public SymptomSceneController() {

    }

    public void goNext(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass()
                    .getClassLoader()
                    .getResource("loss_scene.fxml")));
            Scene scene = new Scene(root, 200, 400);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
