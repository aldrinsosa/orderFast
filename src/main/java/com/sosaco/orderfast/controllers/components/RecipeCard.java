package com.sosaco.orderfast.controllers.components;

import com.sosaco.orderfast.utils.TitleUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class RecipeCard extends VBox {
    @FXML
    private StackPane stackPane;
    @FXML
    private HBox buttonsContainer;
    @FXML
    private Text recipeText;

    private Label initialsLabel;
    private String recipeImage;
    private String recipeName;
    private boolean buttons = true;

    public RecipeCard() {
        //make the class a component
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sosaco/orderfast/views/components/recipe-card.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        initialize();
    }

    private void initialize() {
        buttonsContainer.toFront();
    }

    private void createLabel() {
        initialsLabel = new Label("PLI");
        initialsLabel.setStyle("-fx-font-family: \"Alatsi\"; -fx-font-size: 60px; -fx-max-width: 262px; -fx-alignment: center; -fx-text-fill: #22223b; -fx-translate-y: -9;");
        stackPane.getChildren().add(initialsLabel);
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
        recipeText.setText(recipeName);
        if (recipeImage == null){
            createLabel();
            initialsLabel.setText(TitleUtil.getInitials(recipeName));
        }
    }

    public String getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(String recipeImage) {
        this.recipeImage = recipeImage;
    }

    public boolean isButtons() {
        return buttons;
    }

    public void setButtons(boolean buttons) {
        this.buttons = buttons;
        buttonsContainer.setVisible(buttons);
    }
}
