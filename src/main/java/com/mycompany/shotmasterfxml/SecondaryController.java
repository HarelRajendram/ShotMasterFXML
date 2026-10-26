package com.mycompany.shotmasterfxml;

import com.mycompany.shotmasterfxml.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SecondaryController {

    @FXML
    private Button secondaryButton;
    @FXML
    private Button helloWorldButton;
    @FXML
    private Label myLabel;
    @FXML
    private Label label1;
    @FXML
    private Button helloWorldButton1;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("StartScreen");
    }

    @FXML
    private void onButtonClicked(ActionEvent event) {
        
      myLabel.setText("Hello guys");
        
        
        
    }

    @FXML
    private void onButtonClicked1(ActionEvent event) {
        
        label1.setText("Hello World");
    }
    
    
}