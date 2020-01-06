import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class GameBoard extends Canvas {
    final private String bushUrl = "src/Resources/Images/bush.png";
    final private String bushLeftUrl = "src/Resources/Images/bushRotateLeft.png";
    final private String bushRightUrl = "src/Resources/Images/bushRotateRight.png";
    final private int numberOfPanels = 2;
    final private int lengthOfPanel = 9;
    private int dX = 240;
    private int sideLength = (9 * numberOfPanels) + 2; // full length plus corners
    private int blockSize;
    int getBlockSize(){
        return this.blockSize;
    }

    GameBoard(int blockSize){
        this.blockSize = blockSize;
    }
   public void paint(Graphics g){
        Image img;
       //upper line
       img = getToolkit().getImage(bushUrl);
       for(int x =0,y = 0;x<20;x++){
           g.drawImage(img,x * blockSize + dX,y,this);
       }
       //lower line
       for(int x = 0,y = 19 * blockSize;x<20;x++){
           g.drawImage(img,x*blockSize+dX,y,this);
       }
       //left line
       img = getToolkit().getImage(bushLeftUrl);
       for(int x = dX,y = 1;y<19;y++){
           g.drawImage(img,x,y*blockSize,this);
       }
       //right line
       img = getToolkit().getImage(bushRightUrl);
        for(int x = dX + 19 * blockSize,y = 1;y<19;y++){
            g.drawImage(img,x,y*blockSize,this);
        }
    }
}
