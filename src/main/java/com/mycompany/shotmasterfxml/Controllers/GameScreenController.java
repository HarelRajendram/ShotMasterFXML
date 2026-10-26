package com.mycompany.shotmasterfxml.Controllers;

import com.mycompany.shotmasterfxml.App;
import com.mycompany.shotmasterfxml.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class GameScreenController {

    @FXML
    private BorderPane mainContainer;
    @FXML
    private Slider angleSlider;
    @FXML
    private Slider velocitySlider;
    @FXML
    private TextField velocityTextField;
    @FXML
    private TextField angleTextField;
    @FXML
    private Button startButton;
    @FXML
    private VBox goalStats;
    @FXML
    private Label distanceLabel;
    @FXML
    private Button backButton;

    private double angle = 0;
    private double velocity = 0;
    
    public void initialize() {
        
        angleSlider.valueProperty().addListener((obs, oldValue, newValue) -> {
            angle = newValue.intValue();
        });
        
        velocitySlider.valueProperty().addListener((obs, oldValue, newValue) -> {
            velocity = newValue.intValue();
        });
        
        angleTextField.textProperty().bind(angleSlider.valueProperty()
            .asString("%.2f"));
        
        velocityTextField.textProperty().bind(velocitySlider.valueProperty()
            .asString("%.2f"));
    }
    
    public void loadSubScene(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            
            Parent subView = loader.load();
            
            mainContainer.setCenter(subView); 
            
        } catch (IOException e) {
            System.err.println("Error loading sub-FXML file: " + fxmlPath);
            e.printStackTrace();
        }
    }
    

    @FXML
    private void onAngleDrag(MouseEvent event) {
    }

    @FXML
    private void onVelocityDrag(MouseEvent event) {
    }

    @FXML
    private void onStartButtonPressed(ActionEvent event) {
    }

    @FXML
    private void onBackButtonPressed(ActionEvent event) throws IOException {
        
        App.setRoot("LevelScreen");
    }
}
