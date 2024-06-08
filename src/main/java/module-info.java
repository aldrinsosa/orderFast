module com.sosaco.chefcontrol {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sosaco.orderfast to javafx.fxml;
    exports com.sosaco.orderfast;
}