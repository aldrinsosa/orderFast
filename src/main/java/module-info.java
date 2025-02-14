module com.sosaco.chefcontrol {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sosaco.orderfast to javafx.fxml;
    opens com.sosaco.orderfast.controllers.components to javafx.fxml;
    opens com.sosaco.orderfast.controllers.scenes to javafx.fxml;
    opens com.sosaco.orderfast.enums to javafx.fxml;
    opens com.sosaco.orderfast.utils to javafx.fxml;
    exports com.sosaco.orderfast.controllers.components;
    exports com.sosaco.orderfast.controllers.scenes;
    exports com.sosaco.orderfast.enums;
    exports com.sosaco.orderfast.utils;
    exports com.sosaco.orderfast;
}