class Solution {
    public int balancedStringSplit(String s) {
        int ans =0;
        int bal = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'L'){
                bal++;
            }else{
                bal--;
            }
            if(bal == 0) ans++;
        }
        return ans;
    }
}