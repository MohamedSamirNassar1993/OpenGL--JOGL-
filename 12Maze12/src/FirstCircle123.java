
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.media.opengl.*;
//import net.java.games.jogl.*;

/**
 * This is a basic JOGL app. Feel free to reuse this code or modify it.
 */
public class FirstCircle123 extends JFrame implements KeyListener {

    GLCanvas glcanvas;
    FirstCircleEventListener123 listner = new FirstCircleEventListener123();

    public static void main(String[] args) {
        final FirstCircle123 app = new FirstCircle123();
        JOptionPane.showMessageDialog(null, "Under leadership of \nProfessor: Mohammed El-Gayar \n& Professor:Hend Dawood");
        JOptionPane.showMessageDialog(null, "How to play ;)  \n use arrow up , down , left and right\n to move and reach to final destination\n any errors call me \n G.M. MYehia:01113649361 \n& his parteners...");
//        JOptionPane.showMessageDialog(null, "Choose Level");
        JOptionPane.showMessageDialog(null, "Let's play");
                

// show what we've done
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        app.setVisible(true);
                    }
                }
        );
    }

    public FirstCircle123() {
//set the JFrame title
        super("First Circle Using Sine and Cosine");

//kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//only three JOGL lines of code ... and here they are
        GLCapabilities glcaps2 = new GLCapabilities();
        glcanvas = new GLCanvas(glcaps2);//GLDrawableFactory.getFactory().createGLCanvas(glcaps);
        glcanvas.addGLEventListener(
                listner
        );
        glcanvas.addKeyListener(this);
//add the GLCanvas just like we would any Component
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);
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
    public void keyTyped(KeyEvent ke) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
