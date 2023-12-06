import java.awt.BorderLayout;

import javax.swing.JFrame;

public class HopscotchGame {

    public static void main(String[] args) {
        int startingWidth = 700;
        int startingHeight = 700;

        JFrame frame = new JFrame(); 
        frame.setSize(startingWidth, startingHeight);
        frame.setTitle("Hopscotch Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        HopscotchBoard hopscotchBoard = new HopscotchBoard();  
        PlayerMove playerMove = new PlayerMove(hopscotchBoard);

        // Use BorderLayout for the frame
        frame.setLayout(new BorderLayout());

        // Add the button to the South region
        frame.add(playerMove.getThrowStoneButton(), BorderLayout.SOUTH);  

        // Add the hopscotchBoard to the Center region
        frame.add(hopscotchBoard, BorderLayout.CENTER);

        frame.setVisible(true);

        System.out.println("The current width of the frame is " + frame.getWidth());
        System.out.println("The current height of the frame is " + frame.getHeight());
    }
}

