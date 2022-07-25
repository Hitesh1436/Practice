class Solution {
    public int reachNumber(int tar) {
        int moves =0;
        int sum =0;
        tar = Math.abs(tar);
     while(sum<tar || (sum-tar)%2!=0) {
        moves++;
        sum+=moves;
    }
    return moves;
    }
}