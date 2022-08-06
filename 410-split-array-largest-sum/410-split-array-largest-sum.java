class Solution {
    public int splitArray(int[] nums, int m) {
        int lo =0;
        int hi =0;
        for(int num : nums){
            hi += num;
            lo = Math.max(lo,num);
        }
        while(lo<hi){
            int mid = (lo + hi)/2;
            int limit = mid;
            int countPartitions = 1;
            int currPartitionSum =0;
            for(int num : nums){
                if(currPartitionSum + num <=limit){
                    currPartitionSum += num;
                }else{
                    currPartitionSum = num;
                    countPartitions++;
                }
            }
            if(countPartitions > m){
                // toh mtlb lmit tight rkhi toh loose krna hoga means right jana hoga
                lo = mid +1;
            }else{
                hi = mid;
            }
        }
        return lo;
    }
}