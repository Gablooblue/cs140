
@SuppressWarnings("serial")
public class ME4 
{
    public static void main(String args[]) {
        final MarioWindow w1 = new MarioWindow();
		Box b = new Box();
		w1.add(b);
		Object section1= new Object();
		Object section2= new Object();

        Car cars[] = new Car[2];
        cars[0] = new Car(section1,section2, 0,300 , 'x', '+', 5);
        cars[1] = new Car(section1, section2, 799,300 , 'x', '-',  1);

        for(int i = 0; i < 2; i++)
            w1.add(cars[i]);

        (new Thread() {
            public void run()
            {
                w1.startGame();
            }
        }).start();
    }
}
