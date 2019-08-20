package Texture;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package project;
import com.sun.opengl.util.*;
import com.sun.opengl.util.j2d.TextRenderer;
import com.sun.opengl.util.j2d.TextureRenderer;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import javax.media.opengl.*;
import javax.swing.*;

import java.util.BitSet;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import javax.media.opengl.glu.GLU;
import jdk.nashorn.internal.objects.Global;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Anim extends JFrame {

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Anim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        new Anim();
    }

    GLCanvas glcanvas;
    AnimGLEventListener2 listener;
    Animator animator;

    public Anim() {
        listener = new AnimGLEventListener2();
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addKeyListener(listener);
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        animator = new FPSAnimator(20);
        animator.add(glcanvas);
        animator.start();

        setTitle("Anim Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);
        setVisible(true);
        setFocusable(true);
        glcanvas.requestFocus();
    }
}

class AnimGLEventListener2 implements GLEventListener, KeyListener {

    boolean starIsDead = false;
    int lifes = 3;
    int enemyBulletSpeed = 2;
    int level_counter = 1;
    int score = 0;
    int level_changed = level_counter;
    boolean iamDead = false;
    static int[] enemydirections = {9, 10, 11, 12};
    int xbullet, ybullet, bulletDirection, playerCollesionDirection, collapsedBlockIndex, enemycollapsedBlockIndex, enemyDirection, enemyCollesionDirection;
    int bulletTrigger, blockColletion, enemyblockColletion = 0;
    String textureNames[] = {"gaming.png", "pause.png", "stone.png", "tank up.png",
        "tank right.png", "tank down.png", "tank left.png", "star.png", "tree.png",
        "enemy up.png", "enemy right.png", "enemy down.png", "enemy left.png", "bullet.png", "0.png", "1.png", "2.png", "3.png",
        "4.png", "5.png", "6.png", "7.png", "8.png", "9.png", "Back.jpg" , "enemyBullet.png", "upDamage.png" ,  "rigtDamage.png" ,  "downDamage.png" , "leftDamage.png" }; 
    TextureReader.Texture texture[] = new TextureReader.Texture[textureNames.length];
    int textures[] = new int[textureNames.length];
    final String assetsFolderName = "Texture";
    ArrayList<enemy> enem = new ArrayList<>();
    ArrayList<block> block = new ArrayList<>();
    block blk;
    int frameCounter, collapced = 0;
    int pause;
    int gameOver = 0;
    int playerDirection = 4;
    int killedDirection = 0 ;
    int maxWidth = 100, maxHeight = 100;
    int x = 5, y = 0;
    int x1, y1;
    int state = 0;
    TextRenderer t = new TextRenderer(Font.decode("PLAIN 150"));
    ArrayList<Integer> s = new ArrayList<>();
    private MediaPlayer mediaPlayer;
    boolean isSoundPlaying;

