public class Fries extends Item {
    public Fries() {
        setBonusTime(-10);
        setBonusPoint(-2);
        setValuesInfo("<html>" +"" +
                "<p>kcal: 331</p><br/>"+
                "<p>białko: 3,5g</p><br/>" +
                "<p>tluszcz: 17,4g</p><br/>" +
                "<p>weglowodany: 41,7g</p>" +
                "</html>");
    }

    public Fries(int x, int y) {
        this.setPosX(x);
        this.setPosY(y);
        this.setSkinURL("src/Resources/Images/fries.png");
        setBonusTime(-15);
        setBonusPoint(-1);
        setValuesInfo("<html>" +"" +
                "<p>kcal: 331</p><br/>"+
                "<p>białko: 3,5g</p><br/>" +
                "<p>tluszcz: 17,4g</p><br/>" +
                "<p>weglowodany: 41,7g</p>" +
                "</html>");
    }
}
