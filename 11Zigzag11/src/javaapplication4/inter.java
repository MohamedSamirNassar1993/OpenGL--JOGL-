/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

/**
 *
 * @author Layla
 */


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.IOException;
import javax.media.opengl.*;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;


public class inter extends JFrame implements MouseListener{
   static inter app;
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        app=new inter();
    }

    GLCanvas glcanvas;
    interL l;
    int xPosition, yPosition;


    public inter() {
        l = new interL();
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(l);
        glcanvas.addMouseListener(this);
        getContentPane().add(glcanvas, BorderLayout.CENTER);


        setTitle("Zigzag");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setFocusable(true);
        glcanvas.requestFocus();
    }

    
    public void mouseClicked(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        Component c = e.getComponent();
        double width = c.getWidth();
        double height = c.getHeight();

        xPosition = (int) ((x / width) * 500);
       yPosition = ((int) ((y / height) * 500));
         xPosition=xPosition-250;
        yPosition = 250 - yPosition;
      if((xPosition>-24&&xPosition<55)&&(yPosition>-144&&yPosition<-100)){
         setVisible(false);
         dispose();
         System.exit(0);
      }
       if((xPosition>-75&&xPosition<75)&&(yPosition>-10&&yPosition<30)){
           setVisible(false);
         dispose();
            Final f=new Final();

          f.setVisible(true);
       }
      
    }


    
    public void mousePressed(MouseEvent e) {
    }

   
    public void mouseReleased(MouseEvent e) {
    }

    
    public void mouseEntered(MouseEvent e) {
    }

    
    public void mouseExited(MouseEvent e) {
    }

  
    
}
class interL implements GLEventListener {
     final String assetsFolderName = "Texture";

    String textureName = "back.png";
    TextureReader.Texture texture;
    int textureIndex[] = new int[1];
    int xPosition,yPosition;    
    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);    

        gl.glEnable(GL.GL_TEXTURE_2D);  
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);


        gl.glGenTextures(1, textureIndex, 0);

        try {
            texture = TextureReader.readTexture( textureName, true);
            gl.glBindTexture(GL.GL_TEXTURE_2D, textureIndex[0]);


            new GLU().gluBuild2DMipmaps(
                    GL.GL_TEXTURE_2D,
                    GL.GL_RGBA, 
                    texture.getWidth(), texture.getHeight(),
                    GL.GL_RGBA, 
                    GL.GL_UNSIGNED_BYTE,
                    texture.getPixels() 
            );
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

   
    public void display(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);      
        gl.glLoadIdentity();

        DrawBackground(gl);
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
    
    public void DrawBackground(GL gl) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textureIndex[0]);	

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

        gl.glDisable(GL.GL_BLEND);
    }

    
   
}
