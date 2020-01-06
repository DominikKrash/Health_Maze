import java.awt.*;

public abstract class Item {
    public void setSkinURL(String skinURL) {
        this.skinURL = skinURL;
    }

    private String skinURL;

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


}
