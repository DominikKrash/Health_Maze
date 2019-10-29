import javax.swing.*;

public class Game extends JFrame {
    private final String version = "0.1";
    private final String gameName = "Health Maze";
    private int screenHeight = 1024;
    private int screenWidth = 1280;


    //initalizing all default values to window
    private void initWindows(){
        setTitle(gameName + " " + version);
        setSize(screenWidth,screenHeight);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public Game(){
        initWindows();
    }

    public static void main(String[] args){
        Game game = new Game();
        game.setVisible(true);
    }
}
