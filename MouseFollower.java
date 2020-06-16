/*************************************************************************
  *
  *  Draw circles that follow the mouse, using
  *  BLUE if the mouse is pressed, CYAN if not
  *  
  *************************************************************************/

public class MouseFollower {
  
  public static void main(String[] args) {
    
    final double RADIUS = 0.05; //Circle radius
    
    StdDraw.show(0); //Turn on "animation mode"
    
    while (true) {
      
      //Pick a colour depending on the mouse button.
      if (StdDraw.mousePressed())
        StdDraw.setPenColor(StdDraw.BLUE);
      else                      
        StdDraw.setPenColor(StdDraw.CYAN);
      
      //Draw the circle at the mouse location
      double x = StdDraw.mouseX();
      double y = StdDraw.mouseY();
      StdDraw.filledCircle(x, y, RADIUS);
      
      //Animate
      StdDraw.show(10); //This is 100 frames per second.
    }
  }
}
