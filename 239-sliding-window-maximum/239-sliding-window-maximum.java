class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> maxQueue = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i >= k && !maxQueue.isEmpty() && maxQueue.peek() == nums[i - k]) {
                maxQueue.poll();
            }
            while(!maxQueue.isEmpty() && maxQueue.peekLast() < nums[i]) {
                maxQueue.pollLast();
            }
            maxQueue.add(nums[i]);
            
            if (i - k + 1 >= 0) {
                result[i - k + 1] = maxQueue.peek();    
            }
        }
        return result;
    }
}