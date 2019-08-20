package DrawingSinCosTanLine;

import java.awt.*;
import java.awt.event.*;
import java.nio.Buffer;
import javax.swing.*;
import javax.media.opengl.*;

/**
 * This is a basic JOGL app. Feel free to reuse this code or modify it.
 */
public class TrigGraphApp extends JFrame implements ActionListener {
    //Notice we've given these two objects a larger scope.
    //Local scope to the constructor was no longer sufficient.

    TrigGLEventListener listener = new TrigGLEventListener();
    GLCanvas glcanvas;

    JTextField ajtf2 = new JTextField("3", 3);
    JTextField bjtf2 = new JTextField("2", 3);
    JTextField mjtf2 = new JTextField("-1", 6);

    public static void main(String[] args) {
        final TrigGraphApp app = new TrigGraphApp();
        // show what we've done
        SwingUtilities.invokeLater(
                new Runnable() {
            public void run() {
                app.setVisible(true);
            }
        }
        );
    }

    public TrigGraphApp() {
        //set the JFrame title
        super("Sin, Cos ,Tan and Line");
        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Setting up our southern JPanel with JRadioButtons
        JPanel jp = new JPanel();
        ButtonGroup bg = new ButtonGroup();
        //setting up the sine JRadioButton
        JRadioButton jrb1 = new JRadioButton("Sin", true);
        jrb1.setActionCommand("sin");
        jrb1.addActionListener(this);
        //setting up the cosine JRadioButton
        JRadioButton jrb2 = new JRadioButton("Cos");
        jrb2.setActionCommand("cos");
        jrb2.addActionListener(this);
        //setting up the tangent JRadioButton
        JRadioButton jrb3 = new JRadioButton("Tan");
        JButton drow = new JButton("Drow Line");
        jrb3.setActionCommand("tan");
        jrb3.addActionListener(this);
        JPanel jp1 = new JPanel();
        //adding the JTextFields and JLabels
        //adding the buttons to the ButtonGroup
        bg.add(jrb1);
        bg.add(jrb2);
        bg.add(jrb3);
        //adding the buttons to the JPanel 
        jp.add(jrb1);
        jp.add(jrb2);
        jp.add(jrb3);
        getContentPane().add("North", jp);
        getContentPane().add("South", jp1);

        jp1.add(new JLabel("x:"));
        jp1.add(ajtf2);
        jp1.add(new JLabel(" y:"));
        jp1.add(bjtf2);
        jp1.add(new JLabel(" slope: "));
        jp1.add(mjtf2);
        jp1.add(drow);

        //adding the JButton
        JButton jb = new JButton("Redraw");
        jb.addActionListener(this);
        jp.add(jb);
        drow.setActionCommand("line");
        drow.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                listener.whatToDraw = e.getActionCommand();
                listener.a = Double.parseDouble(ajtf2.getText());
                listener.b = Double.parseDouble(bjtf2.getText());
                listener.m = Double.parseDouble(mjtf2.getText());
                glcanvas.repaint();

            }
        });

        //only three JOGL lines of code ... and here they are
        GLCapabilities glcaps = new GLCapabilities();
        glcanvas = new GLCanvas();
        //GLDrawableFactory.getFactory().createGLCanvas(glcaps);
        glcanvas.addGLEventListener(listener);
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
        frame.setLocation((screenSize.width - frameSize.width) >> 1, (screenSize.height - frameSize.height) >> 1);
    }

    /**
     * Implementation of our ActionListener. This allows the buttons to perform
     * an action. In this case they set the "whatToDraw" String and ask for a
     * repaint of the GLCanvas.
     */
    public void actionPerformed(ActionEvent ae) {
        listener.whatToDraw = ae.getActionCommand();
        glcanvas.repaint();
    }
}

/**
 * For our purposes only two of the GLEventListeners matter. Those would be
 * init() and display().
 */
class TrigGLEventListener implements GLEventListener, GLDrawable {