    public void init(GLAutoDrawable gld) {

        GL gl = gld.getGL();
        gl.glClearColor(0.0f, 0.0f, 0f, 1.0f);
        drawBlocks();
        createEnemies();
        for (int i = 0; i < enem.size(); i++) {
            initializeEnemyblts(enem.get(i));
        }
        gl.glEnable(GL.GL_TEXTURE_2D);
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
        gl.glGenTextures(textureNames.length, textures, 0);

        for (int i = 0; i < textureNames.length; i++) {
            try {
                texture[i] = TextureReader.readTexture(assetsFolderName + "//" + textureNames[i], true);
                gl.glBindTexture(GL.GL_TEXTURE_2D, textures[i]);

//                mipmapsFromPNG(gl, new GLU(), texture[i]);
                new GLU().gluBuild2DMipmaps(
                        GL.GL_TEXTURE_2D,
                        GL.GL_RGBA, // Internal Texel Format,
                        texture[i].getWidth(), texture[i].getHeight(),
                        GL.GL_RGBA, // External format from image,
                        GL.GL_UNSIGNED_BYTE,
                        texture[i].getPixels() // Imagedata
                );
                ReadHighScore();
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }
        playsound("go.mp3",true);
    }
    
    GL gl;

    public void display(GLAutoDrawable gld) {

        gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);       //Clear The Screen And The Depth Buffer
        gl.glLoadIdentity();
        DrawBackground(gl);
        handleKeyPress();
        if (state == 0) {
            drawMain();
        } else if (state == 1) {
            if (pause == 0) {
                if (gameOver == 0) {

                    frameCounter++;
                    //--------------------------------------------------------------------------------------------------------

                    //drawing bullets  
                    if (ybullet > maxWidth - 15 || ybullet < -3 || xbullet < -3 || xbullet > 97) {
                        bulletTrigger = 0;
                    }
                    if (bulletTrigger == 1) {
                        DrawSprite(gl, xbullet, ybullet, 13, .15f);
                        if (bulletDirection == 3) {
                            ybullet += 2;
                        } else if (bulletDirection == 4) {
                            xbullet += 2;
                        } else if (bulletDirection == 5) {
                            ybullet -= 2;
                        } else if (bulletDirection == 6) {
                            xbullet -= 2;
                        }

                    }
                    //drawing bullets
                    //--------------------------------------------------------------------------------------------------------
                    //Drawing enemy bullets
                    for (int i = 0; i < enem.size(); i++) {
                        if (enem.get(i).ybullet > maxHeight - 15 || enem.get(i).ybullet < -3 || enem.get(i).xbullet < -3 || enem.get(i).xbullet > 97) {
                            initializeEnemyblts(enem.get(i));
                        }
                        if (enem.get(i).bulletTrigger == 1 && enem.get(i).isAlive) {
                            DrawSprite(gl, enem.get(i).xbullet, enem.get(i).ybullet, 25 , .15f);
                            if (enem.get(i).bulletDirection == 9) {
                                enem.get(i).ybullet += enemyBulletSpeed;
                            } else if (enem.get(i).bulletDirection == 10) {
                                enem.get(i).xbullet += enemyBulletSpeed;
                            } else if (enem.get(i).bulletDirection == 11) {
                                enem.get(i).ybullet -= enemyBulletSpeed;
                            } else if (enem.get(i).bulletDirection == 12) {
                                enem.get(i).xbullet -= enemyBulletSpeed;
                            }
                        }
                    }
                    //Drawing enemy bullets

                    //drawing player
                    playercollesion();
                    if (!iamDead) {
                        DrawSprite(gl, x, y, playerDirection, .6f);
                        killedDirection = playerDirection + 23 ;
                    }
                    //drawing player
                    //--------------------------------------------------------------------------------------------------------
                    //drawing enemy
                    for (int i = 0; i < enem.size(); i++) {
                        enemycollesion(enem.get(i));
                        if (enem.get(i).isAlive) {
                            DrawSprite(gl, enem.get(i).x, enem.get(i).y, enem.get(i).direction, .6f);
                        }
                        if (enem.get(i).direction == 9 && enem.get(i).y < maxHeight - 10 && !enem.get(i).collesion) {
                            enem.get(i).y++;
                        }
                        if (enem.get(i).direction == 10 && enem.get(i).x < maxWidth - 10 && !enem.get(i).collesion) {
                            enem.get(i).x++;
                        }
                        if (enem.get(i).direction == 11 && enem.get(i).y > -2 && !enem.get(i).collesion) {
                            enem.get(i).y--;
                        }
                        if (enem.get(i).direction == 12 && enem.get(i).x > -2 && !enem.get(i).collesion) {
                            enem.get(i).x--;
                        }
                        if (enem.get(i).collesion) {
                            int k = getRandomDirection();
                            while (k == enem.get(i).direction) {
                                k = getRandomDirection();
                            }
                            enem.get(i).direction = k;
                        }
                        if (enem.get(i).direction != enemyCollesionDirection || !block.get(enemycollapsedBlockIndex).isAlive) {
                            if (enemyCollesionDirection == 9) {
                                enem.get(i).y--;
                                enemyCollesionDirection = 0;
                            }
                            if (enemyCollesionDirection == 11) {
                                enem.get(i).y++;
                                enemyCollesionDirection = 0;
                            }
                            if (enemyCollesionDirection == 10) {
                                enem.get(i).x--;
                                enemyCollesionDirection = 0;
                            }
                            if (enemyCollesionDirection == 12) {
                                enem.get(i).x++;
                                enemyCollesionDirection = 0;
                            }
                            enem.get(i).collesion = false;
                        }
                    }
                    //drawing enemy
                    //--------------------------------------------------------------------------------------------------------
                    //blocks
                    DrawSprite(gl, 46, -3, 7, .9f);

                    DrawSprite(gl, 0, 60, 8, .9f);
                    DrawSprite(gl, 0, 70, 8, .9f);
                    DrawSprite(gl, 90, 40, 8, .9f);
                    DrawSprite(gl, 90, 70, 8, .9f);
                    bulletColletion();
                    enemybulletColletion();
                    for (int i = 0; i < block.size(); i++) {
                        if (block.get(i).isAlive) {
                            DrawSprite(gl, block.get(i).x, block.get(i).y, 2, .5f);
                        }
                    }
                    //blocks
                    //--------------------------------------------------------------------------------------------------------
                    //levels
                    level_counter = ((int) score / 5) + 1;
                    if (level_changed != level_counter) {
                        x = 5;
                        y = 0;
                        playerDirection = 4;
                        enem.clear();
                        block.clear();
                        drawBlocks();
                        createEnemies();
                        for (int i = 0; i < enem.size(); i++) {
                            initializeEnemyblts(enem.get(i));
                        }
                        level_changed = level_counter;
                        enemyBulletSpeed++;
                    }
                    String s1 = level_counter + "";
                    if (s1.length() > 1) {
                        DrawSprite(gl, 45, 90, Integer.parseInt(s1.substring(1, 2)) + 14, 0.3f);
                        DrawSprite(gl, 43, 90, Integer.parseInt(s1.substring(0, 1)) + 14, 0.3f);
                    } else {
                        DrawSprite(gl, 45, 90, Integer.parseInt(s1.substring(0, 1)) + 14, 0.3f);
                    }
                    //levels 
                    //---------------------------------------------------------------------------------------------------------
                    //score
                    String s = score + "";
                    if (s.length() > 1) {
                        DrawSprite(gl, 90, 90, Integer.parseInt(s.substring(1, 2)) + 14, 0.3f);
                        DrawSprite(gl, 87, 90, Integer.parseInt(s.substring(0, 1)) + 14, 0.3f);
                    } else {
                        DrawSprite(gl, 90, 90, Integer.parseInt(s.substring(0, 1)) + 14, 0.3f);
                    }
                    //score
                    //-----------------------------------------------------------------------------------------------------------
                    //lifes
                    for (int n = 0; n < lifes; n++) {
                        DrawSprite(gl, n * 5, 90, 3, 0.5f);
                    }
                    //lifes
                    //-----------------------------------------------------------------------------------------------------------

                } else {
                    DrawSprite(gl, 45, 60, 0, 6);
                    t = new TextRenderer(Font.decode("PLAIN 20"));
                    t.beginRendering(400, 400);
                    t.setColor(Color.RED);
                    t.draw("your score : " + score, 120, 85);
                    t.draw("press Enter to go to main menu", 40, 55);
                    t.setColor(Color.WHITE);
                    t.endRendering();
                    playsound("Score.mp3");
                }
            } else {
                DrawSprite(gl, 50, 50, 1, 5);
            }
        } else if (state == 2) {
            drawHighScore();
        } else if (state == 3) {
            drawHelp();
        }
    }
//create enemy objects

