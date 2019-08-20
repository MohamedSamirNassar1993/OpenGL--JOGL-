
//import static GlutObjectsApp.animator;
import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;
import java.awt.event.*;
import java.io.IOException;
import java.io.*;
import javax.media.opengl.*;
import java.util.BitSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Point;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.glu.GLU;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class SubwaySurf extends JFrame implements ActionListener {

    GLCanvas glcanvas;
    SubwaySurfGLEventListener listener;
    AnimGLEventListener2 player;
    public static Animator animator = null;
    ArrayList<String> obj = new ArrayList<String>();
    
    int count = 0;
    int status = 0;
    String score;
    FileInputStream file;
    BufferedInputStream bff;
    private Timer my_timer;
    private long pauselocation;
    private long songlength;
    private String fileloc;
    private long clipTime;
    private Clip clip;
    

    //Menu GUI
    private final JPanel my_main_panel = new JPanel();
    JPanel p = new JPanel();
    JComboBox jComboBox1 = new JComboBox(new String[]{"Help", "Instructions", "Quit"});
    JButton Game = new JButton("Start");
    JButton scores = new JButton("Scores");
    JButton pause = new JButton("Pause");
    JButton sound = new JButton("Mute");
    JTextArea txt = new JTextArea("0");

    public SubwaySurf() {
        listener = new SubwaySurfGLEventListener();
        player = new AnimGLEventListener2();
       
        //Canvas for home page
        glcanvas = new GLCanvas(); 
        glcanvas.addGLEventListener(listener);
        
        //Add action listener for buttons
        jComboBox1.addActionListener(this); 
        Game.addActionListener(this);
        scores.addActionListener(this);
        pause.addActionListener(this);
        sound.addActionListener(this);

        txt.setEditable(false);
        txt.setBackground(Color.LIGHT_GRAY);
        my_main_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 3));
        p.setBackground(Color.WHITE);
         my_main_panel.setBackground(Color.WHITE);
        
        //Add to panel
        my_main_panel.add(txt);
        my_main_panel.add(Game);
        my_main_panel.add(pause);
        my_main_panel.add(sound);
        my_main_panel.add(scores);
        my_main_panel.add(jComboBox1);

        //Add panels to canvas
        p.add(my_main_panel, BorderLayout.CENTER);
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        getContentPane().add(p, BorderLayout.NORTH);
        setIconImage(new ImageIcon(
        "C:\\Users\\Dalia Khaled\\Documents\\NetBeansProjects\\SubwaySurfers\\src\\subwaysurfers\\icon.PNG").getImage());

        setTitle("Subway Surfers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 700);

        setLocationRelativeTo(null);
        setVisible(true);
        setFocusable(true);
        
        animator = new FPSAnimator(50);
        animator.add(glcanvas);
        glcanvas.requestFocus();

        try {
            Play(); //start music
        } catch (UnsupportedAudioFileException ex) {

        }
    }

    // Main Method
    public static void main(String[] args) throws FileNotFoundException {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubwaySurf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        new SubwaySurf();
        animator.start();
    }

    //Buttons Action
    public void actionPerformed(ActionEvent e) {
        // start Game from class AnimGLEventListener2s
        if (e.getSource() == Game) { 
            glcanvas.removeGLEventListener(listener);
            glcanvas.addGLEventListener(player);
            glcanvas.addKeyListener(player);
            getContentPane().add(glcanvas, BorderLayout.CENTER);
            glcanvas.requestFocus();
            setSize(700, 700);
            newGame();
        } else if (e.getSource() == scores) { //get scores
            Scores();
        } else if (e.getSource() == sound) { //control music
            if (status == 0) {
                pause();
                status = 1;
                sound.setText("UnMute");
            } else if (status == 1) {
                resume();
                status = 0;
                sound.setText("Mute");
            }
        } else if (e.getSource() == pause) {
            togglePause();
        } else if (e.getSource() == jComboBox1) {
            if (jComboBox1.getSelectedItem().equals("Help")) {
                JOptionPane.showMessageDialog(null,
                        "Visit our Website for any Information\nSubway Surf version 1.63.1\nsubwaysurfers.com");
            } else if (jComboBox1.getSelectedItem().equals("Instructions")) {
                JOptionPane.showMessageDialog(null,
                        "1.press left or right to change lanes.\n"
                        + "2.press up to run.\n"
                        + "3.press spaceto change jump");
           } else if (jComboBox1.getSelectedItem().equals("Quit")) {
                System.exit(0);
            }

        }

    }

    //new Game
    public void newGame() {
        my_timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //start counter in text field
                count++;
                txt.setText(Integer.toString(count));

            }
        });
        my_timer.start();
    }

    //Pause Game
    private void togglePause() {
        if (my_timer.isRunning()) {
            my_timer.stop();

            JOptionPane.showMessageDialog(null, " Resume ? ");

        }
        my_timer.start();

    }

    // Game Over
    private void GameOver() {
        my_timer.stop();
        JOptionPane.showMessageDialog(null, " You Lose !  ");
        obj.add(txt.getText()); //array containing scores

    }

    //Music
    private void Play() throws UnsupportedAudioFileException {
        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("TW.wav"));

            try {
                clip = AudioSystem.getClip();
                clip.open(inputStream);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);

            } catch (LineUnavailableException ex) {
                Logger.getLogger(SubwaySurf.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException error) {
        }
    }
    
     //resume music
    private void resume() {
        clipTime = clip.getMicrosecondPosition();

        clip.stop();

        clip.setMicrosecondPosition(clipTime);

        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }

    //pause music
    private void pause() { 
        clip.stop();
    }
    
    //display scores each time you lose
    private void Scores() {
        JOptionPane.showMessageDialog(null, " Your Scores:  " + obj); 

    }

}
