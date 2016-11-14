//Shortest job first:

Code:
import java.util.*;
class sjf
{
	public static void main(String args[])
	{
		int sjf[][];
		System.out.println("enter the number of processes:");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sjf=new int[n][6];
		for(int i=0;i<n;i++)		
		{
			sjf[i][0]=i+1;
			System.out.println("enter the arrival time:");
			sjf[i][1]=sc.nextInt();
			System.out.println("enter the burst time:");
			sjf[i][2]=sc.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(sjf[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("after sort:");
		for(int i=0;i<n-1;i++)
			for(int j=0;j<n-1;j++)
			{
				if(sjf[j][1]>sjf[j+1][1])
				{
					int temp0=sjf[j+1][0];
					int temp1=sjf[j+1][1];
					int temp2=sjf[j+1][2];

					sjf[j+1][0]=sjf[j][0];
					sjf[j+1][1]=sjf[j][1];
					sjf[j+1][2]=sjf[j][2];

					sjf[j][0]=temp0;
					sjf[j][1]=temp1;
					sjf[j][2]=temp2;						
				}
				else if(sjf[j][1]==sjf[j+1][1])
					if(sjf[j][2]>sjf[j+1][2])
					{
					int temp0=sjf[j+1][0];
					int temp1=sjf[j+1][1];
					int temp2=sjf[j+1][2];		
					int temp3=sjf[j+1][5];

					sjf[j+1][0]=sjf[j][0];
					sjf[j+1][1]=sjf[j][1];
					sjf[j+1][2]=sjf[j][2];
					sjf[j+1][5]=sjf[j][5];

					sjf[j][0]=temp0;
					sjf[j][1]=temp1;
					sjf[j][2]=temp2;
					sjf[j][5]=temp3;					
					}
			}
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<3;j++)
				{
					System.out.print(sjf[i][j]+"\t");
				}
				System.out.println();
			}
			sjf[0][3]=0;
			sjf[0][4]=sjf[0][2];
			System.out.println("after sort by burst time:");
			if(sjf[0][4]>sjf[1][1])
			{
				for(int i=1;i<n-1;i++)
				for(int j=1;j<n-1;j++)
				{
					if(sjf[j][2]>sjf[j+1][2])
					{
						int temp0=sjf[j+1][0];
						int temp1=sjf[j+1][1];
						int temp2=sjf[j+1][2];		
						int temp3=sjf[j+1][5];

						sjf[j+1][0]=sjf[j][0];
						sjf[j+1][1]=sjf[j][1];
						sjf[j+1][2]=sjf[j][2];
						sjf[j+1][5]=sjf[j][5];

						sjf[j][0]=temp0;
						sjf[j][1]=temp1;
						sjf[j][2]=temp2;
						sjf[j][5]=temp3;					
					}
					else if(sjf[j][2]==sjf[j+1][2])
						if(sjf[j][1]>sjf[j+1][1])
						{
						int temp0=sjf[j+1][0];
						int temp1=sjf[j+1][1];
						int temp2=sjf[j+1][2];		
						int temp3=sjf[j+1][5];

						sjf[j+1][0]=sjf[j][0];
						sjf[j+1][1]=sjf[j][1];
						sjf[j+1][2]=sjf[j][2];
						sjf[j+1][5]=sjf[j][5];

						sjf[j][0]=temp0;
						sjf[j][1]=temp1;
						sjf[j][2]=temp2;
						sjf[j][5]=temp3;					
						}
				}			
		System.out.println("waiting time:");
		sjf[0][3]=0;
		for(int i=1;i<n;i++)
		{
			int add=0;
			for(int j=i;j>0;j--)
			add+=sjf[j-1][2];
			sjf[i][3]=add-sjf[i][1];			
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<4;j++)
			{
				System.out.print(sjf[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("arrival time:");
		sjf[0][4]=sjf[0][2];
		for(int i=1;i<n;i++)
		{			
			int add=0;
			for(int j=i;j>=0;j--)
			add+=sjf[j][2];
			sjf[i][4]=add-sjf[i][1];			
		}
			}//end if
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<5;j++)
				{
					System.out.print(sjf[i][j]+"\t");
				}
				System.out.println();
			}	
	}
}
