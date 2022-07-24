class Solution {
    public int[] executeInstructions(int n, int[] pos, String s) {
        int []ans = new int[s.length()];
        for(int i=0;i<s.length();i++){
            int moves =0;
            int yy = pos[0];
            int xx = pos[1];
            for(int j=i;j<s.length();j++){
                if(s.charAt(j)== 'R'){
                    xx++;
                }
                if(s.charAt(j)== 'L'){
                    xx--;
                }
                if(s.charAt(j)== 'U'){
                    yy--;
                }
                if(s.charAt(j)== 'D'){
                    yy++;
                }
                if(xx<0 || xx>=n || yy<0 || yy>=n){
                    break;
                }else{
                    moves++;
                }
            }
            ans[i] = moves;
        }
        return ans;
    }
}