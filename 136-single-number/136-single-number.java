class Solution {
    public int singleNumber(int[] nums) {
      Arrays.sort(nums);
        int i= 0;
        int j= nums.length-1;
        int number=0;

     while (i!=j){
         if(nums[i]==nums[j]){
          i =j+1;
          j=nums.length-1;  
         }
         else
             j--;
     }
        if(i==j){
            number=nums[j];
        }
     return number;   
    }
}