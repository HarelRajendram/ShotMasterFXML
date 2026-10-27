/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.shotmasterfxml.Controllers;

import com.mycompany.shotmasterfxml.App;
import com.mycompany.shotmasterfxml.App;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author scrub
 */
public class LevelScreenController implements Initializable {

    @FXML
    private GridPane buttonGrid;
    @FXML
    private Button backButton;
    
    ArrayList<Button> buttons = new ArrayList();
    
    /**
     * Initializes the level controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        for (Node node : buttonGrid.getChildren()) {
            if (node instanceof Button) {
                buttons.add((Button) node);
            }
        }
        
        for (Button button : buttons) {
            button.setOnAction(e -> {
             try {
                
                FXMLLoader loader = App.setRoot("GameScreen");
                
                GameScreenController gameController = loader.getController();
                
                String levelFile = "/com/mycompany/shotmasterfxml/" + 
                        button.getText().toLowerCase().replace(" ", "") + ".fxml";
                
                gameController.loadSubScene(levelFile);
                
             } catch (IOException ex) {
                    ex.printStackTrace();
                }
            
            });
            
        }
        
    }

    @FXML
        private void onBackButtonPressed(ActionEvent event) throws IOException {
        App.setRoot("StartScreen");
    }
}
