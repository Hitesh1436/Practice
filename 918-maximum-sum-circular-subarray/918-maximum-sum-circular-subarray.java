class Solution {
    public int maxSubarraySumCircular(int[] array) {
        int currentSum = 0, maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++) {
            currentSum = Math.max(currentSum + array[i], array[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        if(maxSum < 0) return maxSum;
        currentSum = 0;
        int minSum = Integer.MAX_VALUE;
        for(int i = 0; i < array.length; i++) {
            currentSum = Math.min(currentSum + array[i], array[i]);
            minSum = Math.min(minSum, currentSum);

        }
        int totalSum = 0;
        for(int element : array) totalSum += element;{
        return Math.max(maxSum, totalSum - minSum);   
        }
    }
}