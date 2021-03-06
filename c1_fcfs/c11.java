//package c11;

import java.util.Scanner;

public class c11 {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		String[] procname = new String[size];
		int[]waitingTime  = new int[size];
		int[]burstTime    = new int[size];
		int[]turnAroundTime = new int[size];
		int[]arrivalTime    = new int[size];
		float avgWaitingTime = 0.0f;
		float avgTurnAroundTime=0.0f;
		
		for(int i=0;i<size;i++)
		{
			System.out.println("Enter procedure name:");
			procname[i]=sc.next();
			System.out.println("Enter burst time");
			burstTime[i]=sc.nextInt();
			System.out.println("Enter Arrival time");
			arrivalTime[i]=sc.nextInt();
		}
		int burstSum=0;
		for(int i=0;i<size;i++)
		{
			burstSum = burstSum + burstTime[i];
			
			waitingTime[i]=burstSum - burstTime[i] - arrivalTime[i];
			avgWaitingTime = avgWaitingTime + waitingTime[i];
			
			turnAroundTime[i] = waitingTime[i]+burstTime[i];
			avgTurnAroundTime = avgTurnAroundTime+turnAroundTime[i];			
		}
		avgWaitingTime = avgWaitingTime/size;
		avgTurnAroundTime = avgTurnAroundTime/size;
	
		System.out.println("Waiting time for each procedure:");
		for(int i=0;i<size;i++)
		{
			System.out.println("For "+procname[i]+" "+waitingTime[i]);
		}
		System.out.println("turnAroundTime for each procedure:");
		for(int i=0;i<size;i++)
		{
			System.out.println("For "+procname[i]+" "+turnAroundTime[i]);
		}

		System.out.println("average turn around time:"+avgTurnAroundTime);
		System.out.println("average waiting time:"+avgWaitingTime);
	}
}
