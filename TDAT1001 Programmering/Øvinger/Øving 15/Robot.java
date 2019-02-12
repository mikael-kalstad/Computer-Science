
import java.awt.*;
import javax.swing.*;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.Math;

// For Ã¥ tegne kube/terning
import com.jogamp.opengl.util.gl2.GLUT;

/**
 * Multicolor cube with triangles
 * @author Tomas Holt, based on code from Hock-Chuan Chua (May 2012)
 * @version October 2016
 */

/* Main class which extends GLCanvas. This means that this is a OpenGL canvas.
   We will use OpenGL commands to draw on this canvas.
   This implementation has no animation or user input.
*/
public class Robot extends GLCanvas implements GLEventListener {
   // constants
   private static String TITLE = "Robot";
   private static final int CANVAS_WIDTH = 940;  // width of the drawable
   private static final int CANVAS_HEIGHT = 780; // height of the drawable

   private double rotAngle = 0.0;
   private double walking = -1.0;
   private double sideways = 0.0;

   // Setup OpenGL Graphics Renderer
   private GLU glu;  // for the GL Utility

   /** Constructor to setup the GUI for this Component */
   public Robot() {
      this.addGLEventListener(this);
      this.addKeyListener(new RotateKeyListener()); //listener for keyboard
   }

// ------ Implement methods declared in GLEventListener (init,reshape,display,dispose)

