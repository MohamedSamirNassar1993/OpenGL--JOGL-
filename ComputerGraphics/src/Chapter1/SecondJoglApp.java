package Chapter1;

import java.awt.*;
import javax.swing.*;
import javax.media.opengl.*;
import javax.media.opengl.glu.GLU;


/**
 * This is a basic JOGL app. Feel free to reuse this code or modify it.
 */
public class SecondJoglApp extends JFrame {

    public static void main(String[] args) {
        final SecondJoglApp app = new SecondJoglApp();
        //show what we've done
        SwingUtilities.invokeLater(
                new Runnable() {
            public void run() {
                app.setVisible(true);
            }
        });
    }

    public SecondJoglApp() {
        //set the JFrame title
        super("Second JOGL Application");
        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //only two JOGL lines of code ... and here they are
        GLCanvas glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(new SecondGLEventListener());
        //add the GLCanvas just like we would any Component
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);
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
        frame.setLocation(
                (screenSize.width - frameSize.width) >> 1,
                (screenSize.height - frameSize.height) >> 1);
    }
}

class SecondGLEventListener implements GLEventListener {

    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        GLU glu = new GLU();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glViewport(0, 0, 500, 300);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(0.0, 500.0, 0.0, 300.0);
    }

    /**
     * Take care of drawing here.
     */
    public void display(GLAutoDrawable drawable) {
        float red = 0.0f;
        float green = 0.0f;
        float blue = 0.0f;
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glPointSize(5.0f);
        for (int i = 0; i < 50; i++) {
            red -= .09f;
            green -= .12f;
            blue -= .15f;

            if (red < 0.15) {
                red = 1.0f;
            }
            if (green < 0.15) {
                green = 1.0f;
            }
            if (blue < 0.15) {
                blue = 1.0f;
            }
            gl.glColor3f(red, green, blue);
            gl.glBegin(GL.GL_POINTS);
            gl.glVertex2i((i * 10), 150);
            gl.glEnd();
        }
    }

    /**
     * Called when the GLDrawable (GLCanvas or GLJPanel) has changed in size. We
     * won't need this, but you may eventually need it -- just not yet.
     */
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    /**
     * If the display depth is changed while the program is running this method
     * is called. Nowadays this doesn't happen much, unless a programmer has his
     * program do it.
     */
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
}
