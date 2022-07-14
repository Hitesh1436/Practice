// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            int graph[][] = new int[N][N];
            for(int i = 0;i < N;i++){
                String a[] = in.readLine().trim().split("\\s+");
                for(int j = 0;j < N;j++)
                    graph[i][j] = Integer.parseInt(a[j]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.eulerPath(N, graph));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int eulerPath(int N, int graph[][]){
        // code here
        int count = 0;
        
        for(int i = 0; i < graph.length; i++){
            int size = 0;
            
            for(int j = 0; j < graph.length; j++){
                if(i != j && graph[i][j] == 1){
                    size++;
                }
            }
            
            if(size % 2 == 1){
                count++;
            }
        }
        
        if(count == 0 || count == 2){
            return 1;
        } else {
            return 0;
        }
    }
}