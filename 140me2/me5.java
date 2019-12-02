import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class me5 {
    public static void main(String args[])
    {
        final MarioWindow w1 = new MarioWindow();
        Circle c1 = new Circle(400, 300);
        Circle c2 = new Circle(600, 100);
        Circle c3 = new Circle(200, 200);
        Circle c4 = new Circle(250, 250);
        Circle c5 = new Circle(300, 350);
        Circle c6 = new Circle(100, 150);
        Circle c7 = new Circle(190, 380);
        Circle c8 = new Circle(370, 420);
        Circle c9 = new Circle(200, 340);
        Circle c10 = new Circle(450, 290);
        Circle c11 = new Circle(700, 360);
        Circle c12 = new Circle(100, 140);
        Rectangle r1 = new Rectangle();
        w1.add(r1);
        w1.add(c1);
        w1.add(c2);
        w1.add(c3);
        w1.add(c4);
        w1.add(c5);
        w1.add(c6);
        w1.add(c7);
        w1.add(c8);
        w1.add(c9);
        w1.add(c10);
        w1.add(c11);
        w1.add(c12);

        ( new Thread() {
            public void run() {
                w1.startGame();
            }
        }).start();
    }
}
