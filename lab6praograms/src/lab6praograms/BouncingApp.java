package lab6praograms;

import java.awt.*;
import javax.swing.*;
import javax.media.opengl.*;
import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;
import javax.media.opengl.*;
import javax.media.opengl.glu.GLU;

/**
 * This is a basic JOGL app. Feel free to reuse this code or modify it.
 */
public class BouncingApp extends JFrame {

    static Animator animator = null;

    public static void main(String[] args) {
        BouncingApp app = new BouncingApp();
        //start the animator
        animator.start();
    }

    public BouncingApp() {
        //set the JFrame title
        super("Bouncing Off the Walls");
        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //only two JOGL lines of code ... and here they are
        GLCanvas glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(new BouncingGLEventListener());
        //create the animator                
        animator = new Animator(glcanvas);
        // OR
                /*
         * animator = new Animator();
                animator.add(glcanvas);
         */
        //OR : to control the speed
                /*
         * animator = new FPSAnimator(1000);
                animator.add(glcanvas);
         */
        //add the GLCanvas just like we would any Component
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);
        //center the JFrame on the screen	
        setLocationRelativeTo(null);
        //Show what we have done
        setVisible(true);
    }
}

class BouncingGLEventListener implements GLEventListener {

    float a = 250;//x axis
    float b = 150;//y axis
    //Remember to use floats for calculating slope
    //of the line the ball follows. Ints will be
    //far too imprecise (i.e. (8/9) == 0).
    //
    //Slope will change on each wall impact.
    //It will be multiplied by -1.
    float slope = 7.0f / 6.0f;
    float x = a; //holds the new 'x' position of ball
    float y = b; //holds the new 'y' position
    boolean movingRight = true;
    boolean movingUp = true;

    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable drawable) {

        GL gl = drawable.getGL();
        GLU glu = new GLU();
        //Let's use a different color than black
        gl.glClearColor(0.725f, 0.722f, 1.0f, 0.0f);
        //Let's make the point 5 pixels wide
        gl.glPointSize(5.0f);
        gl.glViewport(0, 0, 500, 300);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(0, 500, 0, 300);
    }

    /**
     * Take care of drawing here.
     */
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        //erase GLCanvas using the clear color
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        //Choose our color for drawing
        float red = 0.1f;
        float green = 0.5f;
        float blue = 0.1f;
        gl.glColor3f(red, green, blue);
        // Point-slope form of a line is:
        // y = m(x -a) + b where (a,b) is 
        // the point.
        //
        // Also,
        // y - b = m( x - a )
        // works.
        // m is of course the slope.

        //(x,y) position of point changes
        //each time this frame is drawn.

        y = (slope * (x - a) + b);

        //note for our bounce we will
        //use the formula:
        //slope *= -1
        if (movingRight) {
            if (x < 500) {
                x += 0.2;
            } else {
                movingRight = false;
                slope *= -1;
                a = x;
                b = y;
            }
        }
        if (!movingRight) {
            if (x > 0) {
                x -= 0.2;
            } else {
                movingRight = true;
                slope *= -1;
                a = x;
                b = y;
            }
        }

        if (movingUp) {
            if (!(y < 300)) {
                slope *= -1;
                a = x;
                b = y;
                movingUp = false;
            }
        }
        if (!movingUp) {
            if (!(y > 0)) {
                slope *= -1;
                a = x;
                b = y;
                movingUp = true;
            }
        }

        //only one point (our ball) to draw
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2d(x, y);
        gl.glEnd(); 
    }

    public void reshape(GLAutoDrawable drawable,int x,int y,int width,int height) { }

    public void displayChanged(GLAutoDrawable drawable,boolean modeChanged,boolean deviceChanged) { }
}
