
import java.awt.*;
import javax.swing.*;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;


/**
 * NeHe Lesson #2 (JOGL 2 Port): Basic 2D Shapes
 * @author Tomas Holt, based on code from Hock-Chuan Chua (May 2012)
 * @version October 2016
 */

/* Main class which extends GLCanvas. This means that this is a OpenGL canvas.
   We will use OpenGL commands to draw on this canvas.
   This implementation has no animation or user input.
*/
public class Sideflater extends GLCanvas implements GLEventListener {
   // constants
   private static String TITLE = "Nehe #2: Your First 2D Polygon";
   private static final int CANVAS_WIDTH = 620;  // width of the drawable
   private static final int CANVAS_HEIGHT = 440; // height of the drawable

   // Setup OpenGL Graphics Renderer
   private GLU glu;  // for the GL Utility

   /** Constructor to setup the GUI for this Component */
   public Sideflater() {
      this.addGLEventListener(this);
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
      gl.glEnable(GL2.GL_DEPTH_TEST);           // enables depth testing
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
      //gl.glViewport(0, 0, width, height);

      // Setup perspective projection, with aspect ratio matches viewport
      gl.glMatrixMode(GL2.GL_PROJECTION);  // choose projection matrix
      gl.glLoadIdentity();             // reset projection matrix
      glu.gluPerspective(60.0, aspect, 0.1, 100.0); // fovy, aspect, zNear, zFar

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

      gl.glTranslatef(-1.0f, -0.5f, -6.0f);
      gl.glRotatef(60.0f, 2.0f, 10.2f, 2.2f);

      gl.glViewport(0,0 ,CANVAS_WIDTH/2, CANVAS_HEIGHT/2);
      drawCube(gl);


		 gl.glLoadIdentity();
	    gl.glTranslatef(1.5f, 1.5f, -6.0f);
      gl.glRotatef(60.0f, 1.0f, 2.2f, 2.2f);

      gl.glViewport(CANVAS_WIDTH/2, 0 ,CANVAS_WIDTH/2, CANVAS_HEIGHT/2);
      drawCube(gl);

      gl.glLoadIdentity();
      gl.glTranslatef(1.5f, 1.5f, -6.0f);
      gl.glRotatef(60.0f, 1.0f, 2.2f, 2.2f);

      gl.glViewport(0,  CANVAS_HEIGHT/2,CANVAS_WIDTH/2 , CANVAS_HEIGHT/2);
      drawCube(gl);

      gl.glLoadIdentity();
      gl.glTranslatef(1.5f, 1.5f, -6.0f);
      gl.glRotatef(60.0f, 1.0f, 2.2f, 2.2f);

      gl.glViewport(CANVAS_WIDTH/2,  CANVAS_HEIGHT/2, CANVAS_WIDTH/2 , CANVAS_HEIGHT/2);
      drawCube(gl);
   }


   public static final float cornerPositions[][] = {
    // Side 1 - TOPP
    {1.0f, 1.0f, -1.0f},
    {-1.0f, 1.0f, -1.0f},
    {-1.0f, 1.0f, 1.0f},
    {1.0f, 1.0f, 1.0f},


    // Side 6 - BUNN
    {1.0f, -1.0f, -1.0f},
    {-1.0f, -1.0f, -1.0f},
    {-1.0f, -1.0f, 1.0f},
    {1.0f, -1.0f, 1.0f}
   };

   public static final float colors[][] = {
    {1.0f, 0.0f, 0.0f}, // RØD
    {0.0f, 1.0f, 0.0f}, // GRØNN
    {0.0f, 0.0f, 1.0f}, // BLÅ
    {0.1f, 0.6f, 0.3f}, // ORANSJE
    {0.4f, 0.8f, 0.9f}, // LYS-BLÅ
    {1.0f, 0.5f, 0.9f} // ROSA
   };

   public void drawSide(int color, int a, int b, int c, int d, GL2 gl) {
      gl.glColor3fv(colors[color], 0);

      gl.glBegin(GL2.GL_POLYGON);
        gl.glVertex3fv(cornerPositions[a], 0);
        gl.glVertex3fv(cornerPositions[b], 0);
        gl.glVertex3fv(cornerPositions[c], 0);
        gl.glVertex3fv(cornerPositions[d], 0);
      gl.glEnd();
   }

    public void drawCube(GL2 gl) {
      drawSide(0, 0, 1, 2, 3, gl);
      drawSide(1, 0, 1, 5, 4, gl);
      drawSide(2, 4, 0, 3, 7, gl);
      drawSide(3, 1, 5, 6, 2, gl);
      drawSide(4, 2, 3, 7, 6, gl);
      drawSide(5, 4, 5, 6, 7, gl);
   }


   /**
    * Called before the OpenGL context is destroyed. Release resource such as buffers.
    */
   public void dispose(GLAutoDrawable drawable) { }

   /** The entry main() method to setup the top-level JFrame with our OpenGL canvas inside */
   public static void main(String[] args) {
       GLCanvas canvas = new Sideflater();
       canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

       final JFrame frame = new JFrame(); // Swing's JFrame or AWT's Frame
       frame.getContentPane().add(canvas);
       frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//stop program
       frame.setTitle(TITLE);
       frame.pack();
       frame.setVisible(true);
   }
}