    public String whatToDraw = "sine";
    public double m = -1;
    public double a = 3;
    public double b = 2;
    ///////////////////////////////////////////////////
    // GLEventListener implementation
    //

    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        GL glu = gld.getGL();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glLineWidth(2.0f);
        gl.glPointSize(2.0f);
        gl.glViewport(-250, -150, 250, 150);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-250.0, 250.0, -150.0, 150.0, -1, 1);
    }

    /**
     * Take care of drawing here.
     */
    @Override
    public void display(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        drawGraph(gl);
        //This is the new code. We find out
        //which trig function is selected,
        //then we draw a scaled up version of
        //the function.
        float red;
        float green;
        float blue;
        ////////////////////
        //drawing the grid
        red = 1.0f;
        green = 0.2f;
        blue = 0.2f;
        gl.glColor3f(red, green, blue);
        gl.glBegin(GL.GL_POINTS);
        if (whatToDraw.equals("sin")) {
            //draw enlarged sine function
            for (int x = -250; x < 250; x++) {
                gl.glVertex2d(x, (Math.sin(x / 60.0) * 100.0));
            }
        } else if (whatToDraw.equals("cos")) {
            //draw enlarged cosine function
            for (int x = -250; x < 250; x++) {
                gl.glVertex2d(x, (Math.cos(x / 60.0) * 100.0));
            }
        } else if (whatToDraw.equals("tan")) {
            //draw enlarged tangent function
            for (int x = -250; x < 250; x++) {
                gl.glVertex2d(x, (Math.tan(x / 60.0) * 30.0));
            }
        } else if (whatToDraw.equals("line")) {
            gl.glBegin(GL.GL_POINTS);
            double a1 = a * 10;
            double b1 = b * 10;

            for (int x = -250; x <= 250; x++) {
                gl.glVertex2d(x, (m * (x - a1) + b1));
            }

            gl.glEnd();
            red = 1.0f;
            green = 1.0f;
            blue = 1.0f;
            gl.glColor3f(red, green, blue);
            gl.glPointSize(4.0f);
            gl.glBegin(GL.GL_POINTS);
            gl.glVertex2d(a1, b1);
            gl.glEnd();
            //resetting the point to 2 pixels.
            gl.glPointSize(2.0f);
        }
        gl.glEnd();
    }

    public void reshape(GLDrawable drawable, int x, int y, int width, int height) {

    }

    public void displayChanged(GLDrawable drawable, boolean modeChanged, boolean deviceChanged) {

    }
    ///////////////////////////////////////////////////
    // Other methods
    //

    /**
     * In here we draw a Cartesian Coordinate System.
     */
    private void drawGraph(GL gl) {
        float red;
        float green;
        float blue;
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        ////////////////////
        //drawing the grid
        red = 0.2f;
        green = 0.2f;
        blue = 0.2f;
        gl.glColor3f(red, green, blue);
        //You may notice I'm using GL_LINES here.
        //Details of glBegin() will be discussed latter.
        gl.glBegin(GL.GL_LINES);
        //draw the vertical lines
        for (int x = -250; x <= 250; x += 10) {
            gl.glVertex2d(x, -150);
            gl.glVertex2d(x, 150);
        }
        //draw the horizontal lines
        for (int y = -150; y <= 150; y += 10) {
            gl.glVertex2d(-250, y);
            gl.glVertex2d(250, y);
        }
        gl.glEnd();
        //////////////////////////////
        // draw the x-axis and y-axis
        red = 0.0f;
        green = 0.2f;
        blue = 0.4f;
        gl.glColor3f(red, green, blue);
        gl.glBegin(GL.GL_LINES);
        //line for y-axis
        gl.glVertex2d(0, 140);
        gl.glVertex2d(0, -140);
        //line for x-axis
        gl.glVertex2d(240, 0);
        gl.glVertex2d(-240, 0);
        gl.glEnd();
        /////////////////////
        // draw arrow heads
        gl.glBegin(GL.GL_TRIANGLES);
        gl.glVertex2d(0, 150);
        gl.glVertex2d(-5, 140);
        gl.glVertex2d(5, 140);
        gl.glVertex2d(0, -150);
        gl.glVertex2d(-5, -140);
        gl.glVertex2d(5, -140);
        gl.glVertex2d(250, 0);
        gl.glVertex2d(240, -5);
        gl.glVertex2d(240, 5);
        gl.glVertex2d(-250, 0);
        gl.glVertex2d(-240, -5);
        gl.glVertex2d(-240, 5);
        gl.glEnd();
    }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayChanged(GLAutoDrawable glad, boolean bln, boolean bln1) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GLContext createContext(GLContext glc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRealized(boolean bln) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSize(int i, int i1) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getWidth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getHeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void swapBuffers() throws GLException {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GLCapabilities getChosenGLCapabilities() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
