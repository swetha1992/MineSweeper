package Minesweeper.Game;

import Minesweeper.Model.Grid;
import Minesweeper.Model.PlayerOption;
import Minesweeper.Utility.ReadPropertyFile;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Class that reads operation from user , inspects the selected square and
 * intimates the result to the user.
 */
public class Play {

    //Constants and error messages used in the code
    String SAFE_MOVE = ReadPropertyFile.getProperty("SAFE_MOVE");
    String ENTER_OPERATION = ReadPropertyFile.getProperty("ENTER_OPERATION");
    String INVALID_OPERATION = ReadPropertyFile.getProperty("INVALID_OPERATION");
    String SQUARE_M = ReadPropertyFile.getProperty("SQUARE_M");
    String SQUARE_X = ReadPropertyFile.getProperty("SQUARE_X");
    String GAME_OVER = ReadPropertyFile.getProperty("GAME_OVER");
    String OPERATION_FLAG = ReadPropertyFile.getProperty("OPERATION_FLAG");
    String OPERATION_OPEN = ReadPropertyFile.getProperty("OPERATION_OPEN");
    String SUCCESS = ReadPropertyFile.getProperty("SUCCESS");
    String result;

    /**
     * Starting point where user starts to inspect each square on the grid.
     * @param grid
     * @throws IOException
     */
    public void startGame(Grid grid) throws IOException {
        grid.printPlayerLayout();
        do {
            result = inspectSquare(grid, readPlayerInput());
            grid.printPlayerLayout();
        } while (result.equals(SAFE_MOVE));
        System.out.println(result);

    }

    /**
     * reads player operation from user.
     * @return
     */
    public PlayerOption readPlayerInput() {
        System.out.println(ENTER_OPERATION);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String playerInput = null;
        int playerSelectionX = 0;
        int playerSelectionY = 0;
        String operation = null;
        try {
            playerInput = br.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(playerInput, "(");
            while (stringTokenizer.hasMoreTokens()) {
                operation = stringTokenizer.nextToken();
                StringTokenizer stringTokenizer1 = new StringTokenizer(stringTokenizer.nextToken(), ",");
                while (stringTokenizer1.hasMoreTokens()) {
                    playerSelectionX = Integer.parseInt(stringTokenizer1.nextToken());
                    playerSelectionY = Integer.parseInt(stringTokenizer1.nextToken().replace(")", ""));
                }
            }
        } catch (Exception e) {
            System.out.println(INVALID_OPERATION);
            readPlayerInput();
        }
        PlayerOption playerOption = new PlayerOption(playerSelectionX, playerSelectionY, operation);
        if (!playerOption.isvalidOperation()) {
            System.out.println(INVALID_OPERATION);
            readPlayerInput();
        }
        return playerOption;
    }

    /**
     * Function inspects grid for the specified player operation.
     * @param grid
     * @param playerOption
     * @return
     * @throws IOException
     */

    public String inspectSquare(Grid grid, PlayerOption playerOption) throws IOException {
        String status = INVALID_OPERATION;
        char value = grid.getValueAt(playerOption.getPlayerSelectionX(),
                playerOption.getPlayerSelectionY(),
                grid.getMineFieldLayout(), grid.getDimension());
        char valueToReplace = ' ';
        if (playerOption.getOperation().equals(OPERATION_OPEN)) {
            if (value == SQUARE_M.charAt(0)) {
                valueToReplace = SQUARE_M.charAt(0);
                status = GAME_OVER;
            } else {
                valueToReplace = value;
                status = SAFE_MOVE;
            }
        } else if (playerOption.getOperation().equals(OPERATION_FLAG)) {
            valueToReplace = OPERATION_FLAG.charAt(0);
            status = SAFE_MOVE;
        }
        grid.replaceValueAtPlayerLayout(playerOption.getPlayerSelectionX(),
                playerOption.getPlayerSelectionY(), valueToReplace);
        if (checkSuccessScenario(grid)) {
            status = SUCCESS;
            grid.getPlayerLayout().forEach(square -> {if(square.getValue()==SQUARE_X.charAt(0))
                                                        square.setValue(SQUARE_M.charAt(0));});
        }
        return status;
    }

    /**
     * looks for the scenario if player has opened all the fields for the game to end.
     * @param grid
     * @return
     */
    public Boolean checkSuccessScenario(Grid grid) {
        int countOfMines = (int) grid.getMineFieldLayout().stream().filter(square -> square.getValue() == SQUARE_M.charAt(0)).count();
        int countOfUnOpenedSquares = (int) grid.getPlayerLayout().stream().filter(square -> square.getValue() == SQUARE_X.charAt(0)).count();
        return countOfMines == countOfUnOpenedSquares;
    }
}
