import java.util.*;

class optimal
{
	static int page[]={99,99,99};
	static int n;
	static int q[]=new int[20];	
	static int k=0;

	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number of pages:");
		n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.println("enter page number:");
			q[i]=sc.nextInt();
		}
		
		for(k=0;k<n;k++)
		{
			int pos,flag=0;
			flag=present();
			if(flag==0)
			{
	
				pos=empty();
				if(pos!=99)	
					page[pos]=q[k];
				else
				{
					pos=check();
					page[pos]=q[k];
				}
			
			
			}
			System.out.println();
			if(flag==1)
			System.out.print("hit  ");
			else
			System.out.print("miss ");
			for(int i=0;i<3;i++)
			{
				System.out.print(page[i]+"\t");
			}
		}
		
	}

	public static int present()
	{
		for(int c=0;c<3;c++)
		{
				if(page[c]==q[k])
				{
					return 1;
				}
		
		}
		return 0;	
	}

	public static  int empty()
	{
		for(int m=0;m<3;m++)
		{
			if(page[m]==99)
			return m;
		}
		return 99;
	}

	public static int check()
	{
		int no=-1,posi=-1,r;
		
			for(r=k;r<n;r++)
			{
				if(no<2)
				if(page[no+1]==q[r])
				{
					if(r>posi)
					{
						posi=r;
						System.out.print("posi is:"+posi);
						no++;
						System.out.print("no is:"+no);
					}
				}
			}
			
			System.out.print("no is:"+no);
			if(no==-1)
			no=0;
			return no;
	}
}