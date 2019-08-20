/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui3;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.*;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;
import sun.applet.Main;

public class NewJFrame extends javax.swing.JFrame {
public static Mixer mixer;
  //  public static Clip clip;
    
    
  
    public NewJFrame()
    {
       setAlwaysOnTop(true);
        initComponents();
        
        //setLocationRelativeTo(null);       
        setSize(800, 500);
        
        // Mixer.Info[] mixinfo = AudioSystem.getMixerInfo();
       // setAlwaysOnTop(true);
        

      
    }
        

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PlayBtn = new javax.swing.JButton();
        InstructionBtn = new javax.swing.JButton();
        ExitBtn = new javax.swing.JButton();
        PlayBtn1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        PlayBtn.setBackground(new java.awt.Color(0, 153, 255));
        PlayBtn.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14)); // NOI18N
        PlayBtn.setForeground(new java.awt.Color(255, 255, 255));
        PlayBtn.setText("2 Players ");
        PlayBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayBtnActionPerformed(evt);
            }
        });
        getContentPane().add(PlayBtn);
        PlayBtn.setBounds(500, 140, 140, 50);

        InstructionBtn.setBackground(new java.awt.Color(255, 102, 0));
        InstructionBtn.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14)); // NOI18N
        InstructionBtn.setForeground(new java.awt.Color(102, 102, 102));
        InstructionBtn.setText("Instructions");
        InstructionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstructionBtnActionPerformed(evt);
            }
        });
        getContentPane().add(InstructionBtn);
        InstructionBtn.setBounds(310, 240, 140, 50);

        ExitBtn.setBackground(new java.awt.Color(255, 0, 0));
        ExitBtn.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14)); // NOI18N
        ExitBtn.setForeground(new java.awt.Color(102, 102, 102));
        ExitBtn.setText("Exit");
        ExitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitBtnActionPerformed(evt);
            }
        });
        getContentPane().add(ExitBtn);
        ExitBtn.setBounds(310, 370, 140, 50);

        PlayBtn1.setBackground(new java.awt.Color(0, 153, 255));
        PlayBtn1.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14)); // NOI18N
        PlayBtn1.setForeground(new java.awt.Color(255, 255, 255));
        PlayBtn1.setText("1 Player");
        PlayBtn1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PlayBtn1MouseMoved(evt);
            }
        });
        PlayBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayBtn1ActionPerformed(evt);
            }
        });
        getContentPane().add(PlayBtn1);
        PlayBtn1.setBounds(120, 140, 140, 50);

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui3/volume-full-30.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(730, 10, 40, 40);

        jButton2.setBackground(new java.awt.Color(0, 153, 255));
        jButton2.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14)); // NOI18N
        jButton2.setText("Game Styles");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(310, 140, 140, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui3/unnamed.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 780, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitBtnActionPerformed
        
         InputStream in;
        try {
            URL soundURL = Main.class.getResource("/Audio/Air Hockey HD (mp3cut.net).wav");
            in = new FileInputStream(new File(soundURL.toURI()));
            AudioStream audios = new AudioStream(in);
            AudioPlayer.player.start(audios);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        System.exit(0);
    }//GEN-LAST:event_ExitBtnActionPerformed

    
    private void InstructionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstructionBtnActionPerformed
        new Instruction().setVisible(true);
         InputStream in;
        try {
            URL soundURL = Main.class.getResource("/Audio/Air Hockey HD (mp3cut.net).wav");
            in = new FileInputStream(new File(soundURL.toURI()));
            AudioStream audios = new AudioStream(in);
            AudioPlayer.player.start(audios);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        this.dispose();
    }//GEN-LAST:event_InstructionBtnActionPerformed

    private void PlayBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayBtnActionPerformed
     new player2().setVisible(true);

 InputStream in;
        try {
            URL soundURL = Main.class.getResource("/Audio/Air Hockey HD (mp3cut.net).wav");
            in = new FileInputStream(new File(soundURL.toURI()));
            AudioStream audios = new AudioStream(in);
            AudioPlayer.player.start(audios);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        this.dispose();
    }//GEN-LAST:event_PlayBtnActionPerformed

    private void PlayBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayBtn1ActionPerformed
        new player1().setVisible(true);
        InputStream in;
        
        try {
            URL soundURL = Main.class.getResource("/Audio/Air Hockey HD (mp3cut.net).wav");
            in = new FileInputStream(new File(soundURL.toURI()));
            AudioStream audios = new AudioStream(in);
            AudioPlayer.player.start(audios);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        this.dispose();
    }//GEN-LAST:event_PlayBtn1ActionPerformed

    private void PlayBtn1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayBtn1MouseMoved

    }//GEN-LAST:event_PlayBtn1MouseMoved

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   //  AudioPlayer.player.stop(audioStream);
         if(Gui2.clip.isRunning())
         {
             Gui2.clip.stop();
         }
         else 
         {
             Gui2.clip.start();
         }
                                            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new level().setVisible(true);
        InputStream in;
    
        try {
            URL soundURL = Main.class.getResource("/Audio/Air Hockey HD (mp3cut.net).wav");
            in = new FileInputStream(new File(soundURL.toURI()));
            AudioStream audios = new AudioStream(in);
            AudioPlayer.player.start(audios);
        }
        catch (Exception ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
      
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
       
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExitBtn;
    private javax.swing.JButton InstructionBtn;
    private javax.swing.JButton PlayBtn;
    private javax.swing.JButton PlayBtn1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
