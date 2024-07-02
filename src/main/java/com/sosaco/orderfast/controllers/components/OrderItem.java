package com.sosaco.orderfast.controllers.components;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class OrderItem extends HBox {

    @FXML
    private Text recipeText;

    @FXML
    private Label amountLabel;

    //props of the component with the name of the recipe and the amount that has been ordered
    private String recipe;
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
        amountLabel.setText(Integer.toString(amount));
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
        recipeText.setText(recipe);
    }

    public OrderItem() {
        //make the class a component
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sosaco/orderfast/views/components/order-item.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
