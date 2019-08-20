
import com.sun.opengl.util.GLUT;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.opengl.*;
import javax.media.opengl.glu.*;
import javax.swing.JOptionPane;

public class GlutObjectsGLEventListener implements GLEventListener {

    double x = 1;
    double y = 0;
    double z = 5;
    
    double x1 = 0;
    double y1 = -0.3;
    double z1 = 5;

    double xPosition;
    double zPosition;
    Texture text;
    Texture texture;
    boolean ob;

    public void init(GLAutoDrawable drawable) {

        GL gl = drawable.getGL();
        GLU glu = new GLU();
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        double w = ((Component) drawable).getWidth();
        double h = ((Component) drawable).getHeight();
        double aspect = w / h;
        glu.gluPerspective(60.0, aspect, 2, 20.0);

        float[] faPosition = {0f, 15f, -30f, 0f};
        FloatBuffer position = FloatBuffer.wrap(faPosition);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, position);

        float[] faDiffuse = {1f, 1f, 1f, 0f};
        FloatBuffer diffuse = FloatBuffer.wrap(faDiffuse);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, diffuse);

        float[] faAmbient = {1f, 1f, 1f, 0f};
        FloatBuffer ambient = FloatBuffer.wrap(faAmbient);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, ambient);

    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLUT glut = new GLUT();
        GLU glu = new GLU();

        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

        glu.gluLookAt(
                xPosition, 0, zPosition,
                xPosition, 0, (zPosition + 20),
                0, 1, 0);
        gl.glEnable(GL.GL_LIGHTING);
        gl.glEnable(GL.GL_LIGHT0);
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

        try {
            text = TextureIO.newTexture(new File("4.png"), true);
            text.enable();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (GLException ex) {
            ex.printStackTrace();

        }

        GLUquadric ground = glu.gluNewQuadric();
        glu.gluQuadricTexture(ground, true);
        gl.glPushMatrix();
        text.bind();
        gl.glTranslated(x1,y1 , z1);
        gl.glRotated(180, 0, 1, 0);
        gl.glRotated(180, 1, 0, 0);
        gl.glScaled(0.3, 0.3, 0.3);
        float faMaterial1[] = {1f, 1f, 1f, 1.0f};
        FloatBuffer material1 = FloatBuffer.wrap(faMaterial1);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT_AND_DIFFUSE, material1);
        glu.gluDisk(ground, 0.1, 2, 64, 64);
        gl.glPopMatrix();
        text.disable();

        drawcube(gl, glut, x, y, z);

        drawcube(gl, glut, x - 2, y, z + 3);

        drawcube(gl, glut, x, y, z + 6);

        drawcube(gl, glut, x - 2, y, z + 9);

        drawcube(gl, glut, x, y, z + 12);

        drawcube(gl, glut, x - 2, y, z + 15);

        drawcube(gl, glut, x, y, z + 18);

        drawcube(gl, glut, x - 2, y, z + 21);

        drawcube(gl, glut, x, y, z + 24);

        drawcube(gl, glut, x - 2, y, z + 27);

        drawcube(gl, glut, x, y, z + 30);

        drawcube(gl, glut, x - 2, y, z + 33);

        drawcube(gl, glut, x, y, z + 36);

        drawcube(gl, glut, x - 2, y, z + 39);

        drawcube(gl, glut, x, y, z + 42);

        drawcube(gl, glut, x, y, z + 42);

        drawcube(gl, glut, x - 2, y, z + 45);
        drawcube(gl, glut, x, y, z + 45);
        drawcube(gl, glut, x - 2, y, z + 48);
        drawcube(gl, glut, x, y, z + 48);
        drawcube(gl, glut, x - 2, y, z + 51);
        drawcube(gl, glut, x, y, z + 51);
        try {
            Path relativePath = Paths.get("IMG_7228.png");
            text = TextureIO.newTexture(relativePath.toFile(), true);

            text.enable();

        } catch (Exception e) {
            e.printStackTrace();
        }
        gl.glPushMatrix();
        text.bind();
        gl.glTranslated(0, -.1, zPosition + 10);

        // White because we use textures
        float faMaterial2[] = {1f, 1f, 1f, 1.0f};
        FloatBuffer material2 = FloatBuffer.wrap(faMaterial2);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT_AND_DIFFUSE, material2);

        // Drawing the Quad
        gl.glScaled(8, 8, 8);
        gl.glBegin(GL.GL_QUADS);

        gl.glTexCoord2d(0, 1);
        gl.glVertex3d(-1, -1, 0);

        gl.glTexCoord2d(1, 1);
        gl.glVertex3d(+1, -1, 0);

        gl.glTexCoord2d(1, 0);
        gl.glVertex3d(+1, +1, 0);

        gl.glTexCoord2d(0, 0);
        gl.glVertex3d(-1, +1, 0);

        gl.glEnd();

        gl.glPopMatrix();
        text.disable();
        if ( z1 == z + 6 || z1 == z + 9 || z1 == z + 12 || z1 == z + 15 || z1 == z + 18) {
          Collision();
        }
        ob =false;
        z1++;
        zPosition += 1;
    }

    public void Collision() {
        ob=true;
        GlutObjectsApp.animator.stop();
        JOptionPane.showMessageDialog(null, "Collision");

        GlutObjectsApp.animator.start();
    }

    public void reshape(
            GLAutoDrawable drawable,
            int x,
            int y,
            int width,
            int height) {
    }

    public void displayChanged(
            GLAutoDrawable drawable,
            boolean modeChanged,
            boolean deviceChanged) {
    }

    public void drawcube(GL gl, GLUT glut, double x, double y, double z) {
        gl.glPushMatrix();
        gl.glTranslated(x, y, z);
        gl.glRotated(0, 1, 0, 0);
        float material2[] = {0.9f, 0f, 0f, 1.0f};
        gl.glMaterialfv(
                GL.GL_FRONT_AND_BACK,
                GL.GL_AMBIENT_AND_DIFFUSE,
                material2, 0);
        glut.glutSolidCube(0.5f);
        gl.glPopMatrix();

    }

    public void drawperso(GL gl, GLUT glut, double x, double y, double z) {
        gl.glPushMatrix();
        gl.glTranslated(x, y, z);
        gl.glRotated(0, 1, 0, 0);
        float material2[] = {0.0f, 1f, 0f, 1.0f};
        gl.glMaterialfv(
                GL.GL_FRONT_AND_BACK,
                GL.GL_AMBIENT_AND_DIFFUSE,
                material2, 0);
        glut.glutSolidCube(1.2f);
        gl.glPopMatrix();

    }

    /*
     * public void DrawSprite(GL gl, double x, double y, int index, float scale)
     * { gl.glEnable(GL.GL_BLEND); gl.glBindTexture(GL.GL_TEXTURE_2D,
     * textures[index]);
     *
     * gl.glPushMatrix(); gl.glTranslated(x, y, 0); gl.glScaled(0.2 * scale, 0.2
     * * scale, 1); gl.glBegin(GL.GL_QUADS); gl.glTexCoord2f(0.0f, 0.0f);
     * gl.glVertex3f(0.0f, 0.0f, 0.0f);
     *
     * gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex3f(1.0f, 0.0f, 0.0f);
     * gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex3f(1.0f, 1.0f, 1.0f);
     * gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex3f(0.0f, 0.0f, 1.0f); gl.glEnd();
     * gl.glPopMatrix();
     *
     * gl.glDisable(GL.GL_BLEND);
    }
     */
// 
//      public void DrawBackground(GL gl) { gl.glEnable(GL.GL_BLEND);
//      gl.glBindTexture(GL.GL_TEXTURE_2D, textures[4]); gl.glPushMatrix();
//     gl.glBegin(GL.GL_QUADS); gl.glTexCoord2f(0.0f, 0.0f);
//      gl.glVertex3f(-1.0f, -1.0f, -1.0f); gl.glTexCoord2f(1.0f, 0.0f);
//      gl.glVertex3f(1.0f, -1.0f, -1.0f); gl.glTexCoord2f(1.0f, 1.0f);
//      gl.glVertex3f(1.0f, 1.0f, -1.0f); gl.glTexCoord2f(0.0f, 1.0f);
//      gl.glVertex3f(-1.0f, 1.0f, -1.0f); gl.glEnd(); gl.glPopMatrix();
//      gl.glDisable(GL.GL_BLEND);
//    }
}
