
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;


/**
 *
 * @author ansty
 */
public class Triangle_exercise {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        startCalcuation();
    }
    
    public static void startCalcuation() throws Exception{
        Triangle triangle = new Triangle();
        try{
            Scanner scanner = new Scanner (System.in);
        System.out.print("Triangle Calucator \n");  
        System.out.print("Enter your side a - please insert a integer value: \n");
        int a  = scanner.nextInt(); // Get what the user types.
        System.out.print("Enter your side b - please insert a integer value: \n");  
        int b  = scanner.nextInt(); // Get what the user types.
        System.out.print("Enter your side c - please insert a integer value: \n");    
        int c  = scanner.nextInt(); // Get what the user types.
        triangle = new Triangle(a, b, c);
        }catch(Exception e){
            triangle.setType(TriangleType.UNKNOWN);
        }
        
        System.out.println("This triangle is " + triangle.getType());
        
    }
    
}
