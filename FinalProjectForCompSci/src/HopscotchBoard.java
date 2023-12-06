import javax.swing.*;
import java.awt.*;
//import java.util.Random;

public class HopscotchBoard extends JPanel {
    private int[][] board;
    private int playerPosition;
    private int stonePosition;
    private int currentRound;
     
    public HopscotchBoard() {
        board = new int[2][6];
        showBoard();
        setLayout(new FlowLayout()); // Add this line to set the layout manager
    playerPosition = -4;
    stonePosition = -1;
    currentRound = 0;

       // playerPosition = -4;
       // stonePosition = -1;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }
// i have to change this method for the rounds
public int throwStone() {
    stonePosition++;
    if (stonePosition >= 12 * (currentRound + 1)) {
        stonePosition = -1;
        currentRound++; 
    }
    repaint();  
    return stonePosition;
}
// if its inside the rectangle 
    public boolean stoneInside(int stonePosition2 ) {
        int row = stonePosition / 6;
        int col = stonePosition % 6;
        return row == 0 && col % 2 == 0;     
    }
// on the line 
    public boolean stoneOnLine(int stonePosition2) {
        int row = stonePosition / 6;
        int col = stonePosition % 6;
        return row == 0 && col % 2 == 1;
    }

    /*  public void stone location(){
if( )
    }*/
    
// to get the player position 
    public void updatePlayerPosition(int newPosition) {
        playerPosition = newPosition;
    }

    private void showBoard () {
        // this is showing the numbering on the board 
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
              board[i][j] =    +i * 6 + j + 1;
            }
        }
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);
        drawPlayer(g);
        drawStone(g);
    }
// shows the rectangles 
    public void drawBoard(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        /*int cellSize = 100;
        int boardWidth = getWidth();
        int boardHeight = getHeight();
    
        // Center the board
        int xOffset = (boardWidth - 6 * cellSize) / 2;
        int yOffset = (boardHeight - 2 * cellSize) / 2;
    
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                int x = xOffset + j * cellSize;
                int y = yOffset + i * cellSize;
    
                // Make rectangles a little bigger
                int enlargedSize = cellSize + 20;  // Adjust the enlargement factor as needed
                g.drawRect(x, y, enlargedSize, enlargedSize);
               // g.drawString(String.valueOf(board[i][j]), x + 20, y + 30);
            }
        }*/
        int x1 = 130;
        int y1 = 50;
        int w1 = 90;
        int h1 = 140;
        Rectangle box1 = new Rectangle(x1,y1,w1,h1); // constructs a new object of type Rectangle.
        g2.draw(box1);

     
    }
    

    public void drawPlayer(Graphics g) {     
        int cellSize = 50;
        int row = playerPosition / 6;  
        int col = playerPosition % 6;

        // Center the player
        int xOffset = (getWidth() - 6 * cellSize) / 2;
        int yOffset = (getHeight() - 2 * cellSize) / 2;

        int x = xOffset + col * cellSize;
        int y = yOffset + row * cellSize;

        g.setColor(Color.RED);
        g.fillOval(x + 10, y + 10, cellSize - 20, cellSize - 20);
        g.setColor(Color.BLACK);
    }
// the stone is black 
    private void drawStone(Graphics g) {
        if (stonePosition != -1) {
            int cellSize = 50;
            int row = stonePosition / 6;   
            int col = stonePosition % 6;
    
            // Center the stone
            int xOffset = (getWidth() - 6 * cellSize) / 2;
            int yOffset = (getHeight() - 2 * cellSize) / 2;
    
            int x = xOffset + col * cellSize;
            int y = yOffset + row * cellSize;
    
            g.setColor(Color.BLACK);
            g.fillOval(x + 5, y + 5, cellSize - 10, cellSize - 10);  
          // g.setColor(Color.BLACK);  
        }
    }
    


}
