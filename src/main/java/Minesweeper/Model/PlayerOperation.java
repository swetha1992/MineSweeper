package Minesweeper.Model;

import Minesweeper.Utility.ReadPropertyFile;

/**
 * Class the represents each operation specified by the player.
 * It has operation (o or f which is open/Flag ) to be performed at (x,y)
 */
public class PlayerOperation {
    int playerSelectionX;
    int playerSelectionY;
    String operation;

    /**
     * Constructor
     * @param playerSelectionX
     * @param playerSelectionY
     * @param operation
     */
    public PlayerOperation(int playerSelectionX, int playerSelectionY, String operation) {
        this.playerSelectionX = playerSelectionX;
        this.playerSelectionY = playerSelectionY;
        this.operation = operation;
    }

    public int getPlayerSelectionX() {
        return playerSelectionX;
    }

    public int getPlayerSelectionY() {
        return playerSelectionY;
    }

    public String getOperation() {
        return operation;
    }

    /**
     * validate a operation .
     * @return
     */
    public Boolean isvalidOperation() {
        String OPERATION_FLAG = ReadPropertyFile.getProperty("OPERATION_FLAG");
        String OPERATION_OPEN = ReadPropertyFile.getProperty("OPERATION_OPEN");
        if (operation.equals(OPERATION_FLAG) || operation.equals(OPERATION_OPEN)) {
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }
    }
}
