import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Console;
import java.io.File;
import java.util.Random;

public class GameBoard extends Canvas {
    final private String bushUrl = "src/Resources/Images/bush.png";
    final private String bushLeftUrl = "src/Resources/Images/bushRotateLeft.png";
    final private String bushRightUrl = "src/Resources/Images/bushRotateRight.png";
    final private String pathUrl = "src/Resources/Images/path.png";
    final private String wallUrl = "src/Resources/Images/wall.png";

    final private int numberOfPanels = 2;
    final private int lengthOfPanel = 9;
    private int dX = 240;
    private int sideLength = (9 * numberOfPanels) + 2; // full length plus corners
    private int blockSize;

    private GameBoardSegment[] gameBoardSegments;
    private Hero hero;
    private int gameBoardDesign[][];

    /*end of variables */
    int getBlockSize(){
        return this.blockSize;
    }

    GameBoard(int blockSize){
        this.blockSize = blockSize;
        gameBoardDesign = new int
                [numberOfPanels * lengthOfPanel][numberOfPanels * lengthOfPanel];
        setUpGameBoard();
        //fill entire board
        fillBoard();
        this.hero = createHero();
    }
    public Hero createHero(){
        Random r = new Random();
        int x,y;
        x = r.nextInt(lengthOfPanel * numberOfPanels);
        y = r.nextInt(lengthOfPanel * numberOfPanels);
        while(gameBoardDesign[y][x] != 0){
            x = r.nextInt(lengthOfPanel * numberOfPanels);
            y = r.nextInt(lengthOfPanel * numberOfPanels);
        }
        Hero hero = new Hero(x,y);
        return hero;
    }
    private void fillBoard(){
        for(int i = 0,dx= 0,dy = 0;i< numberOfPanels * numberOfPanels;i++,dx++){// number of all segments to copy
            int[] tmpPattern =  gameBoardSegments[i].getPattern();
            if(i % numberOfPanels == 0 && i != 0){
                dx = 0;
                dy++;
            }
            for(int y = 0;y<lengthOfPanel;y++){
                for(int x = 0; x<lengthOfPanel;x++){
                    gameBoardDesign[y+(lengthOfPanel*dx)][x+(lengthOfPanel*dy)]
                            = tmpPattern[y*lengthOfPanel+x];
                }
            }
        }
    }
    private void setUpGameBoard(){
        gameBoardSegments = new GameBoardSegment[numberOfPanels * numberOfPanels];
        for(int i = 0 ;i < numberOfPanels * numberOfPanels;i++){
            gameBoardSegments[i] = new GameBoardSegment();
        }
    }
    void paintSides(Graphics g){
        Image img;
        //upper line
        img = getToolkit().getImage(bushUrl);
        for(int x =0,y = 0;x<sideLength;x++){
            g.drawImage(img,x * blockSize + dX,y,this);
        }
        //lower line
        for(int x = 0,y = 19 * blockSize;x<sideLength;x++){
            g.drawImage(img,x*blockSize+dX,y,this);
        }
        //left line
        img = getToolkit().getImage(bushLeftUrl);
        for(int x = dX,y = 1;y<sideLength-1;y++){
            g.drawImage(img,x,y*blockSize,this);
        }
        //right line
        img = getToolkit().getImage(bushRightUrl);
        for(int x = dX + 19 * blockSize,y = 1;y<sideLength-1;y++){
            g.drawImage(img,x,y*blockSize,this);
        }
    }
   public void paintSegments(Graphics g){
        Image pathIMG = getToolkit().getImage(pathUrl);
        Image wallIMG = getToolkit().getImage(wallUrl);

        for(int y = 0;y < lengthOfPanel * numberOfPanels;y++){
            for(int x = 0; x < lengthOfPanel * numberOfPanels;x++){
                if(gameBoardDesign[y][x] == 0)
                    g.drawImage(pathIMG,dX + x*blockSize + blockSize  ,y*blockSize + blockSize,this);
                else if(gameBoardDesign[y][x] == 1)
                    g.drawImage(wallIMG,dX + x*blockSize + blockSize,y*blockSize + blockSize,this);
            }
        }
   }
   private void paintHero(Graphics g){
        Image heroIMG = getToolkit().getImage(this.hero.getSkinURL());
        g.drawImage(heroIMG,hero.getPosX()*blockSize + dX + blockSize,
                hero.getPosY()*blockSize + blockSize,this);
   }
   @Override
   public void paint(Graphics g){
       paintSides(g);
       paintSegments(g);
       paintHero(g);
    }
}
