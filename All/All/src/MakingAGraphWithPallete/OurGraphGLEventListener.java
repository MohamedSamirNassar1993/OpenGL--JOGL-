package MakingAGraphWithPallete;



import javax.media.opengl.*;
import javax.media.opengl.glu.*;


/**
 * For our purposes only two of the
 * GLEventListeners matter. Those would
 * be init() and display().
 */
public class OurGraphGLEventListener implements GLEventListener
{


	/**
	 * Take care of initialization here.
	 */
	public void init(GLAutoDrawable drawable) {	
		
		GL gl = drawable.getGL();
		GLU glu = new GLU();
		
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		
		gl.glLineWidth(2.0f);
		
		gl.glViewport(0, 0, 500, 300);		
		
		gl.glMatrixMode(GL.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);	

	}


	/**
	 * Take care of drawing here.
	 */
	public void display(GLAutoDrawable drawable) {
		
		drawGraph( drawable.getGL() );

	}


	/**
	 * Called when the GLDrawable (GLCanvas
	 * or GLJPanel) has changed in size. 
	 */
	public void reshape(
		   				GLAutoDrawable drawable,
                        int x,
                        int y,
                        int width,
                        int height
                       ) {}


	/**
	 * If the display depth is changed while the
	 * program is running this method is called.
	 * Nowadays this doesn't happen much, unless
	 * a programmer has his program do it.
	 */
	public void displayChanged(
		   				GLAutoDrawable drawable,
                        boolean modeChanged,
                        boolean deviceChanged
                      ) {}
                      
                      
    private void drawGraph(GL gl) {
		float red;
		float green;
		float blue;
		
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		
		////////////////////
		//drawing the grid
		red = 0.2f;
		green = 0.2f;
		blue = 0.2f;
		
		gl.glColor3f(red, green, blue);
		
		//You may notice I'm using GL_LINES here.		
		gl.glBegin(GL.GL_LINES);
		
		//draw the vertical lines
		for (int x=-250; x<=250; x+=10) {
			gl.glVertex2d(x, -150);
			gl.glVertex2d(x, 150);
		}
		
		//draw the horizontal lines
		for (int y=-150; y<=150; y+=10) {
			gl.glVertex2d(-250, y);
			gl.glVertex2d(250, y);
		}
		
		gl.glEnd();
		
		//////////////////////////////
		// draw the x-axis and y-axis
		red = 0.0f;
		green = 0.2f;
		blue = 0.4f;
		
		gl.glColor3f(red, green, blue);
		
		gl.glBegin(GL.GL_LINES);
		
		//line for y-axis
		gl.glVertex2d(0, 140);
		gl.glVertex2d(0, -140);
		
		//line for x-axis
		gl.glVertex2d(240, 0);
		gl.glVertex2d(-240, 0);
		
		gl.glEnd();
		
		/////////////////////
		// draw arrow heads
		gl.glBegin(GL.GL_TRIANGLES);
		
		gl.glVertex2d( 0, 150);
		gl.glVertex2d(-5, 140);
		gl.glVertex2d( 5, 140);
		
		gl.glVertex2d( 0, -150);
		gl.glVertex2d(-5, -140);
		gl.glVertex2d( 5, -140);
		
		gl.glVertex2d(250, 0);
		gl.glVertex2d(240,-5);
		gl.glVertex2d(240, 5);
		
		gl.glVertex2d(-250, 0);
		gl.glVertex2d(-240,-5);
		gl.glVertex2d(-240, 5);
		
		gl.glEnd();
		
	}
	
} 