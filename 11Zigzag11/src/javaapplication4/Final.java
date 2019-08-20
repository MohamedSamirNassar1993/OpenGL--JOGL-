package javaapplication4;
import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;
import com.sun.opengl.util.j2d.TextRenderer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;


public class Final extends JFrame {

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        new Final();
    }
    GLCanvas glcanvas;
    A listener;
    Animator animator;
    Clip clip;
    AudioInputStream audioInputStream;
    int s = 60;
    public Final() {
      switch(A.color){
            case 4:s=65;
            case 5:s=70;
            case 6:s=75;
            case 7:s=80;
            case 8:s=85;
        }
        
        listener = new A(this);
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);        
        glcanvas.addMouseListener(listener);
        glcanvas.addKeyListener(listener);
        getContentPane().add(glcanvas, BorderLayout.CENTER);
       
        
        
        
        animator = new FPSAnimator(s);
        
      animator.add(glcanvas);
        animator.start();
        setTitle("ZIGZAG");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setFocusable(true);
        glcanvas.requestFocus();
        try {
            String soundName = "mus.wav";
            audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
    
class A implements GLEventListener, KeyListener,MouseListener{
     
    JFrame parent=null;
    int frame = 0;
    int x = 250;
    int y = 400;
    double xb=300,yb=-90; 
    int R=45;
    int c = 0,counter=0;
    static int color=3;
    boolean mode;
    boolean k,s=false;
    final int maxWidth = 600, maxHeight = 600;
    TextRenderer n = new TextRenderer(Font.decode("PLAIN"));
    ArrayList<line> r = new ArrayList<>();
    String textureNames[] = {"1.png", "2.png", "0.jpg", "y.png","g.png","b.png","p.png","o.png","r.png"};
    TextureReader.Texture texture[] = new TextureReader.Texture[textureNames.length];
    int textures[] = new int[textureNames.length];
    boolean hit = false;
    GL gl;

    public A(JFrame jframe){
        parent = jframe;
    }
    
    @Override
    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        gl.glEnable(GL.GL_TEXTURE_2D);
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
        gl.glGenTextures(textureNames.length, textures, 0);

        for (int i = 0; i < textureNames.length; i++) {
            try {
                texture[i] = TextureReader.readTexture(textureNames[i], true);
                gl.glBindTexture(GL.GL_TEXTURE_2D, textures[i]);
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
        
    }

    @Override
    public void display(GLAutoDrawable gld) {
        gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);       
        gl.glLoadIdentity();
        DrawBackground(gl);  
        if(hit){
            drawscore();
        }
        else{
            frame++;
            counter++;
            generate();
            drawroad();
            switch (counter) {
                case 700:
                    
                color=4;
                
                    break;
                case 2*700:
                    
                    color=5;
                    
                    break;
                case 3*700:
                    color=6;
                    
                    break;
                case 4*700:
                    color=7;
                    
                    break;
                case 5*700:
                    color=8;
                    
                    break;    
                default:
                    break;
            }
            DrawBall(gl, xb, yb,color, 1,s);
            //D(gl, 300, 0, 9, 1);
    //        n.beginRendering(300, 120);
    //        n.draw("GAME OVER", 150, 60);
    //        n.endRendering();
    //        frame--;
        }
    }
    void check(){
            
            
    }
    void generate(){
        if (frame % 20 == 0) {
            int i=(int)((Math.random()*10))%2;
            k = true;
            if (i == 1) {                    
                if (x < 550 && k) {
                    x += 77;
                    y+=72;
                } else {
                    i=0;
                }
            } 
            if(i==0) {
                if (x > 190 && k) {
                    x -= 133;
                } else {
                    k=false;
                    x += 77;
                    y+=72;
                    if (x > 600) {
                        k = true;
                    }
                }
                
            }
            r.add(new line(x, y, 1));
            frame = 0;
        }
    }
    void drawroad(){
        for (int i = 0; i < r.size(); i++) {            
            DrawSprite(gl, r.get(i).x, r.get(i).y, r.get(i).z, 1);
            if(Math.abs(yb - r.get(i).y) > 0   && Math.abs(yb - r.get(i).y) <10 ){
                if((Math.abs(xb - r.get(i).x) > 0 && Math.abs(xb - r.get(i).x) < 160 )){
                System.err.println(r.get(i).x+" "+r.get(i).y);
                System.err.println(xb+" "+yb);
                }
                
                else {
                    hit = true;
            }
            }
            r.get(i).y -= 5;
            if (r.get(i).y < -700) {
                r.remove(i);
            }
            if(r.get(i).y<=0 && !s){
               s=true;
               xb=r.get(i).x;
            }
//            xb=r.get(i).x;
//            yb=r.get(i).y;
        }
    }
    public void DrawBall(GL gl, double x, double y, int index, float scale,boolean s) {
        if(s){
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]);
        gl.glPushMatrix();
        if(R==-45){
            xb+=(2.3);
        }  
        else{
            xb-=(3.8);
               
        }
        gl.glTranslated(x / (maxWidth / 2.0) - 1, y / (maxHeight / 2.0), 0);
        gl.glRotated(R,0,0,1.0);
        gl.glScaled(0.12 * scale, 0.12 * scale, 1);
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
        gl.glDisable(GL.GL_BLEND);}
    }
    public void DrawSprite(GL gl, int x, int y, int index, float scale) {

        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]);	
        gl.glPushMatrix();
        gl.glTranslated(x / (maxWidth / 2.0) - 1, y / (maxHeight / 2.0), 0);
        gl.glScaled(0.5 * scale, 0.9 * scale, 1);
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
    public void D(GL gl, int x, int y, int index, float scale) {

        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[9]);
        gl.glPushMatrix();
        gl.glTranslated(x / (maxWidth / 2.0) - 1, y / (maxHeight / 2.0), 0);
        gl.glScaled(0.1 * scale, 0.1 * scale, 1);
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
    public void DrawBackground(GL gl) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[2]);
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
    public void drawPause() {
        n.beginRendering(200, 150);
        n.setColor(Color.BLUE);
       // n.draw("Continue press Escape", 50, 100);
        n.draw("Quit press Enter ", 53, 70);
        n.setColor(Color.WHITE);
        n.endRendering();
    }
    public void drawscore() {
        n.beginRendering(200, 150);
        n.setColor(Color.BLUE);
        n.draw("GAME OVER", 60, 60);
        n.draw("score is : "+counter, 65, 100);
        n.setColor(Color.WHITE);
        n.endRendering();
    }
    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
    }

   
    @Override
    public void displayChanged(GLAutoDrawable glad, boolean bln, boolean bln1) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(R==45)
            R=-45;
        else
            R=45;
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
       if(e.getKeyCode() == KeyEvent.VK_SPACE )
       {
            inter f = new inter();
            parent.dispose();
        }
    }
        

    @Override
    public void keyReleased(KeyEvent e) {
        
    
  
}}
