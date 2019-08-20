package Clock;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.media.opengl.*;
import javax.swing.*;

public class ClockDrawApp extends JFrame implements ActionListener {
    //Notice we've given these two objects a larger scope.
    //Local scope to the constructor was no longer sufficient.

    ClockDrawGLEventListener listener = new ClockDrawGLEventListener();
    GLCanvas glcanvas;
    JButton jb1 = new JButton("Clockwise");
    JButton jb2 = new JButton("Anti-Clockwise");
    JButton jb3 = new JButton("exit");

    public static void main(String[] args) {
        final ClockDrawApp app = new ClockDrawApp();
        // show what we've done
        app.setVisible(true);
    }

    public ClockDrawApp() {
        //set the JFrame title
        super("Clock-Draw Application");
        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //only three JOGL lines of code ... and here they are
        GLCapabilities glcaps = new GLCapabilities();
        glcanvas = new GLCanvas(glcaps);
        glcanvas.addGLEventListener(listener);

        JPanel jp = new JPanel();
        jb1.addActionListener(this);
        jb1.setActionCommand("clockwise");
        jb2.addActionListener(this);
        jb2.setActionCommand("anti-clockwise");
        jb3.addActionListener(this);
        jb3.setActionCommand("exit");
        
        jp.add(jb1);
        jp.add(jb2);
        jp.add(jb3);
        //add the GLCanvas just like we would any Component
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

    public void actionPerformed(ActionEvent ae) {
        listener.HowToMove = ae.getActionCommand();
        glcanvas.repaint();
    }

}

class ClockDrawGLEventListener implements GLEventListener {

    double[][] rotation_matrix = new double[3][3];
    double[][] LINE = new double[2][3];
    double[][] arrow = new double[4][3];

    String HowToMove = "None";

    final double ONE_DEGREE = (Math.PI / 180);
    final double THREE_SIXTY = 2 * Math.PI;
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
        //set the line matrix
        LINE[0][0] = 0;
        LINE[0][1] = -230;
        LINE[0][2] = 1;

        LINE[1][0] = 0;
        LINE[1][1] = 230;
        LINE[1][2] = 1;

        //set the arrow matrix
        //first we set the last column to 1's
        for (int i = 0; i < arrow.length; i++) {
            arrow[i][2] = 1;
        }
        //then put the vertices
        arrow[0][0] = 0;
        arrow[0][1] = 0;

        arrow[1][0] = 10;
        arrow[1][1] = 30;

        arrow[2][0] = 0;
        arrow[2][1] = 185;

        arrow[3][0] = -10;
        arrow[3][1] = 30;

    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();

        //The lines of the hours
        gl.glColor3f(0.8549f, 0.68627f, 0.10588f);
        gl.glLineWidth(5.0f);
        gl.glBegin(GL.GL_LINES);
        for (int i = 0; i < 6; i++) {
            LINE = rotate(LINE, 30);
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
        if (HowToMove.equals("clockwise")) {
            arrow = rotate(arrow, -6);
        } else if (HowToMove.equals("anti-clockwise")) {
            arrow = rotate(arrow, 6);
        }else if (HowToMove.equals("exit")) {
            System.exit(0);
        }
        
        //the arrow (the pointer)
        gl.glBegin(GL.GL_POLYGON);
        //BOT
        gl.glColor3f(0.0f, 0.8f, 0.0f);
        gl.glVertex2d(arrow[0][0], arrow[0][1]);
        //Right
        gl.glColor3f(0.2f, 0.8f, 0.2f);
        gl.glVertex2d(arrow[1][0], arrow[1][1]);
        //TOP
        gl.glColor3f(0.2f, 0.0f, 0.9f);
        gl.glVertex2d(arrow[2][0], arrow[2][1]);
        //LEFT
        gl.glColor3f(0.2f, 0.8f, 0.2f);
        gl.glVertex2d(arrow[3][0], arrow[3][1]);

        gl.glEnd();
    }

    private double[][] rotate(double[][] LINE, double angle) {
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
        double[][] result = new double[x.length][3];
        for (int i = 0; i < x.length; i++) {
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

