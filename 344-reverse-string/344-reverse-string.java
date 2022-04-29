class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        Stack<Character> st = new Stack<>();
       for(int i=0;i<n;i++){
            st.push(s[i]);
       }
        int i=0;
        while(st.size()!=0){
            s[i]= st.pop();
            i++;
        }
    }
}