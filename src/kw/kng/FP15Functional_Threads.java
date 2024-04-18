package kw.kng;

import java.io.IOException;
import java.util.stream.IntStream;

public class FP15Functional_Threads
{
	
	public static void main(String[] args) throws IOException
	{
		Runnable runnable = new Runnable()
		{
			@Override
			public void run() 
			{
					for(int i=0;i<5;i++)
					{
							System.out.println(Thread.currentThread().getId() +" : " + i);
					}
				
			}
		};
		
		Runnable runnable2=()->
		{
				IntStream.range(0,10)
								.forEach(
											i -> System.out.println(Thread.currentThread().getId() +" : " + i));
		};
		System.out.println("------------------------------------------------------------------------------------------------");
		Thread thread= new Thread(runnable);
		thread.start();

		Thread thread1= new Thread(runnable);
		thread1.start();
		
		Thread thread2= new Thread(runnable);
		thread2.start();
		
		System.out.println("------------------------------------------------------------------------------------------------");
		Thread thread3= new Thread(runnable2);
		thread3.start();

		Thread thread4= new Thread(runnable2);
		thread4.start();
		
		Thread thread5= new Thread(runnable2);
		thread5.start();
		
		System.out.println("------------------------------------------------------------------------------------------------");
		
		
		
	}

}
