//Priority shceduling:

//CODE:

import java.util.*;
class priority2
{
	public static void main(String args[])
	{
		int priority[][];
		System.out.println("enter the number of processes:");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		priority=new int[n][5];
		for(int i=0;i<n;i++)		
		{
			priority[i][0]=i+1;
			System.out.println("enter the priority:");
			priority[i][1]=sc.nextInt();
			System.out.println("enter the burst time:");
			priority[i][2]=sc.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(priority[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("after sort:");
		for(int i=0;i<n-1;i++)
			for(int j=0;j<n-1;j++)
			{
				if(priority[j][1]>priority[j+1][1])
				{
					int temp0=priority[j+1][0];
					int temp1=priority[j+1][1];
					int temp2=priority[j+1][2];

					priority[j+1][0]=priority[j][0];
					priority[j+1][1]=priority[j][1];
					priority[j+1][2]=priority[j][2];

					priority[j][0]=temp0;
					priority[j][1]=temp1;
					priority[j][2]=temp2;									
				}
			}

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(priority[i][j]+"\t");
			}
			System.out.println();
		}

		System.out.println("waiting time:");
		priority[0][3]=0;
		for(int i=1;i<n;i++)
		{
			int add=0;
			for(int j=i;j>0;j--)
			add+=priority[j-1][2];
			priority[i][3]=add;			
		}
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<4;j++)
			{
				System.out.print(priority[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("turn around time:");
		priority[0][4]=priority[0][2];
		for(int i=1;i<n;i++)
		{
			
			int add=0;
			for(int j=i;j>=0;j--)
			add+=priority[j][2];
			priority[i][4]=add;			
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.print(priority[i][j]+"\t");
			}
			System.out.println();
		}
		float avg=0;
		for(int i=0;i<n;i++)
			avg+=priority[i][3];
		avg=avg/n;
		System.out.println("average waiting time is:"+avg);

		float avg2=0;
		for(int i=0;i<n;i++)
			avg2+=priority[i][4];
		avg2=avg2/n;
		System.out.println("average turn around time is:"+avg2);
		
	}
}
