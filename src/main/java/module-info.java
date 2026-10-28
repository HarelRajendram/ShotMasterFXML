module com.mycompany.shotmasterfxml {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    
    opens com.mycompany.shotmasterfxml to javafx.fxml;
    opens com.mycompany.shotmasterfxml.Controllers to javafx.fxml;  

    exports com.mycompany.shotmasterfxml;
}