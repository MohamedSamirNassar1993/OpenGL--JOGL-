package Clock;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.media.opengl.*;
import javax.swing.*;

public class ClockDrawApp extends JFrame {
    GLCanvas glcanvas;
    public static void main(String[] args) {
        final ClockDrawApp app = new ClockDrawApp();
        // show what we've done
        app.setVisible(true);
    }

    public ClockDrawApp() {
        //set the JFrame title
        super("Clock Draw Application");
        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //only three JOGL lines of code ... and here they are
        GLCapabilities glcaps = new GLCapabilities();
        glcanvas = new GLCanvas(glcaps);
        glcanvas.addGLEventListener(new ClockDrawGLEventListener());
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(700, 700);
        //center the JFrame on the screen
        centerWindow(this);
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

class ClockDrawGLEventListener implements GLEventListener {
    final double ONE_DEGREE = (Math.PI / 180);
    final double THREE_SIXTY = 2 * Math.PI;
    final double TWELVE_DEGREE = (2 * Math.PI / 12);
    //floats used for color selection
    float red;
    float green;
    float blue;

    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glViewport(-350, -350, 350, 350);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-350.0, 350.0, -350.0, 350.0, 1.0, -1.0);
    }

    public void display(GLAutoDrawable drawable) {
        double x, y,x1 ,y1;
        double radius = 300;
        GL gl = drawable.getGL();
        gl.glLineWidth(6.0f);
        gl.glBegin(GL.GL_LINE_LOOP);
        for (double a = 0; a < THREE_SIXTY; a += ONE_DEGREE) {
            x = radius * (Math.cos(a));
            y = radius * (Math.sin(a));
            gl.glColor3f(1, 0, 0);
            gl.glVertex2d(x, y);
        }
        gl.glEnd();
        
        gl.glBegin(GL.GL_LINES);
        for (double a = 0; a < THREE_SIXTY; a += TWELVE_DEGREE) {
            x = radius  * (Math.cos(a));
            y = radius  * (Math.sin(a));
            x1 = (radius - 50) * (Math.cos(a));
            y1 = (radius - 50) * (Math.sin(a));
            gl.glColor3f(0, 1, 0);
            gl.glVertex2d(x , y);
            gl.glVertex2d(x1 , y1);
        }
        gl.glEnd();
        
        gl.glBegin(GL.GL_POLYGON);
        gl.glColor3f(0, 1, 0);
        gl.glVertex2d(10 , 0);
        gl.glColor3f(0, 1, 0);
        gl.glVertex2d(-10 , 0);
        gl.glColor3f(1, 0, 0);
        gl.glVertex2d(0 , 275);
        gl.glEnd();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public void displayChanged(GLAutoDrawable glad, boolean modeChanged, boolean deviceChanged) {
    }
}
