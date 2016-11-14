//First come first serve:
//Code:
import java.util.*;
class fcfs
{
	public static void main(String args[])
	{
		int fcfs[][];
		System.out.println("enter the number of processes:");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		fcfs=new int[n][5];
		for(int i=0;i<n;i++)		
		{
			fcfs[i][0]=i+1;
			System.out.println("enter the arrival time:");
			fcfs[i][1]=sc.nextInt();
			System.out.println("enter the burst time:");
			fcfs[i][2]=sc.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(fcfs[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("after sort:");
		for(int i=0;i<n-1;i++)
			for(int j=0;j<n-1;j++)
			{
				if(fcfs[j][1]>fcfs[j+1][1])
				{
					int temp0=fcfs[j+1][0];
					int temp1=fcfs[j+1][1];
					int temp2=fcfs[j+1][2];

					fcfs[j+1][0]=fcfs[j][0];
					fcfs[j+1][1]=fcfs[j][1];
					fcfs[j+1][2]=fcfs[j][2];

					fcfs[j][0]=temp0;
					fcfs[j][1]=temp1;
					fcfs[j][2]=temp2;									
				}
			}

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(fcfs[i][j]+"\t");
			}
			System.out.println();
		}

		System.out.println("waiting time:");
		fcfs[0][3]=0;
		for(int i=1;i<n;i++)
		{
			int add=0;
			for(int j=i;j>0;j--)
			add+=fcfs[j-1][2];
			fcfs[i][3]=add-fcfs[i][1];			
		}
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<4;j++)
			{
				System.out.print(fcfs[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("arrival time:");
		fcfs[0][4]=fcfs[0][2];
		for(int i=1;i<n;i++)
		{
			
			int add=0;
			for(int j=i;j>=0;j--)
			add+=fcfs[j][2];
			fcfs[i][4]=add-fcfs[i][1];			
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.print(fcfs[i][j]+"\t");
			}
			System.out.println();
		}
		float avg=0;
		for(int i=0;i<n;i++)
			avg+=fcfs[i][3];
		avg=avg/n;
		System.out.println("average waiting time is:"+avg);

		float avg2=0;
		for(int i=0;i<n;i++)
			avg2+=fcfs[i][4];
		avg2=avg2/n;
		System.out.println("average waiting time is:"+avg2);
		
	}
}
