package lab5programs2;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.media.opengl.*;
import javax.media.opengl.glu.*;

public class paint3 extends JFrame implements ActionListener {

    paint3GLEventListener listener = new paint3GLEventListener();
    static GLCanvas glcanvas = null;
    JButton jrb1 = new JButton("Color");
    JButton jrb2 = new JButton("Undo");
    JButton jrb3 = new JButton("Redo");
    JButton jrb4 = new JButton("Clear");

    public static void main(String[] args) {
        final paint3 app = new paint3();
        app.setVisible(true);
    }

    public paint3() {
        super("paint program");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jp = new JPanel();
        jrb1.addActionListener(this);
        jrb1.setActionCommand("color");
        jrb2.addActionListener(this);
        jrb2.setActionCommand("undo");
        jrb3.addActionListener(this);
        jrb3.setActionCommand("redo");
        jrb4.addActionListener(this);
        jrb4.setActionCommand("clear");
//
//        ButtonGroup bg = new ButtonGroup();
//        bg.add(jrb1);
//        bg.add(jrb2);
//        bg.add(jrb3);
        jp.add(jrb1);
        jp.add(jrb2);
        jp.add(jrb3);
        jp.add(jrb4);

        //only three JOGL lines of code ... and here they are 
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addMouseListener(listener);
        glcanvas.addMouseMotionListener(listener);
        //we'll want this for our repaint requests 
        listener.setGLCanvas(glcanvas);

        //add the GLCanvas just like we would any Component
        getContentPane().add("West", jp);
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(1200, 700);
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

    public void actionPerformed(ActionEvent ae) {
        listener.whatToDraw = ae.getActionCommand();
    }
}

class paint3GLEventListener implements GLEventListener, MouseListener, MouseMotionListener, KeyListener {

    Point[] p = new Point[1000];

    Graphics grphcs;
    String whatToDraw = "none";

    float red = 0.0f;
    float green = 0.0f;
    float blue = 0.0f;

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
        gl.glClearColor(1, 1, 1, 0.0f);

        gl.glViewport(0, 0, 1200, 700);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(0.0, 1200.0, 0.0, 700.0);
    }

    /**
     * Take care of drawing here.
     */
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

//        gl.glColor3f(red, green, blue);
        gl.glBegin(GL.GL_LINE_STRIP);
        for (int i = 0; i < p.length; i++) {
            if (p[i].x == 1200 && p[i].y == 700) {
                gl.glColor3f(1, 1, 1);
                gl.glVertex2d(p[i].x, p[i].y);
            } else {
                gl.glColor3f(red, green, blue);
                gl.glVertex2d(p[i].x, p[i].y);
            }
        }
        gl.glEnd();
//        System.out.println(list.);
        /*
        if (whatToDraw.equals("rectangle")) {
            red = 0.0f;
            green = 0.0f;
            blue = 0.0f;
            gl.glLineWidth(3.0f);
            gl.glColor3f(red, green, blue);
            gl.glBegin(GL.GL_LINES);
            gl.glVertex2i(xPosition1, yPosition1);
            gl.glVertex2i(xPosition1, yPosition2);
            
            gl.glVertex2i(xPosition1, yPosition2);
            gl.glVertex2i(xPosition2, yPosition2);
            
            gl.glVertex2i(xPosition2, yPosition2);
            gl.glVertex2i(xPosition2, yPosition1);
            
            gl.glVertex2i(xPosition2, yPosition1);
            gl.glVertex2i(xPosition1, yPosition1);
            gl.glEnd();
        }        
         */
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        Component c = e.getComponent();
        double width = c.getWidth();
        double height = c.getHeight();

        //get percent of GLCanvas instead of
        //points and then converting it to our
        //'300' based coordinate system.
        int xPosition1 = (int) ((x / width) * 1200);
        int yPosition1 = 700 - ((int) ((y / height) * 700));
        p[0] = new Point(xPosition1, yPosition1);
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
        int xPosition2 = (int) ((x / width) * 1200);
        int yPosition2 = 700 - ((int) ((y / height) * 700));
        for(int i = 1 ; i<p.length ;i++){
            if(p[i] == null){
                p[i] = new Point(xPosition2, yPosition2);
                p[i+1] = new Point(1200, 700);
                p[i+2] = new Point(1200, 700);
                
            }
            break;
        }
    }

    public void mouseDragged(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        Component c = e.getComponent();
        double width = c.getWidth();
        double height = c.getHeight();

        //get percent of GLCanvas instead of
        //points and then converting it to ourq
        //'300' based coordinate system.
        int xPosition2 = (int) ((x / width) * 1200);
        int yPosition2 = 700 - ((int) ((y / height) * 700));

        for(int i = 1 ; i< p.length ;i++){
            if(p[i] == null){
                p[i] = new Point(xPosition2, yPosition2);
                break;
            }
        }
        glc.paint(grphcs);
    }

    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
