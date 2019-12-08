import javax.swing.*;

public class Game extends JFrame{
    private final String version = "0.1";
    private final String gameName = "Health Maze";
    private int screenHeight = 1024;
    private int screenWidth = 1280;
    private final int blockPixelWidth = 32;
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
        this.gameBoard = new GameBoard();
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
