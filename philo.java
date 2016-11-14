// this is the dining philosopher's problem

import java.util.*;

class philo
{
	static int n,phil;
	static int fork[] = new int[10];
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number of philosophers:");
		n = sc.nextInt();
		for(int i = 0;i < n;i++)
		{
			fork[i] = 1;//1 indicates fork not used
		}
		int ch;
		do
		{
			
			System.out.print("\nchoose a philospher:");
			phil = sc.nextInt();
			System.out.println("1.Set him to eat.\n2.Set him to think.\nEnter your choice:");
			ch=  sc.nextInt();
			switch(ch)
			{
				case 1:eat();
				break;
				
				case 2:think();
				break;
	
				case 3:break;
			}
		}while(ch != 3);	

	}

	public static void eat()
	{
		int x;
		x = wait(fork[phil],phil);  //checks for availibility of fork with himself
		if(x == 1)
		x = wait(fork[(phil + 1) % n],(phil + 1) % n); //checks for availibiilty of fork with neighbour
		if(x == 1)
		System.out.println("phiosopher is eating!!");
	}

	public static int wait(int sema,int i)
	{
		if(sema <= 0) //(sema)fork[i] = 0 means fork is in use
		{
			System.out.println("philosopher cant get fork to eat!!");
			return 0;
		}
		sema--;
		fork[i] = sema;
		return 1;
	}	

	public static void think()
	{
	       System.out.println("philosopher thinking!!");
		signal(fork[phil],phil); //sets fork[] = 1 means fork becomes available

		signal(fork[(phil + 1) % 5],(phil + 1) % 5); //set fork of neighbour as 1 too
	}

	public static void signal(int sema,int i)
	{
		if(sema <= 0)
		sema++;
		fork[i] = sema;
	}
}