    public void createEnemies() {
        // remember to use enemy counter for levels
        int pos = 85;
        enemy e = new enemy(pos);
        enem.add(e);
        for (int i = 0; i < 4; i++) {
            pos -= 20;
            e = new enemy(pos);
            enem.add(e);

        }
    }
//create enemy objects

    public void bulletColletion() {
        for (int i = 0; i < block.size(); i++) {
            if (block.get(i).isAlive) {
                if (Math.abs(xbullet - block.get(i).x) <= 2 && Math.abs(ybullet - block.get(i).y) <= 2) {
                    bulletTrigger = 0;
                    block.get(i).isAlive = false;
                }

            }
        }
        for (int i = 0; i < enem.size(); i++) {
            if (enem.get(i).isAlive && bulletTrigger == 1) {
                if (Math.abs(xbullet - enem.get(i).x) <= 2 && Math.abs(ybullet - enem.get(i).y) <= 2) {
                    bulletTrigger = 0;
                    enem.get(i).isAlive = false;
                    score += 1;
                }

            }
        }
        if (Math.abs(xbullet - 46) <= 4 && Math.abs(-3 - ybullet) <= 4) {
            gameOver = 1;
        }
    }

    public void initializeEnemyblts(enemy e) {

        e.bulletTrigger = 1;
        e.xbullet = e.x;
        e.ybullet = e.y;
        e.bulletDirection = e.direction;
        e.bulletDirection = e.direction;
        if (e.bulletDirection == 9) {
            e.xbullet = e.x;
            e.ybullet = e.y + 3;
        } else if (e.bulletDirection == 10) {
            e.xbullet = e.x + 3;

            e.ybullet = e.y;
        } else if (e.bulletDirection == 11) {
            e.xbullet = e.x;
            e.ybullet = e.y - 3;
        } else if (e.bulletDirection == 12) {
            e.xbullet = e.x - 3;
            e.ybullet = e.y;
        } else if (state == 2) {

        }
    }

