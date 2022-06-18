class Solution {
    public String defangIPaddr(String s) {
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '.'){
                ans.append("[.]");
            }else {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}