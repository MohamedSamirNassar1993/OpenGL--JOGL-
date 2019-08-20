package MakingaGraph;

import java.awt.*;
import javax.swing.*;
import javax.media.opengl.*;

/**
 * This is a basic JOGL app. Feel free to reuse this code or modify it.
 */
public class OurGraphApp extends JFrame {

    public static void main(String[] args) {
        OurGraphApp app = new OurGraphApp();
    }

    public OurGraphApp() {
        //set the JFrame title
        super("The Cartesian Coordinate System");

        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //only two JOGL lines of code ... and here they are
        GLCanvas glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(new OurGraphGLEventListener());

        //add the GLCanvas just like we would any Component
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);

        //center the JFrame on the screen	
        setLocationRelativeTo(null);

        //Show what we have done
        setVisible(true);
    }

}
