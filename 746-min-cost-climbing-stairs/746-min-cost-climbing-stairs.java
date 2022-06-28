class Solution {
	public int minCostClimbingStairs(int[] cost) {
		if(cost.length == 0 || cost.length == 1){ return 0; }

		int[] minCostArray = new int[cost.length+1];;
		int costMinus2, costMinus1;        
		for(int i = 2; i < minCostArray.length; i++){
			costMinus2 = cost[i-2] + minCostArray[i-2];            
			costMinus1 = cost[i-1] + minCostArray[i-1];
			minCostArray[i] = Math.min(costMinus2, costMinus1);
		}
		return minCostArray[minCostArray.length - 1];
	}
}