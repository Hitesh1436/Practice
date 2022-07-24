class Solution {
    public int maxCoins(int[] piles) {
       Arrays.sort(piles); // 1,2,3,4,7,8
        int n = piles.length;
        int sum =0;
        for(int i=n/3;i<n;i+=2){
            sum +=piles[i];
        }
        return sum;
    }
}