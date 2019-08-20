/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Texture;

import java.util.Random;

/**
 *
 * @author Ashraf
 */
public class enemy {

    int x, y, direction , xbullet ,ybullet ,bulletDirection ;
    int bulletTrigger ;
    boolean isAlive;
    boolean collesion;

    public enemy(int a) {
        x = a;
        y = 82;
        isAlive = true;
        collesion =false;
        direction = getRandomDirection();
        bulletTrigger = 1;
        
    }
    static int[] directions = {9, 10, 11, 12};

    public int getRandomDirection() {
        int rnd = new Random().nextInt(directions.length);
        return directions[rnd];
    }

}
