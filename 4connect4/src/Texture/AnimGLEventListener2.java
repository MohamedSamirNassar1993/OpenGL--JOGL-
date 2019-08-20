package Texture;

import com.sun.opengl.util.GLUT;
import com.sun.opengl.util.j2d.TextRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import static java.awt.SystemColor.menu;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.media.opengl.*;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.text.Font.font;
import javax.media.opengl.glu.GLU;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class AnimGLEventListener2 implements GLEventListener, KeyListener, MouseListener {

    TextRenderer t = new TextRenderer(Font.decode("SansSerif"));
    final String assetsFolderName = "Texture";
    int maxWidth = 100;
    int maxHeight = 100;
    int x = maxWidth / 2, y = 1/* maxHeight / 2*/;
    int index = 0;
    int indexx = 0;
    int yy = 100;
    public int xPosition = 1000;
    public int yPosition = 1000;
    
    ArrayList<Point> eggs = new ArrayList<Point>();
    
    String textureNames[] = {"basket.png", "egg.png", "exit.png", "gameOverbkg.png", "gamebkg.png", "help.png", "helpbkg.png", "menubkg.png", "play.png", "paused.png", "Chicken1.png", "Chicken2.png", "Chicken3.png"};
    TextureReader.Texture texture[] = new TextureReader.Texture[textureNames.length];
    int textures[] = new int[textureNames.length];
    int previousX = 0;
    int currentX = 0;
    int score = 0;
    Clip clip;
    File soundFile ;
    AudioInputStream audioIn;
    
    public void init(GLAutoDrawable gld) {
        
        GL gl = gld.getGL();
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);    //This Will Clear The Background Color To Black
        gl.glEnable(GL.GL_TEXTURE_2D);  // Enable Texture Mapping
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
        gl.glGenTextures(textureNames.length, textures, 0);

        for (int i = 0; i < textureNames.length; i++) {
            try {
                texture[i] = TextureReader.readTexture(assetsFolderName + "//" + textureNames[i], true);
                gl.glBindTexture(GL.GL_TEXTURE_2D, textures[i]);
                new GLU().gluBuild2DMipmaps(
                        GL.GL_TEXTURE_2D,
                        GL.GL_RGBA, // Internal Texel Format,
                        texture[i].getWidth(), texture[i].getHeight(),
                        GL.GL_RGBA, // External format from image,
                        GL.GL_UNSIGNED_BYTE,
                        texture[i].getPixels() // Imagedata
                );
               
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }
        
        for(int i = 0; i < 50; i++) {
            if (i < 7) {
                currentX = (int) (Math.random() * 10 + 1) * 10;
                while ((Math.abs(currentX - previousX) > 20) || (currentX == previousX)) {
                    currentX = (int) (Math.random() * 10 + 1) * 10;
                }
                eggs.add(new Point(currentX, yy));
                yy += 50;
                previousX = currentX;
            }
            
            else if (i < 15) {
                currentX = (int) (Math.random() * 10 + 1) * 10;
                while ((Math.abs(currentX - previousX) > 30) || (currentX == previousX)) {
                    currentX = (int) (Math.random() * 10 + 1) * 10;
                }
                eggs.add(new Point(currentX, yy));
                yy += 35;
                previousX = currentX;
            }
            else if (i < 20) {
                currentX = (int) (Math.random() * 10 + 1) * 10;
                while ((Math.abs(currentX - previousX) > 40) || (currentX == previousX)) {
                    currentX = (int) (Math.random() * 10 + 1) * 10;
                }
                eggs.add(new Point(currentX, yy));
                yy += 30;
                previousX = currentX;
            } else if (i < 25) {
                currentX = (int) (Math.random() * 10 + 1) * 10;
                while ((Math.abs(currentX - previousX) > 50) || (currentX == previousX)) {
                    currentX = (int) (Math.random() * 10 + 1) * 10;
                }
                eggs.add(new Point(currentX, yy));
                yy += 25;
                previousX = currentX;
            } else if (i < 35) {
                currentX = (int) (Math.random() * 10 + 1) * 10;
                while ((Math.abs(currentX - previousX) > 60) || (currentX == previousX)) {
                    currentX = (int) (Math.random() * 10 + 1) * 10;
                }
                eggs.add(new Point(currentX, yy));
                yy += 18;
                previousX = currentX;
            } else if (i < 50) {
                currentX = (int) (Math.random() * 10 + 1) * 10;
                while ((Math.abs(currentX - previousX) > 60) || (currentX == previousX)) {
                    currentX = (int) (Math.random() * 10 + 1) * 10;
                }
                eggs.add(new Point(currentX, yy));
                yy += 10;
                previousX = currentX;
            }
        }
    }

    int eggshanded = 1;
    int level = 1;
    int oldscore = 0;
    int lifes = 3;
    boolean gameover = false;
    boolean pause = false;
    boolean h = false;
    boolean firstone = true;
    boolean startgame = false;
    boolean helppic = false;
    boolean startagain = false;
    int Chickenindex =10;
    int highscore = 0;
    
    public void display(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        
        if(firstone){
            menu(gl);
            if (isKeyPressed(KeyEvent.VK_ENTER) || ((xPosition <= -90 && xPosition >= -210) && (yPosition <= 160 && yPosition >= 95))) {   
                startgame = true; // lw 3awz ybd2 ell3ba
                firstone = false;
            }
            if (isKeyPressed(KeyEvent.VK_H) || ((xPosition <= 60 && xPosition >= -60) && (yPosition <= 75 && yPosition >= 5))) {       
                helppic = true; // lw 3awz y4of el help
                firstone = false;
            }
            if (isKeyPressed(KeyEvent.VK_ESCAPE) || ((xPosition <= 210 && xPosition >= 90) && (yPosition <= -5 && yPosition >= -75))) {  
                firstone = false;
                System.exit(0); //exit
            }
        }
        if (!firstone && startgame) {
            gameplay(gl);
            if (isKeyPressed(KeyEvent.VK_ESCAPE)) {
                pause = !pause;
            }
        }
        if (pause && !gameover) {
            pause(gl);
        } else if (gameover) {
            gameover(gl);
        }
        if (!firstone && helppic) {
            help(gl);
            if (isKeyPressed(KeyEvent.VK_ESCAPE)) {
                firstone = true;
                helppic = false;
            }
        }
        if (lifes < 1) {
            gameover = true;
        }
        if (gameover && isKeyPressed(KeyEvent.VK_ENTER)) {
            reset();
            startagain = true;
        }
        if (startagain) {
            init(gld);
            startagain = false;
        }
    }

    public void DrawSprite(GL gl, int x, int y, int indexx, float scale) {
        GLUT glut = new GLUT();
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[indexx]);	// Turn Blending On

        gl.glPushMatrix();
        gl.glTranslated(x / (maxWidth / 2.0) - 0.9, y / (maxHeight / 2.0) - 0.9, 0);
        gl.glScaled(0.1 * scale, 0.1 * scale, 1);
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
    Color c1 = new Color(0, 0, 0);

    public void DrawBackground(GL gl) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[4]);
        // Turn Blending On
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
    boolean soundone = false;
    public void gameplay(GL gl) {
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);       //Clear The Screen And The Depth Buffer
        gl.glLoadIdentity();
        GLUT glut = new GLUT();
        Font font = new Font("ARIAL", Font.BOLD, 50);
        DrawBackground(gl);
        try {
            handleKeyPress(gl);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(AnimGLEventListener2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AnimGLEventListener2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(AnimGLEventListener2.class.getName()).log(Level.SEVERE, null, ex);
        }

        t.beginRendering(500,500);
        t.setColor(c1.RED);
        t.draw("SCORE : " + score,2, 10);
        t.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        t.endRendering();

        t.beginRendering(400, 400);
        t.setColor(c1.BLACK);
        t.draw("LEVEL : " + level,5, 380);
        t.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        t.endRendering();

        t.beginRendering(200,200);
        t.setColor(c1.RED);
        t.draw(""+lifes,190,3);
        t.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        t.endRendering();
        
        DrawSprite(gl,0,78,  Chickenindex, 2);
        DrawSprite(gl,7,78,  Chickenindex, 2);
        DrawSprite(gl,14,78, Chickenindex, 2);
        DrawSprite(gl,21,78, Chickenindex, 2);
        DrawSprite(gl,28,78, Chickenindex, 2);
        DrawSprite(gl,35,78, Chickenindex, 2);
        DrawSprite(gl,42,78, Chickenindex, 2);
        DrawSprite(gl,49,78, Chickenindex, 2);
        DrawSprite(gl,56,78, Chickenindex, 2);
        DrawSprite(gl,63,78, Chickenindex, 2);
        DrawSprite(gl,70,78, Chickenindex, 2);
        DrawSprite(gl,77,78, Chickenindex, 2);
        DrawSprite(gl,84,78, Chickenindex, 2);
        DrawSprite(gl,91,78, Chickenindex, 2);
        DrawSprite(gl,98,78, Chickenindex, 2);
        
        
        Chickenindex++;
        if(Chickenindex == 13){
            Chickenindex = 10 ;
        }
        for (int i = 0; i < eggs.size(); i++) {
             if(eggs.get(i).y == 72){
                    soundFile = new File("sound3.wav");
                    try {
                    audioIn = AudioSystem.getAudioInputStream (soundFile);// getAudioInputStream(soundFile);
                    } catch (UnsupportedAudioFileException ex) {
                        Logger.getLogger(AnimGLEventListener2.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(AnimGLEventListener2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        clip = AudioSystem.getClip();
                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(AnimGLEventListener2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        clip.open(audioIn);
                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(AnimGLEventListener2.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(AnimGLEventListener2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    clip.start();
                }
            if(eggs.get(i).y <69){   
                DrawSprite(gl, eggs.get(i).x, eggs.get(i).y, 1, 0.3f);
               
            }   
            
            if(!pause && !gameover){
                eggs.get(i).y--;
            }
        }

        for (int j = 0; j < eggs.size(); j++) {
            if ((eggs.get(j).y - 5) == y && ((eggs.get(j).x > x-5)&&(eggs.get(j).x <x+5))) {
                oldscore = score;
                eggshanded++;
                if (eggshanded < 8) {
                    score += 10;
                    level = 1;
                }
                else if (eggshanded < 15) {
                    score += 20;
                    level = 2;
                } else if (eggshanded < 20) {
                    score += 30;
                    level = 3;
                } else if (eggshanded < 25) {
                    score += 40;
                    level = 4;
                } else if (eggshanded < 30) {
                    score += 50;
                    level = 5;
                } else if (eggshanded < 35) {
                    score += 30;
                    level = 6;
                } else if (eggshanded < 40) {
                    score += 40;
                    level = 7;
                } else if (eggshanded < 45) {
                    score += 50;
                    level = 8;
                } else if (eggshanded < 50) {
                    score += 60;
                    level = 9;
                }
                eggs.remove(j);
                t.beginRendering(200, 200);
                t.setColor(c1.BLACK);
                t.draw("+" + (score - oldscore), 10, 10);
                t.setColor(1.0f, 1.0f, 1.0f, 1.0f);
                t.endRendering();
            } else if ((eggs.get(j).y - 5) == y && (!(eggs.get(j).x > x-5)||(!(eggs.get(j).x <x+5))))  {
                lifes--;
                if (lifes == 0) {
                    gameover = true;
                }
                if(lifes >0 && !gameover)
                {
                    soundFile = new File("sound2.wav");
                    try {
                    audioIn = AudioSystem.getAudioInputStream (soundFile);// getAudioInputStream(soundFile);
                    } catch (UnsupportedAudioFileException ex) {
                        Logger.getLogger(AnimGLEventListener2.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(AnimGLEventListener2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        clip = AudioSystem.getClip();
                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(AnimGLEventListener2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        clip.open(audioIn);
                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(AnimGLEventListener2.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(AnimGLEventListener2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    clip.start();
                }
                }
        }
    }
    int scoreeee = 0;
    int soundgameover = 0 ;
    public void gameover(GL gl) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[3]);
        // Turn Blending On
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
        t.beginRendering(200, 200);
        t.setColor(c1.BLACK);
        scoreeee = score;
        t.draw("your Score is : " + scoreeee, 45, 40);
        t.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        t.endRendering();
        
        t.beginRendering(200,200);
        t.setColor(c1.BLACK);
        t.draw("High Score : " + highscore, 45 , 20);
        t.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        t.endRendering();
        
        if(highscore < score){
            highscore = score;
        }
        if(soundgameover == 1){
            soundFile = new File("gameover.wav");
            try {
            audioIn = AudioSystem.getAudioInputStream (soundFile);// getAudioInputStream(soundFile);
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(AnimGLEventListener2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AnimGLEventListener2.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                clip = AudioSystem.getClip();
            } catch (LineUnavailableException ex) {
                Logger.getLogger(AnimGLEventListener2.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                clip.open(audioIn);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(AnimGLEventListener2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AnimGLEventListener2.class.getName()).log(Level.SEVERE, null, ex);
            }
            clip.start();
        }
        soundgameover++;
    }

    public void pause(GL gl) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[9]);
        // Turn Blending On
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
    boolean music = false;
    public void menu(GL gl) {
        music = true;
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[7]);
        // Turn Blending On
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
//        gl.glDisable(GL.GL_BLEND);
//        
//        gl.glEnable(GL.GL_BLEND);
//        t.beginRendering(400, 400);
//        t.setColor(c1.BLACK);
//        t.draw("press Enter to play ", 10, 270);
//        t.setColor(1.0f, 1.0f, 1.0f, 1.0f);
//        t.endRendering();
//
//        t.beginRendering(400, 400);
//        t.setColor(c1.BLACK);
//        t.draw("press h to show the help ", 10, 220);
//        t.setColor(1.0f, 1.0f, 1.0f, 1.0f);
//        t.endRendering();
//
//        t.beginRendering(400, 400);
//        t.setColor(c1.BLACK);
//        t.draw("press Escape to quit ", 10, 180);
//        t.setColor(1.0f, 1.0f, 1.0f, 1.0f);
//        t.endRendering();

        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[2]);
        // Turn Blending On
        gl.glPushMatrix();
        gl.glTranslated(x / (maxWidth / 2.0) - .5, y / (maxHeight / 2.0) - 0.25, 0);
        gl.glScaled(0.2, 0.2, 0.2);

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
//        gl.glDisable(GL.GL_BLEND);
//        
//        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[5]);
        // Turn Blending On
        gl.glPushMatrix();
        gl.glTranslated(x / (maxWidth / 2.0) - 1.0, y / (maxHeight / 2.0) + 0.2, 0);
        gl.glScaled(0.2, 0.2, 0.2);

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
//        gl.glDisable(GL.GL_BLEND);
//        
//         gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[8]);
        // Turn Blending On
        gl.glPushMatrix();
        gl.glTranslated(x / (maxWidth / 2.0) - 1.5, y / (maxHeight / 2.0) + 0.7, 0);
        gl.glScaled(0.2, 0.2, 0.7);

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

    public void reset() {
        firstone = false;
        eggshanded = 0;
        level = 1;
        oldscore = 0;
        lifes = 3;
        gameover = false;
        pause = false;
        previousX = 0;
        currentX = 0;
        score = 0;
    }

    public void help(GL gl) {
        h = true;
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[6]);
        // Turn Blending On
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
    }
    public int getscore(){
        return highscore ;
    }
    public void sethighscore(int highscoree){
        highscore = highscoree;
    }
    public void handleKeyPress(GL gl) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        if (isKeyPressed(KeyEvent.VK_LEFT)) {
            if (x > 0) {
                x -= 2;
                DrawSprite(gl, x, y, 0,0.8f);
                if(!gameover){
                    soundFile = new File("sound2.wav");
                    audioIn = AudioSystem.getAudioInputStream (soundFile);// getAudioInputStream(soundFile);
                    clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
                }
            }
        }
        if (isKeyPressed(KeyEvent.VK_RIGHT)) {
            if (x < maxWidth - 10) {
                x += 2;
                DrawSprite(gl, x, y, 0, 0.8f);
               if(!gameover){
                    soundFile = new File("sound2.wav");
                    audioIn = AudioSystem.getAudioInputStream (soundFile);// getAudioInputStream(soundFile);
                    clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
                }
            }
        }
        DrawSprite(gl, x, y, index,0.8f);
        
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
    }

    public boolean isKeyPressed(final int keyCode) {
        return keyBits.get(keyCode);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        Component c = e.getComponent();
        double width = c.getWidth();
        double height = c.getHeight();

        xPosition = (int) ((x / width) * 600) - 300;
        yPosition = 175 - ((int) ((y / height) * 350));
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
    }

    @Override
    public void displayChanged(GLAutoDrawable glad, boolean bln, boolean bln1) {
    }
//    public void playSound(String soundfile){
//        File f = new File("./" + soundfile);
//        AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
//        Clip clip = AudioSystem.getClip();
//        clip.open();
//        clip.start();
//    }
//    
    
    
    
}

/* 4a8aaaaal
  
      if(firstone){
            menu(gl);
            if(isKeyPressed(KeyEvent.VK_ENTER)){
                startgame = true; // lw 3awz ybd2 ell3ba
                firstone = false;
            }
            if(isKeyPressed(KeyEvent.VK_H)){
                helppic = true; // lw 3awz y4of el help
                firstone = false;
            }
            if(isKeyPressed(KeyEvent.VK_ESCAPE)){
                firstone = false;
                System.exit(0); //exit
            }
        }
        if(!firstone && startgame){
            gameplay(gl);
            if(isKeyPressed(KeyEvent.VK_ESCAPE)){
                pause = !pause;
            }
        }
        if(pause && !gameover)
            pause(gl);
        else if(gameover){
            gameover(gl);
        }
        if(!firstone && helppic){
            help(gl);
            if(isKeyPressed(KeyEvent.VK_ESCAPE)){
                firstone = true;
                helppic = false;
            }
        }
        if(lifes < 1){
            gameover = true ; 
        }
        


        
 */
 /*
                    baaaaz
//        else{
//            if(startgame && isKeyPressed(KeyEvent.VK_ESCAPE)){
//                pause = !pause;
//                if(pause && !gameover)
//                    pause(gl);
//                else{
//                    if(gameover)
//                        gameover(gl);
//                    else
//                        gameplay(gl);
//                }
//            }
//            if(gameover && isKeyPressed(KeyEvent.VK_ENTER)){
//                reset();
//                gameplay(gl);
//            }
//        }
//       
//        if(firstone){
//            menu(gl);
//            if(isKeyPressed(KeyEvent.VK_H) || isKeyPressed(KeyEvent.VK_ENTER) || isKeyPressed(KeyEvent.VK_ESCAPE)){
//                firstone = false;
//            }
//            System.out.println("gwaaa el if");
//        }
//        else{
//            System.out.println("gwaaa el else");
//            if(isKeyPressed(KeyEvent.VK_ENTER)){
//                gameplay(gl);
//            }
//            if(isKeyPressed(KeyEvent.VK_H)){
//                help(gl);
//            }
//            if(h && isKeyPressed(KeyEvent.VK_ESCAPE) ){
//                menu(gl);
//            }
//            if(isKeyPressed(KeyEvent.VK_ESCAPE))
//            {
//                pause = !pause;
//            }
//            if(pause && !gameover)
//                pause(gl);
//            else{
//                if(gameover)
//                    gameover(gl);
//                else
//                    gameplay(gl);
//            }
//        }


 */
