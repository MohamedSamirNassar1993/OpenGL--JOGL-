package House;

import java.awt.*;
import java.awt.event.*;
import javax.media.opengl.*;
import javax.swing.*;
//import net.java.games.jogl.*;

public class House extends JFrame {

    public static void main(String[] args) {
        final House app = new House();
        // show what we've done
        app.setVisible(true);
    }

    public House() {
        //set the JFrame title
        super("House");
        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //only three JOGL lines of code ... and here they are
        GLCapabilities glcaps = new GLCapabilities();
        GLCanvas glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(
                new HouseEventListener()
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

class HouseEventListener implements GLEventListener {

    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glViewport(0, 0, 500, 300);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-250.0, 250.0, -150.0, 150.0, 1.0, -1.0);
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glBegin(GL.GL_LINE_STRIP);
        
        gl.glVertex2d(0, 140);
        gl.glVertex2d(125, 75);
        gl.glVertex2d(-125, 75);
        gl.glVertex2d(-125, -75);
        gl.glVertex2d(125, -75);
        gl.glVertex2d(125, 75);
        gl.glVertex2d(-125, -75);
        gl.glVertex2d(125, -75);
        gl.glVertex2d(-125, 75);
        gl.glVertex2d(0, 140);
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
