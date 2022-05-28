class Solution {
    public int singleNumber(int[] nums) {
	// Count the number of integers in the array
        int size = nums.length;
        // Isolate the first number in the array
        int result = nums[0];
        
        // Traverse through the entire array starting from the second number
        for (int i = 1; i < size; i++)
         /**
             * Use an XOR gate to find the number without a match.
             *
             * XOR or Exclusive Or is a  logical operation that outputs
             * true only when inputs differ (one is true, the other is
             * false).
             *
             * In this case, the program will traverse through the array
             * adding each number to the result until it comes to a number
             * it has already added. Instead of adding a number again, the
             * program will subtract the number from result. When the
             * for-loop has completed, the result will be the number
             * that was added but not subtracted.
             * */
		result = result ^ nums[i];
            
        // Return the "true" integer that does not appear twice
        return result;
    }
}