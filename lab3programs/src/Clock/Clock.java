package clock;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.media.opengl.*;

/**
 * This is a basic JOGL app. Feel free to reuse this code or modify it.
 */
public class Clock extends JFrame {

//    static Animator animator = null;
    public static void main(String[] args) {
        final Clock app = new Clock();
// show what we've done
        SwingUtilities.invokeLater(
                new Runnable() {
            public void run() {
                app.setVisible(true);
            }
        }
        );

//        animator.start();
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
        glcanvas.addGLEventListener(
                new ClockDrowEventListener()
        );

        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(740, 740);
        //center the JFrame on the screen
        centerWindow(this);
    }

    public void centerWindow(Component frame) {
        Dimension screenSize
                = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        frame.setLocation(
                (screenSize.width - frameSize.width) >> 1,
                (screenSize.height - frameSize.height) >> 1
        );
    }
}

/**
 * We make the center of the GLCanvas the origin of our graph and construct a
 * circle around it using sine and cosine methods from the Math class.
 *
 * We have ignored insets in this and other examples, so this circle may be
 * slightly more of an oval depending on the OS.
 */
class ClockDrowEventListener implements GLEventListener {

    final double ONE_DEGREE = (Math.PI / 180);
    final double THREE_SIXTY = 2 * Math.PI;

    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        GL glu = gld.getGL();
        gl.glClearColor(0.1f, 0.5f, 0.6f, 0.5f);
        gl.glViewport(-100, -100, 100, 100);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-100.0, 100.0, -100.0, 100.0, -1, 1);
    }

    /**
     * Take care of drawing here.
     */
    public void display(GLAutoDrawable drawable) {
        double x = 0, y = 0;
        double radius = 70;
        float red = 0.5f;
        float green = 0.0f;
        float blue = 0.5f;
        getPoints();
        GL gl = drawable.getGL();
        GL gl2 = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        //gl.glPolygonMode(GL.GL_FRONT,GL.GL_LINES);
        //gl.glPointSize(6.0f);
        gl.glLineWidth(6.0f);
        gl.glColor3f(1.0f, 1.0f, 1.0f);
        for (int i = 0; i < 12; i++) {
            gl.glBegin(GL.GL_LINE_LOOP);
            gl.glVertex2d(xPoint[i], yPoint[i]);
            gl.glVertex2d(xPoint2[i], yPoint2[i]);
            gl.glEnd();
        }
        gl.glColor3f(red, green, blue);
        gl.glBegin(GL.GL_LINE_LOOP);

        // angle is
        // x = radius * (cosine of angle)
        // y = radius * (sine of angle)
        for (double a = 0; a < THREE_SIXTY; a += ONE_DEGREE) {
            x = radius * (Math.cos(a));
            y = radius * (Math.sin(a));
            gl.glVertex2d(x, y);
        }
        gl.glEnd();

        gl.glRotated(0, 0, 0, 1);
        gl.glBegin(GL.GL_POLYGON);
        gl.glColor3f(0.5f, 0.5f, 0.5f);
        gl.glVertex2d(3, 0);
        gl.glColor3f(0.0f, 1.0f, 0.0f);
        gl.glVertex2d(0, 35);
        gl.glColor3f(1.0f, 1.0f, 1.0f);
        gl.glVertex2d(-3, 0);
        gl.glVertex2d(0, -4);
        gl.glEnd();

        gl.glColor3f(0.1f, 0.1f, 0.2f);
        gl.glLineWidth(1.0f);
        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex2d(3, 0);
        gl.glVertex2d(0, 35);
        gl.glVertex2d(-3, 0);
        gl.glVertex2d(0, -4);
        gl.glEnd();
//        gl.glPopMatrix();

//        gl.glPushMatrix();
        gl.glColor3f(0.0f, 0.0f, 0.0f);
        gl.glBegin(GL.GL_POLYGON);

        for (double a = 0; a < THREE_SIXTY; a += ONE_DEGREE) {
            x = 0.7 * (Math.cos(a));
            y = 0.7 * (Math.sin(a));
            gl.glVertex2d(x, y);
        }
        gl.glEnd();
        gl.glPopMatrix();
    }
    double[] xPoint = new double[12];
    double[] yPoint = new double[12];
    double[] xPoint2 = new double[12];
    double[] yPoint2 = new double[12];

    public void getPoints() {
        for (int i = 0; i < 12; i++) {
            xPoint[i] = 0 + 70 * Math.cos(i * 30 * ONE_DEGREE);
            yPoint[i] = 0 + 70 * Math.sin(i * 30 * ONE_DEGREE);
        }
        for (int i = 0; i < 12; i++) {
            xPoint2[i] = 0 + 55 * Math.cos(i * 30 * ONE_DEGREE);
            yPoint2[i] = 0 + 55 * Math.sin(i * 30 * ONE_DEGREE);
        }

    }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
    }

    @Override
    public void displayChanged(GLAutoDrawable glad, boolean bln, boolean bln1) {
    }

}
