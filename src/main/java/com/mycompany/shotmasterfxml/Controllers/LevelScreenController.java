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

    GridPane buttonGrid = new GridPane();
    
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
                App.setRoot("GameScreen");
                
             } catch (IOException ex) {
                    ex.printStackTrace();
                }
//            try {
//                String fileName = button.getText().toLowerCase().replace(" ", "");
//                App.setRoot("GameScreen");
//            
//            } catch (IOException ex) {
//                ex.printStackTrace();
//                }

            });
            
        }
        
    }
}
