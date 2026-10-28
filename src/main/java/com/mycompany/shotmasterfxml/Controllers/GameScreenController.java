package com.mycompany.shotmasterfxml.Controllers;

import com.mycompany.shotmasterfxml.App;
import com.mycompany.shotmasterfxml.Physics;
import com.mycompany.shotmasterfxml.Score;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

public class GameScreenController {
    
    private static final double METERS_TO_PIXELS_SCALE = 10; 
    private static final double GRAVITY = 9.81;

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
    private Label victoryLabel;
    
    @FXML
    private Button startButton;
    @FXML
    private Button backButton;

    private Score score;
    @FXML
    private ImageView ballSphere;
    @FXML
    private ImageView ballSphere1;
    
    private double angle = 0;
    private double velocity = 0;
    
    private AnimationTimer animationTimer;
   

    public void initialize() {
        this.score = new Score(this);
        
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
            
            ballSphere = (ImageView) subView.lookup("#ballSphere");  
            ballSphere1 = (ImageView) subView.lookup("#ballSphere1");
            
        } catch (IOException e) {
            System.err.println("Error loading sub-FXML file: " + fxmlPath);
            e.printStackTrace();
        }
    }

    private void animateBall() {
        final double angleRadians = Math.toRadians(angle);
        
//        double originalX = ballSphere.getLayoutX(); 
//        double originalY = ballSphere.getLayoutY();

        final double originalX = 67.0; 
        final double originalY = 268.0;
        
        ballSphere.setLayoutX(originalX);
        ballSphere.setLayoutY(originalY);
        
        double startX = originalX;
        double startY = originalY;

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
                        - 0.5 * GRAVITY * elapsedTime * elapsedTime;

                double screenX = startX + x * METERS_TO_PIXELS_SCALE;
                double screenY = startY - y * METERS_TO_PIXELS_SCALE;

                ballSphere.setLayoutX(screenX);
                ballSphere.setLayoutY(screenY);
                
                score.isAGoal();

                if (elapsedTime >= Physics.getTotalTime(velocity, angle)) {
                    animationTimer.stop();
                }
            }
        };

        animationTimer.start();
    }


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
        
        int goalCount = score.getGoalCount();
        goalLabel.setText(String.valueOf(goalCount));
        
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

    public ImageView getBallSphere() {
        return this.ballSphere;
    }

    public ImageView getBallSphere1() {
        return this.ballSphere1;
    }
    
    public Label getVictoryLabel() {
        return victoryLabel;
    }
}
