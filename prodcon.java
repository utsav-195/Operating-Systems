import java.util.*;
import java.io.*;

class prodcon
{
	static int mutex=1,empty=5,full=0,in=0,out=0,put=8;
	static int buffer[]={999,999,999,999,999};	
	
	public static void main(String args[])
	{
		producer p=new producer();
		consumer c=new consumer();
		
		Thread tp=new Thread(p);
		Thread cp=new Thread(c);
		
		
		cp.start();
		tp.start();
	}

	public static void wait(int sema)
	{
		if(sema<=0)
		{
			System.out.println("waiting");
			try
			{
				Thread.sleep(1000);
			}catch(Exception e){}
		}
		sema--;
	}

	public static void signal(int sema)
	{
		sema++;
	}	

	

}

class producer extends prodcon implements Runnable
{
	int put;
	public void run()
	{
		for(int i=0;i<5;i++)
		{
			System.out.println("\nproducer bhaiya....");
			try
			{
				Thread.sleep(1000);
			}catch(Exception e){}
			
			produce();
			
			wait(empty);
			wait(mutex);
			
			fill();
			
			signal(mutex);
			signal(full);	
			
			printbuf();
		}

	}

	public void produce()
	{
		put=put*5+17;
		System.out.println("data generated is:"+put);
		
	}

	public void fill()
	{
		buffer[in]=put;
		in=(in+1)%5;
	}

	public void printbuf()
	{
		System.out.println("buffer is:");
		for(int p=0;p<5;p++)
		{
			System.out.print(buffer[p]+" ");
		}	
	}

}

class consumer extends prodcon implements Runnable
{
	public void run()
	{
		for(int i=0;i<5;i++)
		{
			System.out.println("\nInside consumer.");
			try
			{
				Thread.sleep(1000);
			}catch(Exception e){}	
			
			wait(full);
			wait(mutex);
			
			remove();
		
			signal(mutex);
			signal(empty);

			printbuf();
		}
	}

	public void remove()
	{
		int removed=buffer[out];
		buffer[out]=999;
		if(removed==999)
		{
			System.out.println("nothing removed");
		}
		else
		{
			System.out.println("\nremoved is :"+removed);
		}
		out=(out+1)%5;
	}

	public void printbuf()
	{
		System.out.println("buffer is:");
		for(int p=0;p<5;p++)
		{
			System.out.print(buffer[p]+" ");
		}	
	}
}