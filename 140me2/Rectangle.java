import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Rectangle extends GameObject
{
    public void paint(Graphics2D g)
    {
        g.setColor(Color.gray);
        g.fillRect(0, 200, 800, 200);
        g.setColor(Color.black);
        g.drawString("Critical Region", 300, 300);
    }

}
