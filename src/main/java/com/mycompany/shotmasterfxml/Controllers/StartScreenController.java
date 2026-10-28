package com.mycompany.shotmasterfxml.Controllers;

import com.mycompany.shotmasterfxml.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class StartScreenController {

    
    @FXML
    private Label titleLabel;
    @FXML
    private Label subTitleLabel;
    @FXML
    private Button playButton;

    private void switchToSecondary() throws IOException {
        
    }

    @FXML
    private void onPlayButtonPressed(ActionEvent event) throws IOException {
        App.setRoot("LevelScreen");
        
    }
    
    
}
