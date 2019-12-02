public class MyThread extends Thread {
	int i;
	Object puso;
	public MyThread(int i, Object puso) {
		this.i = i;
		this.puso = puso;
	}
	public void run() {
		for (int ctr = 0; ctr < 500; ctr++) {
			synchronized(puso) {
				for (int ctr2 = 0; ctr2 < 10; ctr2++) {
					System.out.print(i);
				}
				System.out.println("");
			}
}}}
/* in another file
public class MyThreadDemo {
	public static void main(String args[]) {
		MyThread t1 = new MyThread(1);
		MyThread t2 = new MyThread(2);
		MyThread t3 = new MyThread(3);
		t1.start(); t2.start(); t3.start();
	}
}*/