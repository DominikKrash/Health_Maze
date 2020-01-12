public class Apple extends Item{
    public Apple() {
        setBonusPoint(2);
        setBonusTime(3);
        setValuesInfo("<html>" +"" +
                "<p>kcal: 90</p><br/>"+
                "<p>białko: 0,7g</p><br/>" +
                "<p>tluszcz: 0,7g</p><br/>" +
                "<p>weglowodany: 18,2g</p>" +
                "</html>");
    }

    public Apple(int x, int y) {
        this.setPosX(x);
        this.setPosY(y);
        this.setSkinURL("src/Resources/Images/apple.png");
        setBonusPoint(1);
        setBonusTime(5);
        setValuesInfo("<html>" +"" +
                "<p>kcal: 90</p><br/>"+
                "<p>białko: 0,7g</p><br/>" +
                "<p>tluszcz: 0,7g</p><br/>" +
                "<p>weglowodany: 18,2g</p>" +
                "</html>");
    }
}
