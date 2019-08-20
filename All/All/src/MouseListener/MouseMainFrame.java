package MouseListener;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.media.opengl.*;

/**
 * This is a basic JOGL app. Feel free to reuse this code or modify it.
 */
public class MouseMainFrame extends JFrame implements MouseListener {

    MouseJoglApp listener = new MouseJoglApp();
    GLCanvas glcanvas;

    public static void main(String[] args) {

        MouseMainFrame app = new MouseMainFrame();


    }

    public MouseMainFrame() {
        //set the JFrame title
        super("MouseListener Example");


        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //only two JOGL lines of code ... and here they are
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addMouseListener(this);


        //add the GLCanvas just like we would any Component
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);


        //center the JFrame on the screen	
        setLocationRelativeTo(null);

        //Show what we have done
        setVisible(true);
    }

    //////////////////////////////////////////////
    // MouseListener implementation below
    public void mouseClicked(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();

        Component c = e.getComponent();

        //getting the size of the GLCanvas
        double width = c.getWidth();
        double height = c.getHeight();

        //get percent of GLCanvas instead of 
        //points and then converting it to our
        //'100' based coordinate system.
        listener.xPosition = (int) ((x / width) * 100);
        listener.yPosition = (int) ((y / height) * 100);

        //reversing direction of y axis
        listener.yPosition = 100 - listener.yPosition;

        glcanvas.repaint();
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }
}
