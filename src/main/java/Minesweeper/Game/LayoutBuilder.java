package Minesweeper.Game;

import Minesweeper.Model.Square;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * Class Builds mineFieldLayout and playerLayout.
 *
 * MineFieldLayout - buildMineFieldLayout function
 * reads the player input and builds the MineLayout filling all the
 * squares with either 'm' or the count of adjacent mines.
 *
 * playerLayout - buildplayerLayout function fills the player
 * layout with value 'x' as default.
 *
 *
 */
public class LayoutBuilder {
    private List<Square> mineFieldLayout = new ArrayList<>();
    private List<Square> playerLayout = new ArrayList<>();
    private int dimension;

    public int getDimension() { return dimension; }

    /**
     * Function that builds MineFieldLayout.
     * @return
     * @throws IOException
     */
    public List<Square> buildMineFieldLayout() throws IOException {
        readMineFieldLayout();
        mineFieldLayout.forEach(square -> {
            if (square.getValue() != 'm')
                square.setValue(String.valueOf(countOfAdjacentMines(square)).charAt(0));
        });
        return mineFieldLayout;
    }

    /**
     * Function that builds playerLayout.
     * @return
     */
    public List<Square> buildPlayerLayout() {
        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                Square square = new Square(row, col, 'x');
                playerLayout.add(square);
            }
        }
        return playerLayout;
    }

    /**
     * Function that reads user input (MineLayout).
     * @throws IOException
     */
    public void readMineFieldLayout() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Specify Mine Field Layout");
        String layout = br.readLine();
        List<String> layoutArray = new ArrayList<String>();
        StringTokenizer stringTokenizer = new StringTokenizer(layout, ",");
        while (stringTokenizer.hasMoreTokens()) {
            layoutArray.add(stringTokenizer.nextToken());
        }
        dimension = layoutArray.size();
        if (!(layoutArray.stream().filter(row -> row.length() != dimension).count() > 0)) {
            for (int row = 0; row < dimension; row++) {
                for (int col = 0; col < dimension; col++) {
                    Square square = new Square(row, col, layoutArray.get(row).charAt(col));
                    mineFieldLayout.add(square);
                }
            }
        } else {
            System.out.println("Invalid Layout");
            System.exit(0);
        }
    }

    /**
     * Function that calculates count of adjacent mines for a particular square.
     * @param square
     * @return
     */
    public int countOfAdjacentMines(Square square) {
        List<Character> adjacentValues = new ArrayList<Character>();
        adjacentValues.add(getMineFieldValueAt(square.getPositionX(), square.getPositionY() - 1));
        adjacentValues.add(getMineFieldValueAt(square.getPositionX() + 1, square.getPositionY()));
        adjacentValues.add(getMineFieldValueAt(square.getPositionX() - 1, square.getPositionY()));
        adjacentValues.add(getMineFieldValueAt(square.getPositionX(), square.getPositionY() + 1));
        return Collections.frequency(adjacentValues, 'm');
    }

    /**
     * Function that returns value at particular square given x,y.
     * @param positionX
     * @param positionY
     * @return
     */
    public char getMineFieldValueAt(int positionX, int positionY) {
        if (positionX >= 0 && positionX < dimension
                && positionY >= 0 && positionY < dimension) {
            return mineFieldLayout.stream().filter(square -> square.getPositionX() == positionX &&
                    square.getPositionY() == positionY).findAny().orElse(null).getValue();
        }
        return '0';
    }
}
