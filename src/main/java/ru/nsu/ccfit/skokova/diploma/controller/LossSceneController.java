package ru.nsu.ccfit.skokova.diploma.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import ru.nsu.ccfit.skokova.diploma.model.CaseHolder;

import java.io.IOException;
import java.util.Objects;

public class LossSceneController {
    public TextArea input;
    public Button submit;
    public Button previous;

    public void goNext(ActionEvent actionEvent) {
        try {
            CaseHolder.setLoss(input.getText());

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass()
                    .getClassLoader()
                    .getResource("vulnerability_scene.fxml")));
            Scene scene = new Scene(root, 200, 400);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goBack(ActionEvent actionEvent) {
        try {
            CaseHolder.setLoss(input.getText());

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass()
                    .getClassLoader()
                    .getResource("symptom_scene.fxml")));
            Scene scene = new Scene(root, 200, 400);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
