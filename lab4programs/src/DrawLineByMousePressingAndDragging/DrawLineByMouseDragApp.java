package DrawLineByMousePressingAndDragging;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.media.opengl.*;
import javax.media.opengl.glu.*;

public class DrawLineByMouseDragApp extends JFrame {

    DrawLineByMouseDragGLEventListener listener = new DrawLineByMouseDragGLEventListener();
    static GLCanvas glcanvas = null;

    public static void main(String[] args) {
        final DrawLineByMouseDragApp app = new DrawLineByMouseDragApp();
        app.setVisible(true);
        glcanvas.requestFocusInWindow();
    }

    public DrawLineByMouseDragApp() {
        super("Draw Line By Mouse Drag Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addMouseListener(listener);
        glcanvas.addMouseMotionListener(listener);
        glcanvas.addKeyListener(listener);
        listener.setGLCanvas(glcanvas);
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);
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

class DrawLineByMouseDragGLEventListener implements GLEventListener, MouseListener, MouseMotionListener, KeyListener {

    int xPosition1 = 50;
    int yPosition1 = 50;
    int xPosition2 = 50;
    int yPosition2 = 50;

    final double ONE_DEGREE = (Math.PI / 180);
    final double THREE_SIXTY = 2 * Math.PI;

    GLCanvas glc;
    public void setGLCanvas(GLCanvas glc) {
        this.glc = glc;
    }

    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        gl.glClearColor(0, 0, 0, 0.0f);
        gl.glViewport(0, 0, 500, 300);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(0.0, 500.0, 0.0, 300.0);
    }

    /**
     * Take care of drawing here.
     */
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glLineWidth(3.0f);
        gl.glColor3f(1, 1, 1);
        gl.glBegin(GL.GL_LINES);
        gl.glVertex2d(xPosition1, yPosition1);
        gl.glVertex2d(xPosition2, yPosition2);
        gl.glEnd();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    ////////////////////////////////////////////
    // MouseListener implementation below
    public void mousePressed(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        Component c = e.getComponent();
        double width = c.getWidth();
        double height = c.getHeight();
        //get percent of GLCanvas instead of
        //points and then converting it to our
        //'300' based coordinate system.
        xPosition1 = (int) ((x / width) * 500);
        yPosition1 = ((int) ((y / height) * 300));
        //reversing direction of y axis 
        yPosition1 = 300 - yPosition1;
    }

    public void mouseReleased(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        Component c = e.getComponent();
        double width = c.getWidth();
        double height = c.getHeight();
        //get percent of GLCanvas instead of
        //points and then converting it to our
        //'300' based coordinate system.
        xPosition2 = (int) ((x / width) * 500);
        yPosition2 = ((int) ((y / height) * 300));
        //reversing direction of y axis 
        yPosition2 = 300 - yPosition2;
        glc.repaint();
    }

    public void mouseDragged(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        Component c = e.getComponent();
        double width = c.getWidth();
        double height = c.getHeight();
        //get percent of GLCanvas instead of
        //points and then converting it to our
        //'300' based coordinate system.
        xPosition2 = (int) ((x / width) * 500);
        yPosition2 = ((int) ((y / height) * 300));
        //reversing direction of y axis 
        yPosition2 = 300 - yPosition2;
        glc.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
