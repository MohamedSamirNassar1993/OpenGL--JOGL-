


import com.sun.opengl.util.*;
import com.sun.opengl.util.j2d.TextRenderer;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.media.opengl.*;
import javax.swing.*;
import java.util.BitSet;
import java.util.Scanner;
import java.util.concurrent.Phaser;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.JFXPanel;
import javafx.scene.input.KeyCode;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.media.opengl.glu.GLU;
//import newpackage.rabbit;



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
        Anim anim=new Anim();
        SwingUtilities.invokeLater(
                new Runnable() {
            @Override
            public void run() {
               anim.setVisible(true);
       JFXPanel j=new JFXPanel();
       
              String uri=new File("mr_clown.mp3").toURI().toString();
       new MediaPlayer(new Media(uri)).play();
            }
        });
       
        
    }
    GLCanvas glcanvas;
    AnimGLEventListener4 listener;
    Animator animator;

    public Anim() {
        listener = new AnimGLEventListener4();
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addKeyListener(listener);
        glcanvas.addMouseListener(listener);
        glcanvas.addMouseMotionListener(listener);
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        animator = new FPSAnimator(30);
        animator.add(glcanvas);
        animator.start();
        setTitle("Rabbit Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(639, 639);
        setLocationRelativeTo(null);
        setVisible(true);
        setFocusable(true);
        glcanvas.requestFocus();
    }
}

class AnimGLEventListener4 implements GLEventListener, KeyListener, MouseListener, MouseMotionListener {
     
    int state = 0;
    int astate = 0;
    int aastate = 0;
    int mx,hmx;
    int my,hmy;
    int ay = 120;
    int score = 0;
    int timer = 1000;
    int diff = 0;
    boolean dead = false;
    final int maxWidth = 600, maxHeight = 600;
    TextRenderer t = new TextRenderer(Font.decode("PLAIN"));
    ArrayList<String> s = new ArrayList<>();
    String textureNames[] = {"hammer.png","rabbit2.png", "Back.png", "EndGame.png", 
                            "gamename.png", "startplay.png", "chooselevel.png","howtoplay.png",
                            "quit.png", "Rabbit.png", "arrowa.png", "eazy.png", "medium.png", "hard.png" , "rabbit3.png",
                             "pause.png" , "hammer1.png" };
    TextureReader.Texture texture[] = new TextureReader.Texture[textureNames.length];

