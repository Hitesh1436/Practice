class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i=s.length()-1, j=t.length()-1, count;
        while(i>=0 || j>=0){
            while(i>=0 && s.charAt(i) == '#'){
                count = 0;
                while(i >= 0){
                    if(s.charAt(i) == '#')
                        count++;
                    else count--;
                    if(count == 0) break;
                    i--;
                }
                i--;
            }
            while(j>=0 && t.charAt(j) == '#'){
                count = 0;
                while(j >= 0){
                    if(t.charAt(j) == '#')
                        count++;
                    else count--;
                    if(count == 0) break;
                    j--;
                }
                j--;
            }
            if(i<0 && j<0) return true;
            else if((i>=0 && j<0) || (i<0 && j>=0) || (s.charAt(i) != t.charAt(j)))
                return false;
            else{
                i--;
                j--;
            }
        }
        return true;
    }
}