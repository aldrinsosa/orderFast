package com.sosaco.orderfast.controllers.components;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MenuButton extends VBox {

    public enum Color {
        RED,
        GREEN,
        YELLOW,
        BROWN
    }

    @FXML
    private Button button;

    @FXML
    private Label label;

    private String text;
    private Color color;

    public MenuButton(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sosaco/orderfast/views/components/menu-button.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        label.setText(text);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        String rgbColor = switch (color) {
            case RED -> "#E26D5C";
            case GREEN -> "#C9CBA3";
            case YELLOW -> "#FFE1A8";
            case BROWN -> "#723d46";
        };
        String style = "-fx-background-color: " + rgbColor + ";";
        button.setStyle(style);
    }
}
