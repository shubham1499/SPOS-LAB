import java.util.Scanner;

public class SJFNON {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. of processes:");
		int n = sc.nextInt();
		int []at = new int[n];
		int []wt = new int[n];
		int []bt = new int[n];
		int []ct = new int[n];
		int []ta = new int[n];
		int []flag = new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter process " + i+1 + "Arrival time:");
			at[i]=sc.nextInt();
			System.out.println("Enter process " + i+1 + "Burst time:");
			bt[i]=sc.nextInt();
		}
		int st=0;
		int tot=0;
		while(true)
		{
			if(tot == n)
			{
				break;
			}
			int min=999;
			int c=n;
			for(int i=0;i<n;i++)
			{
				if(at[i]<=st && flag[i]==0 && bt[i]<min)
				{
					min = bt[i];
					c=i;
				}
			}
				if(c==n)
					st++;
				else
				{
					ct[c] = st+bt[c];
					ta[c] = ct[c]-at[c];
					wt[c] = ta[c]-bt[c];
					flag[c]=1;
					st+=bt[c];
					tot++;
				}
		}
		float avgWaiting=0.0f;
		float avgTurnAround=0.0f;
		System.out.println("pid  arrival  burst  turn  complete  waiting");
		for(int i=0;i<n;i++)
		{
			avgWaiting+=wt[i];
			avgTurnAround+=ta[i];
			System.out.println((i+1)+"  " +at[i]+"  "+bt[i]+"  "+ta[i]+"  "+ct[i]+"  "+wt[i]);
		}
		avgWaiting=avgWaiting/n;
		avgTurnAround=avgTurnAround/n;
		System.out.println("Average Waiting:"+avgWaiting);
		System.out.println("Average Turn Around:"+avgTurnAround);
	}

}
