class Solution {
public boolean isPowerOfTwo(int n) {
    if (n <= 0) {
    return false; 
    }
if (n <= 2) { 
    return true; 
}
if (n % 2 == 1) { 
    return false; 
}
    boolean ans = isPowerOfTwo(n / 2);
    return ans;
}
}