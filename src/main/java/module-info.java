module com.mycompany.shotmasterfxml {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    
    opens com.mycompany.shotmasterfxml to javafx.fxml;
<<<<<<< HEAD
    opens com.mycompany.shotmasterfxml.Controllers to javafx.fxml; 
//    opens com.mycompany.shotmasterfxml.images to javafx.fxml;
=======
    opens com.mycompany.shotmasterfxml.Controllers to javafx.fxml;  
>>>>>>> f0caa73138df163ac9e7d2120f1924a7eb8837ba

    exports com.mycompany.shotmasterfxml;
}