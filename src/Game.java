import javax.swing.*;

public class Game extends JFrame{
    private final String version = "0.1";
    private final String gameName = "Health Maze";
    private int screenHeight = 1024;
    private int screenWidth = 1280;
    private final int blockPixelWidth = 40;
    private final int blockNumberPerSegment = 9;
    private GameBoard gameBoard;

    public int getBlockPixelWidth() {
        return blockPixelWidth;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public Game(){
        GameBoardSegment.setBlockNumber(blockNumberPerSegment);
        GameBoardSegment.getSegmentPatterns();
        this.gameBoard = new GameBoard(getBlockPixelWidth());
        initWindows();
    }

    private void initWindows(){

        add(getGameBoard());
        pack();
        setTitle(gameName + " " + version);
        setSize(screenWidth,screenHeight);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }



    public static void main(String[] args){
        Game game = new Game();
        game.setVisible(true);
    }

}
