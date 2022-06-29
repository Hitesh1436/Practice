class Solution {
    public int maxProfit(int[] prices) {
        int i=0;
        int max =0,diff=0;
        for(int j=1;j<prices.length;j++){
            diff = prices[j] - prices[i];
            if(diff<0) i =j;
            if(max<diff)max = diff;
        }
        return max;
    }
}