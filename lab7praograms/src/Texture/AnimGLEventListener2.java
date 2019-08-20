package Texture;

import java.awt.Point;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.media.opengl.*;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import javax.media.opengl.glu.GLU;

public class AnimGLEventListener2 implements GLEventListener, KeyListener {

    final String assetsFolderName = "Texture";

    int maxWidth = 100;
    int maxHeight = 100;
    int x = maxWidth / 2, y = 1/* maxHeight / 2*/;
    int index = 0;
    int indexx = 0;
    int yy = 100;

    ArrayList<Point> balls = new ArrayList<Point>();
    ArrayList<Point> fires = new ArrayList<Point>();
    
    String textureNames[] = {"Man1.png", "Man2.png", "Man3.png", "Man4.png", "Back.png", "ball.png","fire.png"};
    TextureReader.Texture texture[] = new TextureReader.Texture[textureNames.length];
    int textures[] = new int[textureNames.length];

    /*
     5 means gun in array pos
     x and y coordinate for gun 
     */
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
        
        for(int i = 0 ; i<200;i++){
            balls.add( new Point( (int) (Math.random() * 10 + 1)*10 , yy));
            yy+=20;
        }
        
        
    }

    public void display(GLAutoDrawable gld) {

        GL gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);       //Clear The Screen And The Depth Buffer
        gl.glLoadIdentity();

        DrawBackground(gl);
        handleKeyPress(gl);
        
        
        for(int i = 0 ; i<balls.size() ;i++){
            DrawSprite(gl, balls.get(i).x, balls.get(i).y, 5, 1);
            balls.get(i).y--;
        }
        for(int j = 0 ; j<fires.size() ;j++){
            DrawSprite(gl, fires.get(j).x, fires.get(j).y, 6, 1);
            fires.get(j).y+=2;
            
        }
        for(int i = 0 ; i <fires.size() ;i++){
            for(int j = 0 ; j<balls.size() ;j++){
                if(fires.get(i).y == balls.get(j).y && (fires.get(i).x <= balls.get(j).x+10 && fires.get(i).x >= balls.get(j).x-10)){
                    balls.remove(j);
                    fires.remove(i);
                    break;
                }
            }
        }
        
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void DrawSprite(GL gl, int x, int y, int indexx, float scale) {

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
    
    public void DrawBackground(GL gl) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[4]);	// Turn Blending On

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
    public void handleKeyPress(GL gl) {

        if (isKeyPressed(KeyEvent.VK_LEFT)) {
            if (x > 0) {
                x-=2;
                DrawSprite(gl, x, y, index, 1);
            }
        }
        if (isKeyPressed(KeyEvent.VK_RIGHT)) {
            if (x < maxWidth - 10) {
                x+=2;
                DrawSprite(gl, x, y, index, 1);
            }
        }
        if (isKeyPressed(KeyEvent.VK_DOWN)) {
            if (y > 0) {
                y--;
            }
            if (index < 3) {
                DrawSprite(gl, x, y, index, 1);
                index++;
            } else {
                index = 0;
                DrawSprite(gl, x, y, index, 1);
            }
        }
        if (isKeyPressed(KeyEvent.VK_UP)) {
            if (y < maxHeight - 10) {
                y++;
            }
            if (index < 3) {
                DrawSprite(gl, x, y, index, 1);
                index++;
            } else {
                index = 0;
                DrawSprite(gl, x, y, index, 1);
            }

        }
        if (isKeyPressed(KeyEvent.VK_ENTER)) {
            fires.add(new Point(x,y+10));
        }
        
        DrawSprite(gl, x, y, index, 1);

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
