import javax.sound.sampled.*;
import java.applet.AudioClip;
import java.awt.*;
import java.io.*;


public class Hero extends Item {
    private final String jumpSound = "src/Resources/Sounds/jump.wav";
    public Hero(int x, int y) {
        this.setPosX(x);
        this.setPosY(y);
        this.setSkinURL("src/Resources/Images/hero.png");
    }

    public String getJumpSound() {
        return jumpSound;
    }

    public void playJumpSound(){
        super.playSound(getJumpSound());
    }


}
