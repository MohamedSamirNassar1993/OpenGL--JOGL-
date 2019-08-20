
package gui3;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;
import com.sun.opengl.util.GLUT;
import com.sun.opengl.util.j2d.TextRenderer;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.util.BitSet;
import javax.swing.*;
import javax.media.opengl.*;
import javax.media.opengl.glu.GLU;
import  com.sun.opengl.util.j2d.TextRenderer;
import static gui3.Gui2.clip;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;
import sun.applet.Main;


public class comp extends JFrame implements MouseMotionListener, MouseListener {//, KeyListener {

    air listener = new air();
    GLCanvas glcanvas;
  static Animator anim;

    public static void main(String[] args) {

        comp app = new comp();
        
    }

    public comp() {
        super("Air_Hocky");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addMouseListener(this);
        glcanvas.addMouseMotionListener(this);
        glcanvas.addKeyListener(listener);
        anim =new FPSAnimator(glcanvas,200);
        anim.start();
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
                    Mixer.Info[] mixinfo = AudioSystem.getMixerInfo();
    
//       Mixer mixer= AudioSystem.getMixer(mixinfo[0]);
//      DataLine.Info datainfo = new DataLine.Info(Clip.class,null);
//      try { clip = (Clip) mixer.getLine(datainfo);
//      } 
//      catch (LineUnavailableException ex) {
//           
//        }
//      try {
//       URL soundURL = Main.class.getResource("/gui3/background.mp3");
//      
//      AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
//      clip.open(audioStream);
//      } catch (IOException ex) {
//            
//        } catch (LineUnavailableException ex) {
//            
//        } catch (UnsupportedAudioFileException ex) {
//            
//        }
//     
//      clip.start();
//     
//      clip.loop(Clip.LOOP_CONTINUOUSLY);
//      do
//      {
//          try { Thread.sleep(50);} catch (InterruptedException ex) {
//              
//        }
//      }while(clip.isActive());
    }

 
    public void mouseClicked(MouseEvent e) {
   
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("hhh"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
   /* double x = e.getX();
        double y = e.getY();

        Component c = e.getComponent();

        //getting the size of the GLCanvas
        double width = c.getWidth();
        double height = c.getHeight();
        x = (int) ((x / width) * 500)-250;
        y = (int) (((height-y) / height) * 500)-250;
        if(y<-20&&y>-225)
           listener.yPosition=(int) y;
        if(x<225&&x>-225)
            listener.xPosition=(int)x;
        glcanvas.repaint(); */ 
    }


}

