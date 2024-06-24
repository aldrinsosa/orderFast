module com.sosaco.chefcontrol {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sosaco.orderfast to javafx.fxml;
    opens com.sosaco.orderfast.controllers.components to javafx.fxml;
    opens com.sosaco.orderfast.controllers.scenes to javafx.fxml;
    exports com.sosaco.orderfast.controllers.components;
    exports com.sosaco.orderfast.controllers.scenes;
    exports com.sosaco.orderfast;
}