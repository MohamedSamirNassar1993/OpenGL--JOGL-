package Texture;

import com.sun.opengl.util.j2d.TextRenderer;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.media.opengl.*;
import java.util.BitSet;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;
import javax.sound.midi.*;
import javax.swing.JOptionPane;

public class AnimGLEventListener33 implements GLEventListener, KeyListener{
    final String assetsFolderName = "Texture";
    int i = 0;
    int maxWidth = 100;
    int maxHeight = 100;
    int x = 50, y = 0;
    boolean gameOver = false;
    boolean pause = false;
    int Score = 0;

    ArrayList<texture.bullet> b =new ArrayList<>();
    texture.enemy [] e =new texture.enemy [20];
    int [] exist = new int[20];
    int frame = 0;
    
    JFrame f = new JFrame(); 
    
    String textureNames[] = {"Man1.png","Man2.png","Man3.png","Man4.png","b3.png","ARM1.png","Man11.png","Man22.png","Man33.png","Man44.png"};
    Texture.TextureReader.Texture texture[] = new Texture.TextureReader.Texture[textureNames.length];
    int textures[] = new int[textureNames.length];

    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);   
        
        gl.glEnable(GL.GL_TEXTURE_2D); 
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);	
        gl.glGenTextures(textureNames.length, textures, 0);
        
        for(int i = 0; i < textureNames.length; i++){
            try {
                texture[i] = TextureReader.readTexture(assetsFolderName + "//" + textureNames[i] , true);
                gl.glBindTexture(GL.GL_TEXTURE_2D, textures[i]);

                new GLU().gluBuild2DMipmaps(
                    GL.GL_TEXTURE_2D,
                    GL.GL_RGBA, 
                    texture[i].getWidth(), texture[i].getHeight(),
                    GL.GL_RGBA, 
                    GL.GL_UNSIGNED_BYTE,
                    texture[i].getPixels() 
                    );
            } catch( IOException e ) {
              System.out.println(e);
              e.printStackTrace();
            }
        }
    }
    public void display(GLAutoDrawable gld) {
        if(!pause){
            if(!gameOver){

                GL gl = gld.getGL();
                gl.glClear(GL.GL_COLOR_BUFFER_BIT);       
                gl.glLoadIdentity(); 
                frame++;
                frame %= 15;
                DrawBackground(gl);
                handleKeyPress();
                i = i % 4;
                DrawSprite(gl, x, y, i, 1);

                for (int j = 0; j < 20; j++) {
                    //كريت جندي
                    if(exist[j] == 0 && Math.random() < 0.3){
                        e[j] = new texture.enemy((int)(Math.random()*95), 100);
                        exist[j] = 1;
                    }
                }
                for (int j = 0; j < 20; j++) {
                    //رسم الاعداء
                    if(exist[j] == 1){
                        DrawSprite(gl, e[j].ex, e[j].ey, e[j].frame, 1);
                        e[j].frame++;
                        if(e[j].frame > 9)
                            e[j].frame = 6;
                        e[j].ey--;
                        if(e[j].ey == 0)
                            exist[j] = 0;
                    }
                    //الرصاص يقتل 
                    for (int l = 0; l < b.size(); l++) {
                        if(exist[j] == 1){
                            if(Math.abs(b.get(l).bx - e[j].ex) < 5 && Math.abs(b.get(l).by - e[j].ey) < 5){
                                b.remove(l);
                                exist[j] = 0;
                                Score++;
                            }
                        }
                    }
                    //you die
                    for (int m = 0; m < 20; m++) {
                        if(exist[j] == 1){
                            if(Math.abs(x - e[j].ex) < 5 && Math.abs(y - e[j].ey) < 5){
                                exist[j] = 0;
                                //System.exit(0);                                                   
                                new gameOver().setVisible(true);
                                f.dispose();
                                gameOver=true;
                                Anim.animator.stop();
                                gl.glClear(i);
                                break;
                            }
                        }
                    }

                }
                //يرسم الرصاص 
                for (int j = 0; j < b.size(); j++) {
                    DrawPoilt(gl, b.get(j).bx, b.get(j).by);
                    b.get(j).by++;

                    System.out.println(b.get(j).bx+"\t"+b.get(j).by);
                    if ( b.get(j).by == 100){
                        b.remove(j);
                    }
                }

            }
        
            TextRenderer textRenderer = new TextRenderer(new Font("Arial", Font.BOLD, 60));
            textRenderer.beginRendering(700, 700);
            textRenderer.setColor(Color.BLACK);
            textRenderer.setSmoothing(true);
            textRenderer.draw(""+Score, 550, 650);
            textRenderer.setColor(Color.white);
            textRenderer.endRendering();
        }else if (pause){
            TextRenderer textRenderer = new TextRenderer(new Font("Arial", Font.BOLD, 60));
            textRenderer.beginRendering(700, 700);
            textRenderer.setColor(Color.WHITE);
            textRenderer.setSmoothing(true);
            textRenderer.draw("pause", 300, 350);
            textRenderer.setColor(Color.white);
            textRenderer.endRendering();
            
        }
    }
        

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
    
    public void DrawSprite(GL gl,int x, int y, int index, float scale){
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]);
        gl.glPushMatrix();
            gl.glTranslated( x/(maxWidth/2.0) - 0.9, y/(maxHeight/2.0) - 0.9, 0);
            gl.glScaled(0.1*scale, 0.1*scale, 1);
            gl.glBegin(GL.GL_QUADS);
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
    
    public void DrawBackground(GL gl){
        gl.glEnable(GL.GL_BLEND);	
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[4]);	

        gl.glPushMatrix();
            gl.glBegin(GL.GL_QUADS);
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
    public void DrawPoilt(GL gl,int x, int y){
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[5]);
        gl.glPushMatrix();
            gl.glTranslated( x/(maxWidth/2.0) - 0.9, y/(maxHeight/2.0) - 0.9, 0);
            gl.glScaled(0.05, 0.05, 1);
            gl.glBegin(GL.GL_QUADS);   
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
  

    public void handleKeyPress() {
        
        if (isKeyPressed(KeyEvent.VK_LEFT)) {
            if (x > 0) {
                x--;
            }
            i++;
        }
        if (isKeyPressed(KeyEvent.VK_RIGHT)) {
            if (x < maxWidth-10) {
                x++;
            }
            i++;
        }
        if (isKeyPressed(KeyEvent.VK_DOWN)) {
            if (y > 0) {
                y--;
            }
            i++;
        }
        if (isKeyPressed(KeyEvent.VK_UP)) {
            if (y < maxHeight-10) {
                y++;
            }
            i++;
        }
        if (isKeyPressed(KeyEvent.VK_SPACE)) {
            System.out.println("you pressed Fire");
            if (frame %2 == 0)
                b.add(new texture.bullet(x + 1, y + 4));
        }
    }

    public BitSet keyBits = new BitSet(256);
 
    @Override 
    public void keyPressed(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.set(keyCode);
        if(event.getKeyCode() == KeyEvent.VK_P){
            pause = !pause;
            
            if(pause == false)
                Anim.animator.start();
        
            else if(pause == true){
                Anim.animator.stop();
                //JOptionPane.showConfirmDialog(null,"Enter P To Continue","ERROR",2);
                JOptionPane.showMessageDialog(null,"Enter P To Continue","Attention",2);
            }
        }
        
    } 
 
    @Override 
    public void keyReleased(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.clear(keyCode);
    } 
 
    @Override 
    public void keyTyped(final KeyEvent e) {
        if(e.getKeyChar()== KeyEvent.VK_ESCAPE)
            System.exit(0);
        
    } 
 
    public boolean isKeyPressed(final int keyCode) {
        return keyBits.get(keyCode);
    }
}