package chapter1;


public class SychronizedNormalMethod {
	
	volatile static int count = 0;
	
	public synchronized void add(){// lock current object
		count++;
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		final SychronizedNormalMethod sychronizedNormalMethod = new SychronizedNormalMethod();
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0; i < 100; i++)
					sychronizedNormalMethod.add();
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0; i < 100; i++)
					sychronizedNormalMethod.add();
			}
		});
		
		thread.start();
		thread2.start();
		thread.join();
		thread2.join();
		System.out.println(SychronizedNormalMethod.count);
	}
}
