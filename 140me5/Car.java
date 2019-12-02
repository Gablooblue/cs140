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
    Object section1;
    Object section2;
    int speed;
    

    public Car(Object section1, Object section2, int x, int y, char axis, char direction, int speed) 
    {
        this.x = x;
        this.y = y;
        this.spawn_x = x;
        this.spawn_y =y ;
        this.axis = axis;
        this.direction = direction;
        this.section1 = section1;
        this.section2 = section2;
        this.speed = speed;
    }

    public void paint(Graphics2D g) 
    {
        g.setColor(Color.WHITE);
        g.fillArc(x,y ,10, 10, 0, 360);
    }    

    public void move(int added) 
    {
        if(axis == 'x')
        {
            if(direction == '+')
            {
                this.x += speed + added;
            }
            else
            {
                this.x -= speed + added;
            }
        }
        else
        {
            if(direction == '+')
            {
                this.y += speed + added;
            }
            else
            {
                this.y -= speed + added;
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
            if(x >= 200 && x <= 600)
            {
                if (direction == '+')
                {
                        MarioWindow.delay(200);
                    synchronized(section1) {
                        while(x >= 200 && x <= 400) {
                            this.move(2);
                            MarioWindow.delay(20);
                        }
                        synchronized(section2) {
                            while(x >= 400 && x <= 600) {
                                this.move(2);
                                MarioWindow.delay(20);
                            }
                        }    

                    }
                }
                else
                {
                        MarioWindow.delay(200);
                    synchronized(section2) {
                            while(x >= 400 && x <= 600) {
                                this.move(2);
                                MarioWindow.delay(20);
                            }

                        synchronized(section1) {
                        while(x >= 200 && x <= 400) {
                            this.move(2);
                            MarioWindow.delay(20);
                        }
                        }    

                    }
                }
            }
            else
            {
                this.move(0);
            }
			if (this.passed_program()) {
				y = this.spawn_y;
				x = this.spawn_x;
			}
        }

    }
}
