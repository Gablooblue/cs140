import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.*;

@SuppressWarnings("serial")
public class Omnom extends GameObject {
    int sugar_level;
    int x;
    int y;
    Random rand = new Random(); 
    Object lock;
    public Omnom(Object lock, int sugar_level, int x, int y)
    {
        this.lock = lock;
        this.x = x;
        this.y = y;
        this.sugar_level = sugar_level;
    }

    public void paint(Graphics2D g) 
    {
        g.setColor(Color.WHITE);
        g.fillArc(x,y ,10, 10, 0, 360);
    }    

    public void add_sugar(int sugar)
    {
        this.sugar_level += sugar;
    }

   public void run()
   {
       while(true)
       {
           MarioWindow.delay(100);
           synchronized(this)
           {
               sugar_level--;
               this.x += rand.nextInt(10);
               this.y += rand.nextInt(10);
               this.x -= rand.nextInt(10);
               this.y -= rand.nextInt(10);
               System.out.println(sugar_level + " Sugar");
               if(sugar_level <= 0)
               {
                   System.out.println("Out of sugar");
                   try {
                       this.wait();
                   } catch (InterruptedException e) {}
               }
           }    

       }
   }
}
