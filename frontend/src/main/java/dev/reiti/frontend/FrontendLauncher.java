package dev.reiti.frontend;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FrontendLauncher extends Application {

    private final JavaFXFrontend backendLogic = new JavaFXFrontend();

    @Override
    public void start(Stage primaryStage) {
        TextField brandInput = new TextField();
        brandInput.setPromptText("Brand");
        TextField modelInput = new TextField();
        modelInput.setPromptText("Model");

        Button addBtn = new Button("Add car");

        Label displayLabel = new Label("No data loaded yet...");
        displayLabel.setWrapText(true);

        ScrollPane scrollPane = new ScrollPane(displayLabel);
        scrollPane.setPrefHeight(150);

        Button refreshBtn = new Button("Load list");
        refreshBtn.setOnAction(e -> {
            displayLabel.setText("Loading...");
            backendLogic.loadCars(jsonString -> {
                Platform.runLater(() -> displayLabel.setText(jsonString));
            });
        });

        addBtn.setOnAction(e -> backendLogic.addCar(brandInput.getText(), modelInput.getText()));

        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(brandInput, modelInput, addBtn, refreshBtn, scrollPane);

        Scene scene = new Scene(root, 450, 450);
        primaryStage.setTitle("Car Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}