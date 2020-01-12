import javax.swing.*;

import java.awt.*;

import static java.lang.Thread.sleep;

public class GameTimer extends Thread {
    private long time;
    private boolean runnning;
    final private int textSize = 100;
    GameTimer(int newTime){
        this.time = newTime; // seconds into miliseconds
        Game.timerLabel = new JLabel();
        Game.timerLabel.setText(Long.toString(this.time));
        Game.timerLabel.setForeground(Color.RED);
        Game.timerLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,textSize));
        Dimension d = Game.timerLabel.getPreferredSize();
        Game.timerLabel.setBounds(50,300,d.width,d.height);
        runnning = true;
    }

    public long getTime() {
        return time;
    }

    @Override
    public void run(){
        while(runnning){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(time == 0 ){
                runnning = false;
            }
            Game.timerLabel.setText(Long.toString(this.time));
            time--;
        }
    }
}
