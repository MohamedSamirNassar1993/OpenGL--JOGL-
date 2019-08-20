
import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.BitSet;
//import java.awt.event.*;
import javax.swing.*;
import javax.media.opengl.*;
import sun.security.x509.OIDMap;

/**
 * This is a basic JOGL app. Feel free to 
 * reuse this code or modify it.
 */

public class SimpleJoglApp extends JFrame implements KeyListener{

    
   public int[]posx=new int [80];
   
   public int[] posy=new int [80];
   public int snake_length=5;
   public int score=0;
           public int up=1, down=-1, right=2, left=-2;
   public boolean gameover=false , food=true;
   public int Max=80;
   public int foodx , foody;
   
 public short sDirection=(short) right;
static Animator animator = null;
private final SimpleGLEventListener listener = new SimpleGLEventListener();
JTextField scoretxt = new JTextField("Score: "+score+"\t\t\t\t"+"press Esc to pause");

public static void main(String[] args) {
      final JFrame menue= new JFrame();
      menue.setSize(300,300);
      menue.setTitle("SNAKE");
      menue.setLayout(null);
      menue.setLocationRelativeTo(null);
            JButton newgame=new JButton("new game");
      JButton Exit= new JButton("Exit");
     newgame.setBounds(40, 100,200, 40);
     Exit.setBounds(40,160,200,40);
     menue.add(newgame);
     menue.add(Exit);
     menue.setVisible(true);
     
     newgame.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent ae) {
           SimpleJoglApp app = new SimpleJoglApp();
            app.listener.frame = app;
            menue.setVisible(false);
            animator.start(); 
          }
      });
     Exit.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent ae) {
                          System.exit(0);
          }
      });
  
       
       
}
 SimpleGLEventListener snake=new SimpleGLEventListener();
  public SimpleJoglApp() {
   
   super("snake");
    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    GLCanvas glcanvas = new GLCanvas();
    glcanvas.addGLEventListener(listener);
      glcanvas.addKeyListener(this);
       getContentPane().add(glcanvas, BorderLayout.CENTER);
        getContentPane().add("South", scoretxt);
 //initial postion of snake at x-axis      
  posx[0]=20;
  posx[1]=20;
  posx[2]=20;
  posx[3]=20;
  posx[4]=20;
   //initial postion of snake at y-axis 
  posy[0]=20;
  posy[1]=19;
  posy[2]=18;
  posy[3]=17;
  posy[4]=16;

    animator = new FPSAnimator(10);
    animator.add(glcanvas);
    add(glcanvas, BorderLayout.CENTER);
    setSize(520, 565);
    //center the JFrame on the screen
    centerWindow();
    setVisible(true);
      glcanvas.requestFocus();
      setResizable(false);
      
  }
  @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode=e.getKeyCode();
        if (keycode == KeyEvent.VK_DOWN) {
            if(sDirection!=up)
                sDirection=(short) down;
        }
        
        if (keycode == KeyEvent.VK_UP) {
            if(sDirection!=down)
                sDirection=(short) up;
        }
         if (keycode == KeyEvent.VK_LEFT) {
             if(sDirection!=right)
                sDirection=(short) left;
        }
         if (keycode == KeyEvent.VK_RIGHT) {
            if(sDirection!=left)
                sDirection=(short) right;
        }
         if (keycode == KeyEvent.VK_ESCAPE) {
            animator.stop();
            scoretxt.setText("Score: "+score+"\t\t\t\t"+"press Enter to continue");

            //JOptionPane.showMessageDialog(null,"paused");
            
            //animator.start();
        }
         if (keycode == KeyEvent.VK_ENTER) {
            animator.start();
            scoretxt.setText("Score: "+score+"\t\t\t\t"+"press Esc to pause");

            //JOptionPane.showMessageDialog(null,"paused");
            
            //animator.start();
        }
         
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

  
  
  
  
  public void centerWindow() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize  = this.getSize();

    if (frameSize.width  > screenSize.width ) frameSize.width  = screenSize.width;
    if (frameSize.height > screenSize.height) frameSize.height = screenSize.height;

    this.setLocation (
      (screenSize.width  - frameSize.width ) >> 1, 
      (screenSize.height - frameSize.height) >> 1
    );
  }

    
  

