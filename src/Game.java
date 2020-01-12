import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame  {
    private final String version = "0.5";
    private final String gameName = "Health Maze";
    private int screenHeight = 1024;
    private int screenWidth = 1280;
    private final int blockPixelWidth = 40;
    private final int blockNumberPerSegment = 9;

    public static JLabel timerLabel;
    private GameBoard gameBoard;
    private GameTimer gameTimer;
    private int gameTimeDuration = 10;

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
        gameTimer = new GameTimer(gameTimeDuration);
        gameTimer.start();
        initWindows();
    }

    private void initWindows(){
        setLayout(null);
        getGameBoard().setBounds(0,0,1200,800);
        add(timerLabel);
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