    public void enemybulletColletion() {
        for (int i = 0; i < block.size(); i++) {
            for (int j = 0; j < enem.size(); j++) {
                if (block.get(i).isAlive && enem.get(j).isAlive) {
                    if (Math.abs(enem.get(j).xbullet - block.get(i).x) <= 2 && Math.abs(enem.get(j).ybullet - block.get(i).y) <= 2) {
                        initializeEnemyblts(enem.get(j));
                        block.get(i).isAlive = false;
                    }
                    if (Math.abs(46 - enem.get(j).xbullet) <= 5 && Math.abs(-3 - enem.get(j).ybullet) <= 5) {
                        initializeEnemyblts(enem.get(j));
                        gameOver = 1;
                    }
                    if (Math.abs(enem.get(j).xbullet - x) <= 2 && Math.abs(enem.get(j).ybullet - y) <= 2) {
                        System.out.println("in if");
                        lifes--;
                            DrawSprite(gl, x, y, killedDirection, .6f);

                        x = 5;
                        y = 0;
                        playerDirection = 4;

                        if (lifes <= 0) {
                            iamDead = true;
                            gameOver = 1;
                        }
                    }
                }
            }
        }
    }

    public void enemycollesion(enemy e) {
        for (int i = 0; i < block.size(); i++) {
            if (Math.abs(block.get(i).x - e.x) <= 5 && Math.abs(block.get(i).y - e.y) <= 5 && block.get(i).isAlive && e.isAlive
                    || e.x <= -2 || e.x == (int) (-2 + Math.random() * 15000) || e.x >= maxWidth - 10 || e.y <= -2 || e.y == (int) (-2 + Math.random() * 15000) || e.y >= maxHeight - 15) {
                e.collesion = true;
                enemyCollesionDirection = e.direction;
                enemycollapsedBlockIndex = i;
            }

        }
        if (Math.abs(x - e.x) <= 5 && Math.abs(y - e.y) <= 5) {
            e.collesion = true;
            enemyCollesionDirection = e.direction;
        }
        if (Math.abs(46 - e.x) <= 5 && Math.abs(-3 - e.y) <= 5) {
            e.collesion = true;
            enemyCollesionDirection = e.direction;
        }
    }

    public void playercollesion() {
        for (int i = 0; i < block.size(); i++) {
            if (Math.abs(block.get(i).x - x) <= 5 && Math.abs(block.get(i).y - y) <= 5 && block.get(i).isAlive) {
                playerCollesionDirection = playerDirection;
                blockColletion = 1;
                collapsedBlockIndex = i;
            }
        }
        for (int i = 0; i < enem.size(); i++) {
            if (Math.abs(enem.get(i).x - x) <= 5 && Math.abs(enem.get(i).y - y) <= 5 && enem.get(i).isAlive) {
                playerCollesionDirection = playerDirection;
                blockColletion = 1;
            }
        }
        if (Math.abs(x - 46) <= 5 && Math.abs(y + 3) <= 5) {
            playerCollesionDirection = playerDirection;
            blockColletion = 1;
        }
    }

    public int getRandomDirection() {
        int rnd = new Random().nextInt(enemydirections.length);
        return enemydirections[rnd];
    }

