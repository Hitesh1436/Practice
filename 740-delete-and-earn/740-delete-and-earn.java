
// for example:
	// After we sum up fpr each particular number, we can get
	// sum1,  sum2,  sum3,  sum4, sum5...
	//    1,     6,     3,     8,    10
	
	// if we reach to sum3,  prev1 = 6 , prev2=1
	// (prev2+sum3)=4  <  prev1=6
	// so new prev1 = 6,  new prev2 = prev1 =6
    // if we reach to sum4, (prev2+sum4)=6+8=14 < prev1=6
	// so new prev1 =14 , new prev2=prev1=6
	// if we reahc to sum5, (prev2+sum5)=6+10=16 > prev1=14
	// finally, new prev1=16 which is the largest sum
	// the key is to compare previous sum(prev1) and the sum before prev1(prev2)+current value
class Solution {
    public int deleteAndEarn(int[] nums) {
        int []dp = new int[10001];
        for(int num : nums){
            dp[num] += num;
        }
        int prev1 =0;
        int prev2 =0;
        for(int val : dp){
            int temp = prev1;
            prev1 = Math.max(prev2+val ,prev1);
            prev2 = temp;
        }
        return prev1;
    }
}