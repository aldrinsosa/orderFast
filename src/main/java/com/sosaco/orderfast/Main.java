package com.sosaco.orderfast;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("views/scenes/orders-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);

        //load custom font
        Font.loadFont(Objects.requireNonNull(getClass().getResource("fonts/Alatsi.ttf")).toExternalForm(), 13);

        stage.setTitle("OrderFast");
        Image icon = new Image("icon.png");
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}