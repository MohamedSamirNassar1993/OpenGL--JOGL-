package connect4;


import com.sun.opengl.util.*;
import java.awt.*;
import javax.media.opengl.*;
import javax.swing.*;

public class game extends JFrame {
    
    GLCanvas glcanvas;
    private Listener listener;
    private Animator animator;
     public static JLabel jTextArea;
    
    public game() {
        
        listener = new Listener();
        glcanvas = new GLCanvas();
        listener.pucket = new float[84][3];
        glcanvas.addGLEventListener(listener);
        glcanvas.addMouseListener(listener);
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        animator = new FPSAnimator(16);
        animator.add(glcanvas);
        animator.start();
        setTitle("connect4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setFocusable(true);
        glcanvas.requestFocus();
    }
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        game anim = new game();
        SwingUtilities.invokeLater (
                new Runnable() {
                    public void run() {
                        anim.setVisible(true);
                    }
                }
        );
    } 
}