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
    
      
    public static double getTotalTime(double velocity, double angleInDegrees) {
        double angleInRadians = Math.toRadians(angleInDegrees);
        double time = ((2 * velocity) * (Math.sin(angleInRadians))) / 9.81;
        return time;
    }
    
    public static double getTotalDisplacement(double velocity, double angleInDegrees) {
        double angleInRadians = Math.toRadians(angleInDegrees);
        double distance = ((Math.pow(velocity, 2)) * (Math.sin(angleInRadians * 2))) / 9.81;
        return distance;
    }   
    
    public static double getMaxHeight(double velocity, double angleInDegrees) {
        double angleInRadians = Math.toRadians(angleInDegrees);
        double height = ((Math.pow(velocity, 2)) * (Math.pow(Math.sin(angleInRadians), 2))) / (2 * 9.81);
        return height;
    }
}
