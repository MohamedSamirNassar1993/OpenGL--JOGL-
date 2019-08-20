package KeyListener;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.media.opengl.*;

/**
 * This is a basic JOGL app. Feel free to reuse this code or modify it.
 */
public class KeyMainFrame extends JFrame implements KeyListener {

    KeyJoglApp listener = new KeyJoglApp();
    GLCanvas glcanvas;

    public static void main(String[] args) {

        KeyMainFrame app = new KeyMainFrame();


    }

    public KeyMainFrame() {
        //set the JFrame title
        super("KeyListener Example");


        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //only two JOGL lines of code ... and here they are
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);

        glcanvas.addKeyListener(this);

        glcanvas.setFocusable(true);
        glcanvas.requestFocus();


        //add the GLCanvas just like we would any Component
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);


        //center the JFrame on the screen	
        setLocationRelativeTo(null);

        //Show what we have done
        setVisible(true);
    }

    //////////////////////////////////////////////
    // KeyListener implementation below
    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_8) {
            listener.yPosition += 1;
        } else if (e.getKeyChar() == KeyEvent.VK_2) {
            listener.yPosition -= 1;
        } else if (e.getKeyChar() == KeyEvent.VK_4) {
            listener.xPosition -= 1;
        } else if (e.getKeyChar() == KeyEvent.VK_6) {
            listener.xPosition += 1;
        }

        glcanvas.repaint();
    }
}
