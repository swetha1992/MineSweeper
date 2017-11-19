package Minesweeper.Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Grid has mineLayout, playerLayout and Dimension.
 *
 *  Layouts are a list squares present int the grid.
 *  The grid has two layouts :
 *
 *  1. minelayout which is a blue print of actual mine map.
 *  2. player layout which gets updated as the player inspects each square.
 *
 */
public class Grid {
    private List<Square> mineFieldLayout = new ArrayList<>();
    private List<Square> playerLayout = new ArrayList<>();
    private int dimension;

    /**
     * constructor
     * @param mineFieldLayout
     * @param playerLayout
     * @param dimension
     */
    public Grid(List<Square> mineFieldLayout, List<Square> playerLayout, int dimension) {
        this.mineFieldLayout = mineFieldLayout;
        this.playerLayout = playerLayout;
        this.dimension = dimension;
    }
    public List<Square> getMineFieldLayout() {
        return mineFieldLayout;
    }
    public List<Square> getPlayerLayout() {
        return playerLayout;
    }
    public int getDimension() {
        return dimension;
    }
    /**
     * prints player layout in 2D form.
     * @throws IOException
     */
    public void printPlayerLayout() throws IOException {
        int count = 1;
        for (Square square : getPlayerLayout()) {
            System.out.print(square.getValue());
            if (count % getDimension() == 0) {
                System.out.print("\n");
            }
            count++;
        }
    }

    /**
     * Gets value present at particular square.
     * @param positionX
     * @param positionY
     * @param layout
     * @param dimension
     * @return
     */
    public char getValueAt(int positionX, int positionY, List<Square> layout, int dimension) {
        if (positionX >= 0 && positionX < dimension
                && positionY >= 0 && positionY < dimension) {
            return layout.stream().filter(square -> square.getPositionX() == positionX &&
                    square.getPositionY() == positionY).findAny().orElse(null).getValue();
        }
        return '0';
    }

    /**
     * Replaces value at mentioned position in player Layout.
     * @param userPositionX
     * @param userPositionY
     * @param value
     */
    public void replaceValueAtPlayerLayout(int userPositionX, int userPositionY, char value) {
        getPlayerLayout().forEach(square -> {
            if (square.getPositionX() == userPositionX
                    && square.getPositionY() == userPositionY)
                square.setValue(value);
        });
    }
}
