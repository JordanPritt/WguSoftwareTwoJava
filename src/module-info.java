module softwaretwo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;

    opens softwaretwo to javafx.fxml;
    exports softwaretwo;

    opens softwaretwo.userInterface.controller to javafx.fxml;
    exports softwaretwo.userInterface.controller;

    opens softwaretwo.userInterface.model to javafx.fxml;
    exports softwaretwo.userInterface.model;
}