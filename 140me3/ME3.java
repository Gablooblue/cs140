public class ME3 {
    public static void main(String args[]) {
        final MarioWindow w1 = new MarioWindow();
		Box b = new Box();
		w1.add(b);
		Object lock= new Object();

        Car cars[] = new Car[4];
        cars[0] = new Car(lock, 400,600 , 'y', '-');
        cars[1] = new Car(lock, 400, 0, 'y', '+');
        cars[2] = new Car(lock, 0,300 , 'x', '+');
        cars[3] = new Car(lock, 799,300 , 'x', '-');

        for(int i = 0; i < 4; i++)
            w1.add(cars[i]);

        (new Thread() {
            public void run()
            {
                w1.startGame();
            }
        }).start();
    }
}
