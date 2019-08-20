
package gui3;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;

import sun.applet.Main;
import sun.audio.AudioPlayer;
public class Gui2   {
 
    
    public static AudioInputStream audioStream;
    public static String selected;
//    static Mixer.Info[] mixinfo = AudioSystem.getMixerInfo();
//    
    //  mixer = AudioSystem.getMixer(mixinfo[0]);
//     static DataLine.Info datainfo = new DataLine.Info(Clip.class,null);
//     public static Mixer mixer= AudioSystem.getMixer(mixinfo[0]);
    public static Clip clip;
    public static void main(String[] args){
        NewJFrame j = new NewJFrame();
        j.setVisible(true);
        
      Mixer.Info[] mixinfo = AudioSystem.getMixerInfo();
    
       Mixer mixer= AudioSystem.getMixer(mixinfo[0]);
      DataLine.Info datainfo = new DataLine.Info(Clip.class,null);
      try { clip = (Clip) mixer.getLine(datainfo);
      } 
      catch (LineUnavailableException ex) {
           
        }
      try {
       URL soundURL = Main.class.getResource("/Audio/Funny_Background_Music_For_Videos_-_Instrumental_F.wav");
      // URL url = new URL ( "https://freewavesamples.com/alesis-fusion-fretless-bass-c3");
      AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
      clip.open(audioStream);
      } catch (IOException ex) {
            
        } catch (LineUnavailableException ex) {
            
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Gui2.class.getName()).log(Level.SEVERE, null, ex);
        }
     // AudioPlayer.player.start();
      clip.start();
     // AudioPlayer.player.start(audioStream);
      clip.loop(Clip.LOOP_CONTINUOUSLY);
      do
      {
          try { Thread.sleep(50);} catch (InterruptedException ex) {
              
        }
      }while(clip.isActive());
    }
    //C:\Users\Boody\Documents\NetBeansProjects\gui2\src\gui2\Funny_Background_Music_For_Videos_-_Instrumental_F.wav
}
