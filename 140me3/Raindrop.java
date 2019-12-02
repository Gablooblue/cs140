import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.*;
@SuppressWarnings("serial")
public class Raindrop extends GameObject {
	int x;
	int y;
	Random r;
	Object puso;
	public Raindrop(Object puso) {
		r = new Random();
		x = r.nextInt(800);
		y = r.nextInt(600);
		this.puso = puso;
	}
	
	public void paint(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillArc(x,y,10,10,0,360);
	}
	
	public void run() {
		while(true) {
			MarioWindow.delay(20);
			if (y >= 250 && y <= 350) {  // inside the box
				synchronized(puso) {
					while(y <= 350) {
						y = y + 7;
						MarioWindow.delay(20);
					}
				}
			} else { // outside the box
				y = y + 5;
			}
			
			if (y > 600) {
				y = 0;
				x = r.nextInt(800);
			}
		}
	}

}
