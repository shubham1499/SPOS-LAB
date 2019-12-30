import java.util.Scanner;


public class SRTF {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of processes:");
		int n = sc.nextInt();
		int []at = new int[n];
		int []wt = new int[n];
		int []ta = new int[n];
		int []ct = new int[n];
		int []bt = new int[n];
		int []flag = new int[n];
		int []tbt = new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter process "+(i+1)+" arrival time:");
			at[i]=sc.nextInt();
			System.out.println("Enter process "+(i+1)+" burst time:");
			bt[i]=sc.nextInt();
			tbt[i]=bt[i];
		}
		
		int st=0;
		int tot=0;
		while(true)
		{
			int c=n;
			int min=9999;
			if(tot == n)
				break;
			for(int i=0;i<n;i++)
			{
				if(flag[i]==0 && bt[i]<min && at[i]<=st)
				{
					min = bt[i];
					c=i;
				}
			}
			if(c==n)
				st++;//idle state
			else
			{
				st++;
				bt[c]--;
				if(bt[c]==0)
				{
					flag[c]=1;
					tot++;
					ct[c]=st;
				}
			}
		}
		float avgWt = 0.0f;
		float avgTa = 0.0f;
		for(int i=0;i<n;i++)
		{
			ta[i] = ct[i] - at[i];
			wt[i] = ta[i] - tbt[i];
			avgWt +=wt[i];
			avgTa +=ta[i];
		}
		avgTa = avgTa/n;
		avgWt = avgWt/n;
		System.out.println("pid\t arrival\t burst\t completion\t turnaround\t waiting\t");
		for(int i=0;i<n;i++)
		{
			System.out.println((i+1) + "\t"+ at[i]+ "\t" + tbt[i]+"\t"+ct[i]+"\t"+ta[i]+"\t"+wt[i]);
		}
		System.out.println("Average Waiting time:"+avgWt);
		System.out.println("Average Turning Around time:"+avgTa);
		
	}
}
