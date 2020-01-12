public class Apple extends Item{
    public Apple() {
        setBonusPoint(2);
        setBonusTime(3);
    }

    public Apple(int x, int y) {
        this.setPosX(x);
        this.setPosY(y);
        this.setSkinURL("src/Resources/Images/apple.png");
        setBonusPoint(1);
        setBonusTime(5);
    }
}
