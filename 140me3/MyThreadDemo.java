// in another file
public class MyThreadDemo {
	public static void main(String args[]) {
		Object puso = new Object();
		MyThread t1 = new MyThread(1, puso);
		MyThread t2 = new MyThread(2, puso);
		MyThread t3 = new MyThread(3, puso);
		t1.start(); t2.start(); t3.start();
	}
}