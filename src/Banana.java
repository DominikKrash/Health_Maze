public class Banana extends Item {
    public Banana(int x, int y) {
        this.setPosX(x);
        this.setPosY(y);
        this.setSkinURL("src/Resources/Images/banan.png");
        setBonusPoint(1);
        setBonusTime(5);
    }
}
