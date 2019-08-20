package lab6praograms;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;
import static javafx.scene.text.Font.font;
import javax.swing.*;
import javax.media.opengl.*;

public class Clock extends JFrame {

    static Animator animator = null;

    public static void main(String[] args) {
        final Clock app = new Clock();
        animator.start();
    }
    static double s_clocRot = 0;
    static GLCanvas glcanvas = null;

    public Clock() {
        //set the JFrame title
        super("clock   drow");
        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        glcanvas = new GLCanvas();
        GLCapabilities glcaps = new GLCapabilities();
        //GLCanvas glcanvas =new GLCanvas();
        //GLDrawableFactory.getFactory().createGLCanvas(glcaps);
        glcanvas.addGLEventListener(new ClockDrowEventListener());
        //create the animator                
        animator = new FPSAnimator(1);
        animator.add(glcanvas);
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(700, 700);
        //center the JFrame on the screen
        centerWindow(this);
        setVisible(true);
    }

    public void centerWindow(Component frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        frame.setLocation((screenSize.width - frameSize.width) >> 1, (screenSize.height - frameSize.height) >> 1);
    }
}

class ClockDrowEventListener implements GLEventListener {

    final double ONE_DEGREE = (Math.PI / 180);
    final double THREE_SIXTY = 2 * Math.PI;

    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        GL glu = gld.getGL();
        //gl.glClearColor(0.1f, 0.5f, 0.6f, 0.5f);
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glViewport(-100, -100, 100, 100);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-100.0, 100.0, -100.0, 100.0, -1, 1);
        
    }

    int second_time, minit_time, hour_time;
    double secondPercent = 0, minetsPercent = 0, houresPercent = 0;

    public void display(GLAutoDrawable drawable) {
        double x = 0, y = 0;
        double radius = 70;
        float red = 0.0f;
        float green = 0.8f;
        float blue = 0.4f;
        getPoints();
        GL gl = drawable.getGL();
//        GL gl2 = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glLineWidth(4.0f);
        gl.glColor3f(0.0f, 0.8f, 0.4f);
        for (int i = 0; i < 12; i++) {
            gl.glBegin(GL.GL_LINES);
            gl.glVertex2d(xPoint[i], yPoint[i]);
            gl.glVertex2d(xPoint2[i], yPoint2[i]);
            gl.glEnd();
        }
        
        /////////////to draw one///////////////////////////////////
        gl.glLineWidth(4.0f);
        gl.glColor3f(1, 0, 0);
        gl.glBegin(GL.GL_LINE_STRIP);
        gl.glVertex2d(xPoint3[2]-3, yPoint3[2]+6);
        gl.glVertex2d(xPoint3[2], yPoint3[2]+10);
        gl.glVertex2d(xPoint3[2], yPoint3[2]);
        gl.glVertex2d(xPoint3[2]+3, yPoint3[2]);
        gl.glVertex2d(xPoint3[2]-3, yPoint3[2]);
        gl.glEnd();          
        /////////////to draw two///////////////////////////////////
        gl.glLineWidth(4.0f);
        gl.glColor3f(1, 0, 0);
        gl.glBegin(GL.GL_LINE_STRIP);
        gl.glVertex2d(xPoint3[1]+4, yPoint3[1]);
        gl.glVertex2d(xPoint3[1], yPoint3[1]);
        gl.glVertex2d(xPoint3[1]+0.5, yPoint3[1]+1);
        gl.glVertex2d(xPoint3[1]+1, yPoint3[1]+2);
        gl.glVertex2d(xPoint3[1]+1.5, yPoint3[1]+3);
        gl.glVertex2d(xPoint3[1]+2, yPoint3[1]+4);
        gl.glVertex2d(xPoint3[1]+2.5, yPoint3[1]+5);
        gl.glVertex2d(xPoint3[1]+3, yPoint3[1]+6);
        gl.glVertex2d(xPoint3[1]+3, yPoint3[1]+7);
        gl.glVertex2d(xPoint3[1]+2.5, yPoint3[1]+8);
        gl.glVertex2d(xPoint3[1]+2, yPoint3[1]+9);
        gl.glVertex2d(xPoint3[1]+1.5, yPoint3[1]+10);
        gl.glVertex2d(xPoint3[1]+1, yPoint3[1]+9);
        gl.glVertex2d(xPoint3[1]+0.5, yPoint3[1]+8);
        gl.glVertex2d(xPoint3[1], yPoint3[1]+7);
        gl.glVertex2d(xPoint3[1], yPoint3[1]+6);
        gl.glEnd();
        /////////////to draw three///////////////////////////////////
        gl.glLineWidth(4.0f);
        gl.glColor3f(1, 0, 0);
        gl.glBegin(GL.GL_LINE_STRIP);
        gl.glVertex2d(xPoint3[0], yPoint3[0]);
        gl.glEnd();
        /////////////to draw one///////////////////////////////////
        /////////////to draw one///////////////////////////////////
        /////////////to draw one///////////////////////////////////
        /////////////to draw one///////////////////////////////////
        /////////////to draw one///////////////////////////////////
        /////////////to draw one///////////////////////////////////
        /////////////to draw one///////////////////////////////////
        /////////////to draw one///////////////////////////////////
        /////////////to draw one///////////////////////////////////
        
        
        
        
        gl.glColor3f(red, green, blue);
        gl.glBegin(GL.GL_LINE_LOOP);
        for (double a = 0; a < THREE_SIXTY; a += ONE_DEGREE) {
            x = radius * (Math.cos(a));
            y = radius * (Math.sin(a));
            gl.glVertex2d(x, y);
            
        }
        gl.glEnd();
        
        

        gl.glPushMatrix();//////////////////////////////////////////////////////
        gl.glRotated(-houresPercent, 0, 0, 1);                                //
        gl.glBegin(GL.GL_POLYGON);                                            //
        gl.glColor3f(0.5f, 0.5f, 0.5f);                                       //
        gl.glVertex2d(3, 0);                                                  //
        gl.glColor3f(0.0f, 1.0f, 0.0f);                                       //
        gl.glVertex2d(0, 35);
        gl.glColor3f(1.0f, 1.0f, 1.0f);
        gl.glVertex2d(-3, 0);
        gl.glVertex2d(0, -4);
        gl.glEnd();

//        gl.glColor3f(0.1f, 0.1f, 0.2f);
//        gl.glLineWidth(1.0f);
//        gl.glBegin(GL.GL_LINE_LOOP);
//        gl.glVertex2d(3, 0);
//        gl.glVertex2d(0, 35);
//        gl.glVertex2d(-3, 0);
//        gl.glVertex2d(0, -4);
//        gl.glEnd();
        gl.glPopMatrix();///////////////////////////////////////////////////////

        gl.glPushMatrix();
        gl.glRotated(-minetsPercent, 0, 0, 1);
        gl.glBegin(GL.GL_POLYGON);
        gl.glColor3f(0.5f, 0.5f, 0.5f);
        gl.glVertex2d(3, 0);
        gl.glColor3f(1.0f, 1.0f, 1.0f);
        gl.glVertex2d(0, 45);
        gl.glColor3f(0.5f, 0.9f, 0.0f);
        gl.glVertex2d(-3, 0);
        gl.glVertex2d(0, -4);
        gl.glEnd();

//        gl.glColor3f(0.1f, 0.1f, 0.2f);
//        gl.glLineWidth(1.0f);
//        gl.glBegin(GL.GL_LINE_LOOP);
//        gl.glVertex2d(3, 0);
//        gl.glVertex2d(0, 45);
//        gl.glVertex2d(-3, 0);
//        gl.glVertex2d(0, -4);
//        gl.glEnd();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glRotated(secondPercent, 0, 0, 1);
        gl.glBegin(GL.GL_POLYGON);
        gl.glColor3f(0.5f, 0.5f, 0.5f);
        gl.glVertex2d(2, 0);
        gl.glColor3f(0.0f, 1.0f, 0.0f);
        gl.glVertex2d(0, 50);
        gl.glColor3f(1.0f, 1.0f, 1.0f);
        gl.glVertex2d(-2, 0);
        gl.glVertex2d(0, -3);
        gl.glEnd();

//        gl.glColor3f(0.1f, 0.1f, 0.2f);
//        gl.glLineWidth(1.0f);
//        gl.glBegin(GL.GL_LINE_LOOP);
//        gl.glVertex2d(2, 0);
//        gl.glVertex2d(0, 50);
//        gl.glVertex2d(-2, 0);
//        gl.glVertex2d(0, -3);
//        gl.glEnd();
        gl.glPopMatrix();
        
//        gl.glPushMatrix();
        gl.glColor3f(0.0f, 0.0f, 0.0f);
        gl.glBegin(GL.GL_POLYGON);
        for (double a = 0; a < THREE_SIXTY; a += ONE_DEGREE) {
            x = 0.7 * (Math.cos(a));
            y = 0.7 * (Math.sin(a));
            gl.glVertex2d(x, y);
        }
        gl.glEnd();
//        gl.glPopMatrix();

        //-----------------------
        Date dt = new Date();

        hour_time = dt.getHours();
        minit_time = dt.getMinutes();
        second_time = dt.getSeconds();
          secondPercent-=6;      
//        secondPercent = (second_time) * 360 / 60;
//        minetsPercent = (minit_time + second_time /60.0) * 360 / 60;
//        houresPercent = (hour_time + minit_time * 0.01666666666666666666666666667) * 360 / 12;
        //-----------------------
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    double[] xPoint = new double[12];
    double[] yPoint = new double[12];
    double[] xPoint2 = new double[12];
    double[] yPoint2 = new double[12];
    double[] xPoint3 = new double[12];
    double[] yPoint3 = new double[12];

    public void getPoints() {
        for (int i = 0; i < 12; i++) {
            xPoint[i] = 0 + 70 * Math.cos(i * 30 * ONE_DEGREE);
            yPoint[i] = 0 + 70 * Math.sin(i * 30 * ONE_DEGREE);
        }
        for (int i = 0; i < 12; i++) {
            xPoint2[i] = 0 + 55 * Math.cos(i * 30 * ONE_DEGREE);
            yPoint2[i] = 0 + 55 * Math.sin(i * 30 * ONE_DEGREE);
        }
        for (int i = 0; i < 12; i++) {
            xPoint3[i] =  75 * Math.cos(i * 30 * ONE_DEGREE);
            yPoint3[i] =  75 * Math.sin(i * 30 * ONE_DEGREE);
        }
    }
}
