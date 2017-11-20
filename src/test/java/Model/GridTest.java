package Model;

import Minesweeper.Model.Grid;
import Minesweeper.Model.Square;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class GridTest {

    List<Square> layout = new ArrayList<>();
    @Before
    public void setUp(){
        int dimension =4;
        int count =0;
        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                char value = String.valueOf(count++).charAt(0);
                Square square = new Square(row, col, value);
                layout.add(square);
            }
        }
    }
    @Test
    public void shouldReturnValueAtPosition00(){
        Grid grid=new Grid(layout,layout,4);
        char value = grid.getValueAt(0,0,layout,4);
        Assert.assertEquals('0',value);
    }
    @Test
    public void shouldReturnValueAtPosition01(){
        Grid grid=new Grid(layout,layout,4);
        char value = grid.getValueAt(0,1,layout,4);
        Assert.assertEquals('1',value);
    }
    @Test
    public void shouldReturnValueAtPosition10(){
        Grid grid=new Grid(layout,layout,4);
        char value = grid.getValueAt(1,0,layout,4);
        Assert.assertEquals('4',value);
    }

}
