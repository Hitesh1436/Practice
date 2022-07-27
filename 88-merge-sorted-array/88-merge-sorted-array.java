// Initially p1 = m-1 , p2 = n-1 , i = m+n-1
// So lets takes two pointers that mark the end of 2 arrays and i ,that would be the index at which we are going to write the value , now we will compare the values at p1 and p2 and write the value that is larger at index i , after writing we decrement the respective indexes .
// And the another edge case is that if any one of the array is empty arr[i] = [0] , index i-1 and another one is arr[j] = [1,2,3] , index = j-1
// So if we consider the index as i-1 then it becomes negative , which is ArrayIndexOutOfBounds ,so we have to take index >=0 .

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1 , p2 = n-1 ,i = m+n-1;
        while(p2 >=0 ){
            if(p1 >=0 && nums1[p1] > nums2[p2]){
                nums1[i--] = nums1[p1--];
            } 
            else{
                nums1[i--] = nums2[p2--];
            }
        }
     }
}