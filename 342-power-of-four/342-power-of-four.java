class Solution {
    public boolean isPowerOfFour(int n) {
        double val = Math.log(n)/Math.log(4);
        double result = val-(int)val;
        return result==0.0;
    }
}