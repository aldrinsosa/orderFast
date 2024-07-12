package com.sosaco.orderfast.controllers.scenes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class NewOrder {

    @FXML
    private Button addButton;

    public void popWindow(MouseEvent mouseEvent) throws IOException {
        final Stage addDish = new Stage();
        addDish.initModality(Modality.APPLICATION_MODAL);
        addDish.initOwner((Stage) addButton.getScene().getWindow());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sosaco/orderfast/views/scenes/addDish-view.fxml"));
        Scene addDishScene = new Scene(loader.load(), 660,675);

        addDish.setTitle("OrderFast - Agregar Platillo");
        Image icon = new Image(Objects.requireNonNull(getClass().getResource("/com/sosaco/orderfast/images/icon.png")).toExternalForm());
        addDish.getIcons().add(icon);
        addDish.setResizable(false);
        addDish.setScene(addDishScene);
        addDish.show();
    }
}