    int textures[] = new int[textureNames.length];
    boolean[][] exist = new boolean[3][3];
    rabbit [][] rabblitPos = new rabbit [3][3];
    rabbit r = new rabbit(0);
    int frame = 0;
    GL gl;
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
        try {
        } catch (Exception ex) {
            Logger.getLogger(AnimGLEventListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void display(GLAutoDrawable gld) {
        gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);       //Clear The Screen And The Depth Buffer
        gl.glLoadIdentity();
        switch(state){
            case 0: drawMenu();
                    break;
            case 1: play();
                    frame++;
                    timer--;
                    break;
            case 2: gameOver();
                    break;
            case 3:drawhelp();
                    break;
            case 4:drawdiff();
                    break;
            case 5:pause();
                    score=score;
                    break;
            case 6: EndGame();
                    break;
            
        }
        handleKeyPress();
    }
    void drawMain(){
    
    }
    
    void play(){
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if(!exist[i][j])
//                    if(Math.random() < .1){
//                        exist[i][j] = true;
//                        rabblitPos[i][j] = 1;
//                    }
//            }
//        }
//        if(frame %20 ==0){
//            for (int i = 0; i < 3; i++) {
//                for (int j = 0; j < 3; j++) {
//                    if(!exist[i][j]){
//                        exist[i][j] = true;
//                        break;
//                    }
//                }
//            }
//            frame = 0;
//        }
        //System.out.println(r.x+" "+r.y);
        
        DrawBackground(gl, 2);
       
        drawScore();
        if(frame %((35 - diff*5)) == 0 || dead){
           // r.x = 150;
          //r.y=150;
           r.x = (int)(Math.random()*400) + 200;
           
            r.y = (int)(Math.random()*400) - 100;
            double m = Math.abs(r.x - mx);
     double e = Math.abs(r.y - my);
      System.out.println( m + "    " +  e);
            r.time++;
            frame = 0;
             check();
            if (dead){
                dead = false;
                score++;
            }
        }
        DrawSprite(gl, r.x, r.y, 1, 2);
        DrawSprite(gl, mx, my, 0, 1);
        
        if (isKeyPressed(KeyEvent.VK_BACK_SPACE))
        {
            
           frame = 0;
           
            timer = 1000;
            score = 0;
           state = 0;
            astate = 0;
            aastate = 0;
            ay=120;
            diff = 1;
        }
        if (isKeyPressed(KeyEvent.VK_X))
        {
            frame = 0;
            timer =timer ;
            score = score;
           state = 5;
            astate = 0;
            aastate = 0;
            diff = 1;
        }
        if (isKeyPressed(KeyEvent.VK_Q))
        {
            
            frame = 0;
            timer = timer;
            score = score;
           state = 6;
            astate = 0;
            aastate = 0;
            diff = 1;
        }
       
          
//            JFXPanel j = new JFXPanel();
//           String uri=new File("music_zapsplat_disco_streets.mp3").toURI().toString();
//           new MediaPlayer(new Media(uri)).play();
        
      
    }
   
   
    void check(){
        if(Math.abs(r.x - mx) < 60 && Math.abs(r.y - my) < 60)
            
            
            
            dead = true;
        if(dead == true){
        DrawSprite2(gl, 290, 1, 14, 1, 1);}
        if(timer <= 0)
            state = 2;
    }
    void gameOver(){
        frame = 0;
        timer = 1000;
        DrawBackground(gl, 2);
        t.beginRendering(300, 300);
        t.setColor(Color.BLUE);
        t.draw("Game Over" , 80, 250);
        t.draw("Your score : " + score, 80, 230);
        t.setColor(Color.WHITE);
        t.endRendering();
        DrawSprite2(gl, 290, 1, 14, 3, 3);
        
        if (isKeyPressed(KeyEvent.VK_BACK_SPACE))
        {
            frame = 0;
            timer = 1000;
            score = 0;
           state = 0;
            astate = 0;
            aastate = 0;
            ay=120;
            diff = 1;
        }
        
    }
    void pause(){
     frame = 0;
        
        DrawBackground(gl, 2);
        t.beginRendering(300, 300);
        t.setColor(Color.BLUE);
        t.draw("pause" , 80, 250);
        t.setColor(Color.WHITE);
        t.endRendering();
        DrawSprite2(gl, 290, 1, 14, 3, 3);
        DrawSprite2(gl, 310, 230, 15, 1, 1);
        if (isKeyPressed(KeyEvent.VK_Y))
        {
            
            frame = 0;
            timer = timer;
            score = score;
           state = 1;
            astate = 0;
            aastate = 0;
            diff = 1;
        }
        
    }
    void EndGame(){
     frame = 0;
        
        DrawBackground(gl, 3);
        t.beginRendering(300, 300);
        t.setColor(Color.BLUE);
        //t.draw("pause" , 80, 250);
        t.setColor(Color.WHITE);
        t.endRendering();
        //DrawSprite2(gl, 290, 1, 3, 3, 3);
       // DrawSprite2(gl, 310, 230, 15, 1, 1);
        if (isKeyPressed(KeyEvent.VK_Y))
        {
            
            frame = 0;
            timer = 1000;
            score = 0;
           state = 0;
            astate = 0;
            aastate = 0;
            diff = 1;
            ay=120;
        }
        
        if (isKeyPressed(KeyEvent.VK_N))
        {
            
            frame = 0;
            timer = timer;
            score = score;
           state = 1;
            astate = 0;
            aastate = 0;
            diff = 1;
        }
        
    }
    
    
    void drawScore(){
        t.beginRendering(300, 300);
        t.setColor(Color.BLUE);
        t.draw("score : " + score, 20, 280);
        t.draw("time left : " + timer, 20, 260);
        t.setColor(Color.WHITE);
        t.endRendering();
    }
    void drawMenu(){
        DrawBackground(gl, 2);
        DrawSprite2(gl, 290, 260, 4, 3, 1);
        DrawSprite2(gl, 290, 130, 5, 2, 1);
        DrawSprite2(gl, 290, 0, 6, 2, 1);
        DrawSprite2(gl, 290, -130,7, 2, 1);
        DrawSprite2(gl, 290, -260, 8, 2, 1);
        DrawSprite2(gl, 75, -20, 9, (float)1.5, 4);
        DrawSprite2(gl, 490, -60, 0, 1, 2);
        DrawSprite2(gl, 450, ay, 10, (float)0.5,(float)0.5);
        if (isKeyPressed(KeyEvent.VK_ESCAPE))
        {
            System.exit(0);
        }
    }
    
    void drawhelp(){
        DrawBackground(gl, 2);
        t.beginRendering(300, 300);
        t.setColor(Color.BLUE);
        t.draw( "How To Play " , 110 , 280 );
        t.draw(" # You see a rabbit move random in any dirction .  " , 1, 260);
        t.draw( " # You Want To Hit a rabbit by hammer that Move " , 1 , 230);
        t.draw("  by mouse ." , 1 , 200); 
        t.draw(" # Hit as mush as a rabbit as you can before Time",1,170);
        t.draw("   runs out  . ",1,140);
        t.draw(" # press begin to stsrt game or choose level ." ,1,110);
        t.draw(" # press esc to back to menu or to quit from a game .",1,80);
        t.draw(" # if you want to play again after game .   " ,1,50);
        t.draw(" # press backspace  to pause game press X ", 1, 20);
       t.draw(" and to continue press Y." , 1 ,1);
        
        t.setColor(Color.WHITE);
        t.endRendering();
        
        if (isKeyPressed(KeyEvent.VK_BACK_SPACE))
        {
            frame = 0;
            timer = 1000;
            score = 0;
            state=0;
            astate = 0;
            aastate = 0;
            ay=120;
            diff = 1;
        }
        
    }
    void drawdiff(){
        DrawBackground(gl, 2);
        DrawSprite2(gl, 290, 130, 11, 2, 1);
        DrawSprite2(gl, 290, 0, 12, 2, 1);
        DrawSprite2(gl, 290, -130,13, 2, 1);
        DrawSprite2(gl, 450, ay, 10, (float)0.5,(float)0.5);
        if (isKeyPressed(KeyEvent.VK_BACK_SPACE))
        {
            frame = 0;
            timer = 1000;
            score = 0;
            state = 0;
            astate = 0;
            aastate = 0;
            diff = 1;
        }
    }
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void DrawSprite(GL gl, int x, int y, int index,float scale) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]);	// Turn Blending On
        gl.glPushMatrix();
        gl.glTranslated(x / (maxWidth / 2.0) - 1, y / (maxHeight / 2.0), 0);
        gl.glScaled(0.1 * scale, 100 / 600.0 * scale, 1);
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
public void DrawSprite2(GL gl, int x, int y, int index,float scalex, float scaley) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]);	// Turn Blending On
        gl.glPushMatrix();
        gl.glTranslated(x / (maxWidth / 2.0) - 1, y / (maxHeight / 2.0), 0);
        gl.glScaled(0.2 * scalex, 100 / 500.0 * scaley, 1);
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
    public void DrawBackground(GL gl, int i) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[i]);
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
    
    // KeyListener    
    public void handleKeyPress() {
        if (isKeyPressed(KeyEvent.VK_DOWN) && state == 0) {
            
            if(ay > -230){
                ay -= 130;
                astate += 1;
                return;
            }
        }
        if (isKeyPressed(KeyEvent.VK_UP)&& state == 0) {
            
            if(ay < 120){
                ay += 130;
                astate -= 1;
                
                return;
            }
        }
        if (isKeyPressed(KeyEvent.VK_ENTER)&& state == 0) {
            switch(astate){
                case 0:state = 1;
                        break;
                case 1:ay = 120;
                    state = 4;
                        break;
                case 2:state = 3;
                        break;
                case 3:System.exit(0);
            }
            return;
        }
        if (isKeyPressed(KeyEvent.VK_ENTER)&& state == 4) {
            switch(aastate){
                case 0:diff = 1;
                        state = 1;
                        break;
                case 1:diff = 2;
                        state = 1;
                        break;
                case 2:diff = 3;
                        state = 1;
                        break;
            }
        }
        if (isKeyPressed(KeyEvent.VK_ESCAPE)&& (state == 3 || state == 1)){
            frame = 0;
            timer = 1000;
            score = 0;
            state = 0;
            astate = 0;
            aastate = 0;
            diff = 1;
            
        }
        if (isKeyPressed(KeyEvent.VK_DOWN) && state == 4 && astate == 1) {
            if(ay > -80){
                ay -= 130;
                aastate++;
                return;
            }
        }
        if (isKeyPressed(KeyEvent.VK_UP)&& state == 4 && astate == 1) {
            if(ay < 120){
                ay += 130;
                aastate--;
                return;
            }
        }
//        System.err.println(aastate+" "+astate+" "+state );
        
    }
    public BitSet keyBits = new BitSet(256);
    
    
    
    
    public boolean isKeyPressed(final int keyCode) {
        return keyBits.get(keyCode);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        int keyCode = e.getKeyCode();
        keyBits.set(keyCode);
    }

//    @Override
//    public void keyPressed(KeyEvent e) {
//        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//            if(ay > -200)
//                ay -= 80;
//        }
//        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//            if(ay < 200)
//                ay += 80;
//        }       
//    }
    
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
    public void mouseClicked(MouseEvent e) {
      
        double x = e.getX();
        double y = e.getY();
        Component c = e.getComponent();
        double width = c.getWidth();
        double height = c.getHeight();
        mx = (int) ((x / width) * 600);
        my = ((int) (((height-y) / height) * 600)) - 280;
       // glc.repaint();
        
    
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        Component c = e.getComponent();
        double width = c.getWidth();
        double height = c.getHeight();
        mx = (int) ((x / width) * 600);
        my = ((int) (((height-y) / height) * 600)) - 280;
    }

}
 class rabbit {
    public int time;
    public int x;
    public int y;
    rabbit(int a){
        time = a;
    }
}