class Solution {
    public int splitArray(int[] nums, int m) {
        int start=0;
        int end=0;
        for(int i=0;i<nums.length;i++){
            start=Math.max(start,nums[i]);
            end+=nums[i];//it keeps the max sum the array can have if only one piece i.e., m is allowed so our ans will lie in the range start to end as it indicates the min possible answer and max possible answer
            
        }
//start keeps the max element in the array as if n numbers are there and m i.e pieces==n        then it is the ans

        while(start<end){
//since now we have taken range of min to max we applied binary search here to find the answer as it must be sorted
            int mid=start+(end-start)/2;
            int pieces=1;
            int sum=0;
            for(int num:nums){
                if(sum+num>mid){
                    sum=num;  
//if sum exceeds mid then we must make other subarray for other elements so sum is reset to next element as it symbolize that another subarray is formed here
                    pieces++;
                }else{
                    sum+=num;
                }
            }
            if(pieces>m){   
// if we see we have divided the array into more pieces than required it is obvious thet we can increase the number of element we take into the subarray to decrease pieces to m so we can expect a larger value than current mid as ans so we did start =mid+1
                start=mid+1;
            }
            else{
                end=mid;
                //if we see subarrays formed are larger in size than required we must shorten it to achieve m so mid must be  greater than the ans expected here so we must decrese mid so end =mid
            }
        }
        return start;
        //here mid==start==end==ans ;) so anything can be returned here
    }
}