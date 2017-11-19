package Minesweeper.Model;

/**
 * Class that represents each square in a grid.
 * It has (x,y) and corresponding value.
 */
public class Square {
    /**
     * constructor
     * @param positionX
     * @param positionY
     * @param value
     */
    public Square(int positionX, int positionY, char value) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.value = value;
    }

    private int positionX;
    private int positionY;
    private char value;

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
}
