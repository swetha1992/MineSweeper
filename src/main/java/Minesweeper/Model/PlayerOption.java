package Minesweeper.Model;

import Minesweeper.Utility.ReadPropertyFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

/**
 * Class the represents each operation specified by the player.
 * It has operation (o or f which is open/Flag ) to be performed at (x,y)
 */
public class PlayerOption {

    String ENTER_OPERATION = ReadPropertyFile.getProperty("ENTER_OPERATION");
    String INVALID_OPERATION = ReadPropertyFile.getProperty("INVALID_OPERATION");
    int playerSelectionX;
    int playerSelectionY;
    String option;

    public int getPlayerSelectionX() {
        return playerSelectionX;
    }
    public int getPlayerSelectionY() {
        return playerSelectionY;
    }
    public String getOption() {
        return option;
    }

    /**
     * validate a operation .
     * @return
     */
    public Boolean isvalidOperation() {
        String OPERATION_FLAG = ReadPropertyFile.getProperty("OPERATION_FLAG");
        String OPERATION_OPEN = ReadPropertyFile.getProperty("OPERATION_OPEN");
        if (option.equals(OPERATION_FLAG) || option.equals(OPERATION_OPEN)) {
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }
    }
    /**
     * reads player option from user.
     * @return
     */
    public void readPlayerOption() {
        System.out.println(ENTER_OPERATION);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String playerInput = null;
        try {
            playerInput = br.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(playerInput, "(");
            while (stringTokenizer.hasMoreTokens()) {
                option = stringTokenizer.nextToken();
                StringTokenizer stringTokenizer1 = new StringTokenizer(stringTokenizer.nextToken(), ",");
                while (stringTokenizer1.hasMoreTokens()) {
                    playerSelectionX = Integer.parseInt(stringTokenizer1.nextToken());
                    playerSelectionY = Integer.parseInt(stringTokenizer1.nextToken().replace(")", ""));
                }
            }
        } catch (Exception e) {
            System.out.println(INVALID_OPERATION);
            readPlayerOption();
        }
        if (!isvalidOperation()) {
            System.out.println(INVALID_OPERATION);
            readPlayerOption();
        }
    }
}