//            listner.px += 10;
//            glcanvas.repaint();
//
//        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            switch (ke.getKeyCode()) {
                case KeyEvent.VK_DOWN:
                    listner.buffer_py -= 8;
                    //listner.py -= 10;
                    glcanvas.repaint();
                    break;
                case KeyEvent.VK_UP:
                    listner.buffer_py += 8;
                    //listner.py += 10;
                    glcanvas.repaint();
                    break;
                case KeyEvent.VK_RIGHT:
                    listner.buffer_px += 8;
                    //listner.px += 10;
                    glcanvas.repaint();
                    break;
                case KeyEvent.VK_LEFT:
                    listner.buffer_px -= 8;
                    //listner.px -= 10;
                    glcanvas.repaint();
                    break;

            }
        }// end switch    
        catch (Exception ee) {
            JOptionPane.showMessageDialog(null, "Error: " + ee.getMessage());
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class FirstCircleEventListener123 implements GLEventListener {

    int maze_level = 2;

    private int n;                 // dimension of maze
    // is there a wall to north of cell i, j
    private boolean[][] north = {{
        true, true, true, true, true, true, true, true, true, true, true, true},
    {
        true, true, false, false, true, false, false, true, false, false, true, true},
    {
        true, true, false, true, true, false, false, false, true, false, true, true},
    {
        true, false, false, true, false, false, false, false, false, true, true, true},
    {
        true, false, false, false, false, true, false, false, false, true, true, true},
    {
        true, false, false, false, true, false, false, true, true, false, true, true},
    {
        true, false, true, false, true, false, true, false, true, false, true, true},
    {
        true, false, true, true, false, true, false, true, false, false, true, true},
    {
        true, false, true, true, true, false, false, false, true, false, true, true},
    {
        true, false, true, false, true, true, false, false, false, false, true, true},
    {
        true, false, false, false, false, false, false, false, false, true, true, true},
    {
        true, true, true, true, true, true, true, true, true, true, true, true}};
    private boolean[][] east = {{
        true, true, true, true, true, true, true, true, true, true, true, true},
    {
        true, false, false, true, false, false, true, true, false, true, false, true},
    {
        true, false, true, false, false, true, true, true, true, false, false, true},
    {
        true, true, true, true, true, true, true, true, true, true, false, true},
    {
        true, true, true, true, true, false, false, true, false, true, false, true},
    {
        true, false, true, true, false, true, true, true, false, false, true, true},
    {
        true, true, false, false, true, false, false, false, true, true, false, true},
    {
        true, false, true, false, false, true, true, true, false, true, true, true},
    {
        true, true, false, false, false, false, true, true, true, true, false, true},
    {
        true, false, true, true, true, false, true, true, true, false, false, true},
    {
        true, true, true, true, true, true, true, true, true, true, true, true},
    {
        true, true, true, true, true, true, true, true, true, true, true, true},};
    private boolean[][] south = {{
        true, true, true, true, true, true, true, true, true, true, true, true},
    {
        true, true, true, false, false, true, false, false, true, false, false, true},
    {
        true, true, true, false, true, true, false, false, false, true, false, true},
    {
        true, true, false, false, true, false, false, false, false, false, true, true},
    {
        true, true, false, false, false, false, true, false, false, false, true, true},
    {
        true, true, false, false, false, true, false, false, true, true, false, true},
    {
        true, true, false, true, false, true, false, true, false, true, false, true},
    {
        true, true, false, true, true, false, true, false, true, false, false, true},
    {
        true, true, false, true, true, true, false, false, false, true, false, true},
    {
        true, true, false, true, false, true, true, false, false, false, false, true},
    {
        true, true, false, false, false, false, false, false, false, false, true, true},
    {
        true, true, true, true, true, true, true, true, true, true, true, true},};
    private boolean[][] west = {{
        true, true, true, true, true, true, true, true, true, true, true, true},
    {
        true, true, true, true, true, true, true, true, true, true, true, true},
    {
        true, false, false, true, false, false, true, true, false, true, false, true},
    {
        true, false, true, false, false, true, true, true, true, false, false, true},
    {
        true, true, true, true, true, true, true, true, true, true, false, true},
    {
        true, true, true, true, true, false, false, true, false, true, false, true},
    {
        true, false, true, true, false, true, true, true, false, false, true, true},
    {
        true, true, false, false, true, false, false, false, true, true, false, true},
    {
        true, false, true, false, false, true, true, true, false, true, true, true},
    {
        true, true, false, false, false, false, true, true, true, true, false, true},
    {
        true, false, true, true, true, false, true, true, true, false, false, true},
    {
        true, true, true, true, true, true, true, true, true, true, true, true},};

    private boolean[][] visited = {
        {
            true, true, true, true, true, true, true, true, true, true, true, true},
        {
            true, true, true, true, true, true, true, true, true, true, true, true},
        {
            true, true, true, true, true, true, true, true, true, true, true, true},
        {
            true, true, true, true, true, true, true, true, true, true, true, true},
        {
            true, true, true, true, true, true, true, true, true, true, true, true},
        {
            true, true, true, true, true, true, true, true, true, true, true, true},
        {
            true, true, true, true, true, true, true, true, true, true, true, true},
        {
            true, true, true, true, true, true, true, true, true, true, true, true},
        {
            true, true, true, true, true, true, true, true, true, true, true, true},
        {
            true, true, true, true, true, true, true, true, true, true, true, true},
        {
            true, true, true, true, true, true, true, true, true, true, true, true},
        {
            true, true, true, true, true, true, true, true, true, true, true, true},};
    double[][] Allowed_points = {
        {-162.0, 112.0}, {-162.0, 104.0}, {-162.0, 96.0}, {-162.0, 88.0}, {-162.0, 80.0}, {-162.0, 72.0}, {-162.0, 64.0}, {-154.0, 64.0}, {-146.0, 64.0}, {-138.0, 64.0}, {-130.0, 64.0}, {-130.0, 56.0}, {-130.0, 48.0}, {-130.0, 40.0}, {-130.0, 32.0}, {-130.0, 24.0}, {-130.0, 16.0}, {-130.0, 8.0}, {-130.0, 0.0}, {-130.0, -8.0}, {-130.0, -16.0}, {-138.0, -16.0}, {-146.0, -16.0}, {-154.0, -16.0}, {-154.0, -8.0}, {-154.0, 0.0}, {-154.0, 8.0}, {-154.0, 16.0}, {-154.0, 24.0}, {-154.0, 32.0}, {-154.0, 40.0}, {-162.0, 40.0}, {-162.0, 32.0}, {-162.0, 24.0}, {-162.0, 16.0}, {-162.0, 8.0}, {-162.0, 0.0}, {-162.0, -8.0}, {-162.0, -16.0}, {-154.0, -16.0}, {-146.0, -16.0}, {-138.0, -16.0}, {-130.0, -16.0}, {-122.0, -16.0}, {-114.0, -16.0}, {-114.0, -8.0}, {-114.0, 0.0}, {-114.0, 8.0}, {-114.0, 16.0}, {-114.0, 24.0}, {-114.0, 32.0}, {-114.0, 40.0}, {-114.0, 48.0}, {-114.0, 56.0}, {-114.0, 64.0}, {-122.0, 64.0}, {-130.0, 64.0}, {-138.0, 64.0}, {-146.0, 64.0}, {-154.0, 112.0}, {-146.0, 112.0}, {-138.0, 112.0}, {-130.0, 112.0}, {-122.0, 112.0}, {-122.0, 104.0}, {-122.0, 96.0}, {-122.0, 88.0}, {-114.0, 88.0}, {-106.0, 88.0}, {-98.0, 88.0}, {-90.0, 88.0}, {-90.0, 80.0}, {-90.0, 72.0}, {-90.0, 64.0}, {-90.0, 56.0}, {-90.0, 48.0}, {-90.0, 40.0}, {-90.0, 32.0}, {-90.0, 24.0}, {-90.0, 16.0}, {-90.0, 8.0}, {-90.0, 0.0}, {-90.0, -8.0}, {-90.0, -16.0}, {-90.0, -24.0}, {-90.0, -32.0}, {-90.0, -40.0}, {-98.0, -40.0}, {-106.0, -40.0}, {-114.0, -40.0}, {-122.0, -40.0}, {-130.0, -40.0}, {-138.0, -40.0}, {-146.0, -40.0}, {-154.0, -40.0}, {-154.0, -48.0}, {-154.0, -56.0}, {-154.0, -64.0}, {-154.0, -72.0}, {-154.0, -80.0}, {-154.0, -88.0}, {-146.0, -88.0}, {-138.0, -88.0}, {-130.0, -88.0}, {-130.0, -80.0}, {-130.0, -72.0}, {-130.0, -64.0}, {-130.0, -56.0}, {-130.0, -64.0}, {-122.0, -64.0}, {-114.0, -64.0}, {-106.0, -64.0}, {-98.0, -64.0}, {-90.0, -64.0}, {-90.0, -72.0}, {-90.0, -80.0}, {-90.0, -88.0}, {-90.0, -96.0}, {-90.0, -104.0}, {-90.0, -112.0}, {-98.0, -112.0}, {-106.0, -112.0}, {-114.0, -112.0}, {-122.0, -112.0}, {-130.0, -112.0}, {-138.0, -112.0}, {-146.0, -112.0}, {-154.0, -112.0}, {-162.0, -112.0},
        {-114.0, 112.0}, {-106.0, 112.0}, {-98.0, 112.0}, {-90.0, 112.0}, {-82.0, 112.0}, {-74.0, 112.0}, {-66.0, 112.0}, {-58.0, 112.0}, {-50.0, 112.0}, {-42.0, 112.0}, {-34.0, 112.0}, {-26.0, 112.0}, {-18.0, 112.0}, {-18.0, 104.0}, {-18.0, 96.0}, {-18.0, 88.0}, {-10.0, 88.0}, {-2.0, 88.0}, {6.0, 88.0}, {14.0, 88.0}, {14.0, 96.0}, {14.0, 104.0}, {14.0, 112.0}, {22.0, 112.0}, {30.0, 112.0}, {38.0, 112.0}, {46.0, 112.0}, {54.0, 112.0}, {54.0, 104.0}, {54.0, 96.0}, {54.0, 88.0}, {54.0, 80.0}, {54.0, 72.0}, {54.0, 64.0}, {62.0, 64.0}, {70.0, 64.0}, {78.0, 64.0}, {86.0, 64.0}, {86.0, 56.0}, {86.0, 48.0}, {86.0, 40.0}, {86.0, 32.0}, {86.0, 24.0}, {86.0, 16.0}, {86.0, 8.0}, {86.0, 0.0}, {86.0, -8.0}, {86.0, -16.0}, {94.0, -16.0}, {102.0, -16.0}, {110.0, -16.0}, {118.0, -16.0}, {126.0, -16.0}, {134.0, -16.0}, {142.0, -16.0}, {150.0, -16.0}, {158.0, -16.0}, {158.0, -8.0}, {158.0, 0.0}, {158.0, 8.0}, {158.0, 16.0}, {158.0, 24.0}, {158.0, 32.0}, {158.0, 40.0}, {158.0, 48.0}, {158.0, 56.0}, {158.0, 64.0}, {158.0, 72.0}, {158.0, 80.0}, {158.0, 88.0}, {150.0, 88.0}, {142.0, 88.0}, {134.0, 88.0}, {126.0, 88.0}, {118.0, 88.0}, {118.0, 96.0}, {118.0, 104.0}, {118.0, 112.0}, {126.0, 112.0}, {134.0, 112.0}, {142.0, 112.0}, {150.0, 112.0}, {158.0, 112.0}, {166.0, 112.0}, {158.0, 112.0}, {150.0, 112.0}, {142.0, 112.0}, {134.0, 112.0}, {126.0, 112.0}, {118.0, 112.0}, {110.0, 112.0}, {102.0, 112.0}, {94.0, 112.0}, {86.0, 112.0}, {86.0, 104.0}, {86.0, 96.0}, {86.0, 88.0},
        {150.0, -16.0}, {158.0, -16.0}, {166.0, -16.0}, {166.0, -24.0}, {158.0, -24.0}, {150.0, -24.0}, {150.0, -32.0}, {158.0, -32.0}, {166.0, -32.0}, {166.0, -40.0}, {158.0, -40.0}, {150.0, -40.0}, {150.0, -48.0}, {158.0, -48.0}, {166.0, -48.0}, {166.0, -56.0}, {158.0, -56.0}, {150.0, -56.0}, {150.0, -64.0}, {158.0, -64.0}, {166.0, -64.0}, {166.0, -72.0}, {158.0, -72.0}, {150.0, -72.0}, {150.0, -80.0}, {158.0, -80.0}, {166.0, -80.0}, {166.0, -88.0}, {158.0, -88.0}, {150.0, -88.0}, {150.0, -96.0}, {158.0, -96.0}, {166.0, -96.0}, {166.0, -104.0}, {158.0, -104.0}, {150.0, -104.0}, {150.0, -112.0}, {158.0, -112.0}, {166.0, -112.0}, {158.0, -112.0}, {150.0, -112.0}, {142.0, -112.0}, {134.0, -112.0}, {126.0, -112.0}, {126.0, -104.0}, {126.0, -96.0}, {126.0, -88.0}, {118.0, -88.0}, {110.0, -88.0}, {102.0, -88.0}, {94.0, -88.0}, {86.0, -88.0}, {78.0, -88.0}, {86.0, -88.0}, {86.0, -96.0}, {86.0, -104.0}, {86.0, -112.0}, {78.0, -112.0}, {70.0, -112.0}, {62.0, -112.0}, {54.0, -112.0}, {54.0, -104.0}, {54.0, -96.0}, {54.0, -88.0}, {46.0, -88.0}, {38.0, -88.0}, {30.0, -88.0}, {22.0, -88.0}, {14.0, -88.0}, {14.0, -96.0}, {14.0, -104.0}, {14.0, -112.0}, {6.0, -112.0}, {-2.0, -112.0}, {-10.0, -112.0}, {-18.0, -112.0}, {-18.0, -104.0}, {-18.0, -96.0}, {-18.0, -88.0}, {-18.0, -80.0}, {-18.0, -72.0}, {-18.0, -64.0}, {-18.0, -56.0}, {-18.0, -48.0}, {-18.0, -40.0}, {-10.0, -40.0}, {-18.0, -56.0}, {-18.0, -48.0}, {-18.0, -40.0}, {-10.0, -40.0}, {-2.0, -40.0}, {6.0, -40.0}, {14.0, -40.0}, {14.0, -48.0}, {14.0, -56.0}, {14.0, -64.0}, {22.0, -64.0}, {30.0, -64.0}, {38.0, -64.0}, {46.0, -64.0}, {54.0, -64.0}, {62.0, -64.0}, {70.0, -64.0}, {78.0, -64.0}, {86.0, -64.0}, {94.0, -64.0}, {102.0, -64.0}, {110.0, -64.0}, {118.0, -64.0}, {126.0, -64.0}, {126.0, -56.0}, {126.0, -48.0}, {126.0, -40.0}, {118.0, -40.0}, {110.0, -40.0}, {102.0, -40.0}, {94.0, -40.0}, {86.0, -40.0}, {78.0, -40.0}, {70.0, -40.0}, {62.0, -40.0}, {54.0, -40.0}, {54.0, -32.0}, {54.0, -24.0}, {54.0, -16.0}, {54.0, -8.0}, {46.0, -8.0}, {38.0, -8.0}, {30.0, -8.0}, {54.0, -16.0}, {46.0, -16.0}, {38.0, -16.0}, {30.0, -16.0}, {22.0, -16.0}, {14.0, -16.0}, {14.0, -8.0}, {14.0, 0.0}, {14.0, 8.0}, {14.0, 16.0}, {22.0, 16.0}, {30.0, 16.0}, {38.0, 16.0}, {46.0, 16.0}, {54.0, 16.0}, {54.0, 24.0}, {54.0, 32.0}, {54.0, 40.0}, {46.0, 40.0}, {38.0, 40.0}, {30.0, 40.0}, {22.0, 40.0}, {14.0, 40.0}, {14.0, 48.0}, {14.0, 56.0}, {14.0, 64.0}, {6.0, 64.0}, {-2.0, 64.0}, {-10.0, 64.0}, {-18.0, 64.0}, {-26.0, 64.0}, {-34.0, 64.0}, {-42.0, 64.0}, {-50.0, 64.0}, {-50.0, 72.0}, {-50.0, 80.0}, {-50.0, 88.0}, {-50.0, 80.0}, {-50.0, 72.0}, {-50.0, 64.0}, {-50.0, 56.0}, {-50.0, 48.0}, {-50.0, 40.0}, {-50.0, 32.0}, {-50.0, 24.0}, {-50.0, 16.0}, {-42.0, 16.0}, {-42.0, 8.0}, {-34.0, 8.0}, {-26.0, 8.0}, {-18.0, 8.0}, {-18.0, 16.0}, {-18.0, 24.0}, {-18.0, 32.0}, {-18.0, 40.0}, {-18.0, 32.0}, {-18.0, 24.0}, {-18.0, 16.0}, {-18.0, 8.0}, {-18.0, 0.0}, {-18.0, -8.0}, {-18.0, -16.0}, {-26.0, -16.0}, {-34.0, -16.0}, {-42.0, -16.0}, {-50.0, -16.0}, {-50.0, -24.0}, {-50.0, -32.0}, {-50.0, -40.0}, {-50.0, -48.0}, {-50.0, -56.0}, {-50.0, -64.0}, {-50.0, -72.0}, {-50.0, -80.0}, {-50.0, -88.0}, {-50.0, -96.0}, {-50.0, -104.0}, {-50.0, -112.0}
    };

    double px = -162, py = 112;
    double buffer_px = px;
    double buffer_py = py;
    final double ONE_DEGREE = (Math.PI / 180);
    final double THREE_SIXTY = 2 * Math.PI;

    public void maze(int n) {
        this.n = n;
        // init_maze();
        //generate();
    }

    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        GL glu = gld.getGL();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glViewport(0, 0, 500, 300);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.glOrtho(-250.0, 250.0, -150.0, 150.0, -1, 1);
        maze(10);

    }

    public void display(GLAutoDrawable drawable) {
        float red = 0.5f;
        float green = 0.0f;
        float blue = 0.5f;
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glColor3f(red, green, blue);

        gl.glPushMatrix();
        gl.glScaled(35, 25, 0);
        gl.glTranslated(-6, -6, 0);
        gl.glBegin(GL.GL_LINES);
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                if (south[x][y]) {
                    gl.glVertex2d((x), (y));
                    gl.glVertex2d((x + 1), (y));
//                    arr[ref][0] = (50*x)+3 ;
//                    arr[ref][1] = (40*y)+3;
//                    ref++;
//                    arr[ref][0] = 50*(x+1)+3;
//                    arr[ref][1] = 40*y+3;
//                    ref++;

                }
                if (north[x][y]) {
                    gl.glVertex2d((x), (y + 1));
                    gl.glVertex2d((x + 1), (y + 1));
//
//                    arr[ref][0] = (50*x)+3 ;
//                    arr[ref][1] = (40*(y+1))+3;
//                    ref++;
//                    arr[ref][0] = 50*(x+1)+3;
//                    arr[ref][1] = 40*(y+1)+3;
//                    ref++;

                }
                if (west[x][y]) {
                    gl.glVertex2d((x), (y));
                    gl.glVertex2d((x), (y + 1));
//
//                    arr[ref][0] = (50*x)+3 ;
//                    arr[ref][1] = (40*y)+3;
//                    ref++;
//                    arr[ref][0] = 50*(x)+3;
//                    arr[ref][1] = 40*(y+1)+3;
//                    ref++;
                }
                if (east[x][y]) {
                    gl.glVertex2d((x + 1), (y));
                    gl.glVertex2d((x + 1), (y + 1));

                }
            }
        }
        gl.glEnd();
        gl.glPopMatrix();
