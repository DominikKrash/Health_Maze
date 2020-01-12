public class HotDog extends Item{
    public HotDog(int x, int y) {
        this.setPosX(x);
        this.setPosY(y);
        this.setSkinURL("src/Resources/Images/hotdog.png");
        setBonusTime(-5);
        setBonusPoint(-1);
    }
}
