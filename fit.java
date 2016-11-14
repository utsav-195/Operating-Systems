import java.util.*;

class fit
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int process[]=new int[5];
		int emptyf[][]=new int[9][2];
		int emptyw[][]=new int[9][2];	
		int emptyb[][]=new int[9][2];	

		for(int k=0;k<9;k++)
		{
			emptyf[k][0]=emptyw[k][0]=emptyb[k][0]=sc.nextInt();
			emptyf[k][1]=emptyw[k][1]=emptyb[k][1]=99;
		}

		for(int k=0;k<9;k++)
		{
			System.out.print(emptyf[k][0]+"   ");
		}

		for(int i=0;i<5;i++)
		{
			System.out.println("enter size of process "+i+":");
			process[i]=sc.nextInt();
		}

		System.out.println("------------------first fit--------------");
		for(int m=0;m<5;m++)
		{
			for(int z=0;z<9;z++)
			{
				if(process[m]<=emptyf[z][0])
				{
					emptyf[z][0]=emptyf[z][0]-process[m];
					emptyf[z][1]=m;
					break;
				}
			}
		}
		
		for(int k=0;k<9;k++)
		{
			System.out.print("emptyf " + k+"  ");
			System.out.print(emptyf[k][0]+"  ");
			System.out.print(emptyf[k][1]+"\n");
		}
	

		System.out.println("------------------best fit--------------");
		for(int m=0;m<5;m++)
		{
			int min=999,pos=999;
			for(int z=0;z<9;z++)
			{
				if(process[m]<=emptyb[z][0])
				{
					int small=emptyb[z][0]-process[m];
					if(small<min)
					{
						pos=z;
						min=small;
					}
					
				}
			}
			emptyb[pos][0]=min;
			emptyb[pos][1]=m;
				
		}	

		
		for(int k=0;k<9;k++)
		{
			System.out.print("emptyb " + k+"  ");
			System.out.print(emptyb[k][0]+"  ");
			System.out.print(emptyb[k][1]+"\n");
		}

		System.out.println("------------------worst fit--------------");
		for(int m=0;m<5;m++)
		{
			
			int max=0,pos=999;
			for(int z=0;z<9;z++)
			{
				if(process[m]<=emptyw[z][0])
				{
					int big=emptyw[z][0]-process[m];
					if(big>max)
					{
						pos=z;
						max=big;
					}
					
				}
			}
			emptyw[pos][0]=max;
			emptyw[pos][1]=(emptyw[pos][1]*10)+m;
				
		}	

		
		for(int k=0;k<9;k++)
		{
			System.out.print("emptyw " + k+"  ");
			System.out.print(emptyw[k][0]+"  ");
			System.out.print(emptyw[k][1]+"\n");
		}

	}	
}