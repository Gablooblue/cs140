import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Line extends GameObject
{
    int x;
    int y; 
    public Line(int x, int y)
    {
        this.x= x;
        this.y= y;
    }

    public void paint(Graphics2D g)
    {
        Random rand = new Random();
        float red, green, blue;
        red = rand.nextFloat();   
        green = rand.nextFloat();   
        blue = rand.nextFloat();   
        Color random = new Color(red, green, blue);
        g.setColor(random);
        g.drawLine(this.x, this.y, this.x + 50, this.y);
    }

    public void run() {
        while(true)
        {
            MarioWindow.delay(20);
            x = x+ 5;
            if (x > 800) { x= -50; }
        }
    }
}
