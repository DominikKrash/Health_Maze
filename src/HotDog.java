public class HotDog extends Item{
    public HotDog() {
        setBonusTime(-15);
        setBonusPoint(-1);
    }

    public HotDog(int x, int y) {
        this.setPosX(x);
        this.setPosY(y);
        this.setSkinURL("src/Resources/Images/hotdog.png");
        setBonusTime(-15);
        setBonusPoint(-1);
    }
}
