// Time Complexity : O(n)
// Space Complexity : O(1)
class Solution {
    public String reverseWords(String s) {
         int i = 0; // i will be looking for non-space
         int n = s.length();
        String result = new String();
        while(i<n){
            while(i<n && s.charAt(i) == ' '){
                i++;
            }
            if(i>=n){
                break;
            }
            int j = i+1; // j is looking for space
            while(j<n && s.charAt(j) != ' '){
                j++;
            }
            String sub = s.substring(i, j);
            if(result.length() == 0){
                result = sub;
            }
            else{
                result = sub + " " + result;
            }
            i = j+1; 
        }
        return result;
    }
}

