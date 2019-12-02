import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Circle extends GameObject
{
    int x;
    int y; 
    public Circle(int x, int y)
    {
        this.x= x;
        this.y= y;
    }

    public void paint(Graphics2D g)
    {
        g.setColor(Color.blue);
        g.fillArc(this.x, this.y, 25, 25, 0, 360);
    }

    public void run() {
        while(true)
        {
            MarioWindow.delay(20);
            y = y+ 5;
            if (y > 600)
            { 

                Random rand = new Random();
                x = rand.nextInt(800);
                y= -50;
            }
        }
    }
}