    class air implements GLEventListener , KeyListener{
        GLUT g=new GLUT();
    int xPosition = 0;     // x1for player1
    int yPosition =-225;  // y1 for player1
   // int xp=0;        //x1 for player2
   // int yp=220;     // y1 for player2
    int xc=0;      //x1 for computer player 
    int yc=220;   // y1 for computer player
    double cx,cy;  // vertices for draw cycle
    final double ONE_DEGREE = (Math.PI / 180);
    final double THREE_SIXTY = 2 * Math.PI;
    double radius1 =20;   // big cycle
    double radius2 =10;   // small cycle && ball
    double radius3 =100;  // ground cycle
    float a = 0;         //x0 axis
    float b = 0;        //y0 axis
    float slope =0;    // slpe betwen ball and playr
    float x= a;       //holds the new 'x' position of ball
    float y = b;     //holds the new 'y' position
    boolean movingRight= true;  // check ball x1 increase or decrease
    boolean movingUp= true;    // check ball will crash up or down
    boolean verticle =false;  // check slope not define is vertical if (x1-x0 =0) 
    boolean up=false;        // if slope not define do it if y1>y0
    boolean down=false;     // if slope not define do it if y1<y0
    boolean play=false;    //  begin play if one player touch ball & to be false if game finished
    boolean computer_player=true; //who is 2player computer or player 
    int scoreplayer1=0;
    int scoreplayer2=0;
    TextRenderer renderer;
    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();
       // GLU glu = new GLU();
        gl.glViewport(-250, -250, 250, 250);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
         gl.glOrtho(-250.0, 250.0, -250.0, 250.0,1.0,-1.0);
         renderer = new TextRenderer(new Font("SansSerif", Font.BOLD, 40));
    }

    
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);         
          draw_ground(gl,1,1,1);        
          drawplayer(gl,1,0,0,0,0,1,xPosition,yPosition);  //player1
         // drawplayer(gl,0,0,1,1,0,0,xp,yp); //player2  
            handleKeyPress(); 

          drawplayer(gl,0,0,1,1,0,0,xc,yc);  // computer player
             computer_control(); 
          winner(gl);

    /*renderer.beginRendering(500, 500);
    renderer.setColor(1.0f, 0.2f, 0.2f, 0.8f);
    renderer.draw(Integer.toString(scoreplayer2),-200,10);
    renderer.draw(Integer.toString(scoreplayer1),-200,-10);
    renderer.endRendering();*/
          gl.glRasterPos2i(-200, 10);
          g.glutBitmapString(5,Integer.toString(scoreplayer2));
          gl.glRasterPos2i(-200, -20);
          g.glutBitmapString(5,Integer.toString(scoreplayer1));
    }      
    
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
    
    public void drawball(GL gl){
          // computer player
         if(computer_player){
              if((int)Math.sqrt(Math.pow(x-xc,2)+Math.pow(y-yc,2))<=30){
                    a=xc;
                    b=yc;
                    play=true;
                   verticle=(x-xc==0);
                    if(verticle){
                       if(b>y){
                         down=true;
                       }else{
                        up=true;   
                       }
                    }else{down=up=false;}
                    slope=(y-yc)/(x-xc);
                    if(yc>y&&slope<0){
                        movingUp=false;
                        movingRight=true;
                       x+=10;
                    }
                    if(yc>y&&slope>0){
                       movingUp=false;
                       movingRight=false;
                       x-=10;
                    } 

                    if(yc<y&&slope<0){
                        movingUp=true;
                        movingRight=false;
                       x-=10;
                    }

                    if(yc<y&&slope>0){
                        movingUp=true;
                        movingRight=true;
                       x+=10;
                    }
               } 
           }
          // player 1
         if((int)Math.sqrt(Math.pow(x-xPosition,2)+Math.pow(y-yPosition,2))<=30){
             a=xPosition;
             b=yPosition;
             play=true;
            verticle=(x-xPosition==0);
             if(verticle){
                if(b>y){
                  down=true;
                }else{
                 up=true;   
                }
             }else{down=up=false;}
             slope=(y-yPosition)/(x-xPosition);
             if(yPosition>y&&slope<0){
                 movingUp=false;
                 movingRight=true;
                x+=10;
             }
             if(yPosition>y&&slope>0){
                movingUp=false;
                movingRight=false;
                x-=10;
             } 
             
             if(yPosition<y&&slope<0){
                 movingUp=true;
                 movingRight=false;
                x-=10;
             }
             
             if(yPosition<y&&slope>0){
                 movingUp=true;
                 movingRight=true;
                x+=10;
             }
         }
          // player2
      /* if(!computer_player){
            if((int)Math.sqrt(Math.pow(x-xp,2)+Math.pow(y-yp,2))<=30){
                    a=xp;
                    b=yp;
                    play=true;
                   verticle=(x-xp==0);
                    if(verticle){
                       if(b>y){
                         down=true;
                       }else{
                        up=true;   
                       }
                    }else{down=up=false;}
                    slope=(y-yp)/(x-xp);
                    if(yp>y&&slope<0){
                        movingUp=false;
                        movingRight=true;
                       x+=10;
                    }
                    if(yp>y&&slope>0){
                       movingUp=false;
                       movingRight=false;
                       x-=10;
                    } 

                    if(yp<y&&slope<0){
                        movingUp=true;
                        movingRight=false;
                       x-=10;
                    }

                    if(yp<y&&slope>0){
                        movingUp=true;
                        movingRight=true;
                       x+=10;
                    }
              } 
          }*/
         
        if(play){ 
            if(!verticle){
              y = (slope * (x - a) + b);
            }

           if (movingRight) {
               if (x < 235) {
                   x += 1;
               } else {
                   movingRight = false;
                   slope *= -1;
                   a = x;
                   b = y;
               }
           }
           if (!movingRight) {
               if (x >-235) {
                   x -= 1;
               } else {
                   movingRight = true;
                   slope *= -1;
                   a = x;
                   b = y;
               }
           }

           if (movingUp) {
               if (!(y < 235)) {
                   slope *= -1;
                   a = x;
                   b =y;
                   movingUp = false;
               }
           }
           if (!movingUp) {
               if (!(y > -235)) {
                   slope *= -1;
                   a = x;
                   b = y;
                   movingUp = true;
               }
           }

           if(down){
            y--;
            if(y<=-235)
              up=true;
              down=false;
           }

           if(up){
             y++;
             if(y>=235)
              down=true;
             up=false;
           }
        }   
        gl.glColor3f(.3f,0.5f,.3f);
        gl.glBegin(GL.GL_POLYGON);
        for (double i = 0; i < THREE_SIXTY; i += ONE_DEGREE){
               cx = radius2 * (Math.cos(i))+x;
               cy= radius2 * (Math.sin(i))+y;
               gl.glVertex2d(cx, cy);
        }
        gl.glEnd(); 
       
    }  

    public void drawplayer(GL gl,float red1,float green1,float blue1,float red2,float green2,float blue2,double x,double y){
           // draw big circle for player  
               gl.glPolygonMode(GL.GL_FRONT_AND_BACK,GL.GL_FILL);
               gl.glColor3f(red1, green1, blue1);
               gl.glBegin(GL.GL_POLYGON);
               for (double aa = 0; aa < THREE_SIXTY; aa += ONE_DEGREE){
                     cx = radius1 * (Math.cos(aa))+x;
                     cy = radius1 * (Math.sin(aa))+y;
                     gl.glVertex2d(cx, cy);
               }
               gl.glEnd();
               // draw small circle for player 
               gl.glColor3f(red2, green2, blue2);
               gl.glBegin(GL.GL_POLYGON);
               for (double aa = 0; aa < THREE_SIXTY; aa += ONE_DEGREE){
                     cx = radius2 * (Math.cos(aa))+x;
                     cy = radius2 * (Math.sin(aa))+y;
                     gl.glVertex2d(cx, cy);
               }
               gl.glEnd();
    }
    
    public void draw_ground(GL gl,float red,float green,float blue){
            gl.glLineWidth(3f);
            //draw ground
            gl.glColor3f(red, green, blue);
            gl.glBegin(GL.GL_LINES);
            gl.glVertex2f(245,-245);
            gl.glVertex2f(245,245);
            
            gl.glVertex2f(-245,-245);
            gl.glVertex2f(-245,245);
            
            gl.glVertex2f(245,245);
            gl.glVertex2f(40,245);
            
            gl.glVertex2f(-40,245);
            gl.glVertex2f(-245,245);
            
            gl.glVertex2f(-40,-245);
            gl.glVertex2f(-245,-245);
            
            gl.glVertex2f(40,-245);
            gl.glVertex2f(245,-245); 
            
            gl.glVertex2f(-245,0);
            gl.glVertex2f(245,0);
            
             gl.glVertex2f(100,245);
            gl.glVertex2f(100,200); 
            
             gl.glVertex2f(-100,245);
            gl.glVertex2f(-100,200);
            
             gl.glVertex2f(-100,200);
            gl.glVertex2f(100,200);
            
              gl.glVertex2f(-100,-245);
            gl.glVertex2f(-100,-200);
            
             gl.glVertex2f(-100,-200);
            gl.glVertex2f(100,-200);
            
            gl.glVertex2f(100,-245);
            gl.glVertex2f(100,-200);
            
            gl.glEnd();
            
            gl.glPolygonMode(GL.GL_FRONT_AND_BACK,GL.GL_LINE);
             gl.glBegin(GL.GL_POLYGON);
            for (double aa = 0; aa < THREE_SIXTY; aa += ONE_DEGREE){
                  cx = radius3 * (Math.cos(aa));
                  cy = radius3 * (Math.sin(aa));
                  gl.glVertex2d(cx, cy);
            }
            gl.glEnd();
    }
    
    public void winner(GL gl){
      if((x>-35&&x<35)&&y<=-235&&play){
         // JOptionPane.showMessageDialog(null,"winer is player 2 ^_^ | ^_^");
           reset();
           scoreplayer2++;
      }
      if((x>-35&&x<35)&&y>=235&&play){
         // JOptionPane.showMessageDialog(null,"winer is player 1 ^_^ | ^_^");
          reset();
          scoreplayer1++;
      } 
           drawball(gl);
   
    }
    
    public void reset(){
     xPosition = 0;     
     yPosition =-225;  
    // xp=0;        
    // yp=220;     
     xc=0;       
     yc=220;   
     a = 0;         
     b = 0;        
    slope =0;    
    x= a;       
    y = b;     
    movingRight= true;  
    movingUp= true;    
    verticle =false;   
    up=false;        
    down=false;   
    play=false; 
    }
    
    public void computer_control(){
       /*
        //top play  
         if (y >10&&y<200) {
                yc=(int) (y+20);
         } 
       
         if(x<210&&x>0){
            xc=(int) (x-8);
         }
         if(x>-210&&x<0){
           xc= (int) (x+8);
         } */
       
        //  midium  play  && hard (just change i*i)
         if(Math.pow(yc-y,2)>=10*10){
            if(y>yc)
              if(yc<225)
              yc+=4;
           if(y<yc)
             if(yc>20)
             yc+=-4;
         }
        if(y>225&&x>0){
          xc+=-3;
        }
         if(y>225&&x<0){
            xc+=3;
         }
         if((x>225||x<-225)&&y>10)
             yc+=3;
         if(Math.pow(xc-x,2)>=10*10){
            if(x>xc)
              if(xc<200)
              xc+=1;
           if(x<xc)
             if(xc>-200)
             xc+=-1;
         } 
         /* //  easy  play
         if(x>80){
              if(xc<50){
                  System.out.println(xc);
              xc+=1;
              }
         }
         if(x<80){
             if(xc>-50)
             xc+=-1;
             
         } */
        
    }
    
     public void handleKeyPress() {

        // control player2
      /*  if (isKeyPressed(KeyEvent.VK_A)) {
            if (xp >-220) {
                xp+=-3;
            }
        }
        if (isKeyPressed(KeyEvent.VK_D)) {
            if (xp < 220 ) {
                xp+=3;
            }
        }
        if (isKeyPressed(KeyEvent.VK_S)) {
            if (yp > 20) {
                yp+=-3;
            }
        }
        if (isKeyPressed(KeyEvent.VK_W)) {
            if (yp < 220) {
                yp+=3; 
            }
        } */
       // control player1
        if (isKeyPressed(KeyEvent.VK_LEFT)) {
            if (xPosition > -220) {
                xPosition+=-3; 
            }
        }
        if (isKeyPressed(KeyEvent.VK_RIGHT)) {
            if (xPosition < 220) {
                xPosition+=3; 
            }
        }
        if (isKeyPressed(KeyEvent.VK_DOWN)) {
            if (yPosition > -220) {
                yPosition+=-3; 
            }
        }
        if (isKeyPressed(KeyEvent.VK_UP)) {
            if (yPosition < -20) {
                yPosition+=3; 
            }
        } 
        
    }

    public BitSet keyBits = new BitSet(256);
 
 
    public void keyPressed(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.set(keyCode);
    } 
 

    public void keyReleased(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.clear(keyCode);
    } 
  
    public void keyTyped(final KeyEvent event) {
        // don't care 
    } 
 
    public boolean isKeyPressed(final int keyCode) {
        return keyBits.get(keyCode);
    }

}
