/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shotmasterfxml;

import com.mycompany.shotmasterfxml.Controllers.GameScreenController;
import javafx.scene.image.ImageView;

/**
 *
 * @author macos
 */
public class Score {
    
    private int goalCount = 0;
    private GameScreenController controller;
    private boolean hasScored = false;

    public Score(GameScreenController controller) {
        this.controller = controller;
    }
    
    public boolean isAGoal() {
    
        ImageView ball = controller.getBallSphere();
        ImageView goal = controller.getBallSphere1();
        
        if (ball != null && goal != null) {
            if (ball.getBoundsInParent().intersects(goal.getBoundsInParent())) {
                if (!hasScored) {
                    goalCount++;
                    hasScored = true;
                    
                    controller.getVictoryLabel().setText("YOU WIN!!!!!");
                    controller.getVictoryLabel().setVisible(true);
                    
                    controller.updateGoalLabel(goalCount);
                }
                return true;
            }
        }
        return false;
        
    }

    public void resetShot() {
        hasScored = false;
        controller.getVictoryLabel().setText("");
        controller.getVictoryLabel().setVisible(false);
    }

    public int getGoalCount() {
        return goalCount;
    }
}
