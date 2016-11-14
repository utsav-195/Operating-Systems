import java.util.*;

class khana
{
	static int n,phil;
	static int fork[]=new int[10];
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number of philosophers:");
		n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			fork[i]=1;
		}
		int ch;
		do
		{
			
			System.out.print("\nchoose a philospher:");
			phil=sc.nextInt();
			System.out.println("1.Khana khila garib ko.\n2.Ghehri soch me daal...\nkya kiya jaye:");
			ch=sc.nextInt();
			switch(ch)
			{
				
				case 1:eat();
				break;
				
				case 2:think();
				break;
				
				case 3:break;
			}
		}while(ch!=3);	

	}

	public static void eat()
	{
		int x;
		x=wait(fork[phil],phil);
		if(x==1)
		x=wait(fork[(phil+1)%n],(phil+1)%n);
		if(x==1)
		System.out.println("khana khane baith gaya!!");
	}

	public static int wait(int sema,int i)
	{
		if(sema<=0)
		{
			System.out.println("khana nai kha sakta!!");
			return 0;
		}
		sema--;
		fork[i]=sema;
		return 1;
	}	

	public static void think()
	{
	       System.out.println("Soch me daal diya usko!!");
		signal(fork[phil],phil);

		signal(fork[(phil+1)%5],(phil+1)%5);
	}

	public static void signal(int sema,int i)
	{
		if(sema<=0)
		sema++;
		fork[i]=sema;
	}

	

}