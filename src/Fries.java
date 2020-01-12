public class Fries extends Item {
    public Fries() {
        setBonusTime(-10);
        setBonusPoint(-2);
    }

    public Fries(int x, int y) {
        this.setPosX(x);
        this.setPosY(y);
        this.setSkinURL("src/Resources/Images/fries.png");
        setBonusTime(-15);
        setBonusPoint(-1);
    }
}
