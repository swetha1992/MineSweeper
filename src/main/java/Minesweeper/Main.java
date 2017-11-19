package Minesweeper;

import Minesweeper.Game.LayoutBuilder;
import Minesweeper.Game.Play;
import Minesweeper.Model.Grid;

import java.io.IOException;

/**
 * IDEA :
 *
 * mineFieldLayout - will have all the squares filled with either 'm' (indicating mine) or
 *                   count of adjacent mines.
 *
 * playerLayout - will have all the squares filled with value 'x' as default.
 *
 * LayoutBuilder reads value from user and builds the above two layouts.
 *
 * This two are then given to Grid with witch the game starts.
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        LayoutBuilder layoutBuilder = new LayoutBuilder();
        Grid grid = new Grid(layoutBuilder.buildMineFieldLayout(),
                layoutBuilder.buildPlayerLayout(),
                layoutBuilder.getDimension());
        Play game= new Play();
        game.startGame(grid);
    }
}
