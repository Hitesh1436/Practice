/*Time Complexity: O(nlogn)
Step 1: Sort the array
Step 2: Find the middle element 
Step 3: Keep adding the difference between middle element and other array elements to count.
Since we have to give the minimum count of moves required to make all elements equal, we sort and choose the middle element and keep adding for count of moves for every element to become equal to middle element,i.e., difference between the gives the number of moves.

eg: [1,10,2,9]
Step 1: [1,2,9,10]
Step 2: middle=9
Step 3: count+=Math.abs(9-1)=8
        count+=Math.abs(9-2)=8+7=15
        count+=Math.abs(9-9)=15+0=15
        count+=Math.abs(9-10)=15+1=16
Ans=16
*/


class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);                              //Step1
        int count=0;
        int middle=nums[nums.length/2];                 //Step2
        for(int i=0;i<nums.length;i++){                  //Step3
            count+=Math.abs(middle-nums[i]);
        }
        return count;
    }
}