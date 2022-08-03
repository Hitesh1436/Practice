// Time Complexity : O(N)
// Space Complexity : O(N)
class Solution {
    public String reverseWords(String s) {
        Stack <String> st = new Stack<>();
        int i = 0;
        int n = s.length();
        String result = "";
        while(i<n){
            while(i<n && s.charAt(i) == ' '){
                i++;
            }
            if(i>=n){
                break;
            }
            int j = i+1;
            while(j<n && s.charAt(j) != ' '){
                j++;
            }
            String sub = s.substring(i,j);
            st.push(sub);
            i = j+1;
        }
        if(result.length()==0){
            result = st.pop();
        }
        while(!st.isEmpty()){
            result = result + " " + st.pop();
        }
        return result;
    }
}