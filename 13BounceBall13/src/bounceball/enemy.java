/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bounceball;
import java.util.Random;
public class enemy {

    public double x, y;
    public int color;
    double angle;
    boolean p;

    public enemy(double a, double b, double c,int c2, boolean z) {
        x = a;
        y = b;
        angle = c;
        if(!z){
            color = (int)(Math.random()*4) + 1;
        }
        else 
            color = c2;
    }
}
