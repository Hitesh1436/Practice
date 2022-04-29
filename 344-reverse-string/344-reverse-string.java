class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        int fwd = 0;
        int bck = n-1;
        
        while(fwd<=bck){
            char temp = s[fwd];
            s[fwd] = s[bck];
            s[bck]=temp;
            fwd++;
            bck--;
        }
    }
}