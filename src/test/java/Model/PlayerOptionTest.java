package Model;

import Minesweeper.Model.PlayerOption;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PlayerOptionTest {

    @Test
    public void shouldReturnTrueForValidPlayerOptionOpen(){
        PlayerOption playerOption=new PlayerOption();
        playerOption.setOption("o");
        playerOption.setPlayerSelectionX(1);
        playerOption.setPlayerSelectionY(2);
        Assert .assertTrue(playerOption.isvalidOperation());
    }
    @Test
    public void shouldReturnTrueForValidPlayerOptionFlag(){
        PlayerOption playerOption=new PlayerOption();
        playerOption.setOption("f");
        playerOption.setPlayerSelectionX(1);
        playerOption.setPlayerSelectionY(2);
        Assert .assertTrue(playerOption.isvalidOperation());
    }
    @Test
    public void shouldReturnTrueForInValidPlayerOption(){
        PlayerOption playerOption=new PlayerOption();
        playerOption.setOption("ssss");
        playerOption.setPlayerSelectionX(1);
        playerOption.setPlayerSelectionY(2);
        Assert .assertFalse(playerOption.isvalidOperation());
    }
}