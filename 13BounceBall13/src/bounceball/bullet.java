/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bounceball;

/**
 *
 * @author Ashraf
 */
public class bullet {
    double x,y;
    boolean isAlive;
    double angle;
    
    public bullet(double a , double b, double c){
        x = a;
        y = b;
        isAlive = true;
        angle = c;
    }
}
