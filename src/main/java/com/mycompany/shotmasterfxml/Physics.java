/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shotmasterfxml;

import com.mycompany.shotmasterfxml.Controllers.GameScreenController;

/**
 *
 * @author macos
 */
public class Physics {
    
    public static double getTotalTime() {
        GameScreenController velocity = new GameScreenController();
        GameScreenController angle = new GameScreenController();
        double time = (2 * velocity.velocity * (Math.sin(angle.angle))) / 9.81;
        
        return time;
    }
    
    public static double getTotalDisplacement() {
        GameScreenController velocity = new GameScreenController();
        GameScreenController angle = new GameScreenController();
        double distance = ((Math.pow(velocity.velocity, 2)) * (Math.sin(angle.angle * 2))) / 9.81;
        
        return distance;
    }   
    
//    public double calculateHeight() {}
//    
//    
//
    
}