class SimpleGLEventListener implements GLEventListener {
  SimpleJoglApp frame;
  double columns = 40;
  double rows =40;
  public void init(GLAutoDrawable drawable) {
	  	GL gl = drawable.getGL();
	    gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);    
  }
  public void display(GLAutoDrawable drawable) {
     
		GL gl = drawable.getGL();
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
if(gameover){
    gameover=false;
    
   final JFrame menue= new JFrame();
      menue.setSize(300,300);
      menue.setTitle("GAME OVER");
      menue.setLayout(null);
      menue.setLocationRelativeTo(null);
      JLabel lbl_score=new JLabel("GAME OVER \n YOUR SCORE: "+score);
      JButton newgame=new JButton("start new game");
      JButton Exit= new JButton("Exit");
      lbl_score.setBounds(40,40, 200, 100);
     newgame.setBounds(40, 100,200, 40);
     Exit.setBounds(40,160,200,40);
     menue.add(newgame);
     menue.add(Exit);
     menue.add(lbl_score);
     menue.setVisible(true);
     newgame.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent ae) {
                          SimpleJoglApp app = new SimpleJoglApp();
                          app.listener.frame = app;
                          menue.setVisible(false);
                           animator.start(); 
          }
      });
     Exit.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent ae) {
                          System.exit(0);
          }
      });
   frame.dispose();
}
                for(int x=0;x<columns;x++){
                    for(int y=0;y<rows;y++){
                        if(x==0||y==0 ||x==columns-1||y==rows-1){
                            gl.glLineWidth(3.0f);
                            gl.glColor3f(1.0f, 0.0f, 0.0f);
                        }else{
                            gl.glLineWidth(1.0f);
                             gl.glColor3f(0.0f, 0.0f, 0.0f);
                        }
                         gl.glBegin(GL.GL_LINE_LOOP);
                gl.glVertex2f(x, y);
                 gl.glVertex2f(x+1, y);
                 gl.glVertex2f(x+1, y+1);
                 gl.glVertex2f(x, y+1);
                gl.glEnd();
                }
                }
                for(int i=snake_length-1;i>0;i--){
                    posx[i]=posx[i-1];
                    posy[i]=posy[i-1];
                }
                
                if(sDirection==up)
                    posy[0]++;
                else if(sDirection==down)
                    posy[0]--;
                else if(sDirection==right)
                    posx[0]++;
                else if(sDirection==left)
                    posx[0]--;
                //make the color of head blue
                for(int i=0;i<snake_length;i++){
                    if(i==0)
                     gl.glColor3f(0.0f, 0.0f,1.0f);
                     else{
                       gl.glColor3f(0.0f, 1.0f,0.0f);}
                     gl.glRectd(posx[i], posy[i], posx[i]+1, posy[i]+1);
                }
                //when snake hit the wall
                if(posx[0]==0 ||posx[0]==columns-1||posy[0]==0||posy[0]==rows-1)
               gameover=true;
                //when snake hit the food
                 if(posx[0]==foodx &&posy[0]==foody){
                     score++;
scoretxt.setText("Score: "+score+"\t\t\t\t"+"press Esc to pause");
                     snake_length++;
                     if(snake_length>Max)
                         snake_length=Max;
                    food=true;
                 }
                 //when snake hit itself
              for(int j=1;j<snake_length;j++) {
        if(posx[j]==posx[0] && posy[j]==posy[0])
            gameover=true;
         }
                 
                
                if(food){
           // int maxX=(int) (columns-2);
          //int maxY=(int) (rows-2);
         // int min=1;
          int b=(int)(Math.random()*30);
           int a=(int)(Math.random()*30);
          System.out.println(b);
          foodx= b+1 %(39);
          foody= a+1%(39);
                    }
                food=false;
                //create new food
                gl.glColor3f(1.0f,1.0f,1.0f);
                gl.glRectf(foodx, foody, foodx+1, foody+1);
                
               
  }
  
  public void reshape(
                        GLAutoDrawable drawable, 
                        int x, 
                        int y, 
                        int width, 
                        int height
                      ) {
  
  GL gl = drawable.getGL();
  
   gl.glViewport(0, 0,515, 515);
	    gl.glMatrixMode(GL.GL_PROJECTION);
	    gl.glLoadIdentity();
	    gl.glOrtho(0.0, columns, 0.0, rows, -1.0, 1.0);
            gl.glMatrixMode(GL.GL_MODELVIEW);
  
  }
	
  public void displayChanged(
                              GLAutoDrawable drawable, 
                              boolean modeChanged, 
                              boolean deviceChanged
                            ) {}

public void dispose(GLAutoDrawable arg0) {
	// TODO Auto-generated method stub
	
}

      

        

      
          
      
      

}
}

 
    
