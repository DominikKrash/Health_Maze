import javax.swing.*;

import java.awt.*;

import static java.lang.Thread.sleep;

public class GameTimer extends Thread {
    private long startTime;
    private long time;
    private boolean runnning;
    private boolean gameRunning;
    final private int textSize = 100;
    private Game game;

    GameTimer(int newTime,Game game){
        this.game = game;
        this.startTime = newTime; // seconds into miliseconds
        Game.timerLabel = new JLabel();
        Game.timerLabel.setText(Long.toString(this.time));
        Game.timerLabel.setForeground(Color.RED);
        Game.timerLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,textSize));
        Dimension d = Game.timerLabel.getPreferredSize();
        Game.timerLabel.setBounds(50,300,d.width+100,d.height);
        runnning = true;
        gameRunning = true;
    }

    public long getStartTimeTime() {
        return startTime;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    @Override
    public void run(){
        while(runnning) {
            time = startTime;
            while (gameRunning) {
                Game.timerLabel.setText(Long.toString(this.time));
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (time <= 0) {
                    gameRunning = false;
                }
                time--;
            }
            int choice = this.game.startNewGame();
            if(choice == 0){
                runnning = false;
            }else if(choice == 1){
                gameRunning = true;
                time = startTime;
            }
        }
    }
}
