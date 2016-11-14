import java.util.* ;
class roundrobin
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);

		int a=1,n,count=0,i,temp,sq=0,f,sum1=0,sum2=0,burst=0;
		
		float avg1,avg2;

		System.out.println("enter the no of process");
		n=sc.nextInt();
		int b[]=new int[n];
		int bt[]=new int[n];
		int tt[]=new int[n];

		for(i=0;i<n;i++)
		{
			System.out.println("Enter the burst time for  process:"+(i+1));
			b[i]=sc.nextInt();
			burst=burst+b[i];
		}
		int tat[]=new int[burst+5];
		
		System.out.println("enter the frame size:");
		 f=sc.nextInt();
	
		//RR calculation
		i=0;
		
		while(i<burst)
		{
			
			for(int p=0;p<n;p++)
			{System.out.println("hi");
				if(i<burst+1)
				{

				if(b[p]>f)
				{
					System.out.println("if");
					b[p]=b[p]-f;
					for(int g=i;g<i+f;g++)
					tat[g]=p;
					i=i+f;
					System.out.println("i is:"+i);
				}
								


				else if(b[p]<=f && b[p]!=0)
				{
					System.out.println("else");	
					for(int g=i;g<i+b[p];g++)
					tat[g]=p;
					i=i+b[p];
					b[p]=0;
					System.out.println("i is:"+i);
				}
				
				
				}	
			}
		}
		for(int v=0;v<n;v++)
		{
			for(int j=burst;j>=0;j--)
			{
				if(tat[j]==v)
				{
					bt[v]=j;
					break;
				}
			}
		}		

		for(int d=0;d<burst;d++)
		{
			System.out.println(d+"\t" +tat[d]+"\t");
		}

		for(int d=0;d<n;d++)
		{
			sum1=sum1+bt[d]+n;
		}
		avg1=(float)sum1/n;
		System.out.println("Avg tat:"+avg1);
		
		
	}
}