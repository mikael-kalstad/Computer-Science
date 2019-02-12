
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
public class TiFigurer extends GLCanvas implements GLEventListener {
   // constants
   private static String TITLE = "Nehe #2: Your First 2D Polygon";
   private static final int CANVAS_WIDTH = 900;  // width of the drawable
   private static final int CANVAS_HEIGHT = 500; // height of the drawable
  
   // Setup OpenGL Graphics Renderer 
   private GLU glu;  // for the GL Utility
   
   /** Constructor to setup the GUI for this Component */
   public TiFigurer() {
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
      gl.glClearColor(0.0f, 0.4f, 0.4f, 0.0f); // set background (clear) color
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
      glu.gluPerspective(45.0, aspect, 0.1, 100.0); // fovy, aspect, zNear, zFar

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


      // Punktene som skal brukes i alle figurene nedenfor
      double[][] punkter = {
        {0.0, 2.0, 0.0},
        {1.5, 1.5, 0.0},
        {2.0, 0.0, 0.0},
        {1.5, -1.5, 0.0},
        {0.0, -2.0, 0.0},
        {-1.5, -1.5, 0.0},
        {-2.0, 0.0, 0.0},
        {-1.5, 1.5, 0.0}
      };
      //--------------------Venstre------------------------

      // Øverst til venstre
      gl.glTranslatef(-1.5f, 4.0f, -15.0f); 

      gl.glBegin(GL2.GL_POINT); 
        for (int i = 0; i < punkter.length; i++) {
          gl.glVertex3dv(punkter[i], 0);
        }
      gl.glEnd();

      // Midt i til venstre
      gl.glTranslatef(-1.5f, 0.0f, -10.0f); 

      gl.glBegin(GL2.GL_LINES); 
        for (int i = 0; i < punkter.length; i++) {
          gl.glVertex3dv(punkter[i], 0);
        }
      gl.glEnd();

      // Nederst til venstre
      gl.glTranslatef(-1.5f, -10.0f, -13.0f); 

      gl.glBegin(GL2.GL_LINE_STRIP); 
        for (int i = 0; i < punkter.length; i++) {
          gl.glVertex3dv(punkter[i], 0);
        }
      gl.glEnd();

      // ---------------------Midten--------------------------

      // Øverst i midten
      gl.glTranslatef(13.0f, 20.0f, -5.0f); 

      gl.glBegin(GL2.GL_LINE_LOOP); 
        for (int i = 0; i < punkter.length; i++) {
          gl.glVertex3dv(punkter[i], 0);
        }
      gl.glEnd();

      // Midt i midten
      gl.glTranslatef(-1.5f, -10.0f, -7.0f); 

      gl.glBegin(GL2.GL_TRIANGLES); 
        for (int i = 0; i < punkter.length; i++) {
          gl.glVertex3dv(punkter[i], 0);
        }
      gl.glEnd();
       

      // Nederst i midten
      gl.glTranslatef(-1.5f, -10.0f, -13.0f); 

      gl.glBegin(GL2.GL_TRIANGLE_STRIP);
        for (int i = 0; i < punkter.length; i++) {
          gl.glVertex3dv(punkter[i], 0);
        }
      gl.glEnd();


    // ---------------------Høyre--------------------------

     // Øverst til høyre
      gl.glTranslatef(22.0f, 23.0f, -1.0f); 

      gl.glBegin(GL2.GL_TRIANGLE_FAN); 
        for (int i = 0; i < punkter.length; i++) {
          gl.glVertex3dv(punkter[i], 0);
        }
      gl.glEnd();

      // Midt til høyre
      gl.glTranslatef(2.0f, -13.0f, -3.0f); 

      gl.glBegin(GL2.GL_QUADS); 
        for (int i = 0; i < punkter.length; i++) {
          gl.glVertex3dv(punkter[i], 0);
        }
      gl.glEnd();

      // Nederst til høyre
      gl.glTranslatef(2.0f, -13.0f, -3.0f); 

      gl.glBegin(GL2.GL_QUAD_STRIP); 
        for (int i = 0; i < punkter.length; i++) {
          gl.glVertex3dv(punkter[i], 0);
        }
      gl.glEnd();

      // Helt til høyre
      gl.glTranslatef(15.0f, 10.0f, -1.0f); 

      gl.glBegin(GL2.GL_POLYGON); 
        for (int i = 0; i < punkter.length; i++) {
          gl.glVertex3dv(punkter[i], 0);
        }
      gl.glEnd();
   }



   /** 
    * Called before the OpenGL context is destroyed. Release resource such as buffers. 
    */
   public void dispose(GLAutoDrawable drawable) { }
   
   /** The entry main() method to setup the top-level JFrame with our OpenGL canvas inside */
   public static void main(String[] args) {
       GLCanvas canvas = new TiFigurer();
       canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
       
       final JFrame frame = new JFrame(); // Swing's JFrame or AWT's Frame
       frame.getContentPane().add(canvas);
       frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//stop program
       frame.setTitle(TITLE);
       frame.pack();
       frame.setVisible(true);      
   }
}
