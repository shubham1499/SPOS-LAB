package roundrobin;

import java.util.Scanner;

public class RR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of processes:");
		int n = sc.nextInt();
		
		int []wt = new int[n];
		int []ta = new int[n];
		int []ct = new int[n];
		int []bt = new int[n];
		int []rbt = new int[n];
		float avgWt = 0.0f;
		float avgTa = 0.0f;
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter process "+(i+1)+" burst time:");
			bt[i]=sc.nextInt();
			rbt[i]=bt[i];
		}
		System.out.println("Enter quantum time:");
		int qt = sc.nextInt();
		boolean flag = true;
		int t=0;
		while(true)
		{
			flag=true;
			
			for(int i=0;i<n;i++)
			{
				if(rbt[i]>0)
				{
					flag=false;
					
					if(rbt[i]>qt)
					{
						t=t+qt;
						rbt[i]=rbt[i]-qt;
					}
					else
					{
						t=t+rbt[i];
						rbt[i]=0;
						wt[i]=t-bt[i];
					}
				}
			}
			if(flag==true)
				break;
		}
		for(int i=0;i<n;i++)
		{
			ta[i] = wt[i] + bt[i];
			avgWt = avgWt + wt[i];
			avgTa = avgTa + ta[i];
		}
		avgWt = avgWt/n;
		avgTa = avgTa/n;
		System.out.println("pid\t turnaround\t waiting\t");
		for(int i=0;i<n;i++)
		{
			System.out.println((i+1) + "\t"+ta[i]+"\t"+wt[i]);
		}
		System.out.println("Average waiting time:"+avgWt);
		System.out.println("Average TurnAround time:"+avgTa);
	}

}
