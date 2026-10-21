module com.mycompany.shotmasterfxml {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.shotmasterfxml to javafx.fxml;
    exports com.mycompany.shotmasterfxml;
}
