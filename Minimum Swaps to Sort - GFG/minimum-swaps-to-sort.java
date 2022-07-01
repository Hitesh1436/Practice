// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        //posMap -> position map bnya h given array ka
        HashMap<Integer,Integer> posMap = new HashMap<>();  
        for(int i=0;i<nums.length;i++){
            posMap.put(nums[i],i);
        }
     Arrays.sort(nums);
     boolean []vis = new boolean[nums.length];
     int swap = 0;
     for(int i=0;i<nums.length;i++){
         if(vis[i]==true || posMap.get(nums[i])==i){
             continue;
         }
         vis[i] = true;  // mark krdia h
         
         int j =i;  // j ko statr kia i se
         int cycleSize =0;  
         do{
             j = posMap.get(nums[j]);  // phle map se dkha j vala khn se aaya hai
             vis[j] = true;  // uss j vale ko mark krdia
             cycleSize++;
         }while(j !=i);  // jbtk i  and j equal ni hity mtlb j vaps i tk ni aata tbtk kiaa
         swap += (cycleSize-1);
     }
     return swap;
    }
}