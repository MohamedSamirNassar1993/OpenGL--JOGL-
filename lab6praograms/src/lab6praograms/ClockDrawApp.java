package lab6praograms;

import com.sun.opengl.util.Animator;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.media.opengl.*;
import javax.swing.*;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;


public class ClockDrawApp extends JFrame implements ActionListener {
    //Notice we've given these two objects a larger scope.
    //Local scope to the constructor was no longer sufficient.

    ClockDrawGLEventListener listener = new ClockDrawGLEventListener();
    GLCanvas glcanvas;

    //radio buttons for clockwise and anti clockwise moving
    JRadioButton jrb1 = new JRadioButton("Clockwise", true);
    JRadioButton jrb2 = new JRadioButton("Anti-Clockwise");

    public static Animator animator = null;

    public static void main(String[] args) {
        final ClockDrawApp app = new ClockDrawApp();
        // show what we've done
        app.setVisible(true);
        animator.start();
    }

    public ClockDrawApp() {
        //set the JFrame title
        super("Clockwise and Anti-Clockwise moving Clock Application");
        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //only three JOGL lines of code ... and here they are
        JPanel jp = new JPanel();
        GLCapabilities glcaps = new GLCapabilities();
        glcanvas = new GLCanvas(glcaps);
        glcanvas.addGLEventListener(listener);

        ButtonGroup bg = new ButtonGroup();

        jrb1.setActionCommand("clockwise");
        jrb1.addActionListener(this);
        jrb2.setActionCommand("anti-clockwise");
        jrb2.addActionListener(this);

        bg.add(jrb1);
        bg.add(jrb2);

        animator = new Animator(glcanvas);
        //add the GLCanvas just like we would any Component
        jp.add(jrb1);
        jp.add(jrb2);
        getContentPane().add("South", jp);
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(500, 500);
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
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        listener.whatToDraw  = ae.getActionCommand();
    }

}

class ClockDrawGLEventListener implements GLEventListener {

    double[][] rotation_matrix = new double[3][3];
    double[][] LINE = new double[2][3];

    public String whatToDraw = "clockwise";

    final double ONE_DEGREE = (Math.PI / 180);
    final double THREE_SIXTY = 2 * Math.PI;
    //for animating the arrows
    double angle_mintues = 25 * ONE_DEGREE;
    double angle_hours = 25 * ONE_DEGREE;

    //floats used for color selection
    float red;
    float green;
    float blue;

    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glLineWidth(2.0f);
        gl.glPointSize(2.0f);
        gl.glViewport(-250, -250, 250, 250);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();

        gl.glOrtho(-250.0, 250.0, -250.0, 250.0, 1.0, -1.0);

        LINE[0][0] = 0;
        LINE[0][1] = -230;
        LINE[0][2] = 1;

        LINE[1][0] = 0;
        LINE[1][1] = 230;
        LINE[1][2] = 1;
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();

        //The lines of the hours
        gl.glColor3f(0.8549f, 0.68627f, 0.10588f);
        gl.glLineWidth(5.0f);
        gl.glBegin(GL.GL_LINES);
        for (int i = 0; i < 6; i++) {
            LINE = rotate_Line(LINE, 30);
            gl.glVertex2d(LINE[0][0], LINE[0][1]);
            gl.glVertex2d(LINE[1][0], LINE[1][1]);
        }
        gl.glEnd();

        //The outside circle of the clock
        gl.glColor3f(0.91372f, 0.84313f, 0.04313f);
        double x, y;
        double radius = 230;
        gl.glLineWidth(5.0f);
        gl.glBegin(GL.GL_LINE_LOOP);
        for (double a = 0; a < THREE_SIXTY; a += ONE_DEGREE) {
            x = radius * (Math.cos(a));
            y = radius * (Math.sin(a));
            gl.glVertex2d(x, y);
        }
        gl.glEnd();

        //The Black Circle in the middle to erase the lines
        gl.glColor3f(0.0f, 0.0f, 0.0f);
        radius = 190;
        gl.glBegin(GL.GL_POLYGON);
        for (double a = 0; a < THREE_SIXTY; a += ONE_DEGREE) {
            x = radius * (Math.cos(a));
            y = radius * (Math.sin(a));
            gl.glVertex2d(x, y);
        }
        gl.glEnd();

        if (whatToDraw.equals("clockwise")) {
            angle_mintues -= ONE_DEGREE / 50;
            angle_hours -= ONE_DEGREE / 600;

        } else if (whatToDraw.equals("anti-clockwise")) {
            angle_mintues += ONE_DEGREE / 50;
            angle_hours += ONE_DEGREE / 600;
        }
        //the arrow (the pointer minutes)z
        gl.glBegin(GL.GL_POLYGON);
        //BOT
        gl.glColor3f(0.0f, 0.8f, 0.0f);
        gl.glVertex2d(0, 0);
        //Right
        gl.glColor3f(0.2f, 0.8f, 0.2f);
        gl.glVertex2d(-20 * Math.cos(10 + angle_mintues), -20 * Math.sin(10 + angle_mintues));
        //TOP
        gl.glColor3f(0.2f, 0.0f, 0.9f);
        gl.glVertex2d(190 * Math.cos(20 + angle_mintues), 190 * Math.sin(20 + angle_mintues));
        //LEFT
        gl.glColor3f(0.2f, 0.8f, 0.2f);
        gl.glVertex2d(-20 * Math.cos(30 + angle_mintues), -20 * Math.sin(30 + angle_mintues));

        gl.glEnd();

        //the arrow (the pointer Hours)
        gl.glBegin(GL.GL_POLYGON);
        //BOT
        gl.glColor3f(0.0f, 0.8f, 0.0f);
        gl.glVertex2d(0, 0);
        //Right
        gl.glColor3f(0.2f, 0.8f, 0.2f);
        gl.glVertex2d(-20 * Math.cos(10 + angle_hours), -20 * Math.sin(10 + angle_hours));
        //TOP
        gl.glColor3f(0.2f, 0.0f, 0.9f);
        gl.glVertex2d(150 * Math.cos(20 + angle_hours), 150 * Math.sin(20 + angle_hours));
        //LEFT
        gl.glColor3f(0.2f, 0.8f, 0.2f);
        gl.glVertex2d(-20 * Math.cos(30 + angle_hours), -20 * Math.sin(30 + angle_hours));

        gl.glEnd();

    }

    private double[][] rotate_Line(double[][] LINE, double angle) {
        final double ONE_DEGREE = Math.PI / 180;
        double angle_deg = angle * ONE_DEGREE;
        //set the Rotation matrix
        rotation_matrix[0][0] = Math.cos(angle_deg);
        rotation_matrix[0][1] = Math.sin(angle_deg);
        rotation_matrix[0][2] = 0;

        rotation_matrix[1][0] = -Math.sin(angle_deg);
        rotation_matrix[1][1] = Math.cos(angle_deg);
        rotation_matrix[1][2] = 0;

        rotation_matrix[2][0] = 0;
        rotation_matrix[2][1] = 0;
        rotation_matrix[2][2] = 1;
        return multiply_two_matrices(LINE, rotation_matrix);
    }

    private double[][] multiply_two_matrices(double[][] x, double[][] y) {
        double[][] result = new double[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = (x[i][0] * y[0][j])
                        + (x[i][1] * y[1][j])
                        + (x[i][2] * y[2][j]);
            }
        }
        return result;
    }

    public void reshape(GLAutoDrawable drawable,
            int x, int y,
            int width,
            int height) {
    }

    public void displayChanged(GLAutoDrawable glad,
            boolean modeChanged,
            boolean deviceChanged) {
    }

}


