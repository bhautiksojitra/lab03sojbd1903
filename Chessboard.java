/**
 * Draw a chessboard.
 */
public class Chessboard {
  
  // Start 
  public static void main(String[] args) { 
    
    // board size - square tiles
    final int BOARD_SIZE = 8;
    

    for( int row = 0; row < BOARD_SIZE; row++ )
      for( int col = 0; col < BOARD_SIZE; col++ ){
        if( 0 == ( row + col ) %2 )
          StdDraw.setPenColor(StdDraw.BLACK);
        else
          StdDraw.setPenColor(StdDraw.WHITE);
        
        StdDraw.filledRectangle(( 2 * col + 1 )/( 2.0 * BOARD_SIZE ),
                                ( 2 * row + 1 )/( 2.0*BOARD_SIZE ),
                                0.5 / BOARD_SIZE, 0.5 / BOARD_SIZE);
    }//both for loops
    
    // High End Graphics
    //It would look better with a border around it.
    StdDraw.line(0,0,1,0);
    StdDraw.line(1,0,1,1);
    StdDraw.line(1,1,0,1);
    StdDraw.line(0,1,0,0);
    
  }//main
  
}//Chessboard
