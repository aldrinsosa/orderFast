package com.sosaco.orderfast.controllers.components;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class OrderCard extends VBox {

    @FXML
    private Label tableLabel;

    private int table;

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
        tableLabel.setText(Integer.toString(table));
    }

    public OrderCard() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sosaco/orderfast/views/components/order-card.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
