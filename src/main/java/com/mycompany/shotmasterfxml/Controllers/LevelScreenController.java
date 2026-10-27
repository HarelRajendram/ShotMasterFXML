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
            // 1. Switch the main window to the GameScreen
            javafx.fxml.FXMLLoader loader = App.setRootAndGetLoader("GameScreen");
            
            // 2. Grab the GameScreen's controller
            GameScreenController gameController = loader.getController();
            
            // 3. Figure out which level file to load based on the button text 
            // (e.g., button text "Level 1" turns into "/com/mycompany/shotmasterfxml/level1.fxml")
            String levelName = button.getText().toLowerCase().replace(" ", "");
            String levelFile = "/com/mycompany/shotmasterfxml/" + levelName + ".fxml";
            
            // 4. Load that level inside the GameScreen
            gameController.loadSubScene(levelFile);
            
        } catch (java.io.IOException ex) {
            ex.printStackTrace();
        }
    });
}
            
        }
        
    }

