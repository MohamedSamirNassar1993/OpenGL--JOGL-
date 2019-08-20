package lab6praograms;

import java.awt.*;
import javax.swing.*;
import javax.media.opengl.*;
import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;
import javax.media.opengl.glu.*;

public class RotTriangleApp extends JFrame {

    public static Animator animator = null;

    public static void main(String[] args) {
        RotTriangleApp app = new RotTriangleApp();
    }

    public RotTriangleApp() {
        //set the JFrame title
        super("Fan and Rotating Triangle");
        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //only two JOGL lines of code ... and here they are
        GLCanvas glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(new RotTriangleGLEventListener());
        // Creating an animator that will redraw the scene 40 times per second.
        animator = new FPSAnimator(40);
        // Registering the canvas to the animator.
        animator.add(glcanvas);
        // Starting the animator.
        animator.start();
        //add the GLCanvas just like we would any Component
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);
        //center the JFrame on the screen	
        setLocationRelativeTo(null);
        //Show what we have done
        setVisible(true);
    }
}

class RotTriangleGLEventListener implements GLEventListener {

    private float angle = 0;
    private float a = 0;

    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glLineWidth(2.0f);
        //	gl.glViewport(0, 0, 500, 300);		
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        // Setting the projection to be orthographic.
        // Selecting the view volume to be x from 0 to 1, y from 0 to 1, z from -1 to 1. 
        gl.glOrtho(0, 1, 0, 1, -1, 1);
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        // Erasing the canvas -- filling it with the clear color.
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        // Selecting white as the current drawing color.
        gl.glColor3f(1, 1, 1);
        // Selecting lines only to be drawn for both front and back.
        gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL.GL_LINE);
        // Drawing a circle.
        drawCircle(gl, 0.5f, 0.5f, 0f, 0.4f, 65);
        // WITHOUT TRANSFORMATIONS
        /*
         * // Selecting filling for both the front and back.
         * gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL.GL_FILL);
         *
         * // Beginning a triangle list.
         * gl.glBegin(GL.GL_TRIANGLES);
         *
         * // Selecting red as the current drawing color -- the color of the
         * first corner.
         * gl.glColor3f(1, 0, 0);
         *
         * // Defining the first corner.
         * gl.glVertex2f(0.5f, 0.5f);
         *
         * gl.glColor3f(0, 1, 0);
         * gl.glVertex2d(0.5 + Math.cos(this.angle) * 0.5, 0.5 + Math.sin(this.angle) * 0.5);
         *
         * gl.glColor3f(0, 0, 1);
         * gl.glVertex2d(0.5 + Math.cos(this.angle +Math.PI / 2) * 0.5, 0.5 + Math.sin(this.angle + Math.PI / 2) * 0.5);
         *
         * // Ending the triangle list.
         * gl.glEnd();
         *
         * // Forcing the scene to be rendered.
         * gl.glFlush();
         *
         * this.angle += (2 * Math.PI) / 90;
         *
         */

        // USING TRANSFORMATIONS
        // Selecting filling for both the front and back.
        gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL.GL_FILL);
        gl.glPushMatrix();
        gl.glTranslated(0.5, 0.5, 0);
        gl.glRotated(a, 0, 0, 1);
        // Beginning a triangle list.
        gl.glBegin(GL.GL_TRIANGLES);
        gl.glColor3f(1, 0, 0);
        gl.glVertex2f(0f, 0f);
        gl.glColor3f(0, 1, 0);
        gl.glVertex2d(Math.cos(this.angle) * 0.5, Math.sin(this.angle) * 0.5);
        gl.glColor3f(0, 0, 1);
        gl.glVertex2d(Math.cos(this.angle + Math.PI / 2) * 0.5, Math.sin(this.angle + Math.PI / 2) * 0.5);
        // Ending the triangle list.
        gl.glEnd();
        gl.glPopMatrix();
        // Forcing the scene to be rendered.
        gl.glFlush();
        a += (2 * Math.PI) / 3;  // 120 degrees
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    private void drawCircle(GL gl, float x, float y, float z, float r, int steps) {
        // Starting a list of triangles.
        gl.glBegin(GL.GL_TRIANGLE_FAN);
        // Seting the center vertex of the fan.
        gl.glVertex3f(x, y, z);
        // For each step draw a triangle from the fan.
        for (int step = 0; step <= steps; step++) {
            double angle = 2 * Math.PI / steps * step;
            gl.glVertex3d(x + Math.cos(angle) * r, y + Math.sin(angle) * r, z);
        }

        // Close the fan.
        //  gl.glVertex3f(x + r, y, z);
        // End the list of triangles.
        gl.glEnd();
    }
}
