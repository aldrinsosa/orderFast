package com.sosaco.orderfast.controllers.scenes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.Objects;

public class Recipes {
    public Button newDishButton;


    public void createDish(MouseEvent mouseEvent) {
        //get the view with the id of the button
        String view = "/com/sosaco/orderfast/views/scenes/createEditDish-view.fxml";
        //create the new pane with the view
        Parent pane = null;
        try {
            pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(view)));
        } catch (IOException ex) {
            throw new RuntimeException("could not load the view");
        }
        //set the pane as the new root
        newDishButton.getScene().setRoot(pane);
    }
}
