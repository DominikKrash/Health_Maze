import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class GameBoard extends Canvas {
    final private String bushUrl = "src/Resources/Images/bush.jpg";
    final private String bushLeftUrl = "src/Resources/Images/bush_rotateLeft.jpg";
    final private String bushRightUrl = "src/Resources/Images/bush_rotateRight.jpg";
    private int dX = 240;


    GameBoard(){

    }
   public void paint(Graphics g){
        for(int i = 0;i<20;i++){
            for(int j = 0;j < 20;j++) {
                if(i == 0 || j == 0 || i == 19 || j == 19)
                try {
                    Image img;
                    if(i == 0 && j != 0 && j != 19){
                        img = getToolkit().getImage(bushLeftUrl);
                    }else if(i == 19 && j < 19 && j >0){
                        img = getToolkit().getImage(bushRightUrl);
                    }
                    else{
                        img = getToolkit().getImage(bushUrl);
                    }
                    g.drawImage(img, i *32+dX, j*32, this);

                } catch (Exception e) {
                    System.out.println("Cant draw image");
                    e.printStackTrace();
                }
            }
        }
    }
}
