package com.mycompany.shotmasterfxml.Controllers;

import com.mycompany.shotmasterfxml.App;
import com.mycompany.shotmasterfxml.Physics;
import java.io.IOException;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

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
    private VBox goalStats;
    @FXML
    private Label distanceLabel;
    @FXML
    private Label timeLabel;
    @FXML
    private Label heightLabel;
    @FXML
    private Label goalLabel;
    
    @FXML
    private Button startButton;
    @FXML
    private Button backButton;
    
    @FXML
    private Circle ballSphere;

    @FXML
    private AnchorPane gameField;

    private double angle = 0;
    private double velocity = 0;
    
    private AnimationTimer animationTimer;

    @FXML
    public void initialize() {
        angleSlider.valueProperty().addListener((obs, oldValue, newValue) -> {
            angle = newValue.doubleValue();
        });
        
        velocitySlider.valueProperty().addListener((obs, oldValue, newValue) -> {
            velocity = newValue.doubleValue();
        });
        
        angleTextField.textProperty().bind(angleSlider.valueProperty().asString("%.2f"));
        velocityTextField.textProperty().bind(velocitySlider.valueProperty().asString("%.2f"));
        
        angle = angleSlider.getValue();
        velocity = velocitySlider.getValue();
    }

    public void loadSubScene(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent subView = loader.load();
            
            mainContainer.setCenter(subView); 
            
            ballSphere = (Circle) subView.lookup("#ballSphere");        
        } catch (IOException e) {
            System.err.println("Error loading sub-FXML file: " + fxmlPath);
            e.printStackTrace();
        }
    }

    private void animateBall() {
        double gravity = 9.81;
        double angleRadians = Math.toRadians(angle);

        double startX = 67;
        double startY = 268;

        double scale = 8;

        double initialVelocityX = velocity * Math.cos(angleRadians);
        double initialVelocityY = velocity * Math.sin(angleRadians);

        long startTime = System.nanoTime();

        if (animationTimer != null) {
            animationTimer.stop();
        }

        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                double elapsedTime = (now - startTime) / 1_000_000_000.0;

                double x = initialVelocityX * elapsedTime;
                double y = initialVelocityY * elapsedTime
                        - 0.5 * gravity * elapsedTime * elapsedTime;

                double screenX = startX + x * scale;
                double screenY = startY - y * scale;

                ballSphere.setLayoutX(screenX);
                ballSphere.setLayoutY(screenY);

                if (elapsedTime >= Physics.getTotalTime(velocity, angle)) {
                    animationTimer.stop();
                }
            }
        };

        animationTimer.start();
    }

    @FXML
    private void onAngleDrag(MouseEvent event) {}

    @FXML
    private void onVelocityDrag(MouseEvent event) {}

    @FXML
    private void onStartButtonPressed(ActionEvent event) {
        System.out.println("Angle = " + angle);
        System.out.println("Velocity = " + velocity);

        double distance = Physics.getTotalDisplacement(this.velocity, this.angle);
        distanceLabel.setText(String.format("%.2f", distance));
        
        double time = Physics.getTotalTime(this.velocity, this.angle);
        timeLabel.setText(String.format("%.2f", time));
        
        double height = Physics.getMaxHeight(this.velocity, this.angle);
        heightLabel.setText(String.format("%.2f", height));

        animateBall();
    }

    @FXML
    private void onBackButtonPressed(ActionEvent event) throws IOException {
        App.setRoot("LevelScreen");
    }

    public TextField getVelocityTextField() {
        return velocityTextField;
    }

    public TextField getAngleTextField() {
        return angleTextField;
    }
}