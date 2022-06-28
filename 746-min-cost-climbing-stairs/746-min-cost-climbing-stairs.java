class Solution {
	public int minCostClimbingStairs(int[] cost) {
		if(cost.length == 0 || cost.length == 1){ return 0; }        
		int costMinus2 = 0, costMinus1 = 0, minCost = 0;        
		for(int i = 2; i <= cost.length; i++){
			minCost = Math.min( cost[i-2]+costMinus2, cost[i-1] + costMinus1 );
			costMinus2 = costMinus1;            
			costMinus1 = minCost;
		}
		return minCost;
	}
}