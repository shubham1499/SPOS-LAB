import java.util.*;
public class Priority
{
	Scanner sc=new Scanner(System.in);
	int n;
	int pid[];
	int at[];
	int bt[];
	int ct[];
	int tt[];
	int wt[];
	int f[];
	int pri[];
	int st=0, tot=0;
	float avgwt=0, avgtt=0;
	public void input()
	{
		System.out.println("Enter the total no. of processes");
		n=sc.nextInt();
		
	    pid = new int[n];
	    at = new int[n]; // at means arrival time
	    bt = new int[n]; // bt means burst time
	    pri=new int[n];  //also stores burst time
		ct = new int[n]; // ct means complete time
		tt = new int[n]; // ta means turn around time
		wt = new int[n];  //wt means waiting time
		f = new int[n];  // f means it is flag it checks process is completed or not
		
		int i;
		for(i=0;i<n;i++)
		{
			System.out.println("Enter process id");
			//System.out.println("Enter process id  I : " + i); 
			pid[i]=sc.nextInt();
			
			//System.out.println("Enter arrival time");
			//at[i]=sc.nextInt();
			
			System.out.println("Enter burst time");
			bt[i]=sc.nextInt();
			
			
			System.out.println("Enter priority");
			pri[i]=sc.nextInt();
		}
		for (i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (pri[j] > pri[j+1]) 
                { 
                    // swap arr[j+1] and arr[i] 
                    int temp = pri[j]; 
                    pri[j] = pri[j+1]; 
                    pri[j+1] = temp;
                    temp = bt[j]; 
                    bt[j] = bt[j+1]; 
                    bt[j+1] = temp;
                    temp = pid[j]; 
                    pid[j] = pid[j+1]; 
                    pid[j+1] = temp;
                    
                } 
	
		wt[0]=0;
		int s=bt[0];
		for( i=0;i<n;i++)
		{
			if(i!=0)
			{
				wt[i]=s-at[i];
				s=s+bt[i];
			}
		tt[i]=wt[i]+bt[i];
		System.out.println("Pid "+"Priority"+"Burst Time"+"Turnaround Time"+"Waiting Time");
		System.out.println(pid[i]+" "+pri[i]+"             "+bt[i]+"             "+tt[i]+"             "+wt[i]);
		avgwt=avgwt+wt[i];
		avgtt=avgtt+tt[i];
		}
		System.out.println("Average waiting time:"+ (avgwt/n));
		System.out.println("Average turn around time:"+(avgtt/n));
	}
		
	public static void main(String args[])
	{
		Priority obj=new Priority();
		obj.input();
	}
}

