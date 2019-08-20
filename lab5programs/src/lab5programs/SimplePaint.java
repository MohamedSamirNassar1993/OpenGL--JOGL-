package lab5programs;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.media.opengl.*;
import javax.media.opengl.glu.*;

public class SimplePaint extends JFrame implements ActionListener {

    SimplePaintGLEventListener listener = new SimplePaintGLEventListener();
    static GLCanvas glcanvas = null;
    public JButton jrb1 = new JButton("Color");
    JButton jrb2 = new JButton("Undo");
    JButton jrb3 = new JButton("Redo");
    JButton jrb4 = new JButton("Clear");

    public static void main(String[] args) {
        final SimplePaint app = new SimplePaint();
        app.setVisible(true);
    }

    public SimplePaint() {
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
        getContentPane().add("North", jp);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        listener.whatToDraw = e.getActionCommand();
    }

}

class SimplePaintGLEventListener implements GLEventListener, MouseListener, MouseMotionListener, KeyListener {

    ArrayList<point> list = new ArrayList<point>();
    ArrayList<point> list1 = new ArrayList<point>();
    ArrayList<point> list2 = new ArrayList<point>();
    Graphics grphcs;
    String whatToDraw = "none";

    float red = 0.0f;
    float green = 0.0f;
    float blue = 0.0f;

    Color ss;

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

        ss = Color.BLACK;
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
        gl.glBegin(GL.GL_LINE_STRIP);
        for (int i = 0; i < list.size(); i++) {
            point p = list.get(i);

            if (p.isIsStart() == false) {
                gl.glColor3f(p.getColor().getRed() / 255.0f, p.getColor().getGreen() / 255.0f, p.getColor().getBlue() / 255.0f);
                gl.glVertex2d(p.getX(), p.getY());
            } else {
                gl.glEnd();
                gl.glBegin(GL.GL_LINE_STRIP);
            }
        }
        gl.glEnd();

        if (whatToDraw.equals("color")) {
            Color newColor = JColorChooser.showDialog(glc, "Choose Color", Color.yellow);
            if (newColor != null) {
                ss = newColor;
            }
            whatToDraw = "none";
        }

        if (whatToDraw.equals("undo")) {
            for (int i = list.size()-1 ; i <= 0; i--) {
                point p1 = list.get(i);
                if(p1.isIsStart() == true){
                    /*
                    for (int j = 0 ; j < i ; j++) {
                        point p2 = list.get(j);
                        list1.add(j,p2);
                        break;
                    }
                    */
                    System.arraycopy(list, 0, list1, 0, i-1);
                    break;
                }
                
            }
            gl.glClearColor(1, 1, 1, 0.0f);
            gl.glClear(GL.GL_COLOR_BUFFER_BIT);
            gl.glBegin(GL.GL_LINE_STRIP);
            for (int k = 0; k < list1.size(); k++) {
                point p1 = list1.get(k);
                if (p1.isIsStart() == false) {
                    gl.glColor3f(p1.getColor().getRed() / 255.0f, p1.getColor().getGreen() / 255.0f, p1.getColor().getBlue() / 255.0f);
                    gl.glVertex2d(p1.getX(), p1.getY());
                } else {
                    gl.glEnd();
                    gl.glBegin(GL.GL_LINE_STRIP);
                }
            }
            gl.glEnd();
            whatToDraw = "none";
        }

        if (whatToDraw.equals("redo")) {

        }
        
        if (whatToDraw.equals("clear")) {
            GL gl1 = drawable.getGL();
            gl1.glClear(GL.GL_COLOR_BUFFER_BIT);
            whatToDraw = "none";
        }

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
        point p = new point();
        p.setX(xPosition1);
        p.setY(yPosition1);
        p.setIsStart(true);
        p.setColor(ss);
        list.add(p);
//        list.add(0 ,Point(Point.setX(xPosition1) ,setY(yPosition1)));
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

        point p = new point();
        p.setX(xPosition2);
        p.setY(yPosition2);
        p.setIsStart(false);
        p.setColor(ss);
        list.add(p);
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
        int xPosition2 = (int) ((x / width) * 1200);
        int yPosition2 = 700 - ((int) ((y / height) * 700));

        point p = new point();
        p.setX(xPosition2);
        p.setY(yPosition2);
        p.setIsStart(false);
        p.setColor(ss);
        list.add(p);
        glc.repaint();
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

class point {

    private int x;
    private int y;
    private boolean isStart;
    private Color color;

    public point() {
        this.x = x;
        this.y = y;
        this.isStart = isStart;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isIsStart() {
        return isStart;
    }

    public void setIsStart(boolean isStart) {
        this.isStart = isStart;
    }

}