   /**
    * Called immediately after the OpenGL context is initialized. Can be used
    * to perform one-time initialization. Run only once.
    */
   public void init(GLAutoDrawable drawable) {
      GL2 gl = drawable.getGL().getGL2();      // get the OpenGL graphics context
      glu = new GLU();                         // get GL Utilities
      gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); // set background (clear) color
      // gl.glEnable(GL2.GL_DEPTH_TEST);           // enables depth testing
      gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST); // best perspective correction


   }

   /**
    * Handler for window re-size event. Also called when the drawable is
    * first set to visible
    */
   public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
      GL2 gl = drawable.getGL().getGL2();  // get the OpenGL 2 graphics context

      if (height == 0) height = 1;   // prevent divide by zero
      float aspect = (float)width / height;

      //Set the view port (display area) to cover the entire window
      gl.glViewport(0, 0, width, height);

      // Setup perspective projection, with aspect ratio matches viewport
      gl.glMatrixMode(GL2.GL_PROJECTION);  // choose projection matrix
      gl.glLoadIdentity();             // reset projection matrix
      glu.gluPerspective(99.0, aspect, 0.1, 100.0); // fovy, aspect, zNear, zFar

      // Enable the model-view transform
      gl.glMatrixMode(GL2.GL_MODELVIEW);
      gl.glLoadIdentity(); // reset
   }

   /**
    * Called by OpenGL for drawing
    */
   public void display(GLAutoDrawable drawable) {
      GL2 gl = drawable.getGL().getGL2();  // get the OpenGL 2 graphics context
      gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT); // clear color and depth buffers
      gl.glLoadIdentity();  // reset the model-view matrix


      // Lager objekt av klassen GLUT
     GLUT glut = new GLUT();

      // glu.gluLookAt(
      //       1.0, 1.0, 1.0,
      //       0.0, -1.0, -1.0,
      // 0.0, 1.0, 0.0);

      double x = Math.cos(rotAngle);
      double z = Math.sin(rotAngle);

     // ENDRE KAMERAVINKEL
     glu.gluLookAt(
       x+sideways, 0.0, z+walking, // Eye point
       sideways, 0.0, walking, // Reference point
       0.0, 1.0, 0.0); // Up vector

      gl.glPushMatrix();

     // Objekt 1
      gl.glColor3f(0.6f, 1.0f, 0.0f); //
      gl.glTranslatef(-1.0f, -1.0f, -1.8f);
      glut.glutSolidCube(0.4f);
      gl.glPopMatrix();

      // Objekt 2
      gl.glPushMatrix();
      gl.glColor3f(0.9f, 0.2f, 0.1f); //
      gl.glTranslatef(1.2f, -1.0f, -3.0f);
      glut.glutSolidCube(0.4f);
      gl.glPopMatrix();

      // Flate
      gl.glPushMatrix();
      gl.glColor3f(0.2f, 0.2f, 0.8f); //
      gl.glTranslatef(0.0f, -3.5f, 0.0f);
      gl.glScalef(20.0f, 0.03f, 20.0f);
      glut.glutSolidCube(2.0f);
	  gl.glPopMatrix();

	gl.glTranslated(sideways, 0.0, walking);

     // Hode
     gl.glPushMatrix();
     gl.glColor3f(0.2f, 0.1f, 0.4f); // LILLA
     gl.glTranslatef(0.0f, 0.0f, 0.0f);
     // gl.glRotated(rotAngle, 0, 1, 0);
     glut.glutSolidSphere(0.15, 100, 100);
     gl.glPopMatrix();

     // Hals
     gl.glPushMatrix();
     gl.glColor3f(0.0f, 0.0f, 1.0f); // BLÅ
     gl.glTranslatef(0.0f, -0.2f, 0.0f);
     // gl.glRotated(rotAngle, 0, 1, 0);
     gl.glScalef(0.7f, 1.5f, 0.7f); // Skaler for rektangel
     glut.glutSolidCube(0.1f);
     gl.glPopMatrix();


     // Kropp
     gl.glPushMatrix();
     gl.glColor3f(1.0f, 0.0f, 0.0f); // RØD
     gl.glTranslatef(0.0f, -0.4f, 0.0f);
     // gl.glRotated(rotAngle, 0, 1, 0);
     gl.glScalef(0.5f, 0.8f, 0.2f);
     glut.glutSolidCube(0.4f);
     gl.glPopMatrix();

     // Høyre arm
      gl.glPushMatrix();
     gl.glColor3f(0.4f, 0.4f, 0.2f); //
	   gl.glTranslatef(0.13f, -0.4f, 0.0f);
	   // gl.glRotated(rotAngle, 0, 1, 0);
     gl.glScalef(0.1f, 0.8f, 0.1f); // Skaler for rektangel
     glut.glutSolidCube(0.4f);
		gl.glPopMatrix();

  	 // Venstre arm
  	  gl.glPushMatrix();
     gl.glColor3f(0.4f, 0.4f, 0.2f); //
     gl.glTranslatef(-0.13f, -0.4f, 0.0f);
     // gl.glRotated(rotAngle, 0, 1, 0);
     gl.glScalef(0.1f, 0.8f, 0.1f); // Skaler for rektangel
     glut.glutSolidCube(0.4f);
     gl.glPopMatrix();

  	// Høyre fot
  	 gl.glPushMatrix();
  	gl.glColor3f(0.0f, 1.0f, 0.0f); //
  	gl.glTranslatef(0.05f, -0.74f, 0.0f);
  	// gl.glRotated(rotAngle, 0, 1, 0);
  	gl.glScalef(0.15f, 0.7f, 0.15f); // Skaler for rektangel
  	glut.glutSolidCube(0.4f);
  	gl.glPopMatrix();

  	// Venstre fot
  	 gl.glPushMatrix();
  	gl.glColor3f(0.0f, 1.0f, 0.0f); //
  	gl.glTranslatef(-0.05f, -0.74f, 0.0f);
  	// gl.glRotated(rotAngle, 0, 1, 0);
  	gl.glScalef(0.15f, 0.7f, 0.15f); // Skaler for rektangel
  	glut.glutSolidCube(0.4f);
    gl.glPopMatrix();




   }

   /**
    * Called before the OpenGL context is destroyed. Release resource such as buffers.
    */
   public void dispose(GLAutoDrawable drawable) { }

   private class RotateKeyListener extends KeyAdapter{
        public void keyPressed(KeyEvent e) {
            // Forward
            if (e.getKeyChar() == 'w') {
               walking -= 0.4;//
               Robot.this.repaint();//repaint our canvas
            }

            // Backward
            if (e.getKeyChar() == 's') {
               walking += 0.4;//
               Robot.this.repaint();//repaint our canvas
            }

            // Right
            if (e.getKeyChar() == 'q') {
               rotAngle += 0.3;//
               Robot.this.repaint();//repaint our canvas
            }

            // Left
            if (e.getKeyChar() == 'e') {
               rotAngle -= 0.3;//
               Robot.this.repaint();//repaint our canvas
            }

            // Right
            if (e.getKeyChar() == 'a') {
               sideways += 0.3;//
               Robot.this.repaint();//repaint our canvas
            }

            // Left
            if (e.getKeyChar() == 'd') {
               sideways -= 0.3;//
               Robot.this.repaint();//repaint our canvas
            }
        }
   }

   /** The entry main() method to setup the top-level JFrame with our OpenGL canvas inside */
   public static void main(String[] args) {
       GLCanvas canvas = new Robot();
       canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

       final JFrame frame = new JFrame(); // Swing's JFrame or AWT's Frame
       frame.getContentPane().add(canvas);
       frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//stop program
       frame.setTitle(TITLE);
       frame.pack();
       frame.setVisible(true);
   }
}
