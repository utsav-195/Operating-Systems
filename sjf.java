//Shortest job first scheduling(non - pre-emptive):

import java.util.*;
class sjf
{
	public static void main(String args[])
	{
		
		System.out.println("enter the number of processes:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sjf[][] = new int[n][5];
		
		for(int i = 0;i < n;i++)		
		{
			sjf[i][0] = i + 1;
			
			System.out.println("enter the arrival time:");
			sjf[i][1] = sc.nextInt();
			
			System.out.println("enter the burst time:");
			sjf[i][2] = sc.nextInt();
		}
		
		for(int i = 0;i < n;i++)
		{
			for(int j = 0;j < 3;j++)
			{
				System.out.print(sjf[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("after sort by arrival time:");
		
		for(int i = 0;i < (n - 1);i++)
			for(int j = 0;j < (n - 1);j++)
			{
				if(sjf[j][1] > sjf[j+1][1])
				{
					int temp0 = sjf[j+1][0];
					int temp1 = sjf[j+1][1];
					int temp2 = sjf[j+1][2];

					sjf[j+1][0] = sjf[j][0];
					sjf[j+1][1] = sjf[j][1];
					sjf[j+1][2] = sjf[j][2];

					sjf[j][0] = temp0;
					sjf[j][1] = temp1;
					sjf[j][2] = temp2;						
				}
				else if(sjf[j][1] == sjf[j + 1][1]) // if the arrival times are the same then sort according to the burst time
					if(sjf[j][2] > sjf[j + 1][2])
					{
					int temp0 = sjf[j + 1][0];
					int temp1 = sjf[j + 1][1];
					int temp2 = sjf[j + 1][2];		

					sjf[j + 1][0] = sjf[j][0];
					sjf[j + 1][1] = sjf[j][1];
					sjf[j + 1][2] = sjf[j][2];

					sjf[j][0] = temp0;
					sjf[j][1] = temp1;
					sjf[j][2] = temp2;				
					}
			}
		
			for(int i = 0;i < n;i++)
			{
				for(int j = 0;j < 3;j++)
				{
					System.out.print(sjf[i][j] + "\t");
				}
				System.out.println();
			}
		
			sjf[0][3] = 0;
			sjf[0][4] = sjf[0][2];
		
		
			System.out.println("after sort by burst time:");
		
			if(sjf[0][4] > sjf[1][1]) //if the next  process has arrival time within the turn arounf time of the current process then only sorting by burst time is required
			{
				for(int i = 1;i< (n - 1);i++)
				for(int j = 1;j< (n - 1);j++)
				{
					if(sjf[j][2] > sjf[j + 1][2])
					{
						int temp0 = sjf[j + 1][0];
						int temp1 = sjf[j + 1][1];
						int temp2 = sjf[j + 1][2];		

						sjf[j + 1][0] = sjf[j][0];
						sjf[j + 1][1] = sjf[j][1];
						sjf[j + 1][2] = sjf[j][2];

						sjf[j][0] = temp0;
						sjf[j][1] = temp1;
						sjf[j][2] = temp2;				
					}
					
					else if(sjf[j][2] == sjf[j + 1][2])
						if(sjf[j][1] > sjf[j + 1][1])
						{
							
							int temp0 = sjf[j + 1][0];
							int temp1 = sjf[j + 1][1];
							int temp2 = sjf[j + 1][2];		

							sjf[j + 1][0] = sjf[j][0];
							sjf[j + 1][1] = sjf[j][1];
							sjf[j + 1][2] = sjf[j][2];

							sjf[j][0] = temp0;
							sjf[j][1] = temp1;
							sjf[j][2] = temp2;
							
						}
				}			
				
		System.out.println("waiting time:");
		
		/*
		* waiting time is the time after the arrival time of the process, it has to wait for the CPU to be allocated
		* waiting time of a process will be the total burst time of processes executed before itself 
		minus the arrival time of the process 
		*/
				
		sjf[0][3] = 0; //first process will by default have arrival time 0	
				
		for(int i = 1;i < n;i++)
		{
			int add = 0;
			for(int j = i;j > 0;j--)
			add += sjf[j - 1][2];
			sjf[i][3] = add - sjf[i][1];			
		}
		for(int i = 0;i < n;i++)
		{
			for(int j = 0;j < 4;j++)
			{
				System.out.print(sjf[i][j] + "\t");
			}
			System.out.println();
		}
				
		System.out.println("turn around time:");
				
		/*
		* turn around time is the time after the arrival time of the process till its completion
		* turn around2 time of a process will be the total burst time of processes executed before & itself 
		minus the arrival time of the process 
		*/
				
		sjf[0][4] = sjf[0][2]; //turn around time of the first process is its burst time
				
		for(int i = 1;i < n;i++)
		{			
			int add = 0;
			for(int j = i;j >= 0;j--)
			add += sjf[j][2];
			sjf[i][4] = add - sjf[i][1];			
		}
			}//end if
		
			for(int i = 0;i < n;i++)
			{
				for(int j = 0;j < 5;j++)
				{
					System.out.print(sjf[i][j] + "\t");
				}
				System.out.println();
			}	
	}
}
