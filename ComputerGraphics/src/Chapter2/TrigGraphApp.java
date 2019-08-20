package Chapter2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.media.opengl.*;
import javax.media.opengl.glu.GLU;

/**
 * This is a basic JOGL app. Feel free to reuse this code or modify it.
 */
public class TrigGraphApp extends JFrame implements ActionListener {
    //Notice we've given these two objects a larger scope.
    //Local scope to the constructor was no longer sufficient.

    TrigGLEventListener listener = new TrigGLEventListener();
    GLCanvas glcanvas;

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
        super("Sine, Cosine and Tangent");

        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Setting up our southern JPanel with JRadioButtons
        JPanel jp = new JPanel();
        ButtonGroup bg = new ButtonGroup();

        //setting up the sine JRadioButton
        JRadioButton jrb1 = new JRadioButton("Sine", true);
        jrb1.setActionCommand("sine");
        jrb1.addActionListener(this);

        //setting up the cosine JRadioButton
        JRadioButton jrb2 = new JRadioButton("Cosine");
        jrb2.setActionCommand("cosine");
        jrb2.addActionListener(this);

        //setting up the tangent JRadioButton
        JRadioButton jrb3 = new JRadioButton("Tangent");
        jrb3.setActionCommand("tangent");
        jrb3.addActionListener(this);

        //adding the buttons to the ButtonGroup
        bg.add(jrb1);
        bg.add(jrb2);
        bg.add(jrb3);

        //adding the buttons to the JPanel
        jp.add(jrb1);
        jp.add(jrb2);
        jp.add(jrb3);

        getContentPane().add("South", jp);

        //only two JOGL lines of code ... and here they are 
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);

        //add the GLCanvas just like we would any Component
        getContentPane().add("Center", glcanvas);
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
                (screenSize.height - frameSize.height) >> 1
        );
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

class TrigGLEventListener implements GLEventListener {

    public String whatToDraw = "sine";

    ///////////////////////////////////////////////////
    // GLEventListener implementation
    //
    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        GLU glu = new GLU();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

        gl.glLineWidth(2.0f);
        gl.glPointSize(2.0f);

        gl.glViewport(-250, -150, 250, 150);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);
    }

    /**
     * Take care of drawing here.
     */
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

        if (whatToDraw.equals("sine")) {
            //draw enlarged sine function
            for (int x = -250; x < 250; x++) {
                gl.glVertex2d(x, (Math.sin(x / 60.0) * 100.0));
            }
        } else if (whatToDraw.equals("cosine")) {
            //draw enlarged cosine function
            for (int x = -250; x < 250; x++) {
                gl.glVertex2d(x, (Math.cos(x / 60.0) * 100.0));
            }
        } else if (whatToDraw.equals("tangent")) {
            //draw enlarged tangent function
            for (int x = -250; x < 250; x++) {
                gl.glVertex2d(x, (Math.tan(x / 60.0) * 30.0));
            }
        }

        gl.glEnd();

    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
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

}
