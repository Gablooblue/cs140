import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Square extends GameObject
{
    int x;
    int y; 
    public Square(int x, int y)
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
        g.drawRect(this.x, this.y, 50, 50);
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
