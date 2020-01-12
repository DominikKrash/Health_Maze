import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.awt.*;
import java.io.File;

public abstract class Item {
    private final String goodFoodSound = "src/Resources/Sounds/pyszne.wav";
    private final String badFoodSound = "src/Resources/Sounds/niezdrowe.wav";

    public String getBadFoodSound() {
        return badFoodSound;
    }

    public String getGoodFoodSound() {
        return goodFoodSound;
    }

    public void setSkinURL(String skinURL) {
        this.skinURL = skinURL;
    }


    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public String getSkinURL() {
        return skinURL;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    private int posY,posX;
    private int bonusPoint;
    private int bonusTime;

    public int getBonusPoint() {
        return bonusPoint;
    }

    public int getBonusTime() {
        return bonusTime;
    }

    public void setBonusPoint(int bonusPoint) {
        this.bonusPoint = bonusPoint;
    }

    public void setBonusTime(int bonusTime) {
        this.bonusTime = bonusTime;
    }

    private String skinURL;

    Item(int x,int y,String skin){
        this.posX = x;
        this.posY = y;
        this.skinURL = skin;
    }
    Item(){
        this.skinURL = "";
        this.posX = 0;
        this.posY = 0;
    }

    public void moveStep(int dX,int dY){
        setPosY(this.posY + dY);
        setPosX(this.posX + dX);
    }
    public void move(int newX, int newY){
        setPosX(newX);
        setPosY(newY);
    }
    public void playSound(String fileName)  {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(fileName));
            clip.open(inputStream);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            double gain = 0.008;
            float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
            gainControl.setValue(dB);
            clip.start();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
