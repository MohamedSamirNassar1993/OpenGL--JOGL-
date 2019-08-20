package connect4;
import com.sun.opengl.util.GLUT;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.BitSet;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class Listener  extends javax.swing.JFrame implements GLEventListener, MouseListener {
  GLCanvas glc;

    public void setGLCanvas(GLCanvas glc) {
        this.glc = glc;
    }
 Board b; int k = 52;
 javax.swing.JButton score = new javax.swing.JButton();
 Connect4AI ai; long msl;
 public static int game,oldGame,newGame;
 int frame = 1;int index = 0;int i = 13;int j = 26;
 float xc,yc;
 boolean mummyTurn, playDone,falling,up,cake,myTurn;
 int mummyPlay,myPlay,play,player,counter,cnt,count,myScore,mummyScore,temp;
 int[] empty = new int[7];
 float [][] pucket = new float[84][3];
 private static int  maxWidth = 100, maxHeight = 100, x = maxWidth/2, y = 50;
    
    String path = "connect4/";
    String textureNames[] = {path+"background.png",path+"play.png",path+"how.png",path+"exit.png",path+"col1.png",path+"col2.png",path+"board.png",path+"body.png",path+"s1.png",path+"s2.png",path+"s3.png",path+"s4.png",path+"play_frame.png"
    ,path+"left_1.png",path+"left_2.png",path+"left_3.png",path+"left_4.png",path+"left_5.png",path+"left_6.png",path+"left_7.png",path+"left_8.png",path+"left_8.5.png",path+"left_9.png",path+"left_10.png",path+"left_11.png"
    ,path+"left_12.png",path+"right_1.png",path+"right_2.png",path+"right_3.png",path+"right_4.png",path+"right_5.png",path+"right_6.png",path+"right_7.png",path+"right_8.png",path+"right_8.5.png",path+"right_9.png",path+"right_10.png",path+"right_11.png"
    ,path+"player_1.png",path+"player_2.png",path+"home.png",path+"playl.png",path+"backl.png",path+"exitl.png",path+"got itl.png",path+"howl.png",path+"multiplayerl.png",path+"mummyl.png"
    ,path+"board2.png",path+"draw.jpg",path+"win.jpg",path+"lose.jpg",path+"a1.png",path+"a2.png",path+"a3.png",path+"a4.png",path+"a3.png",path+"a2.png"
    };
    TextureReader.Texture texture[] = new TextureReader.Texture[textureNames.length];
    int textures[] = new int[textureNames.length];

    public void init(GLAutoDrawable gld) {
          play("src\\connect4\\1.wav",0);

          GL gl = gld.getGL();
          gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);  
        
          gl.glEnable(GL.GL_TEXTURE_2D); 
          gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);	
          gl.glGenTextures(textureNames.length, textures, 0);
        
            for(int i = 0; i < textureNames.length; i++){
              try {
                texture[i] = TextureReader.readTexture( textureNames[i] , true);
                gl.glBindTexture(GL.GL_TEXTURE_2D, textures[i]);

                new GLU().gluBuild2DMipmaps(
                    GL.GL_TEXTURE_2D,
                    GL.GL_RGBA, 
                    texture[i].getWidth(), texture[i].getHeight(),
                    GL.GL_RGBA, 
                    GL.GL_UNSIGNED_BYTE,
                    texture[i].getPixels()
                    );
                   } catch( IOException e ) {
                  System.out.println(e);
                   e.printStackTrace();
                  }
                  }
    }

    
    public void display(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        gl.glLoadIdentity(); 
        final GLUT glut = new GLUT();
        
     if(game==0){
        DrawBackground(gl, 0);
        DrawBackground(gl, 40);
    }    
    else if(game == 6){
        DrawBackground(gl, 12);
        DrawBackground(gl, 42);
        msl--;
    if(msl <= 0){
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        DrawBackground(gl, 0);
        DrawBackground(gl, 40);     
    }
    }else if(game==98){
        DrawBackground(gl, 0);
        DrawBackground(gl, 40); 
        DrawBackground(gl, 43);
        msl--;
    if(msl <= 0){
    gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        DrawBackground(gl, 0);
        DrawBackground(gl, 40);  
    }
    }
    else if (game==1){
       DrawBackground(gl, 45);
       msl--;
    if(msl <= 0){
       gl.glClear(GL.GL_COLOR_BUFFER_BIT);
       DrawBackground(gl, 0);
       DrawBackground(gl, 8);
   }
   }
   else if(game == 5){
      DrawBackground(gl, 12);
      DrawBackground(gl, 46); 
      msl--;
      if(msl <= 0){
      gl.glClear(GL.GL_COLOR_BUFFER_BIT);
      DrawBackground(gl, 12);     
   }
   }
   else if(game==7){
     DrawBackground(gl, 0);
     DrawBackground(gl, 9);     
     DrawBackground(gl, 44);
     msl--;
   if(msl <= 0){
    gl.glClear(GL.GL_COLOR_BUFFER_BIT);  
    DrawBackground(gl, 0);
    DrawBackground(gl, 9);
  }
  }
   else if(game==8){
     DrawBackground(gl, 0);
     DrawBackground(gl,10);
     DrawBackground(gl, 44);
     msl--;
   if(msl <= 0){
     gl.glClear(GL.GL_COLOR_BUFFER_BIT);  
     DrawBackground(gl, 0);
     DrawBackground(gl,10);
 }
 }
  else if(game==9){
      DrawBackground(gl, 0);
      DrawBackground(gl, 11);
      DrawBackground(gl, 44);
     msl--;
  if(msl <= 0){
      gl.glClear(GL.GL_COLOR_BUFFER_BIT);  
      DrawBackground(gl, 0);
      DrawBackground(gl, 11);
   }
   }
   else if(game == 10){
      DrawBackground(gl, 0);
      DrawBackground(gl, 11); 
      DrawBackground(gl, 44);
      msl--;
   if(msl <= 0){
      gl.glClear(GL.GL_COLOR_BUFFER_BIT);  
      DrawBackground(gl, 0);
      DrawBackground(gl, 40);
   }
   }
   else if(game==2 ){
      DrawBackground(gl, 41);
      msl--;
   if(msl <= 0){
      gl.glClear(GL.GL_COLOR_BUFFER_BIT);    
      DrawBackground(gl, 12);
    }
    }
    else if(game == 31){     
      gl.glClear(GL.GL_COLOR_BUFFER_BIT);
      DrawBackground(gl, 49);
    //show mummyScore and muScore
    gl.glRasterPos2i((int)(30/(maxWidth/2.0) ),(int)(80/(maxHeight/2.0) - 0.9));
  glut.glutBitmapString( 5, String.valueOf(mummyScore)+"                                   "+String.valueOf(myScore));   
 }
 else if(game == 32){
    //show mummyScore and muScore
    gl.glClear(GL.GL_COLOR_BUFFER_BIT);    
    DrawBackground(gl, 51);
   gl.glRasterPos2i((int)(30/(maxWidth/2.0) ),(int)(80/(maxHeight/2.0) - 0.9));
  glut.glutBitmapString( 5, String.valueOf(mummyScore)+"                                   "+String.valueOf(myScore));       
  if(k > 56)
      k = 52;
  else
      k++;     
  
  DrawSprite3(gl,8,30,k,8f);
  DrawSprite3(gl,80,30,k,8f);
 }
 else if(game == 33){
    gl.glClear(GL.GL_COLOR_BUFFER_BIT);    
    DrawBackground(gl, 50);
    //show mummyScore and muScore
    gl.glRasterPos2i((int)(30/(maxWidth/2.0) ),(int)(80/(maxHeight/2.0) - 0.9));
  glut.glutBitmapString( 5, String.valueOf(mummyScore)+"                                    "+String.valueOf(myScore));   
 }
 else if(game==4){
     DrawBackground(gl, 0); 
     DrawSprite5(gl,46.8f,45.2f,7, 1.73f);
   if(mummyTurn){
   if(mummyPlay >= 4){
        if(playDone)
            if (i > 13)i--;
            else {
                playDone = false;
                mummyTurn = false;
            }   
        else{ 
            if (i < 21+(7-mummyPlay)+1) i++;
            else 
                playDone = true;
        }
                
    }
    else {
        if(playDone) 
            if (j > 26)j--;
           else {
                playDone = false;
                mummyTurn = false;
            }   
        else 
            if (j < 35+(mummyPlay-1)) j++;
            else playDone = true;
        
    }    
}
else {
    i = 13;
    j = 26;
    
}
DrawSprite5(gl,46.8f,45.2f,i, 1.73f);
DrawSprite5(gl,46.8f,45.2f,j, 1.73f);
DrawSprite5(gl,46.8f,44.8f,48, 1.72f);

if(j == 35+(mummyPlay-1) || i == 21+(7-mummyPlay)+1){
        falling = true;
        xc = (float)(29.5+((mummyPlay-1)*5.5));
        yc = 71.3f;
        DrawSprite6(gl,(float)xc,(float)yc,39,.11f);
        cnt = empty[mummyPlay-1]*2-1;
        up = false;
        play = mummyPlay;
        player = 39;
 }
else if(myPlay >= 1){
     
        falling = true;
        xc = (float)(29.5+((myPlay-1)*5.5));
        yc = 71.3f;
        DrawSprite6(gl,(float)xc,(float)yc,38,.11f);
        cnt = empty[myPlay-1]*2-1;
        up = false;
        play = myPlay;
        player = 38;
        myPlay = 0;
}
else if(falling){
    if(cnt == empty[play-1]){
         yc -= 7.3;
         cnt--;
    }
    else if(cnt > 0){
         yc -= 4.5; 
         cnt--;
    }         
    else if(empty[play-1] > 2 && !up){      
          yc += 4.5;
          cnt--;
          if(cnt == -2){
          up = true;
          cnt = 2;
          }
        }
    else {
        play("src\\connect4\\4.wav",0);
        falling = false;
        pucket[count][0] = xc;
        pucket[count][1] = yc;
        pucket[count][2] = player;
        count++;
        empty[play-1]--;
        if(player == 39)
            myTurn = true;
        else
        mummyTurn = true;
        if(game != newGame)
            if(cake){
                game = newGame;
                if(game == 31){
                    myScore = count*30;
                    mummyScore = count*30;
                }
                else if(game == 32){
                    play("src\\connect4\\5.wav",0);
                    myScore = count*10;
                    mummyScore = 100*(100-count);
                }
                else {  
                    myScore = 100*(100-count);
                    mummyScore = count*10;;
                }
            }
            else
                cake = true;       
        System.out.println(empty[play-1]);
    }
  
           DrawSprite6(gl,xc,yc,player,.11f);
       }
         for(int m = 0; m < count ; m++){
            DrawSprite6(gl,pucket[m][0],pucket[m][1],(int)pucket[m][2],.11f);
           }
          DrawSprite5(gl,46.8f,44.9f,6, 1.72f);
          DrawSprite3(gl,78,93f,3,2.0f);
     } 
 
   else if(game==99){
         DrawBackground(gl, 43);
         msl--;
   if(msl <= 0){
      setVisible(false);
      dispose();
      System.exit(0);
    }
         
    }   
    }   
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
    public void DrawSprite5(GL gl,float x, float y, int index, float scale){
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]);	// Turn Blending On

        gl.glPushMatrix();
            gl.glTranslated( x/(maxWidth/2.0) - 0.9, y/(maxHeight/2.0) - 0.9, 0);
           gl.glScaled(.44875*scale, .575555*scale, 1);
            //System.out.println(x +" " + y);
            gl.glBegin(GL.GL_QUADS);
            // Front Face
                gl.glTexCoord2f(0.0f, 0.0f);
                gl.glVertex3f(-1.0f, -1.0f, -1.0f);
                gl.glTexCoord2f(1.0f, 0.0f);
                gl.glVertex3f(1.0f, -1.0f, -1.0f);
                gl.glTexCoord2f(1.0f, 1.0f);
                gl.glVertex3f(1.0f, 1.0f, -1.0f);
                gl.glTexCoord2f(0.0f, 1.0f);
                gl.glVertex3f(-1.0f, 1.0f, -1.0f);
            gl.glEnd();
        gl.glPopMatrix();
        
        gl.glDisable(GL.GL_BLEND);
    }
    public void DrawSprite6(GL gl,float x, float y, int index, float scale){
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]);	// Turn Blending On

        gl.glPushMatrix();
            gl.glTranslated( x/(maxWidth/2.0) - 0.9, y/(maxHeight/2.0) - 0.9, 0);
           gl.glScaled(.44875*scale, .8*scale, 1);
            //System.out.println(x +" " + y);
            gl.glBegin(GL.GL_QUADS);
            // Front Face
                gl.glTexCoord2f(0.0f, 0.0f);
                gl.glVertex3f(-1.0f, -1.0f, -1.0f);
                gl.glTexCoord2f(1.0f, 0.0f);
                gl.glVertex3f(1.0f, -1.0f, -1.0f);
                gl.glTexCoord2f(1.0f, 1.0f);
                gl.glVertex3f(1.0f, 1.0f, -1.0f);
                gl.glTexCoord2f(0.0f, 1.0f);
                gl.glVertex3f(-1.0f, 1.0f, -1.0f);
            gl.glEnd();
        gl.glPopMatrix();
        
        gl.glDisable(GL.GL_BLEND);
    }
     public void DrawSprite(GL gl,float x, float y, int index, float scale){
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]);	// Turn Blending On

        gl.glPushMatrix();
            gl.glTranslated( x/(maxWidth/2.0) - 0.9, y/(maxHeight/2.0) - 0.9, 0);
            gl.glScaled(0.1*scale, 0.1*scale, 1);
            //System.out.println(x +" " + y);
            gl.glBegin(GL.GL_QUADS);
            // Front Face
                gl.glTexCoord2f(0.0f, 0.0f);
                gl.glVertex3f(-1.0f, -1.0f, -1.0f);
                gl.glTexCoord2f(1.0f, 0.0f);
                gl.glVertex3f(1.0f, -1.0f, -1.0f);
                gl.glTexCoord2f(1.0f, 1.0f);
                gl.glVertex3f(1.0f, 1.0f, -1.0f);
                gl.glTexCoord2f(0.0f, 1.0f);
                gl.glVertex3f(-1.0f, 1.0f, -1.0f);
            gl.glEnd();
        gl.glPopMatrix();
        
        gl.glDisable(GL.GL_BLEND);
    }

      public void DrawSprite3(GL gl,float x, float y, int index, float scale){
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]);	// Turn Blending On

        gl.glPushMatrix();
            gl.glTranslated( x/(maxWidth/2.0) - 0.9,( y/(maxHeight/2.0) - 0.9)-.1, 0);
            gl.glScaled(0.04*scale, 0.06*scale, 1);
            //System.out.println(x +" " + y);
            gl.glBegin(GL.GL_QUADS);
            // Front Face
                gl.glTexCoord2f(0.0f, 0.0f);
                gl.glVertex3f(-1.0f, -1.0f, -1.0f);
                gl.glTexCoord2f(1.0f, 0.0f);
                gl.glVertex3f(1.0f, -1.0f, -1.0f);
                gl.glTexCoord2f(1.0f, 1.0f);
                gl.glVertex3f(1.0f, 1.0f, -1.0f);
                gl.glTexCoord2f(0.0f, 1.0f);
                gl.glVertex3f(-1.0f, 1.0f, -1.0f);
            gl.glEnd();
        gl.glPopMatrix();
        
        gl.glDisable(GL.GL_BLEND);
    }
    
    public void DrawBackground(GL gl, int index){
        gl.glEnable(GL.GL_BLEND);	
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]);	// Turn Blending On

        gl.glPushMatrix();
            gl.glBegin(GL.GL_QUADS);
            // Front Face
                gl.glTexCoord2f(0.0f, 0.0f);
                gl.glVertex3f(-1.0f, -1.0f, -1.0f);
                gl.glTexCoord2f(1.0f, 0.0f);
                gl.glVertex3f(1.0f, -1.0f, -1.0f);
                gl.glTexCoord2f(1.0f, 1.0f);
                gl.glVertex3f(1.0f, 1.0f, -1.0f);
                gl.glTexCoord2f(0.0f, 1.0f);
                gl.glVertex3f(-1.0f, 1.0f, -1.0f);
            gl.glEnd();
        gl.glPopMatrix();
        
        gl.glDisable(GL.GL_BLEND);
     
    }
   
    @Override
    public void mouseClicked( MouseEvent e) {
    
         double x = e.getX();
        double y = e.getY();

        Component c = e.getComponent();
        double width = c.getWidth();
        double height = c.getHeight();
       
        double x1=(x/(900)*100 );
        double y1=(y/(600)*100 );
        y1=100-y1;
      
       //if exit is pressed
       if ((x1>=121&&x1<=130) && (y1>=87&&y1<=97)){
                  play("src\\connect4\\pop.wav",0);
               if(frame == 1) 
                   
                   game=99;
               else {
                   frame =1;
                   game = 98;
               }
                    
       }else if(frame == 1){
           //if how to play is pressed
        if ((x1>=44&&x1<=105) && (y1>=17&&y1<=40 ) )  {
                    play("src\\connect4\\pop.wav",0);
            frame = 3;
            game=1;
            
            
         }
         //if play is pressed
         else if ((x1>=44&&x1<=106) && (y1>=48&&y1<=70) )   {
                 play("src\\connect4\\pop.wav",0);
            game=2;
            frame = 2;
            
         }
         else{
            game = 1000;
            oldGame = 1000;
       }
         
       }
       else if(frame == 2){
//         if mummy is pressed
           if ((x1>=53&&x1<=97) && (y1>=41&&y1<=65 ) )  { 
                  play("src\\connect4\\pop.wav",0);
               game=4;
               frame = 4;
               count = 0;
               myPlay = 0;
               myTurn = true;
               newGame = 0;
               cake = false;
               myScore = 0;
               mummyScore = 0;
               k = 52;
               for(int i = 0 ; i <= 6 ; i++)
                   empty[i]=6;              
               b = new Board();
               ai = new Connect4AI(b);
        }
         //if multiplayer is pressed
         else if ((x1>=53&&x1<=97) && (y1>=21&&y1<=35) )   { 
                   play("src\\connect4\\pop.wav",0);
             game = 5;
             frame = 2;
            
         }
         //if back is pressed
         else if ((x1>=53&&x1<=97) && (y1>=0&&y1<=13) )   {
                  play("src\\connect4\\pop.wav",0);
            game=6;
            frame = 1;
            
         } 
         else{
            oldGame = 1000; 
            game = 1000; 
         }
            
       }
       else if(frame == 3){
         //if got it is pressed
           if ((x1>=59&&x1<=92) && (y1>=81&&y1<=96 ) )  {
                play("src\\connect4\\pop.wav",0);
               if(index == 0){
                    game = 7;
                    index++;
                    
                    
               }
                  
               else if(index == 1){
                   game = 8;
                   index++;
               }
               else if(index == 2){
                   game = 9;
                   index++;
               }
               else{
                   game = 10;
                   index = 0;
                   frame = 1;
               }
               
               
         
        
       }
           else{
           oldGame = 1000;     
           game = 1000;
           }
       }
        else if(frame == 4 && myTurn){ 
            int x0 = 48;
            float l = 8.6f;
            game = 4;
            if((x1 >= x0 && x1 <= x0+7*l) && (y1 >= 71.3 && 71 <= 77)){
                if (x1 <= x0+l){
                    if(empty[0] > 0)
                        myPlay = 1; 
                    else{
                     play("src\\connect4\\2.wav",0);
                        return;                    
                }
                    }
                else if (x1 <= x0+2*l){ 
                        if(empty[1] > 0)
                            myPlay = 2;
                        else{
                           play("src\\connect4\\2.wav",0);
                            return;                    
                         }
                }
                else if (x1 <= x0+3*l){ 
                        if(empty[2] > 0)
                          myPlay = 3;
                        else{
                        play("src\\connect4\\2.wav",0);
                        return;                    
                        }
                }
                         
                else if (x1 <= x0+4*l) {
                        if(empty[3] > 0)
                          myPlay = 4;
                        else{
                      play("src\\connect4\\2.wav",0);
                            return;                    
                         }
                }
                else if (x1 <= x0+5*l) {
                        if(empty[4] > 0)
                          myPlay = 5;
                        else{
                            play("src\\connect4\\2.wav",0);
                            return;                    
                         }
                }
                else if (x1 <= x0+6*l ) {
                        if(empty[5] > 0)
                          myPlay = 6;
                        else{
                             play("src\\connect4\\2.wav",0);
                            return;                    
                }
                         }
                else if(empty[6] > 0){                   
                         myPlay = 7;
                } 
                else{
                         play("src\\connect4\\2.wav",0);
                       return;                    
                }
                myTurn = false;                 
                newGame = 4;
                temp = ai.playWithTheMummy(myPlay);
                mummyPlay = temp;
                if(ai.gameResult(b) == 0){
                    newGame = 31;   
                    frame = 5;
                }                                   
                else if(ai.gameResult(b) == 1){
                    newGame = 32;
                    frame =5;
                }
                else if(ai.gameResult(b) == 2){
                    newGame = 33;
                    frame = 5;
                }                    
                    
            }   
            else{
                oldGame = game;
                game = 1000; 
            }
        }
        
       else if(frame == 5){
               
       }
       else{
                 oldGame = game;
                 game = 1000;
        } 
       msl = 4;
      if(game==1000) {
         play("src\\connect4\\2.wav",0);
         game = oldGame;
      }
      
    }
      

    @Override
    public void mousePressed(MouseEvent e) {       
      
           
    }
     public void mouseDragged(MouseEvent e) {
        
          
     }
public void mouseMoved(MouseEvent e) {
   
    }
    @Override
    public void mouseReleased(MouseEvent e) {
      
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {       
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }




 public void play(String s,int count) { //Plays the background music
    try
    {
        Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(new File(s)));
        clip.start();
        if (!clip.isRunning())
            clip.loop(count);
        clip.start();
        }
    catch (Exception exc)
    {
        exc.printStackTrace(System.out);
    }
}
        
 

   
   

}