class Solution {
    public int maxProfit(int[] prices, int fee) {
        int obsp = -prices[0];  // obsp-> old bought stock price
        int ossp = 0; //obsp-> old stock sell price
        for(int i = 1; i < prices.length; i++){
            int nbsp = Math.max(ossp - prices[i], obsp);  // new bsp
            int nssp = Math.max(obsp + prices[i] - fee, ossp);  // new ssp
            obsp = nbsp;
            ossp = nssp;
        }
        return ossp;
    }
}