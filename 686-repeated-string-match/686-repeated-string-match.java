class Solution {
    private int kmp(String t, String p) {
        int m = p.length();
        int n = t.length();
        int[] table = new int[m + 1];
        table[0] = -1;
        int i = 0, k = -1;
        for(i = 1; i <= m; ++i) {
            while(k >= 0 && p.charAt(k) != p.charAt(i - 1)) {
                k = table[k];
            }
            table[i] = ++k;
        }
        k = 0;
        for(i = 1; i <= n; ++i) {
            while(k >= 0 && p.charAt(k) != t.charAt(i - 1)) {
                k = table[k];
            }
            ++k;
            if(k == m) {
                return i-m;
            }
        }
        return -1;
    }
    public int repeatedStringMatch(String a, String b) {
        int m = a.length();
        int n = b.length();
        int ans = (n-1)/m;
        StringBuilder sb = new StringBuilder(ans + 2);
        sb.append(a);
        sb.append(a);
        for(int i = 0; i < ans; ++i) {
            sb.append(a);
        }
        int x = kmp(sb.toString(), b); // x denoted starting of the match
        if(x == -1)
            return -1;
        if(x != 0)
            ++ans;
        if((x+n-1) >= (ans)*m)
            ++ans;
        return ans;
    }
}