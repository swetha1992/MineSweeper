# MineSweeper

Problem Statement :
The objective of the Minesweeper game is to clear an abstract minefield without detonating a land mine. The player is initially presented with a n*n grid of squares. Some randomly-selected squares, unknown to the player, are designated to contain mines. 

On each turn, the player has to select a square (x,y) by indicating if it contains a mine (flagging) or if it is safe, thereby opening it. If the square containing a mine is revealed, the player loses the game. If it does not contain a mine, a digit is instead displayed in the square, indicating how many adjacent squares contain mines; if no mines are adjacent, the square diplays '0'. Two squares are adjacent to each other only if they share atleast one side.

The player uses this information to deduce the contents of other squares, and may either safely reveal each square or flag the square as containing a mine. The game is won when all mine-free squares are revealed, because all mines have been located.

## Class Diagram :
![MineSweeper - Class Diagram ](MineSweeper.png?raw=true "Optional Title")

## Logic :

Grid - Grid has mineLayout, playerLayout and Dimension.Layouts are a list squares present int the grid.
       Grid has two layouts :
       1. minelayout which is a blue print of actual mine map.
       2. player layout which gets updated as the player inspects each square.
 
 Square - Square represents each square in a grid. It has (x,y) and a corresponding value.
 
 PlayerOption - PlayerOption represents each option specified by the player.
                It has option (o or f which is open/Flag ) to be performed at (x,y)
                
 Play - Inspects the selected square and intimates the result to the user.
 
 LayoutBuilder - Builds mineFieldLayout and playerLayout reading input given by the player.

## Sample Scenarios
### Successful Game
![MineSweeper - successfulgame](SampleScenarios/successfulgame.png?raw=true "Optional Title")

### Unsuccessful Game
![MineSweeper - gameover ](SampleScenarios/gameover.png?raw=true "Optional Title")

### Flagging
![MineSweeper - flag ](SampleScenarios/flag.png?raw=true "Optional Title")

### Invalid Layout
![MineSweeper - Class Diagram ](SampleScenarios/InvalidLayout.png?raw=true "Optional Title")
