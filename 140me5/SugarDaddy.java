import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.*;
import java.util.Random; 


@SuppressWarnings("serial")
public class SugarDaddy extends GameObject {

    Object lock;
    Omnom o;
    Random rand = new Random(); 

    public SugarDaddy(Object lock, Omnom o)
    {
        this.lock = lock;
        this.o = o;
    }
    public void run()
    {
        while(true)
        {
            MarioWindow.delay(200);
            synchronized(this)
            {

                int x = rand.nextInt(3000) + 1;
                System.out.println("Sleeping for " + x + " miliseconds" );
                try {
                    Thread.sleep(x);
                } catch (InterruptedException e) {}
                synchronized(o)
                {
                    System.out.println("sleepin");
                    System.out.println("Adding sugar");
                    o.add_sugar(10);
                    o.notify();
                }
            }

        }
    }
}

