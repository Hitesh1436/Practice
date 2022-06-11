class Solution {
    public int minOperations(int[] nums, int x) {
	int sum = 0;
	for (int i : nums) {
		sum += i;
	}
	int target = sum - x;
	int longSub = longestSub(nums, target);
	return longSub == Integer.MIN_VALUE ? -1 : nums.length - longSub;
}

int longestSub(int[] nums, int target) {
	Map<Integer, Integer> map = new HashMap<>();
	if (target == 0) {
		return 0;
	}
	int sum = 0;
	int max = Integer.MIN_VALUE;
	for (int i = 0; i < nums.length; i++) {

		sum += nums[i];

		if (sum == target) {
			max = i + 1;
		} else {
			int comp = sum - target;
			if (map.containsKey(comp)) {
				max = Math.max(max, i - map.get(comp));
			}
		}
		map.put(sum, i);
	}
	return max;
}
}