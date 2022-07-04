// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}// } Driver Code Ends

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/

class Sorter implements Comparator<Job>{                                    
    public int compare(Job o1 ,Job o2){
        return o2.profit-o1.profit;
    }
}
class Solution{ 
    int[] JobScheduling(Job arr[], int n){
        int total=0;
        int count=0;
        Arrays.sort(arr,new Sorter());
        boolean[] avail=new boolean[101];

        for(int i=0;i<arr.length;i++){
            if(avail[arr[i].deadline]==false){
                total+=arr[i].profit;
                avail[arr[i].deadline]=true;
                count++;
            }
            else {
                for(int j=arr[i].deadline-1;j>=1;j--){
                    if(avail[j]==false){
                        count++;
                        total+=arr[i].profit;
                        avail[j]=true;
                        break;
                    }
                }
            }
        }
        return new int[]{count,total};
    }
    
}

