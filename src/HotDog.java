public class HotDog extends Item{
    public HotDog() {
        setBonusTime(-15);
        setBonusPoint(-1);
        setValuesInfo("<html>" +"" +
                "<p>kcal: 436</p><br/>"+
                "<p>białko: 12,2g</p><br/>" +
                "<p>tluszcz: 25,1g</p><br/>" +
                "<p>weglowodany: 42g</p>" +
                "</html>");
    }

    public HotDog(int x, int y) {
        this.setPosX(x);
        this.setPosY(y);
        this.setSkinURL("src/Resources/Images/hotdog.png");
        setBonusTime(-15);
        setBonusPoint(-1);
        setValuesInfo("<html>" +"" +
                "<p>kcal: 436</p><br/>"+
                "<p>białko: 12,2g</p><br/>" +
                "<p>tluszcz: 25,1g</p><br/>" +
                "<p>weglowodany: 42g</p>" +
                "</html>");
    }
}
