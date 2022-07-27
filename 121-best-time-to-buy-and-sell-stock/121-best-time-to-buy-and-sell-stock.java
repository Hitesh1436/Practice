class Solution {
    public int maxProfit(int[] p) {
        int lowestPrice = p[0];
        int maxProfit = 0;
        for(int i=1;i<p.length;i++){
            lowestPrice = Math.min(p[i],lowestPrice);
            maxProfit = Math.max(maxProfit,p[i]-lowestPrice);
        }
        return maxProfit;
    }
}