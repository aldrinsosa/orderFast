package com.sosaco.orderfast.controllers.components;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.FlowPane;

import java.io.IOException;

public class MenuBar extends FlowPane {
   public MenuBar(){
       //make the class a component
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sosaco/orderfast/views/components/menu-bar.fxml"));
        loader.setController(this);
        loader.setRoot(this);
       //let the nested components load first
       loader.setClassLoader(getClass().getClassLoader());
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
