import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
public class Box extends GameObject {
	public void paint(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillRect(200,250,400,100);
	}
}
