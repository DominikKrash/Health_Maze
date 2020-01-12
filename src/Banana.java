public class Banana extends Item {
    public Banana() {
        setBonusPoint(1);
        setBonusTime(5);
        setValuesInfo("<html>" +"" +
                "<p>kcal: 116</p><br/>"+
                "<p>białko: 1,2g</p><br/>" +
                "<p>tluszcz: 0,4g</p><br/>" +
                "<p>weglowodany: 26,2g</p>" +
                "</html>");
    }

    public Banana(int x, int y) {
        this.setPosX(x);
        this.setPosY(y);
        this.setSkinURL("src/Resources/Images/banan.png");
        setBonusPoint(1);
        setBonusTime(5);
        setValuesInfo("<html>" +"" +
                "<p>kcal: 116</p><br/>"+
                "<p>białko: 1,2g</p><br/>" +
                "<p>tluszcz: 0,4g</p><br/>" +
                "<p>weglowodany: 26,2g</p>" +
                "</html>");
    }
}
