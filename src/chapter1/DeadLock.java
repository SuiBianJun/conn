package chapter1;

// blog1 :)
public class DeadLock {// dead lock test

	static Object A = new Object();
	static Object B = new Object();
	
	static void getB(){
		
		synchronized (A) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (B) {
				System.out.println("get B");
			}
		}
	}
	
	static void getA(){
		synchronized (B) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (A) {
				System.out.println("get A");
			}
		}
	}
	
	public static void main(String[] args) {
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				getA();
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				getB();
			}
		});
		
		thread.start();
		thread2.start();
		
	}
	
	
}
