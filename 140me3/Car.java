import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.*;

@SuppressWarnings("serial")
public class Car extends GameObject {
    int x;
    int y;
    int spawn_x;
    int spawn_y;
    char axis;
    char direction;
    Object lock;

    public Car(Object lock, int x, int y, char axis, char direction) 
    {
        this.x = x;
        this.y = y;
        this.spawn_x = x;
        this.spawn_y =y ;
        this.axis = axis;
        this.direction = direction;
        this.lock = lock;
    }

    public void paint(Graphics2D g) 
    {
        g.setColor(Color.WHITE);
        g.fillArc(x,y ,10, 10, 0, 360);
    }    

    public void move(int speed) 
    {
        if(axis == 'x')
        {
            if(direction == '+')
            {
                this.x += speed;
            }
            else
            {
                this.x -= speed;
            }
        }
        else
        {
            if(direction == '+')
            {
                this.y += speed;
            }
            else
            {
                this.y -= speed;
            }
        }
    }

    public boolean passed_box()
    {
        if(axis == 'x')
        {
            if(direction == '+')
            {
                return x<= 600;
            }
            else
            {
                return x >= 200;
            }
        }
        else
        {
            if(direction == '+')
            {
                return y <= 350;
            }
            else
            {
                return y >= 250;
            }
        }

    }

    public boolean passed_program()
    {
        if(axis == 'x')
        {
            if(direction == '+')
            {
                return x > 800;
            }
            else
            {
                return x < 0;
            }
        }
        else
        {
            if(direction == '+')
            {
                return y > 600;
            }
            else
            {
                return y < 0;
            }
        }

    }

    public void run() 
    {
        while(true) {
            MarioWindow.delay(20);
            if(y >= 250 && y <= 350 && x >= 200 && x <= 600)
            {
                synchronized(lock) {
					while(this.passed_box()) {
                        this.move(7);
						MarioWindow.delay(20);
					}

                }
            }
            else
            {
                this.move(5);
            }
			if (this.passed_program()) {
				y = this.spawn_y;
				x = this.spawn_x;
			}
        }

    }
}
