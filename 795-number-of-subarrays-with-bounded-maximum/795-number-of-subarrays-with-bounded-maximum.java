class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int leftPointer = 0, rightPointer = 0;
        int n = nums.length;
        int count = 0;
        int number = 0;
        while(leftPointer<n && rightPointer<n) {
                if(nums[rightPointer]>=left && nums[rightPointer]<=right) {
					/* variable "number" signifies the last element greater satisfying this condition. 
					Why we are keeping this count is if a number less than left is there, then this number can be a part of that array.
					Example: 
					[79,69,33,52,68,5,78] , left = 32, right = 80
					 for number 5 present in 5th index of the array, the possible combinations will include 
					 [79,69,33,52,68,5],
					 [69,33,52,68,5],
					 [33,52,68,5],
					 [52,68,5]
					 [68,5]
					 
					 if you see clearly here, the number of combinations that include 5 are the same as the number 
					 of combinations that are possible with 68( the last element till 5 which is greater than 32 and less than 80).
					 To keep track of this count we have stored this in variable "number".
					*/
				
                    count+=(rightPointer-leftPointer+1);
                    number = (rightPointer-leftPointer+1); 
                } else if(nums[rightPointer]<left) {count+=number;}
             else {
                if(nums[rightPointer]>right) {           
					// reset everything if the array element is greater than right.
                    rightPointer++;  
                    leftPointer = rightPointer;
                    number = 0;
                    continue;
                }
            }
            rightPointer++;
        }
        return count;
    }
}