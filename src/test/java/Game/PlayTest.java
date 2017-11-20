package Game;

import Minesweeper.Game.Play;
import Minesweeper.Model.Grid;
import Minesweeper.Model.PlayerOption;
import Minesweeper.Model.Square;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class PlayTest {

    List<Square> mineFieldLayout = new ArrayList<>();
    @Before
    public void setUp(){
        int dimension =4;


        mineFieldLayout.add(new Square(0,0,'0'));
        mineFieldLayout.add(new Square(0,1,'1'));
        mineFieldLayout.add(new Square(1,0,'1'));
        mineFieldLayout.add(new Square(1,1,'m'));

    }

    @Test
    public void shouldReturnSafeMoveFor00() throws IOException {
        List<Square> playerLayout = new ArrayList<>();
        playerLayout.add(new Square(0,0,'x'));
        playerLayout.add(new Square(0,1,'x'));
        playerLayout.add(new Square(1,0,'x'));
        playerLayout.add(new Square(1,1,'x'));

        PlayerOption playerOption = new PlayerOption();
        playerOption.setPlayerSelectionX(0);
        playerOption.setPlayerSelectionY(0);
        playerOption.setOption("o");
        Grid grid=new Grid(mineFieldLayout,playerLayout,4);
        Play play = new Play();
        Assert.assertEquals("SAFE_MOVE",play.inspectSquare(grid,playerOption));

    }

    @Test
    public void shouldReturnSafeMovefor01() throws IOException {
        List<Square> playerLayout = new ArrayList<>();
        playerLayout.add(new Square(0,0,'x'));
        playerLayout.add(new Square(0,0,'x'));
        playerLayout.add(new Square(0,0,'x'));
        playerLayout.add(new Square(0,0,'x'));

        PlayerOption playerOption = new PlayerOption();
        playerOption.setPlayerSelectionX(0);
        playerOption.setPlayerSelectionY(1);
        playerOption.setOption("o");
        Grid grid=new Grid(mineFieldLayout,playerLayout,4);
        Play play = new Play();
        System.out.println(play.inspectSquare(grid,playerOption));
        Assert.assertEquals("SAFE_MOVE",play.inspectSquare(grid,playerOption));

    }

    @Test
    public void shouldReturnGameOverfor11() throws IOException {
        List<Square> playerLayout = new ArrayList<>();
        playerLayout.add(new Square(0,0,'x'));
        playerLayout.add(new Square(0,0,'x'));
        playerLayout.add(new Square(0,0,'x'));
        playerLayout.add(new Square(0,0,'x'));

        PlayerOption playerOption = new PlayerOption();
        playerOption.setPlayerSelectionX(1);
        playerOption.setPlayerSelectionY(1);
        playerOption.setOption("o");
        Grid grid=new Grid(mineFieldLayout,playerLayout,4);
        Play play = new Play();
        Assert.assertEquals("Oops!! You Steps On A Mine! GAME OVER.",play.inspectSquare(grid,playerOption));

    }

    @Test
    public void shouldReturnSafeMove10() throws IOException {
        List<Square> playerLayout = new ArrayList<>();
        playerLayout.add(new Square(0,0,'x'));
        playerLayout.add(new Square(0,0,'x'));
        playerLayout.add(new Square(0,0,'x'));
        playerLayout.add(new Square(0,0,'x'));

        PlayerOption playerOption = new PlayerOption();
        playerOption.setPlayerSelectionX(1);
        playerOption.setPlayerSelectionY(0);
        playerOption.setOption("o");
        Grid grid=new Grid(mineFieldLayout,playerLayout,4);
        Play play = new Play();
        Assert.assertEquals("SAFE_MOVE",play.inspectSquare(grid,playerOption));

    }
}