    public void drawBlocks() {
// boss house        
        blk = new block(41, -3);
        block.add(blk);
        blk = new block(41, 2);
        block.add(blk);
        blk = new block(46, 2);
        block.add(blk);
        blk = new block(51, 2);
        block.add(blk);
        blk = new block(51, -3);
        block.add(blk);
// h middle
        blk = new block(65, 55);
        block.add(blk);
        blk = new block(60, 55);
        block.add(blk);
        blk = new block(55, 55);
        block.add(blk);
        blk = new block(50, 55);
        block.add(blk);
        blk = new block(45, 55);
        block.add(blk);
        blk = new block(40, 55);
        block.add(blk);
        blk = new block(35, 55);
        block.add(blk);
// H right
        blk = new block(72, 76);
        block.add(blk);
        blk = new block(72, 71);
        block.add(blk);
        blk = new block(72, 66);
        block.add(blk);
        blk = new block(72, 61);
        block.add(blk);
        blk = new block(72, 56);
        block.add(blk);
        blk = new block(72, 51);
        block.add(blk);
        blk = new block(72, 46);
        block.add(blk);
        blk = new block(72, 41);
        block.add(blk);
        blk = new block(72, 36);
        block.add(blk);
        blk = new block(72, 31);
        block.add(blk);
// H left
        blk = new block(28, 76);
        block.add(blk);
        blk = new block(28, 71);
        block.add(blk);
        blk = new block(28, 66);
        block.add(blk);
        blk = new block(28, 61);
        block.add(blk);
        blk = new block(28, 56);
        block.add(blk);
        blk = new block(28, 51);
        block.add(blk);
        blk = new block(28, 46);
        block.add(blk);
        blk = new block(28, 41);
        block.add(blk);
        blk = new block(28, 36);
        block.add(blk);
        blk = new block(28, 31);
        block.add(blk);
// L left
        blk = new block(33, 31);
        block.add(blk);
// T up
        blk = new block(8, 72);
        block.add(blk);
        blk = new block(8, 67);
        block.add(blk);
        blk = new block(8, 62);
        block.add(blk);
        blk = new block(8, 57);
        block.add(blk);
        blk = new block(8, 52);
        block.add(blk);
        blk = new block(8, 47);
        block.add(blk);
// T down
        blk = new block(3, 47);
        block.add(blk);
        blk = new block(13, 47);
        block.add(blk);
// | right
        blk = new block(82, 76);
        block.add(blk);
        blk = new block(82, 71);
        block.add(blk);
        blk = new block(82, 66);
        block.add(blk);
        blk = new block(82, 61);
        block.add(blk);
        blk = new block(82, 56);
        block.add(blk);
        blk = new block(82, 51);
        block.add(blk);
        blk = new block(82, 46);
        block.add(blk);
        blk = new block(82, 41);
        block.add(blk);
        blk = new block(82, 36);
        block.add(blk);
        blk = new block(82, 31);
        block.add(blk);
// L right
        blk = new block(67, 31);
        block.add(blk);
// -- right
        blk = new block(61, 19);
        block.add(blk);
        blk = new block(66, 19);
        block.add(blk);
        blk = new block(71, 19);
        block.add(blk);
        blk = new block(76, 19);
        block.add(blk);
        blk = new block(81, 19);
        block.add(blk);
        blk = new block(86, 19);
        block.add(blk);
        blk = new block(91, 19);
        block.add(blk);
// -- left
        blk = new block(34, 19);
        block.add(blk);
        blk = new block(29, 19);
        block.add(blk);
        blk = new block(24, 19);
        block.add(blk);
        blk = new block(19, 19);
        block.add(blk);
        blk = new block(14, 19);
        block.add(blk);
        blk = new block(9, 19);
        block.add(blk);
        blk = new block(4, 19);
        block.add(blk);
        blk = new block(-1, 19);
        block.add(blk);
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void DrawSprite(GL gl, double x, double y, int index, float scale) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]);	// Turn Blending On

        gl.glPushMatrix();
        gl.glTranslated(x / (maxWidth / 2.0) - 0.9, y / (maxHeight / 2.0) - 0.9, 0);
        gl.glScaled(0.1f * scale, 0.1f * scale, 1);
        //System.out.println(x +" " + y);
        gl.glBegin(GL.GL_QUADS);
        // Front Face
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glEnd();
        gl.glPopMatrix();

        gl.glDisable(GL.GL_BLEND);
    }

    //Download the whole sound package form https://www.zophar.net/music/nintendo-nes-nsf/battle-city
    public void playsound(String s) {
        playsound(s, false);
    }
    public void playsound(String s, boolean stopCurrent) {
        try {
            URL soundURL = getClass().getResource(s);
//            in = new FileInputStream(new File(soundURL.toURI()));
//            AudioStream audios = new AudioStream(in);
//            AudioPlayer.player.start(audios);
            JFXPanel j = new JFXPanel();
//            String uri = new File(s).toURI().toString();
            
            if(mediaPlayer!=null && stopCurrent)
                mediaPlayer.stop();
            
            if(mediaPlayer==null || stopCurrent || !isSoundPlaying)
            {
                Media soundTrack = new Media(soundURL.toURI().toString());
                mediaPlayer = new MediaPlayer(soundTrack);
                mediaPlayer.play();
                isSoundPlaying = true;
                mediaPlayer.setOnEndOfMedia(new Runnable() {
                        @Override
                        public void run() {
                            isSoundPlaying = false;
                            System.out.println("Stopped");
                        }
                    });
            }
            System.out.println(mediaPlayer.getTotalDuration().subtract(mediaPlayer.currentTimeProperty().get()));
            System.out.println(mediaPlayer.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("sound stoped");
        }
    }

    public void DrawBackground(GL gl) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[24]);	// Turn Blending On

        gl.glPushMatrix();
        gl.glBegin(GL.GL_QUADS);
        // Front Face
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glEnd();
        gl.glPopMatrix();

        gl.glDisable(GL.GL_BLEND);
    }

    /*
     * KeyListener
     */
    public void handleKeyPress() {

        if (isKeyPressed(KeyEvent.VK_LEFT) && pause == 0) {
            if (x > -2) {
                playerDirection = 6;
                if (blockColletion == 0) {
                    x--;
                }
            }
        } else if (isKeyPressed(KeyEvent.VK_RIGHT) && pause == 0) {
            if (x < maxWidth - 10) {
                playerDirection = 4;
                if (blockColletion == 0) {
                    x++;
                }
            }
        } else if (isKeyPressed(KeyEvent.VK_DOWN) && pause == 0) {
            if (y > -2) {
                playerDirection = 5;
                if (blockColletion == 0) {
                    y--;
                }
            }
        } else if (isKeyPressed(KeyEvent.VK_UP) && pause == 0) {
            if (y < maxHeight - 15) {
                playerDirection = 3;
                if (blockColletion == 0) {
                    y++;
                }
            }
        }
        if (playerDirection != playerCollesionDirection || !block.get(collapsedBlockIndex).isAlive) {
            if (playerCollesionDirection == 3) {
                y--;
                playerCollesionDirection = 0;
            }
            if (playerCollesionDirection == 5) {
                y++;
                playerCollesionDirection = 0;
            }
            if (playerCollesionDirection == 4) {
                x--;
                playerCollesionDirection = 0;
            }
            if (playerCollesionDirection == 6) {
                x++;
                playerCollesionDirection = 0;
            }
            blockColletion = 0;
        }

        if (isKeyPressed(KeyEvent.VK_SPACE) && pause == 0 && bulletTrigger == 0) {
            bulletTrigger = 1;
            bulletDirection = playerDirection;
            if (bulletDirection == 3) {
                xbullet = x;
                ybullet = y + 3;
            } else if (bulletDirection == 4) {
                xbullet = x + 3;

                ybullet = y;
            } else if (bulletDirection == 5) {
                xbullet = x;
                ybullet = y - 3;
            } else if (bulletDirection == 6) {
                xbullet = x - 3;
                ybullet = y;
            }
            // playsound("s.mp3");
        }
        if (isKeyPressed(KeyEvent.VK_ESCAPE)&& state ==1){
             gameOver = 1;
        }
        if ((isKeyPressed(KeyEvent.VK_ENTER) && gameOver == 1) ) {
            if(score != 0)
                s.add(score);
            System.out.println(s.toString());
            try{WriteHighScore();
                playsound("go.mp3",true);}
            catch (Exception e){}
            t = new TextRenderer(Font.decode("PLAIN 150"));
            gameOver = 0;
            System.out.println("here  " + gameOver);
            lifes = 3;
            xbullet = -10;
            ybullet = -10;
            starIsDead = false;
            level_counter = 1;
            enemyBulletSpeed = 2;
            level_changed = level_counter;
            score = 0;
            iamDead = false;
            frameCounter = 0;
            x = 5;
            y = 0;
            playerDirection = 4;
            enem.clear();
            block.clear();
            state = 0;
            drawBlocks();
            createEnemies();
            for (int i = 0; i < enem.size(); i++) {
                initializeEnemyblts(enem.get(i));
            }
        }
        
        if (isKeyPressed(KeyEvent.VK_P)) {
            if (pause == 0) {
                pause = 1;
            } else if (pause == 1) {
                pause = 0;
            }
        }
    }

    public BitSet keyBits = new BitSet(256);

    @Override
    public void keyPressed(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.set(keyCode);
    }

    @Override
    public void keyReleased(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.clear(keyCode);
    }

    @Override
    public void keyTyped(final KeyEvent event) {
        // don't care 
    }

    public boolean isKeyPressed(final int keyCode) {
        return keyBits.get(keyCode);
    }

    public void drawMain() {
        t.beginRendering(2000, 1500);
        t.setColor(Color.WHITE);
        t.draw("1- SINGLE PLAYER", 480, 1100);
        t.draw("2- LAST SCORES", 480, 900);
        t.draw("3- CONTROLS", 480, 700);
        t.draw("4- QUIT", 480, 500);
        t.setColor(Color.WHITE);
        t.endRendering();
        if (isKeyPressed(KeyEvent.VK_1)) {
            state = 1;
            gameOver = 0;
        } else if (isKeyPressed(KeyEvent.VK_2)) {
            state = 2;
            t.setColor(Color.WHITE);
        } else if (isKeyPressed(KeyEvent.VK_3)) {
            state = 3;
        } else if (isKeyPressed(KeyEvent.VK_4)) {
            System.exit(0);
        }
    }

    public void drawHighScore() {
        t.beginRendering(2000, 1500);
        t.setColor(Color.BLUE);
        for (int i = 0; i < s.size(); i++) {
            t.draw(s.get(i) + "", 500, (1300 - ((i + 1) * 120)));
        }t.draw("to return to main menu", 0, 20);
        t.draw("Press Escape ", 0, 120);
        if (isKeyPressed(KeyEvent.VK_ESCAPE)) {
            state = 0;
        }
        t.setColor(Color.WHITE);
        t.endRendering();
    }

    void drawHelp() {
        t.beginRendering(2000, 1500);
        t.setColor(Color.BLUE);
        t.draw("arrows to control movement", 60, 1300);
        t.draw("space to fire ", 60, 1000);
        t.draw("p to pause/resume", 60, 700);
        t.draw("press Esc to go back", 60, 100);
        t.setColor(Color.WHITE);
        t.endRendering();
        if (isKeyPressed(KeyEvent.VK_ESCAPE)) {
            state = 0;
        }
    }

    public void ReadHighScore() throws Exception {
        s.clear();
        Scanner input = new Scanner(new File("file.txt"));
        
        while (input.hasNext()) {
            s.add(Integer.parseInt(input.nextLine()));
        }
        Collections.sort(s);
        Collections.reverse(s);
    }
    public void WriteHighScore() throws Exception {
        PrintWriter output = new PrintWriter("file.txt");
        Collections.sort(s);
        Collections.reverse(s);
        for (int i = 0; i < s.size() && i < 5; i++) {
            if(s.get(i) != 0)
                output.println(s.get(i));
        }
        output.close();
    }
//    public void drawEnd(){
//        if(isKeyPressed(KeyEvent.VK_ESCAPE)){
//            lifes = 3;
//            xbullet = -10;
//            ybullet = -10;
//            starIsDead = false;
//            level_counter = 1;
//            enemyBulletSpeed = 2;
//            level_changed = level_counter;
//            score = 0;
//            iamDead = false;
//            frameCounter = 0;
//            x = 5;
//            y = 0;
//            playerDirection = 4;
//            enem.clear();
//            block.clear();
//            drawBlocks();
//            createEnemies();
//            for (int i = 0; i < enem.size(); i++) {
//                initializeEnemyblts(enem.get(i));
//            }
//            state = 0;
//        }
//    }
}
