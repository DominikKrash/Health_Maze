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
    private int gameTimeDuration = 3;

    public int getBlockPixelWidth() {
        return blockPixelWidth;
    }

    public GameTimer getGameTimer() {
        return gameTimer;
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
        gameTimer = new GameTimer(gameTimeDuration,this);
        initWindows();
    }

    public int startNewGame(){
        this.setVisible(false);
        int select = JOptionPane.showOptionDialog(null,
                "Koniec gry, gramy jeszcze?", "Gotowy?", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, null, null);
        if (select == JOptionPane.OK_OPTION) {
            this.gameBoard.resetGameBoard();
            this.setVisible(true);
            return 1;
        } else if (select == JOptionPane.CANCEL_OPTION) {
            dispose();
            System.exit(0);
            return 0;
        }
        return 0;
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
            int start = JOptionPane.showOptionDialog(null,
                    "Jestes gotowy?", "Gotowy?", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, null, null);
            if (start == JOptionPane.OK_OPTION) {
                game.getGameTimer().start();
            } else if (start == JOptionPane.CANCEL_OPTION) {
                game.dispose();
                System.exit(0);
            }
            game.setVisible(true);

    }

}
