import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class me1 {
    public static void main(String args[])
    {
        final MarioWindow w1 = new MarioWindow();
        Circle c1 = new Circle(400, 300);
        Crescent cr1 = new Crescent(400, 100);
        Square s1 = new Square(400, 200);
        HalfCircle hc1 = new HalfCircle(400, 500);
        Line l1 = new Line(400, 400);
        w1.add(c1);
        w1.add(cr1);
        w1.add(hc1);
        w1.add(l1);
        w1.add(s1);

        ( new Thread() {
            public void run() {
                w1.startGame();
            }
        }).start();
    }
}
