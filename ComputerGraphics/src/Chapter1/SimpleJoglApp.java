package Chapter1;

import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
import javax.media.opengl.*;

public class SimpleJoglApp extends JFrame {
    public static void main(String[] args) {
        final SimpleJoglApp app = new SimpleJoglApp();
    }

    public SimpleJoglApp() {
        //set the JFrame title
        super("Simple JOGL Application");
        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //only three JOGL lines of code ... and here they are 
        GLCanvas glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(new SimpleGLEventListener());
        // add the GLCanvas just like we would	 any Component
        add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);
        //center the JFrame on the screen
        centerWindow();
        setVisible(true);
    }

    public void centerWindow() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        this.setLocation(
                (screenSize.width - frameSize.width) >> 1,
                (screenSize.height - frameSize.height) >> 1
        );
    }
}

class SimpleGLEventListener implements GLEventListener {
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glViewport(0, 0, 600, 300);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(0.0, 600.0, 0.0, 300.0, -1.0, 1.0);
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glPointSize(13.0f);
        gl.glColor3f(1.0f, 0.0f, 0.0f);
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2i(300, 150);
        gl.glEnd();
        gl.glPointSize(33.0f);
        gl.glColor3f(0.0f, 1.0f, 0.0f);
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2i(200, 150);
        gl.glEnd();
        gl.glColor3f(0.0f, 0.0f, 1.0f);
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2i(400, 150);
        gl.glEnd();
    }

    public void reshape(GLAutoDrawable drawable,int x,int y,int width,int height) {
    }

    public void displayChanged(GLAutoDrawable drawable,boolean modeChanged,boolean deviceChanged) {
    }

    public void dispose(GLAutoDrawable arg0) {
        // TODO Auto-generated method stub
    }
}
