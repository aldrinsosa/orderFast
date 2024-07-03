package com.sosaco.orderfast.controllers.components;

import com.sosaco.orderfast.enums.ButtonColor;
import com.sosaco.orderfast.enums.ButtonIcon;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Objects;

public class MenuButton extends VBox {
    @FXML
    private Button button;
    @FXML
    private Label label;
    @FXML
    private Region svgPath;

    //props for the icon, color and the text that goes with the button
    private ButtonIcon icon;
    private String text;
    private ButtonColor color;

    public MenuButton(){
        //make the class a component
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sosaco/orderfast/views/components/menu-button.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        initElements();
    }

    private void initElements() {
        //add event listener to the button
        button.setOnMouseClicked(this::changePage);
    }

    private void changePage(MouseEvent e){
        //get the view with the id of the button
        String view = "/com/sosaco/orderfast/views/scenes/" + button.getParent().getId() + "-view.fxml";
        //create the new pane with the view
        Parent pane = null;
        try {
            pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(view)));
        } catch (IOException ex) {
            throw new RuntimeException("could not load the view");
        }
        //set the pane as the new root
        button.getScene().setRoot(pane);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        label.setText(text);
    }

    public ButtonColor getColor() {
        return color;
    }

    public void setColor(ButtonColor color) {
        this.color = color;
        String rgbColor = color.getRgbColor();
        //set the background color according to the props
        String style = "-fx-background-color: " + rgbColor + ";";
        button.setStyle(style);
    }

    public ButtonIcon getIcon() {
        return icon;
    }

    public void setIcon(ButtonIcon icon) {
        this.icon = icon;

        //get the svg and the size of the icon
        String svgIcon  = icon.getSvgPath();
        String svgWidth = icon.getSvgWidth();

        //set the icon and the width of it according to the props
        String shape = " -fx-shape: \"" + svgIcon + "\" ;";
        String width = " -fx-max-width: " + svgWidth + ";";
        //get the current style and the new ones
        String style = svgPath.getStyle() + shape + width;
        svgPath.setStyle(style);
    }

}
