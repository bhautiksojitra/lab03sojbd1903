/**
 * Use some simple graphics from StdDraw to 
 * make a face whose eyeballs follow the mouse.
 */
import java.awt.Color;

public class Watcher{
  
  //X and Y coordinates of the centres of the pieces
  final static double X_LEFT_EYE = 0.4;
  final static double X_CENTRE = 0.5;
  final static double X_RIGHT_EYE = 0.6;
  final static double Y_EYES = 0.75;
  final static double Y_NOSE = 0.65;
  final static double Y_FACE = 0.65;
  
  //The radii of the various circles that make the face
  final static double RADIUS_EYE = .075;
  final static double RADIUS_EYEBALL = .025;
  final static double RADIUS_NOSE = .025;
  final static double RADIUS_FACE = 0.25;
  final static double LASER_WIDTH = 0.2;
  
  //The colours used to draw the components
  final static Color SKIN_TONE = new Color(250, 200, 100);
  final static Color EYE_COLOUR = new Color(255, 255, 255);
  final static Color NOSE_COLOUR = new Color(255, 50, 50);
  final static Color EYEBALL_COLOUR = new Color(0, 50, 50);
  final static Color LASER_COLOUR = new Color(255, 0, 0);
  
  //-----------------------------------------------------------
  
  //the Variables needed
  private static double xMouse, yMouse; //Where the mouse is - coordinates
  private static boolean mouseDown;

  public static void main(String[] args){

    while(true){

      stepUpdate();


      

    }

  }

  public static void stepUpdate(){

    //Get the current mouse position
    xMouse = StdDraw.mouseX();
    yMouse = StdDraw.mouseY();

    // mouse press
    mouseDown = StdDraw.mousePressed();
      
    //Redraw the face each time
    drawFace();      
    //Draw the eyeballs.
    drawEyeball(xMouse,yMouse,X_RIGHT_EYE,Y_EYES);
    drawEyeball(xMouse,yMouse,X_LEFT_EYE,Y_EYES);

    drawLaser(xMouse, yMouse,X_RIGHT_EYE, Y_EYES, mouseDown);
    drawLaser(xMouse, yMouse,X_LEFT_EYE, Y_EYES, mouseDown);
    StdDraw.show(50); // show drawing for 50ms
    StdDraw.clear(); // clear before the next frame. 
  }//main

  private static void drawLaser(double xCoordinateMouse, double yCoordinateMouse, double originX, double originY, boolean isMousePressed){
    if( isMousePressed ){
      StdDraw.setPenColor(LASER_COLOUR);
      StdDraw.setPenRadius(0.05);
      StdDraw.line(originX, originY, xCoordinateMouse, yCoordinateMouse);
    }    
  }

  static void drawFace(){
    StdDraw.setPenColor(SKIN_TONE); StdDraw.filledCircle(X_CENTRE, Y_FACE, RADIUS_FACE);
    StdDraw.setPenColor(NOSE_COLOUR); StdDraw.filledCircle(X_CENTRE, Y_NOSE, RADIUS_NOSE);
    StdDraw.setPenColor(EYE_COLOUR); StdDraw.filledCircle(X_LEFT_EYE, Y_EYES, RADIUS_EYE);
    StdDraw.setPenColor(EYE_COLOUR); StdDraw.filledCircle(X_RIGHT_EYE, Y_EYES, RADIUS_EYE);
  }//drawFace
  
  static void drawEyeball(double xMouse, double yMouse,double xEyeCentre, double yEyeCentre){
    //Find the distance from the eye centre to the mouse
    double distance = Math.sqrt(Math.pow(xMouse-xEyeCentre,2)+Math.pow(yMouse-yEyeCentre,2));
    //Find the portion of that distance to the centre of the eyeball
    double portionOfDistance = (RADIUS_EYE-RADIUS_EYEBALL)/distance;
    //Find the position of the eyeball
    double xEyeball = xEyeCentre+portionOfDistance*(xMouse-xEyeCentre);
    double yEyeball = yEyeCentre+portionOfDistance*(yMouse-yEyeCentre);
    //Draw the eyeball
    StdDraw.setPenColor(EYEBALL_COLOUR);
    StdDraw.filledCircle(xEyeball, yEyeball, RADIUS_EYEBALL);
  }//drawEyeball
  
}//Watcher
