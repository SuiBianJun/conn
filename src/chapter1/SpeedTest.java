package chapter1;

/**
 * 
 * @author seed
 * 
 * serial and concurrence speed compare
 */

public class SpeedTest {
	
	static final int count = 100000001;
	
	public static void main(String[] args) {
		serial();
		concurren();
	}
	
	static void serial() {
		long start = System.currentTimeMillis();
		int a = 0;
		for(int i = 0; i < count; i++) {
			a += 5;
		}
		
		int b = 0;
		for(int i = 0; i < count; i++) {
			b--;
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - start);
	}

	static void concurren() {
		
		long start = System.currentTimeMillis();
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int a = 0;
				for(int i = 0; i < count; i++) {
					a += 5;
				}
			}
		});
		
		thread.start();
		int b = 0;
		for(int i = 0; i < count; i++) {
			b--;
		}
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - start);
	}
}
