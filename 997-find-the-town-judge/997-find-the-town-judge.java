class Solution {
    public int findJudge(int n, int[][] trust) {
        int [] trusted = new int[n+1];
        int [] trusting = new int[n+1];
        for(int []arr : trust){
            int p1 = arr[0];
            int p2 = arr[1];
            // p1 trusting p2
            trusted[p2]++;
            trusting[p1]++;
        }
        for(int i=n;i>=0;i--){
            if(trusted[i] == n-1 && trusting[i] == 0){
                return i;
            }
        }
        return -1;
    }
}