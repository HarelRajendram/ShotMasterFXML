/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shotmasterfxml;

/**
 *
 * @author macos
 */
public class Physics {
    
    
    public static double calculateDisplacement(double initialVelocity, double time, double acceleration) {
        
        return (initialVelocity * time) + ((acceleration * Math.pow(time, 2)) / 2);
        
        
    }
    
//    public double calculateHeight() {}
//    
//    
//
    
}
