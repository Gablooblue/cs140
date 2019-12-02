public class RaindropsDemo {
	public static void main(String args[]) {
		final MarioWindow w1 = new MarioWindow();
		
		Box b = new Box();
		w1.add(b);
		Object puso = new Object();
		for (int i = 0; i < 50; i++) {
			Raindrop r = new Raindrop(puso);
			w1.add(r);
		}			
		
		(new Thread() { public void run() {
			w1.startGame(); 
		}}).start();
			
			
	}
}