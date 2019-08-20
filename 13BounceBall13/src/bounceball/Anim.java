package bounceball;

import static bounceball.Menu.panel;
import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.media.opengl.*;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.media.opengl.*;
import java.util.BitSet;
import javax.media.opengl.glu.GLU;
import java.util.BitSet;
import java.util.Random;
import javax.media.opengl.glu.GLU;
import javax.swing.plaf.basic.BasicComboBoxUI;

    public class Anim implements GLEventListener, KeyListener {
   GLCanvas glcanvas;
    Anim listener;
    Animator animator;
    int score;
    final String assetsFolderName = "bounceball";
    int animationIndex =0;
    ArrayList<bounceball.enemy> b = new ArrayList<>(); //bullets
    int maxWidth = 100;
    int maxHeight = 100;
    int texCounter, enmtexCounter, frameCounter, collapced = 0;
    bounceball.enemy [][] enem = new bounceball.enemy [20][20]; //enemies
    boolean [][] enempos = new boolean [20][20];
    int state = 0;
    int level = 1;
    double x = maxWidth/2; double y= maxHeight/2;
    double theta = 0.0;
    GL gl;
    String textureNames[] = {"zuma1.png","yellowball.png" ,"greenball.png","blueball.png","redball.png","back1.png","gameover.png","pause.png", "1.png", "2.png", "3.png", "4.png", "5.png", "6.png", "7.png", "8.png", "9.png"};
    TextureReader.Texture texture[] = new TextureReader.Texture[textureNames.length];
    int textures[] = new int[textureNames.length];
    boolean create = true;
    boolean pressed = false;
    boolean q = false; 
    boolean z = false;
    enemy bullt  = new enemy(50, 15, theta, 0,false);
    /*
     5 means gun in array pos
     x and y coordinate for gun
     */
    public void init(GLAutoDrawable gld) {
        score = 0;
        panel.setVisible(true);
        
        GL gl = gld.getGL();
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);    //This Will Clear The Background Color To Black

        gl.glEnable(GL.GL_TEXTURE_2D);  // Enable Texture Mapping
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
        gl.glGenTextures(textureNames.length, textures, 0);

        for(int i = 0; i < textureNames.length; i++){
            try {
                texture[i] = TextureReader.readTexture(assetsFolderName + "//" + textureNames[i] , true);
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
            } catch( IOException e ) {
              System.out.println(e);
              e.printStackTrace();
            }
        }
    }

    public void display(GLAutoDrawable gld) {
        gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);       
        gl.glLoadIdentity();
        DrawBackground(gl, 5);
        handleKeyPress();
       
        if ( state == 0){
            
            DrawSprite(gl, 50 , 5 , 0, 1, theta);//zumba
            DrawSprite(gl, 50 - 7*Math.sin(Math.toRadians(theta)), 8 + 7*Math.cos(Math.toRadians(theta)), bullt.color, 1, 0);//cora fo2 zumb
            if (create == true)
                creatlevel(level);
            drawbullets();
            if(!check()){
                level++;
                create = true;
            }
        }
          if (level == 1) {
                DrawSprite(gl, 90, 5, 8, (float) 0.5, 0);
            }
            if (level == 2) {
                DrawSprite(gl, 90, 5, 9, (float) 0.5, 0);
            }
            if (level == 3) {
                DrawSprite(gl, 90, 5, 10, (float) 0.5, 0);
            }
            if (level == 4) {
                DrawSprite(gl, 90, 5, 11, (float) 0.5, 0);
            }
            if (level == 5) {
                DrawSprite(gl, 90, 5, 12, (float) 0.5, 0);
            }
            if (level == 6) {
                DrawSprite(gl, 90, 5, 13, (float) 0.5, 0);
            }
            if (level == 7) {
                DrawSprite(gl, 90, 5, 14, (float) 0.5, 0);
            }
            if (level == 8) {
                DrawSprite(gl, 90, 5, 15, (float) 0.5, 0);
            }
            if (level == 9) {
                DrawSprite(gl, 90, 5, 16, (float) 0.5, 0);
            }
            
        else if(state == 2)
            DrawSprite(gl, 50, 50, 6, 1.4f, 360);
        else if(state == 1)
            DrawSprite(gl, 50, 50, 7, 1, 360);
}
//check for colletion  
    public  void creatlevel(int l){
        for (int i = 0; i < level ; i++) {
            for (int j = 0; j < 10; j++) {
                if(create){
                    enem[i][j] = new bounceball.enemy(4 + j * 9,90-(i*9), 0,0,false);
                    enempos[i][j] = true;
                }
            }
        }
        create = false;
    }
    public boolean check(){
        for (int i = 0; i < 10 ; i++) {
            for (int j = 0; j < 10; j++) {
                if(enempos[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
    public void drawbullets(){
        for (int k = 0; k < b.size(); k++) {
            DrawSprite(gl, b.get(k).x, b.get(k).y, b.get(k).color, 1, b.get(k).angle);
            b.get(k).x -= 2*Math.sin(Math.toRadians(b.get(k).angle));
            b.get(k).y += 2*Math.cos(Math.toRadians(b.get(k).angle));
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    //System.out.println(enem[i][j].x+" "+ b.get(k).x+" "+enem[i][j].y+" "+ b.get(k).y );
                        if(enempos[i][j] && Math.abs(enem[i][j].x - b.get(k).x) <= 4 && Math.abs(enem[i][j].y - b.get(k).y) <= 4 && b.get(k).color == enem[i][j].color ){
                        //System.err.println(b.size());
                         score += 5;
                        // System.out.print(score);
                           Menu.scot.setText(score + "");
                        //System.out.println(enem[i][j].x+" "+enem[i][j].y);
                        b.remove(k);
                      
                        enempos[i][j] = false;
                        q = true;
                        break;
                    }
                    if(b.isEmpty())break;
                    else if(enempos[i][j] && Math.abs(enem[i][j].x - b.get(k).x) <= 4 && Math.abs(enem[i][j].y - b.get(k).y) <= 4 && b.get(k).color != enem[i][j].color ){
                        enem[i+1][j] = new enemy(b.get(k).x, b.get(k).y-5, 0,b.get(k).color,true);
                        enempos[i+1][j] = true;
                        b.remove(k);
                       
                        break;
                    }
                }
                if(q){
                    q = false;
                    break;
                }
            }
        }
        //  game over
        for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if(enempos[i][j]){
                        DrawSprite(gl,enem[i][j].x, enem[i][j].y, enem[i][j].color, 1, 0);
                        if(enem[i][j].y <= 20)
                            state = 2;
                    }
                }
        }
        
        for (int k = 0; k < b.size(); k++)
            if (b.get(k).y >= 100)
                b.remove(k);
    }
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void DrawSprite(GL gl,double x, double y, int index, float scale, double theta){
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]);	// Turn Blending On
        gl.glPushMatrix();
            
            gl.glTranslated( x/(maxWidth/2.0) - 0.9, y/(maxHeight/2.0) - 0.9, 0);
            if (theta == 360)
                gl.glScaled(0.8*scale, 0.8*scale, 1);
            else
                gl.glScaled(0.1*scale, 0.1*scale, 1);
            if (index == 0)
                gl.glRotated(theta, 0, 0, 1 );
           
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

    public void DrawBackground(GL gl, int i){
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[i]);	// Turn Blending On

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
        if (isKeyPressed(KeyEvent.VK_LEFT)&& state == 0) {
            if (theta < 50 ) {
                theta += 2 ;
            }
        }
        if (isKeyPressed(KeyEvent.VK_RIGHT)&& state ==0) {
            if (theta >  -50) {
                theta -= 2;
            }
        }
        if (isKeyPressed(KeyEvent.VK_DOWN)&& state ==0) {
        }
        if (isKeyPressed(KeyEvent.VK_UP)&& state ==0) {
        }
        if (isKeyPressed(KeyEvent.VK_SPACE)&& state ==0 && b.size() < 1) {
            bullt.angle = theta;
            bullt.x = 50 - 7*Math.sin(Math.toRadians(theta));
            bullt.y = 10 + 7*Math.cos(Math.toRadians(theta));
            b.add(bullt);
            bullt = new enemy(50, 13, theta,0,false);
        }
        if (isKeyPressed(KeyEvent.VK_ESCAPE) && !z ) {
            z = true;
            
            Menu.g.dispose();
            Menu.g = new Menu();

        }
        if (isKeyPressed(KeyEvent.VK_ENTER) && state == 2 ) {
            //            collapced = 0;
//            gameOver = 0;
//            x = 50;
//            y = 50;
            enempos = new boolean[10][10];
            b.clear();
            texCounter = enmtexCounter = frameCounter = collapced = 0;
            state = 0;
            level = 1;
            create = true;
            score = 0;
        }
        if (isKeyPressed(KeyEvent.VK_P)) {
            if (state == 0) {
                state = 1;
            } else if (state == 1) {
                state = 0;
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
}

