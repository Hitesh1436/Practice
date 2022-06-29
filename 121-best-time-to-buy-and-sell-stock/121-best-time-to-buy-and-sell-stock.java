class Solution {

    public int maxProfit(int[] prices){ 
    
        // time : O(N)
        // space: O(1)
        
        int lowest_price = prices[0];
        int max_profit = 0;
        
        for(int i = 1; i < prices.length; i++)
        {
            lowest_price = Math.min(lowest_price, prices[i]);
            max_profit = Math.max(max_profit, prices[i] - lowest_price);
        }
        return max_profit;
    }
}