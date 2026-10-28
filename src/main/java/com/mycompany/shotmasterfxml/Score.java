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

    public Score(GameScreenController controller) {
        this.controller = controller;
    }
    
    public void isAGoal() {
        System.out.println("Controller reference: " + controller);
    
        if (controller != null) {
        System.out.println("Ball Node: " + controller.getBallSphere());
        System.out.println("Goal Node: " + controller.getBallSphere1());
        }
        
        ImageView ball = controller.getBallSphere();
        ImageView goal = controller.getBallSphere1();
        
        if (ball != null && goal != null) {
            if (ball.getBoundsInParent().intersects(goal.getBoundsInParent())) {
                goalCount++;
                controller.getVictoryLabel().setText("YOU WIN!!!!!");
            }
        }
       
    }

    public int getGoalCount() {
        return goalCount;
    }
    
    
}
