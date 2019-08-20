package lab6praograms;

import java.awt.*;
import javax.swing.*;
import javax.media.opengl.*;
import com.sun.opengl.util.Animator;
import javax.media.opengl.glu.*;

public class DialApp extends JFrame {
    public static Animator animator = null;

    public static void main(String[] args) {
        DialApp app = new DialApp();
        //start the animator          
        animator.start();
    }

    public DialApp() {
        //set the JFrame title
        super("Rotating Dial");
        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //only two JOGL lines of code ... and here they are
        GLCanvas glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(new DialGLEventListener());
        //create the animator
        animator = new Animator(glcanvas);
        //add the GLCanvas just like we would any Component
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);
        //center the JFrame on the screen	
        setLocationRelativeTo(null);
        //Show what we have done
        setVisible(true);
    }
}

class DialGLEventListener implements GLEventListener {
    boolean running = true;
    final double ONE_DEGREE = (Math.PI / 180);
    final double THREE_SIXTY = 2 * Math.PI;
    double angle = 240 * ONE_DEGREE;

    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        //Let's use a different color than black
        gl.glClearColor(0.725f, 0.722f, 1.0f, 0.0f);
        gl.glPointSize(5f);
        gl.glViewport(0, 0, 500, 300);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        //gluOrtho2D's arguments represent
        //left, right, bottom, top
        glu.gluOrtho2D(0, 500, 0, 300);
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        double x, y;
        double radius = 70;

        // To center the circle in our canvas
        int shiftXPosition = 250;
        int shiftYPosition = 150;
        
        float red = 0.2f;
        float green = 0.2f;
        float blue = 0.2f;
        
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glColor3f(red, green, blue);
        // Draw the Filled Circle
        gl.glBegin(GL.GL_POLYGON);
        // x = radius * (cosine of angle)
        // y = radius * (sine of angle)
        for (double a = 0; a < THREE_SIXTY; a += ONE_DEGREE) {
            x = radius * (Math.cos(a)) + shiftXPosition;
            y = radius * (Math.sin(a)) + shiftYPosition;
            gl.glVertex2d(x, y);
        }
        gl.glEnd();

        red = 1.0f;
        green = 0.2f;
        blue = 0.2f;
        gl.glColor3f(red, green, blue);

        if (angle > (30 * ONE_DEGREE)) {
            angle -= ONE_DEGREE / 100;
        } else if (running) {
            //stop the animator
            //we're done with it            
            DialApp.animator.stop();
            running = false;
        }

        gl.glPushMatrix();

        gl.glTranslated(250, 150, 0);
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2d(55 * (Math.cos(angle)), 55 * (Math.sin(angle)));
        gl.glEnd();

        gl.glPopMatrix();

    }

    public void reshape(GLAutoDrawable drawable,int x,int y,int width,int height) { }

    public void displayChanged(GLAutoDrawable drawable,boolean modeChanged,boolean deviceChanged) { }
}
