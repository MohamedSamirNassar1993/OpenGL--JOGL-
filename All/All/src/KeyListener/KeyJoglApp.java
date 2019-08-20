package KeyListener;

import javax.media.opengl.*;
import javax.media.opengl.glu.*;

/**
 * For our purposes only two of the GLEventListeners matter. Those would be
 * init() and display().
 */
public class KeyJoglApp implements GLEventListener {

    int xPosition = 25;
    int yPosition = 25;
    float red = 0.0f;
    float green = 0.0f;
    float blue = 1.0f;

    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable drawable) {

        GL gl = drawable.getGL();
        GLU glu = new GLU();

        red = 0.0f;
        green = 0.0f;
        blue = 1.0f;

        gl.glClearColor(red, green, blue, 0.0f);

        gl.glViewport(0, 0, 50, 50);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(0.0, 50.0, 0.0, 50.0);


    }

    /**
     * Take care of drawing here.
     */
    public void display(GLAutoDrawable drawable) {

        GL gl = drawable.getGL();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        //Remember point size refers
        //to pixels, not the coordinate
        //system we've set up in the
        //GLCanvas
        gl.glPointSize(6.0f);

        red = 0.0f;
        green = 1.0f;
        blue = 0.0f;

        gl.glColor3f(red, green, blue);

        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2i(xPosition, yPosition);
        gl.glEnd();

    }

    /**
     * Called when the GLDrawable (GLCanvas or GLJPanel) has changed in size. We
     * won't need this, but you may eventually need it -- just not yet.
     */
    public void reshape(
            GLAutoDrawable drawable,
            int x,
            int y,
            int width,
            int height) {
    }

    /**
     * If the display depth is changed while the program is running this method
     * is called. Nowadays this doesn't happen much, unless a programmer has his
     * program do it.
     */
    public void displayChanged(
            GLAutoDrawable drawable,
            boolean modeChanged,
            boolean deviceChanged) {
    }
}
