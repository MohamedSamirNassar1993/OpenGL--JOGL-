package ApproximationCircle;

import java.awt.*;
import java.awt.event.*;
import javax.media.opengl.*;
import javax.swing.*;
//import net.java.games.jogl.*;

public class ApproximatoinCircleFillingWithWhiteColor extends JFrame {

    public static void main(String[] args) {
        final ApproximatoinCircleFillingWithWhiteColor app = new ApproximatoinCircleFillingWithWhiteColor();
        // show what we've done
        app.setVisible(true);
    }

    public ApproximatoinCircleFillingWithWhiteColor() {
        //set the JFrame title
        super("Drawing An Approximatoin Circle Filling With White Color");
        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //only three JOGL lines of code ... and here they are
        GLCapabilities glcaps = new GLCapabilities();
        GLCanvas glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(
                new ApproximatoinCircleFillingWithWhiteColorEventListener()
        );
        //add the GLCanvas just like we would any Component
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);
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

class ApproximatoinCircleFillingWithWhiteColorEventListener implements GLEventListener {

    final double ONE_DEGREE = (2 * Math.PI / 9);
    final double THREE_SIXTY = 2 * Math.PI;

    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glViewport(-250, -150, 250, 150);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-250.0, 250.0, -150.0, 150.0, 1.0, -1.0);
    }

    public void display(GLAutoDrawable drawable) {
        double x, y;
        double radius = 100;
        float red = 0.5f;
        float green = 0.5f;
        float blue = 0.5f;
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glColor3f(red, green, blue);
        //gl.glBegin(GL.GL_POLYGON);
        gl.glBegin(GL.GL_POLYGON);
        // angle is
        // x = radius * (cosine of angle)
        // y = radius * (sine of angle)

        for (double a = 0; a < THREE_SIXTY; a += ONE_DEGREE) {
            x = radius * (Math.cos(a));
            y = radius * (Math.sin(a));
            gl.glColor3f(1, 1, 1);
            gl.glVertex2d(x, y);
        }
        gl.glEnd();
        
    }

    public void reshape(
            GLAutoDrawable drawable,
            int x,
            int y,
            int width,
            int height
    ) {
    }

    public void displayChanged(
            GLAutoDrawable drawable,
            boolean modeChanged,
            boolean deviceChanged
    ) {
    }
}
