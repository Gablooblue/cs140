@SuppressWarnings("serial")
public class ME5
{
    public static void main(String args[]) {
        final MarioWindow w1 = new MarioWindow();
		Object lock = new Object();
        
        Omnom o = new Omnom(lock, 10, 200, 200);
        SugarDaddy sd = new SugarDaddy(lock, o);
        w1.add(sd);
        w1.add(o);


        (new Thread() {
            public void run()
            {
                w1.startGame();
            }
        }).start();
    }
}
