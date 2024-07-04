package com.sosaco.orderfast.controllers.components;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;

import java.io.IOException;

public class OrderItemList extends HBox {
    @FXML
    private Text orderText;
    @FXML
    private Label orderAmount;
    @FXML
    private Region deleteButton;

    private String order;
    private int amount;

    public OrderItemList() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sosaco/orderfast/views/components/order-item-list.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
        orderAmount.setText(Integer.toString(amount));
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
        orderText.setText(order);
    }
}
