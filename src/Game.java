import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame  {
    private final String version = "0.8";
    private final String gameName = "Health Maze";
    private int screenHeight = 1024;
    private int screenWidth = 1280;
    private final int blockPixelWidth = 40;
    private final int blockNumberPerSegment = 9;

    public static JLabel timerLabel;
    public static JLabel pointsLabel;
    public static JLabel foodInfo;

    private GameBoard gameBoard;
    private GameTimer gameTimer;
    private int gameTimeDuration = 60;
    private int points;

    public void setPoints(int dPoints) {
        this.points += dPoints;
        pointsLabel.setText("Punkty: " + this.points);
    }

    public int getPoints() {
        return points;
    }
    public void setNewTime(long dTime){
        this.gameTimer.setTime(gameTimer.getTime() + dTime);
    }
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
        this.points = 0;
        this.gameBoard = new GameBoard(getBlockPixelWidth(),this);
        gameTimer = new GameTimer(gameTimeDuration,this);
        initWindows();
    }

    public int startNewGame(){
        this.setVisible(false);
        int select = JOptionPane.showOptionDialog(null,
                "Koniec gry,uzyskales: "+this.points+"pkt, gramy jeszcze?", "Gotowy?", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, null, null);
        if (select == JOptionPane.OK_OPTION) {
            this.gameBoard.resetGameBoard();
            this.points = 0;
            pointsLabel.setText("Punkty: " + this.points);
            this.setVisible(true);
            return 1;
        } else if (select == JOptionPane.CANCEL_OPTION) {
            dispose();
            System.exit(0);
            return 0;
        }
        return 0;
    }

    private void setPointsLabel(){
        pointsLabel = new JLabel("Punkty: " + this.points);
        pointsLabel.setForeground(Color.BLACK);
        pointsLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,26));
        Dimension d = Game.timerLabel.getPreferredSize();
        pointsLabel.setBounds(20,440,220,26);
    }
    private void setFoodInfo(){
        foodInfo = new JLabel("Zbierz jedzenie!");
        foodInfo.setForeground(Color.BLACK);
        foodInfo.setFont(new Font(Font.SANS_SERIF,Font.BOLD,26));
        Dimension d = Game.foodInfo.getPreferredSize();
        foodInfo.setBounds(1060,140,220,400);
    }
    private void initWindows(){
        setPointsLabel();
        setFoodInfo();
        setLayout(null);
        getGameBoard().setBounds(0,0,1200,800);
        add(pointsLabel);
        add(timerLabel);
        add(foodInfo);
        add(getGameBoard());
        pack();
        setTitle(gameName + " " + version);
        setSize(screenWidth,screenHeight);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public void setFoodInfo(String text,int type){
        foodInfo.setText(text);
        if(type < 0)
            foodInfo.setForeground(Color.RED);
        else if(type > 0 ){
            foodInfo.setForeground(new Color(0,128,0));

        }
        Dimension d = Game.foodInfo.getPreferredSize();
        foodInfo.setBounds(1060,140,220,400);
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
