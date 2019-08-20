package DrawStarWithMouseClick;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.media.opengl.*;
import javax.media.opengl.glu.*;

public class DrowStar extends JFrame {
    static GLCanvas glcanvas = null;
    public static void main(String[] args) {
        final DrowStar app = new DrowStar();
        app.setVisible(true);
        glcanvas.requestFocusInWindow();
    }

    public DrowStar() {
        super("Drow Star On Mouse Click!");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DrowStarGLEventListene md = new DrowStarGLEventListene();
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(md);
        glcanvas.addMouseListener(md);
        glcanvas.addKeyListener(md);
        md.setGLCanvas(glcanvas);
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(500, 500);
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

class DrowStarGLEventListene implements GLEventListener, MouseListener, KeyListener {
    static int xPosition = 50;
    static int yPosition = 50;
    int OutCircleRadius = 15, inCircleRadius = 5;
    double[] xStarPoints = new double[10];
    double[] yStarPoints = new double[10];
    final double ONE_DEGREE = (Math.PI / 180);
    
    GLCanvas glc;
    public void setGLCanvas(GLCanvas glc) {
        this.glc = glc;
    }

    //this method to get points to drow star
    public void getPoints() {
        for (int i = 0; i < 5; i++) {
            xStarPoints[i] = xPosition + inCircleRadius * Math.cos((i + 1) * ONE_DEGREE * 72);
            yStarPoints[i] = yPosition + inCircleRadius * Math.sin((i + 1) * ONE_DEGREE * 72);
        }
        for (int i = 5; i < 10; i++) {
            xStarPoints[i] = xPosition + OutCircleRadius * Math.cos((i - 4) * ONE_DEGREE * 72 + ONE_DEGREE * 36);
            yStarPoints[i] = yPosition + OutCircleRadius * Math.sin((i - 4) * ONE_DEGREE * 72 + ONE_DEGREE * 36);
        }
    }

    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        gl.glClearColor(0, 0, 0, 0.0f);
        gl.glViewport(0, 0, 100, 100);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(0.0, 100.0, 0.0, 100.0);
    }
    
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        //Remember point size refers
        //to pixels, not the coordinate
        //system we've set up in the
        //GLCanvas
        gl.glPointSize(6.0f);
        gl.glColor3f(1, 1, 1);

        gl.glBegin(GL.GL_LINE_LOOP);
        for (int i = 0; i < 5; i++) {
            gl.glVertex2d(xStarPoints[i], yStarPoints[i]);
            gl.glVertex2d(xStarPoints[i + 5], yStarPoints[i + 5]);
        }
        gl.glEnd();
    }

    public void reshape(GLAutoDrawable drawable, int x,int y,int width,int height) { }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) { }

    public void mouseClicked(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        Component c = e.getComponent();
        double width = c.getWidth();
        double height = c.getHeight();

        //get percent of GLCanvas instead of
        //points and then converting it to our
        //'100' based coordinate system.
        xPosition = (int) ((x / width) * 100);
        yPosition = ((int) ((y / height) * 100));

        //reversing direction of y axis 
        yPosition = 100 - yPosition;
        getPoints();
        
        glc.repaint();
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}