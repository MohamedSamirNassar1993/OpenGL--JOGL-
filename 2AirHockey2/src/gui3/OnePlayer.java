package gui3;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package project;
import com.sun.opengl.util.j2d.TextRenderer;
import static gui3.Anim.animator;
import java.awt.Component;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.media.opengl.*;

import java.util.BitSet;
import javax.media.opengl.glu.GLU;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class OnePlayer implements GLEventListener, KeyListener, MouseListener, MouseMotionListener {

    final String assetsFolderName = "shit";
    String message;
    final int img = 0;
    final int img1= 1;
    final int img2 = 2;
    int KICK = 0;
    int maxWidth = 100;
    int maxHeight = 100;
    boolean started = true, up = false, down = false, vertical = true, paused = false, ended = false, exited = false;
    // create two players
    // (1) AI, (2) human being
    Player first = new Player(maxWidth/2 - 5, maxHeight/2 - 45);
    Player second = new Player(maxWidth/2 - 5, maxHeight/2 + 35);
    Score f1 = new Score(0);
    Score s2 = new Score(0);
    float slope = 0;
    Ball ball = new Ball(maxWidth/2 - 5, maxHeight/2 + 15);
    String textureNames[] = {"Man1.png","Man2.png","ball4.png", "Back.png"};
    TextureReader.Texture texture[] = new TextureReader.Texture[textureNames.length];
    int textures[] = new int[textureNames.length];
    private TextRenderer text = new TextRenderer(new Font("SansSerif", Font.BOLD, 10));
    
    GLCanvas a;
    public void set(GLCanvas c){
        a = c;
    }
    /*
     5 means gun in array pos
     x and y coordinate for gun 
     */
    @Override
    public void init(GLAutoDrawable gld) {
        
        ball.setPreviousX(ball.getX());
        ball.setPreviousY(ball.getY());

        GL gl = gld.getGL();
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);    //This Will Clear The Background Color To Black
        
        gl.glEnable(GL.GL_TEXTURE_2D);  // Enable Texture Mapping
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);	
        gl.glGenTextures(textureNames.length, textures, 0);
        
        for(int i = 0; i < textureNames.length; i++){
            try {
                texture[i] = TextureReader.readTexture(textureNames[i] , true);
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
    
    
    /*
        Computer playing againt a player
        The player must move with the mouse and the Computer responds
        as well as possible to avoid loosing
    */
    @Override
    public void display(GLAutoDrawable gld) {

        GL gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);       //Clear The Screen And The Depth Buffer
        gl.glLoadIdentity(); 
        
        DrawBackground(gl);
        if (!exited)
            handleKeyPress();
        // check if the game is paused
        if(paused & !ended){
            gl.glPushMatrix();
            DrawSprite(gl, first, img, 1);
            ball.DrawBall(gl, ball.getPreviousX(), ball.getPreviousY(), img2, 1, maxWidth, maxHeight, textures);
            DrawSprite(gl, second, img1, 1);
            displayScore();
            gl.glPopMatrix();
        }

        // check if the game is playing
        else if (started){
            DrawSprite(gl, first, img, 1);
            ball.DrawBall(gl, ball.getPreviousX(), ball.getPreviousY(), img2, 1, maxWidth, maxHeight, textures);
            DrawSprite(gl, second, img1, 1);
            moveBall(gl);
            displayScore();
            
        }
        // if one player scores give the other player the ball
        // the game restarts after a few second
        else if(!ended){
            kickoff(KICK, gl);
            moveBall(gl);
        }
        else{
            Gui2.clip.stop();
            display(gl, message);
        }
    }
    
    // display score for each player
    void displayScore(){
        
        text.beginRendering(maxWidth, maxHeight);
        text.draw(String.valueOf(f1.getScore()), 2, 2);
        text.draw(String.valueOf(s2.getScore()), 2, 90);
        text.endRendering();
    }
    
    void display(GL gl, String message){
        initialize();
        gl.glPushMatrix();
        text.beginRendering(maxWidth, maxHeight);
        text.draw(message, maxWidth/2 - 30, maxHeight/2);
        text.endRendering();
        gl.glPopMatrix();
        
    }
    void initialize(){
        first.setX(maxWidth/2 - 5);
        first.setY(maxHeight/2 - 45);
        second.setX(maxWidth/2 - 5);
        second.setY(maxHeight/2 + 30);
    }
    
    // move the ball according to the player who hit
    // it last
    void moveBall(GL gl){
        Point a = new Point((int)ball.getPreviousX(), (int)ball.getPreviousY());
        Point b = new Point(first.getX(), first.getY());
        Point c = new Point(second.getX(), second.getY());
        //System.out.println(a.distance(b));
        if (a.distance(b) <= 10){
            //System.out.println(a.distance(b));
            started = true;
            direction(ball, first);
            move();
        }
        // check if the first player scored
        if ((ball.getPreviousX() >= 44 && ball.getPreviousX() <= 52) && ball.getPreviousY() >= 90 && started){
            int s = f1.getScore();
            ++s;
            f1.setScore(s);
            started = false;
            KICK = 1;
        }
        if (a.distance(c) <= 10){
            started = true;
            direction(ball, second);
            move();
        }
        // check if the second player scored
        if ((ball.getPreviousX() > 44 && ball.getPreviousX() < 52) && ball.getPreviousY() <= 5 && started){
            int s = s2.getScore();
            ++s;
            s2.setScore(s);
            started = false;
            KICK = 0;
        }
        // check if one player has reached 7 goals
        if (f1.getScore() >= 7){
            paused = true;
            started = false;
            ended = true;
            f1.setScore(0);
            s2.setScore(0);
            message = "Computer wins";
            //display(gl, message);
        }
        else if (s2.getScore() >= 7){
            paused = true;
            ended = true;
            started = false;
            f1.setScore(0);
            s2.setScore(0);
            message = "Player 1 wins";
            //display(gl, message);
        }
        else{
            ended = false;
        }
        move();
    }
    
    /*
        move the ball and the must bounce after
        hitting one of the corner(or side)
    */
    void move(){
        float x = ball.getPreviousX();
        float y = slope * (ball.getPreviousX() - ball.getX()) + ball.getY();
        //System.out.println(y);
        ball.setPreviousY(y);
        if (ball.isMovingRight()){
            if (x < maxWidth-5){
                ball.setPreviousX(x+1);
            }
            else{
                ball.setMovingRight(false);
                slope *= -1;
                ball.setX(ball.getPreviousX());
                ball.setY(y);
            }
        }
        if (!ball.isMovingRight()) {
            if (x > 5) {
                ball.setPreviousX(x-1);
            } else {
                ball.setMovingRight(true);
                slope *= -1;
                ball.setX(ball.getPreviousX());
                ball.setY(y);
            }
        }
        if (ball.isMovingUp()) {
            if (!(y < maxHeight-5)) {
                slope *= -1;
                ball.setX(ball.getPreviousX());
                ball.setY(y);
                ball.setMovingUp(false);
            }
        }
        if (!ball.isMovingUp()) {
            if (!(y > 3)) {
                slope *= -1;
                ball.setX(ball.getPreviousX());
                ball.setY(y);
                ball.setMovingUp(true);
            }
        }
        if(down){
            ball.setPreviousY(--y);
            if(ball.getPreviousY()  < 5){
                up = true;
                down = false;
            }
        }

        if(up){
            ball.setPreviousY(++y);
            if(ball.getPreviousY() >= maxHeight - 5){
                down = true;
                up = false;
            }
        }
    }
    
    // determine the direction of the ball after hitting the first player
    // left(up or down)
    // right(up or down)
    void direction(Ball ball, Player p){
        int x = p.getX();
        int y = p.getY();
        float a = ball.getPreviousX();
        float b = ball.getPreviousY();
        ball.setX(x);
        ball.setY(y);
        boolean horizontal = (ball.getPreviousY() - x == 0);
        vertical = (ball.getPreviousX() - x == 0);
        if (vertical){
            if(ball.getY() > b){
                down = true;
            }
            else{
                up = true;   
            }
        }
        else{
            down = up = false;
            slope = (b - y) / (a - x);
        }
        
        if (horizontal){
            slope += 0.4;
        }
        
        if (slope > 0){
            if (ball.getPreviousY() > y){
                ball.setMovingUp(true);
                ball.setMovingRight(true);
                ball.setPreviousX(++a);
            }
            else{
                ball.setMovingUp(false);
                ball.setMovingRight(false);
                ball.setPreviousX(--a);
            }
        }
        else{
            if (ball.getPreviousY() > y){
                ball.setMovingUp(true);
                ball.setMovingRight(false);
                ball.setPreviousX(--a);
            }
            else{
                ball.setMovingUp(false);
                ball.setMovingRight(true);
                ball.setPreviousX(++a);
            }
        }
    }
    
    // if a player score give the other player the ball
    void kickoff(int i, GL gl){
        
        
        if (i == 0){
            Player f = new Player(maxWidth/2 - 5, maxHeight/2 - 45);
            Player s = new Player(maxWidth/2 - 5, maxHeight/2 + 35);
            Ball b = new Ball(maxWidth/2 - 5, maxHeight/2 - 40);
            DrawSprite(gl, f, img, 1);
            ball.DrawBall(gl, b.getX(), b.getY(), img2, 1, maxWidth, maxHeight, textures);
            DrawSprite(gl, s, img1, 1);
            displayScore();
        }
        else if (i == 1){
            Player f = new Player(maxWidth/2 - 5, maxHeight/2 - 45);
            Player s = new Player(maxWidth/2 - 5, maxHeight/2 + 35);
            Ball b = new Ball(maxWidth/2 - 5, maxHeight/2 + 30);
            DrawSprite(gl, f, img, 1);
            ball.DrawBall(gl, b.getX(), b.getY(), img2, 1, maxWidth, maxHeight, textures);
            DrawSprite(gl, s, img1, 1);
            displayScore();
        }
    }
    
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
    
    public void DrawSprite(GL gl, Player p, int index, float scale){
        gl.glEnable(GL.GL_BLEND);
        
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]);

        gl.glPushMatrix();
            gl.glTranslated( p.getX()/(maxWidth/2.0) - 0.9, p.getY()/(maxHeight/2.0) - 0.9, 0);
            gl.glScaled(0.1*scale, 0.1*scale, 1);
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
        AI();
        
        gl.glDisable(GL.GL_BLEND);
    }
    
    public void DrawBackground(GL gl){
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
    }
    
    
    /*
     * KeyListener
     */
    // First player movements
    // Don't croos the center

    

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

    @Override
    public void mouseClicked(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        Component c = e.getComponent();
        double width = c.getWidth();
        double height = c.getHeight();

        
        int xPosition = (int) ((x / width) * 100);
        int yPosition = ((int) ((y / height) * 100));
        yPosition = 100 - yPosition;
        System.out.println(xPosition + " " + yPosition);
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
    public void mouseDragged(MouseEvent e) {
    }
    
    // Second player movements
    // Don't croos the center
    @Override
    public void mouseMoved(MouseEvent e) {
        if (!paused){
            double x = e.getX();
            double y = e.getY();
            Component c = e.getComponent();
            double width = c.getWidth();
            double height = c.getHeight();


            int xPosition = (int) ((x / width) * 100);
            int yPosition = ((int) ((y / height) * 100));
            yPosition = 100 - yPosition;
            if (xPosition > 0 && xPosition < maxWidth-10) {
                second.setX(xPosition);
            }
            if (yPosition > maxHeight/2 && yPosition < maxHeight-10) {
                second.setY(yPosition);
            }
        }
    }
    // move AI player
    void AI(){
        float x = ball.getPreviousX();
        int a  = first.getX();
        if(x > a){
            first.setX(++a);
        }
        else if(x < a){
            first.setX(--a);
        }
    }
    
    public void handleKeyPress() {

        if (isKeyPressed(KeyEvent.VK_SPACE)) {
            if(paused){
                paused = false;
                Gui2.clip.start();
            }
            else{
                paused = true;
                Gui2.clip.stop();
                
            }
            ended = !ended;
        }
        if (isKeyPressed(KeyEvent.VK_ENTER)) {
            System.exit(0);
            
        }
    }
}