//////////////////////////////// circle /////////////////
//
//        gl.glPointSize(13.0f);

        int honka = 0;
//         red = 0.5f;
//         green = 0.0f;
//         blue = 0.5f;
        gl.glColor3f(.9f, .9f, .3f);
        for (int i = 0; i < Allowed_points.length; i++) {
            if (buffer_px == Allowed_points[i][0] && buffer_py == Allowed_points[i][1]) {
//                buffer_px = px;
//                buffer_py = py;
                honka = 1;
            }
        }
        if (honka == 1) {
            //System.out.println("honka = 1");
            gl.glPushMatrix();
            px = buffer_px;
            py = buffer_py;

//            System.out.println(" { " + px + "," + py + "},");
            gl.glTranslated(px, py, 0);
            //        gl.glBegin(GL.GL_POINTS);

            double x, y;
            double radius = 10;
            gl.glBegin(GL.GL_POLYGON);
            for (double a = 0; a < THREE_SIXTY; a += ONE_DEGREE) {
                x = radius * (Math.cos(a));
                y = radius * (Math.sin(a));
                gl.glVertex2d(x, y);
            }
            gl.glEnd();
            gl.glPopMatrix();

        } else {

            //System.out.println("honka = 0");
            gl.glPushMatrix();
            buffer_px = px;
            buffer_py = py;

//            System.out.println(" { " + px + "," + py + "},");
            gl.glTranslated(px, py, 0);
            //        gl.glBegin(GL.GL_POINTS);
            double x, y;
            double radius = 10;
            gl.glBegin(GL.GL_POLYGON);
            for (double a = 0; a < THREE_SIXTY; a += ONE_DEGREE) {
                x = radius * (Math.cos(a));
                y = radius * (Math.sin(a));
                gl.glVertex2d(x, y);
            }
            gl.glEnd();
            gl.glPopMatrix();

        }
        honka = 1;
        gl.glPushMatrix();
        gl.glTranslated(165, -113, 0);
        gl.glColor3f(red, green, blue);
        double x2, y2;
        double radius1 = 18;
//        gl.glBegin(GL.GL_LINE_STRIP);
         gl.glBegin(GL.GL_POLYGON);
        for (double a = 0; a < THREE_SIXTY; a += ONE_DEGREE) {
            x2 = radius1 * (Math.cos(a));
            y2 = radius1 * (Math.sin(a));
            gl.glVertex2d(x2, y2);
        }
        gl.glEnd();
        gl.glPopMatrix();

            if (px == 166 && py == -112) {
                JOptionPane.showMessageDialog(null, "Good Job ;)");
                
            }
        
    }// end display method

    public void reshape(
            GLDrawable drawable,
            int x,
            int y,
            int width,
            int height
    ) {
    }

    public void displayChanged(
            GLDrawable drawable,
            boolean modeChanged,
            boolean deviceChanged
    ) {
    }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
    }

    @Override
    public void displayChanged(GLAutoDrawable glad, boolean bln, boolean bln1) {
    }
}