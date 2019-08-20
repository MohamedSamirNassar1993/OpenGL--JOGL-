package Texture;

import java.awt.event.*;
import java.io.IOException;
import javax.media.opengl.*;
import java.util.BitSet;
import javax.media.opengl.glu.GLU;
import java.awt.Component;


public class SnakeEventListener implements GLEventListener,KeyListener,MouseListener{
        final String assetsFolderName = "Texture";
    int animationIndex = 0;
    int maxWidth = 100;
    int maxHeight = 100;
    boolean b = false;
    double x =23.2, y = 44.1 ,x1 = 17.4 ,y1 = 44 , x2 = 11.4 , y2 = 44 , x3=74 , y3=44;
    double snake[][]= new double[50][2] ;
    int comp = 2;
    String textureNames[] = {"A1.png","Fright.png","life.png","Ground.png","body.png","dright.png","A3.png","pause.png"};
    TextureReader.Texture texture[] = new TextureReader.Texture[textureNames.length];
    int textures[] = new int[textureNames.length];
    
  public void init(GLAutoDrawable drawable) {
	  	GL gl = drawable.getGL();
	    
	    gl.glClearColor(0.4f, 0.5f, 0.1f, 1.0f);
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
 int c = 0;
  public void display(GLAutoDrawable drawable) {
		GL gl = drawable.getGL();
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
                gl.glLoadIdentity(); 
                DrawBackground(gl);
                handleKeyPress();

           Drawsnake(gl);
     DrawSprite(gl, x,y, 1, 0.06f);
     DrawSprite(gl, x1,y1,4, 0.06f);
     DrawSprite(gl, x2,y2,5, 0.06f);
     DrawSprite(gl, x3,y3, 0, 0.08f);
     DrawSprite(gl, 75,90, 2, 0.06f);
     DrawSprite(gl, 80,90, 2, 0.06f);
     DrawSprite(gl, 85,90, 2, 0.06f);
     DrawSprite(gl, 1.9,91.4, 6, 0.08f);
     DrawSprite(gl, 68,90.6, 7, 0.08f);
  }
    public void Drawsnake(GL gl){
        for(int i =0; i<=comp; i++){
        double fx = snake [i][0];
        double fy = snake [i][1];
        
            if( i==0){
            }
        }
  }
  public void DrawBackground(GL gl){
        gl.glEnable(GL.GL_BLEND);	
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[3]);	// Turn Blending On

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
   public void DrawSprite(GL gl,double x, double y, int index, float scale){
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]);	// Turn Blending On

        gl.glPushMatrix();
            gl.glTranslated( x/(maxWidth/2.0) - 0.9, y/(maxHeight/2.0) - 0.9, 0);
            gl.glScaled(scale, scale, 1);
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
  public void reshape(
                        GLAutoDrawable drawable, 
                        int x, 
                        int y, 
                        int width, 
                        int height
                      ) {}
  
  
  
	
  public void displayChanged(
                              GLAutoDrawable drawable, 
                              boolean modeChanged, 
                              boolean deviceChanged
                            ) {}

public void dispose(GLAutoDrawable arg0) {
	// TODO Auto-generated method stub
	
}

  public void handleKeyPress() {

        if (isKeyPressed(KeyEvent.VK_LEFT)) {
            if (x > 0) {
                x--;
                x1--;
                x2--;
            }
        }
        if (isKeyPressed(KeyEvent.VK_RIGHT)) {
            if (x < maxWidth-10) {
                x++;
                x1++;
                x2++;
            }
                animationIndex++;
        }
        if (isKeyPressed(KeyEvent.VK_DOWN)) {
            if (y > 0) {
                y--;
                y1--;
                y2--;
            }
                animationIndex++;
        }
        if (isKeyPressed(KeyEvent.VK_UP)) {
            if (y < maxHeight-10) {
                y++;
                y1++;
                y2++;
            }
                animationIndex++;
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

     
    public void mouseClicked(MouseEvent e) {

        double x = e.getX();
        double y = e.getY();
        Component c = e.getComponent();
        double width = c.getWidth();
        double height = c.getHeight();
        double u =  ((x / width) * 750 - 375);
        double v = ((((height - y) / height) * 700 - 350));
           //System.out.println(u + v);
            
        if(u >= 465.4 && u <= 517.6 && v >= 469.7 && v <= 508.9)
           System.out.println(u + " " +v);


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
   


 
    