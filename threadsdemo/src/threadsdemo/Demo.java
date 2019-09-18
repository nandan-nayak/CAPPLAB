package threadsdemo;

class Thread1 extends Thread
{
	public void run()
	{
		
		while(true)
			{
			System.out.println("thread 1");
			}
		
		
		
	}
	
	
}



class Thread2 extends Thread
{
	public void run()
	{
		
		while(true)
			{
			System.out.println("thread 222222222222");
			}
		
		
		
	}
	
	
}



public class Demo {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Thread1 t1=new Thread1();
		Thread2 t2=new Thread2();
		t1.start();t2.start();
		t1.join();t2.join();

	}

}
