/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bounceball;




import bounceball.Anim;
import static bounceball.Menu.glcanvas;
import static bounceball.Menu.lis;
import static bounceball.Menu.panel;
import com.sun.opengl.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import java.util.BitSet;
import javax.media.opengl.*;
import javax.media.opengl.glu.GLU;
import javax.swing.*;


public class Menu extends JFrame {
    static Menu g;
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
           
        }
        g = new Menu();
       
    }
    
      static JLabel score = new JLabel("score");
      
      static JTextField scot = new JTextField("0" , 3);
      static JLabel text = new JLabel("press P for pause and esc back to main menu");
       static JPanel panel = new JPanel();

    static GLCanvas glcanvas;
    //listeners
  ballGLEventListener listener1 = new ballGLEventListener();
    Anim listener2 = new Anim();
  

    static ArrayList<Object> lis = new ArrayList<Object>();
    Animator animator;
  
 
     public Menu() {
         
         
           panel.setLayout(new FlowLayout(FlowLayout.CENTER));
          
             panel.add(score);
              panel.add(scot);
          
              panel.add(text);
               getContentPane().add(panel, BorderLayout.SOUTH);
               panel.setVisible(false);

   //add listeners
        lis.add(listener1);
        lis.add(listener2);
    
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener((ballGLEventListener) lis.get(0));
        glcanvas.addKeyListener((ballGLEventListener) lis.get(0));

        getContentPane().add(glcanvas, BorderLayout.CENTER);
        animator = new FPSAnimator(30);
        animator.add(glcanvas);
        animator.start();

        setTitle("");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);
        setVisible(true);
        setFocusable(true);
        glcanvas.requestFocus();
    }
    
}
class ballGLEventListener implements GLEventListener, KeyListener {

    Animator animator;
    Anim eventListener1;
    int animationIndex = 0;
    int maxWidth = 100;
    int maxHeight = 100;

    int x = 10, y = 10;

    String textureNames[] = {"image//back2.png" , "image//start-hi.png" , "image//redpoint.png" ,"image//word.png" ,"image//quit.png" };
    TextureReader.Texture texture[] = new TextureReader.Texture[textureNames.length];
    int textures[] = new int[textureNames.length];

    /*
     5 means gun in array pos
     x and y coordinate for gun 
     */
  int pointx, pointy;
  
 public void init(GLAutoDrawable gld) {
//clear keybits to go back between pages
        keyBits.clear();

       
        GL gl = gld.getGL();

        gl.glEnable(GL.GL_TEXTURE_2D);  // Enable Texture Mapping
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
        gl.glGenTextures(textureNames.length, textures, 0);

        for (int i = 0; i < textureNames.length; i++) {
            try {
                texture[i] = TextureReader.readTexture(textureNames[i], true);
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
            } catch (IOException e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }
      pointx = 65;
        pointy = 64;
    }

  
       
      
    
    public void display(GLAutoDrawable gld) {

        GL gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);       
        gl.glLoadIdentity();

        DrawBackground(gl);

    
       
        //bounceball
        DrawSprite(gl, 45, 87, 3, 1,  0.8, 0.1);
        //start
        DrawSprite(gl, 50, 64,1, (float) 0.1, 2, 1);
        //quit
        DrawSprite(gl, 50, 50, 4, (float) 0.1, 3, 2);
        //point
        DrawSprite(gl, pointx, pointy, 2, (float) 0.1, 1, 1);
        handleKeyPress();
       

    }
   

  

     public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }
      public void handleKeyPress() {

        if (isKeyPressed(KeyEvent.VK_UP)) {
            if (pointy == 50) {   
                pointy = 64;
            }
        }
        if (isKeyPressed(KeyEvent.VK_DOWN)) {
            if (pointy == 64) {
               
                pointy = 50;
            }
        }
        if (isKeyPressed(KeyEvent.VK_ENTER)) {
            if (pointy == 64) {
                
            GLContext context = glcanvas.getContext();
            context.makeCurrent();
            eventListener1 = (Anim) lis.get(1);
            lis.set(1, eventListener1);
            eventListener1.init(glcanvas);
            eventListener1.display(glcanvas);
            glcanvas.removeGLEventListener((ballGLEventListener) lis.get(0));
            glcanvas.removeKeyListener((ballGLEventListener) lis.get(0));
            glcanvas.addGLEventListener(eventListener1);
            glcanvas.addKeyListener(eventListener1);
            
            panel.setVisible(true);
            
            } else if (pointy == 50) {
               
                 System.exit(0);

           }
           
        }
    }
    
    @Override
    public void displayChanged(GLAutoDrawable glad, boolean bln, boolean bln1) {
      
    }
      public void DrawSprite(GL gl, double x, double y, int index, float scale, double x1, double y1) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]);	// Turn Blending On
//try to recall with index 5 and x,y random
        gl.glPushMatrix();
        gl.glTranslated(x / (maxWidth / 2.0) - 0.9, y / (maxHeight / 2.0) - 0.9, 0);
        gl.glScaled(x1* scale, y1 * scale, 1);
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
       public void DrawBackground(GL gl) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[0]);	// Turn Blending On

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