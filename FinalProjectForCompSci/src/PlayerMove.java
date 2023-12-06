/*import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerMove {
    private HopscotchBoard hopscotchBoard;
    private JButton throwStoneButton;

    public PlayerMove(HopscotchBoard hopscotchBoard) {
        this.hopscotchBoard = hopscotchBoard;

        throwStoneButton = new JButton("Throw Stone");
        throwStoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simulatePlayerMove();
            }
        });
    }

    public JButton getThrowStoneButton() {
        return throwStoneButton;
    }

    public void simulatePlayerMove() {
        int stonePosition = hopscotchBoard.throwStone();
        int playerPosition = hopscotchBoard.getPlayerPosition();
    
        if (hopscotchBoard.isStoneInsideRectangle(stonePosition)) {
            playerPosition++;
        } else if (hopscotchBoard.isStoneOnRectangleLine(stonePosition)) {
            // Player stays in the same position or goes back one position
            playerPosition = Math.max(0, playerPosition - 1);
        }
    
        hopscotchBoard.updatePlayerPosition(playerPosition);
        hopscotchBoard.repaint();
    }
}*/
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerMove {
    private HopscotchBoard hopscotchBoard;
    private JButton throwStoneButton;

    public PlayerMove(HopscotchBoard hopscotchBoard) {
        this.hopscotchBoard = hopscotchBoard;

        throwStoneButton = new JButton("Throw Stone");
        throwStoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simulatePlayerMove();
            }
        });

        // Add the button to the hopscotchBoard
      //  hopscotchBoard.throwStone(throwStoneButton);
    }

    public JButton getThrowStoneButton() {
        return throwStoneButton;
    }

    public void simulatePlayerMove() {
        int stonePosition = hopscotchBoard.throwStone();
        int playerPosition = hopscotchBoard.getPlayerPosition();
    
        if (hopscotchBoard.stoneInside(stonePosition)) {
            playerPosition++;
        } else if (hopscotchBoard.stoneOnLine(stonePosition)) {
            // Player stays in the same position or goes back one position
            playerPosition = Math.max(0, playerPosition - 1);
        }
    
        hopscotchBoard.updatePlayerPosition(playerPosition);
        hopscotchBoard.repaint();
    }
}

